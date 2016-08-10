/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.11.26
 * apidoc:0.11.33 http://www.apidoc.me/bryzek/apidoc-generator/0.11.26/play_2_4_client
 */
package com.bryzek.apidoc.generator.v0.models {

  /**
   * An attribute represents a key/value pair that is optionally used to provide
   * additional instructions / data to the code generator. An example could be an
   * attribute to specify the root import path for a go client..
   */
  case class Attribute(
    name: String,
    value: String
  )

  case class Error(
    code: String,
    message: String
  )

  /**
   * Represents a source file
   */
  case class File(
    name: String,
    dir: _root_.scala.Option[String] = None,
    contents: String
  )

  /**
   * The generator metadata.
   */
  case class Generator(
    key: String,
    name: String,
    language: _root_.scala.Option[String] = None,
    description: _root_.scala.Option[String] = None,
    attributes: Seq[String] = Nil
  )

  case class Healthcheck(
    status: String
  )

  /**
   * The result of invoking a generator.
   */
  case class Invocation(
    source: String,
    files: Seq[com.bryzek.apidoc.generator.v0.models.File]
  )

  /**
   * The invocation form is the payload send to the code generators when requesting
   * generation of client code.
   */
  case class InvocationForm(
    service: com.bryzek.apidoc.spec.v0.models.Service,
    attributes: Seq[com.bryzek.apidoc.generator.v0.models.Attribute] = Nil,
    userAgent: _root_.scala.Option[String] = None
  )

}

