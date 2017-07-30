/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.12.24
 * apibuilder:0.12.38 https://app.apibuilder.io/apicollective/apibuilder-internal/0.12.24/anorm_2_x_parsers
 */
import anorm._

package io.apibuilder.internal.v0.anorm.parsers {

  import io.apibuilder.internal.v0.anorm.conversions.Standard._

  import io.apibuilder.internal.v0.anorm.conversions.Types._

  object Task {

    def parserWithPrefix(prefix: String, sep: String = "_") = parser(
      guid = s"$prefix${sep}guid",
      dataPrefix = s"$prefix${sep}data",
      numberAttempts = s"$prefix${sep}number_attempts",
      lastError = s"$prefix${sep}last_error"
    )

    def parser(
      guid: String = "guid",
      dataPrefix: String = "data",
      numberAttempts: String = "number_attempts",
      lastError: String = "last_error"
    ): RowParser[io.apibuilder.internal.v0.models.Task] = {
      SqlParser.get[_root_.java.util.UUID](guid) ~
      io.apibuilder.internal.v0.anorm.parsers.TaskData.parserWithPrefix(dataPrefix) ~
      SqlParser.long(numberAttempts) ~
      SqlParser.str(lastError).? map {
        case guid ~ data ~ numberAttempts ~ lastError => {
          io.apibuilder.internal.v0.models.Task(
            guid = guid,
            data = data,
            numberAttempts = numberAttempts,
            lastError = lastError
          )
        }
      }
    }

  }

  object TaskDataDiffVersion {

    def parserWithPrefix(prefix: String, sep: String = "_") = parser(
      oldVersionGuid = s"$prefix${sep}old_version_guid",
      newVersionGuid = s"$prefix${sep}new_version_guid"
    )

    def parser(
      oldVersionGuid: String = "old_version_guid",
      newVersionGuid: String = "new_version_guid"
    ): RowParser[io.apibuilder.internal.v0.models.TaskDataDiffVersion] = {
      SqlParser.get[_root_.java.util.UUID](oldVersionGuid) ~
      SqlParser.get[_root_.java.util.UUID](newVersionGuid) map {
        case oldVersionGuid ~ newVersionGuid => {
          io.apibuilder.internal.v0.models.TaskDataDiffVersion(
            oldVersionGuid = oldVersionGuid,
            newVersionGuid = newVersionGuid
          )
        }
      }
    }

  }

  object TaskDataIndexApplication {

    def parserWithPrefix(prefix: String, sep: String = "_") = parser(
      applicationGuid = s"$prefix${sep}application_guid"
    )

    def parser(
      applicationGuid: String = "application_guid"
    ): RowParser[io.apibuilder.internal.v0.models.TaskDataIndexApplication] = {
      SqlParser.get[_root_.java.util.UUID](applicationGuid) map {
        case applicationGuid => {
          io.apibuilder.internal.v0.models.TaskDataIndexApplication(
            applicationGuid = applicationGuid
          )
        }
      }
    }

  }

  object TaskData {

    def parserWithPrefix(prefix: String, sep: String = "_") = {
      io.apibuilder.internal.v0.anorm.parsers.TaskDataIndexApplication.parserWithPrefix(prefix, sep) |
      io.apibuilder.internal.v0.anorm.parsers.TaskDataDiffVersion.parserWithPrefix(prefix, sep)
    }

    def parser() = {
      io.apibuilder.internal.v0.anorm.parsers.TaskDataIndexApplication.parser() |
      io.apibuilder.internal.v0.anorm.parsers.TaskDataDiffVersion.parser()
    }

  }

}