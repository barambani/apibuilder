package controllers

import io.apibuilder.spec.v0.models.Method
import lib.{ApiClient, Config}
import models.MainTemplate
import io.apibuilder.api.v0.models.User
import play.api.mvc._
import play.api.mvc.Results.Redirect
import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._
import play.api.Play.current
import java.util.UUID

class AuthenticatedRequest[A](val sessionId: String, val user: User, request: Request[A]) extends WrappedRequest[A](request) {

  lazy val api = Authenticated.api(Some(sessionId))

  def mainTemplate(title: Option[String] = None): MainTemplate = {
    MainTemplate(
      requestPath = request.path,
      title = title,
      user = Some(user)
    )
  }

}

object Authenticated extends ActionBuilder[AuthenticatedRequest] {

  import scala.concurrent.ExecutionContext.Implicits.global

  def api(sessionId: Option[String] = None) = ApiClient(sessionId).client

  def invokeBlock[A](request: Request[A], block: (AuthenticatedRequest[A]) => Future[Result]) = {

    lazy val returnUrl: Option[String] = {
      Method(request.method) match {
        case Method.Get => Some(request.uri)
        case Method.Connect | Method.Delete | Method.Head | Method.Options | Method.Patch | Method.Post | Method.Put | Method.Trace => None
        case Method.UNDEFINED(_) => None
      }
    }

    request.session.get("session_id").map { sessionId =>
      ApiClient.getUserBySessionId(sessionId) match {

        case None => {
          Future.successful(Redirect(routes.LoginController.index(return_url = returnUrl)).withNewSession)
        }

        case Some(u: User) => {
          block(new AuthenticatedRequest(sessionId, u, request))
        }

      }

    } getOrElse {
      Future.successful(Redirect(routes.LoginController.index(return_url = returnUrl)).withNewSession)
    }

  }
}