package com.bryzek.apidoc.generator.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import com.bryzek.apidoc.common.v0.models.json._
    import com.bryzek.apidoc.generator.v0.models.json._
    import com.bryzek.apidoc.spec.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    implicit def jsonReadsApidocgeneratorAttribute: play.api.libs.json.Reads[Attribute] = {
      (
        (__ \ "name").read[String] and
        (__ \ "value").read[String]
      )(Attribute.apply _)
    }

    def jsObjectAttribute(obj: com.bryzek.apidoc.generator.v0.models.Attribute) = {
      play.api.libs.json.Json.obj(
        "name" -> play.api.libs.json.JsString(obj.name),
        "value" -> play.api.libs.json.JsString(obj.value)
      )
    }

    implicit def jsonWritesApidocgeneratorAttribute: play.api.libs.json.Writes[Attribute] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.Attribute] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.Attribute) = {
          jsObjectAttribute(obj)
        }
      }
    }

    implicit def jsonReadsApidocgeneratorError: play.api.libs.json.Reads[Error] = {
      (
        (__ \ "code").read[String] and
        (__ \ "message").read[String]
      )(Error.apply _)
    }

    def jsObjectError(obj: com.bryzek.apidoc.generator.v0.models.Error) = {
      play.api.libs.json.Json.obj(
        "code" -> play.api.libs.json.JsString(obj.code),
        "message" -> play.api.libs.json.JsString(obj.message)
      )
    }

    implicit def jsonWritesApidocgeneratorError: play.api.libs.json.Writes[Error] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.Error] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.Error) = {
          jsObjectError(obj)
        }
      }
    }

    implicit def jsonReadsApidocgeneratorFile: play.api.libs.json.Reads[File] = {
      (
        (__ \ "name").read[String] and
        (__ \ "dir").readNullable[String] and
        (__ \ "contents").read[String]
      )(File.apply _)
    }

    def jsObjectFile(obj: com.bryzek.apidoc.generator.v0.models.File) = {
      play.api.libs.json.Json.obj(
        "name" -> play.api.libs.json.JsString(obj.name),
        "contents" -> play.api.libs.json.JsString(obj.contents)
      ) ++ (obj.dir match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("dir" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesApidocgeneratorFile: play.api.libs.json.Writes[File] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.File] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.File) = {
          jsObjectFile(obj)
        }
      }
    }

    implicit def jsonReadsApidocgeneratorGenerator: play.api.libs.json.Reads[Generator] = {
      (
        (__ \ "key").read[String] and
        (__ \ "name").read[String] and
        (__ \ "language").readNullable[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "attributes").read[Seq[String]]
      )(Generator.apply _)
    }

    def jsObjectGenerator(obj: com.bryzek.apidoc.generator.v0.models.Generator) = {
      play.api.libs.json.Json.obj(
        "key" -> play.api.libs.json.JsString(obj.key),
        "name" -> play.api.libs.json.JsString(obj.name),
        "attributes" -> play.api.libs.json.Json.toJson(obj.attributes)
      ) ++ (obj.language match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("language" -> play.api.libs.json.JsString(x))
      }) ++
      (obj.description match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("description" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesApidocgeneratorGenerator: play.api.libs.json.Writes[Generator] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.Generator] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.Generator) = {
          jsObjectGenerator(obj)
        }
      }
    }

    implicit def jsonReadsApidocgeneratorHealthcheck: play.api.libs.json.Reads[Healthcheck] = {
      (__ \ "status").read[String].map { x => new Healthcheck(status = x) }
    }

    def jsObjectHealthcheck(obj: com.bryzek.apidoc.generator.v0.models.Healthcheck) = {
      play.api.libs.json.Json.obj(
        "status" -> play.api.libs.json.JsString(obj.status)
      )
    }

    implicit def jsonWritesApidocgeneratorHealthcheck: play.api.libs.json.Writes[Healthcheck] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.Healthcheck] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.Healthcheck) = {
          jsObjectHealthcheck(obj)
        }
      }
    }

    implicit def jsonReadsApidocgeneratorInvocation: play.api.libs.json.Reads[Invocation] = {
      (
        (__ \ "source").read[String] and
        (__ \ "files").read[Seq[com.bryzek.apidoc.generator.v0.models.File]]
      )(Invocation.apply _)
    }

    def jsObjectInvocation(obj: com.bryzek.apidoc.generator.v0.models.Invocation) = {
      play.api.libs.json.Json.obj(
        "source" -> play.api.libs.json.JsString(obj.source),
        "files" -> play.api.libs.json.Json.toJson(obj.files)
      )
    }

    implicit def jsonWritesApidocgeneratorInvocation: play.api.libs.json.Writes[Invocation] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.Invocation] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.Invocation) = {
          jsObjectInvocation(obj)
        }
      }
    }

    implicit def jsonReadsApidocgeneratorInvocationForm: play.api.libs.json.Reads[InvocationForm] = {
      (
        (__ \ "service").read[com.bryzek.apidoc.spec.v0.models.Service] and
        (__ \ "attributes").read[Seq[com.bryzek.apidoc.generator.v0.models.Attribute]] and
        (__ \ "user_agent").readNullable[String]
      )(InvocationForm.apply _)
    }

    def jsObjectInvocationForm(obj: com.bryzek.apidoc.generator.v0.models.InvocationForm) = {
      play.api.libs.json.Json.obj(
        "service" -> com.bryzek.apidoc.spec.v0.models.json.jsObjectService(obj.service),
        "attributes" -> play.api.libs.json.Json.toJson(obj.attributes)
      ) ++ (obj.userAgent match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("user_agent" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesApidocgeneratorInvocationForm: play.api.libs.json.Writes[InvocationForm] = {
      new play.api.libs.json.Writes[com.bryzek.apidoc.generator.v0.models.InvocationForm] {
        def writes(obj: com.bryzek.apidoc.generator.v0.models.InvocationForm) = {
          jsObjectInvocationForm(obj)
        }
      }
    }
  }
}

package com.bryzek.apidoc.generator.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}
    import org.joda.time.{DateTime, LocalDate}
    import org.joda.time.format.ISODateTimeFormat
    import com.bryzek.apidoc.generator.v0.models._

    // Type: date-time-iso8601
    implicit val pathBindableTypeDateTimeIso8601 = new PathBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    implicit val queryStringBindableTypeDateTimeIso8601 = new QueryStringBindable.Parsing[org.joda.time.DateTime](
      ISODateTimeFormat.dateTimeParser.parseDateTime(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date time $key. Example: 2014-04-29T11:56:52Z"
    )

    // Type: date-iso8601
    implicit val pathBindableTypeDateIso8601 = new PathBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )

    implicit val queryStringBindableTypeDateIso8601 = new QueryStringBindable.Parsing[org.joda.time.LocalDate](
      ISODateTimeFormat.yearMonthDay.parseLocalDate(_), _.toString, (key: String, e: _root_.java.lang.Exception) => s"Error parsing date $key. Example: 2014-04-29"
    )



  }

}


package com.bryzek.apidoc.generator.v0 {

  object Constants {

    val BaseUrl = "http://www.apidoc.me"
    val Namespace = "com.bryzek.apidoc.generator.v0"
    val UserAgent = "apidoc:0.11.33 http://www.apidoc.me/bryzek/apidoc-generator/0.11.26/play_2_4_client"
    val Version = "0.11.26"
    val VersionMajor = 0

  }

  class Client(
    val baseUrl: String = "http://www.apidoc.me",
    auth: scala.Option[com.bryzek.apidoc.generator.v0.Authorization] = None,
    defaultHeaders: Seq[(String, String)] = Nil
  ) extends interfaces.Client {
    import com.bryzek.apidoc.common.v0.models.json._
    import com.bryzek.apidoc.generator.v0.models.json._
    import com.bryzek.apidoc.spec.v0.models.json._

    private[this] val logger = play.api.Logger("com.bryzek.apidoc.generator.v0.Client")

    logger.info(s"Initializing com.bryzek.apidoc.generator.v0.Client for url $baseUrl")

    def generators: Generators = Generators

    def healthchecks: Healthchecks = Healthchecks

    def invocations: Invocations = Invocations

    object Generators extends Generators {
      override def get(
        key: _root_.scala.Option[String] = None,
        limit: Int = 100,
        offset: Int = 0,
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.bryzek.apidoc.generator.v0.models.Generator]] = {
        val queryParameters = Seq(
          key.map("key" -> _),
          Some("limit" -> limit.toString),
          Some("offset" -> offset.toString)
        ).flatten

        _executeRequest("GET", s"/generators", queryParameters = queryParameters, requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.com.bryzek.apidoc.generator.v0.Client.parseJson("Seq[com.bryzek.apidoc.generator.v0.models.Generator]", r, _.validate[Seq[com.bryzek.apidoc.generator.v0.models.Generator]])
          case r => throw new com.bryzek.apidoc.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200")
        }
      }

      override def getByKey(
        key: String,
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.bryzek.apidoc.generator.v0.models.Generator] = {
        _executeRequest("GET", s"/generators/${play.utils.UriEncoding.encodePathSegment(key, "UTF-8")}", requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.com.bryzek.apidoc.generator.v0.Client.parseJson("com.bryzek.apidoc.generator.v0.models.Generator", r, _.validate[com.bryzek.apidoc.generator.v0.models.Generator])
          case r if r.status == 404 => throw new com.bryzek.apidoc.generator.v0.errors.UnitResponse(r.status)
          case r => throw new com.bryzek.apidoc.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 404")
        }
      }
    }

    object Healthchecks extends Healthchecks {
      override def get(
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.bryzek.apidoc.generator.v0.models.Healthcheck] = {
        _executeRequest("GET", s"/_internal_/healthcheck", requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.com.bryzek.apidoc.generator.v0.Client.parseJson("com.bryzek.apidoc.generator.v0.models.Healthcheck", r, _.validate[com.bryzek.apidoc.generator.v0.models.Healthcheck])
          case r => throw new com.bryzek.apidoc.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200")
        }
      }
    }

    object Invocations extends Invocations {
      override def postByKey(
        key: String,
        invocationForm: com.bryzek.apidoc.generator.v0.models.InvocationForm,
        requestHeaders: Seq[(String, String)] = Nil
      )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.bryzek.apidoc.generator.v0.models.Invocation] = {
        val payload = play.api.libs.json.Json.toJson(invocationForm)

        _executeRequest("POST", s"/invocations/${play.utils.UriEncoding.encodePathSegment(key, "UTF-8")}", body = Some(payload), requestHeaders = requestHeaders).map {
          case r if r.status == 200 => _root_.com.bryzek.apidoc.generator.v0.Client.parseJson("com.bryzek.apidoc.generator.v0.models.Invocation", r, _.validate[com.bryzek.apidoc.generator.v0.models.Invocation])
          case r if r.status == 409 => throw new com.bryzek.apidoc.generator.v0.errors.ErrorsResponse(r)
          case r => throw new com.bryzek.apidoc.generator.v0.errors.FailedRequest(r.status, s"Unsupported response code[${r.status}]. Expected: 200, 409")
        }
      }
    }

    def _requestHolder(path: String): play.api.libs.ws.WSRequest = {
      import play.api.Play.current

      val holder = play.api.libs.ws.WS.url(baseUrl + path).withHeaders(
        "User-Agent" -> Constants.UserAgent,
        "X-Apidoc-Version" -> Constants.Version,
        "X-Apidoc-Version-Major" -> Constants.VersionMajor.toString
      ).withHeaders(defaultHeaders : _*)
      auth.fold(holder) {
        case Authorization.Basic(username, password) => {
          holder.withAuth(username, password.getOrElse(""), play.api.libs.ws.WSAuthScheme.BASIC)
        }
        case a => sys.error("Invalid authorization scheme[" + a.getClass + "]")
      }
    }

    def _logRequest(method: String, req: play.api.libs.ws.WSRequest)(implicit ec: scala.concurrent.ExecutionContext): play.api.libs.ws.WSRequest = {
      val queryComponents = for {
        (name, values) <- req.queryString
        value <- values
      } yield s"$name=$value"
      val url = s"${req.url}${queryComponents.mkString("?", "&", "")}"
      auth.fold(logger.info(s"curl -X $method $url")) { _ =>
        logger.info(s"curl -X $method -u '[REDACTED]:' $url")
      }
      req
    }

    def _executeRequest(
      method: String,
      path: String,
      queryParameters: Seq[(String, String)] = Nil,
      requestHeaders: Seq[(String, String)] = Nil,
      body: Option[play.api.libs.json.JsValue] = None
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[play.api.libs.ws.WSResponse] = {
      method.toUpperCase match {
        case "GET" => {
          _logRequest("GET", _requestHolder(path).withHeaders(requestHeaders:_*).withQueryString(queryParameters:_*)).get()
        }
        case "POST" => {
          _logRequest("POST", _requestHolder(path).withHeaders(_withJsonContentType(requestHeaders):_*).withQueryString(queryParameters:_*)).post(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PUT" => {
          _logRequest("PUT", _requestHolder(path).withHeaders(_withJsonContentType(requestHeaders):_*).withQueryString(queryParameters:_*)).put(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "PATCH" => {
          _logRequest("PATCH", _requestHolder(path).withHeaders(requestHeaders:_*).withQueryString(queryParameters:_*)).patch(body.getOrElse(play.api.libs.json.Json.obj()))
        }
        case "DELETE" => {
          _logRequest("DELETE", _requestHolder(path).withHeaders(requestHeaders:_*).withQueryString(queryParameters:_*)).delete()
        }
         case "HEAD" => {
          _logRequest("HEAD", _requestHolder(path).withHeaders(requestHeaders:_*).withQueryString(queryParameters:_*)).head()
        }
         case "OPTIONS" => {
          _logRequest("OPTIONS", _requestHolder(path).withHeaders(requestHeaders:_*).withQueryString(queryParameters:_*)).options()
        }
        case _ => {
          _logRequest(method, _requestHolder(path).withHeaders(requestHeaders:_*).withQueryString(queryParameters:_*))
          sys.error("Unsupported method[%s]".format(method))
        }
      }
    }

    /**
     * Adds a Content-Type: application/json header unless the specified requestHeaders
     * already contain a Content-Type header
     */
    def _withJsonContentType(headers: Seq[(String, String)]): Seq[(String, String)] = {
      headers.find { _._1.toUpperCase == "CONTENT-TYPE" } match {
        case None => headers ++ Seq(("Content-Type" -> "application/json; charset=UTF-8"))
        case Some(_) => headers
      }
    }

  }

  object Client {

    def parseJson[T](
      className: String,
      r: play.api.libs.ws.WSResponse,
      f: (play.api.libs.json.JsValue => play.api.libs.json.JsResult[T])
    ): T = {
      f(play.api.libs.json.Json.parse(r.body)) match {
        case play.api.libs.json.JsSuccess(x, _) => x
        case play.api.libs.json.JsError(errors) => {
          throw new com.bryzek.apidoc.generator.v0.errors.FailedRequest(r.status, s"Invalid json for class[" + className + "]: " + errors.mkString(" "))
        }
      }
    }

  }

  sealed trait Authorization
  object Authorization {
    case class Basic(username: String, password: Option[String] = None) extends Authorization
  }

  package interfaces {

    trait Client {
      def baseUrl: String
      def generators: com.bryzek.apidoc.generator.v0.Generators
      def healthchecks: com.bryzek.apidoc.generator.v0.Healthchecks
      def invocations: com.bryzek.apidoc.generator.v0.Invocations
    }

  }

  trait Generators {
    /**
     * Get all available generators
     */
    def get(
      key: _root_.scala.Option[String] = None,
      limit: Int = 100,
      offset: Int = 0,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[Seq[com.bryzek.apidoc.generator.v0.models.Generator]]

    /**
     * Get generator with this key
     */
    def getByKey(
      key: String,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.bryzek.apidoc.generator.v0.models.Generator]
  }

  trait Healthchecks {
    def get(
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.bryzek.apidoc.generator.v0.models.Healthcheck]
  }

  trait Invocations {
    /**
     * Invoke a generator
     */
    def postByKey(
      key: String,
      invocationForm: com.bryzek.apidoc.generator.v0.models.InvocationForm,
      requestHeaders: Seq[(String, String)] = Nil
    )(implicit ec: scala.concurrent.ExecutionContext): scala.concurrent.Future[com.bryzek.apidoc.generator.v0.models.Invocation]
  }

  package errors {

    import com.bryzek.apidoc.common.v0.models.json._
    import com.bryzek.apidoc.generator.v0.models.json._
    import com.bryzek.apidoc.spec.v0.models.json._

    case class ErrorsResponse(
      response: play.api.libs.ws.WSResponse,
      message: Option[String] = None
    ) extends Exception(message.getOrElse(response.status + ": " + response.body)){
      lazy val errors = _root_.com.bryzek.apidoc.generator.v0.Client.parseJson("Seq[com.bryzek.apidoc.generator.v0.models.Error]", response, _.validate[Seq[com.bryzek.apidoc.generator.v0.models.Error]])
    }

    case class UnitResponse(status: Int) extends Exception(s"HTTP $status")

    case class FailedRequest(responseCode: Int, message: String, requestUri: Option[_root_.java.net.URI] = None) extends _root_.java.lang.Exception(s"HTTP $responseCode: $message")

  }

}