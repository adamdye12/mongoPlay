package models

import java.awt.Image

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class User(
                 age: Int,
                 firstName: String,
                 lastName: String
               )


object JsonFormats {

  import play.api.libs.json.Json

  // Generates Writes and Reads for User thanks to Json Macros
  implicit val userFormat = Json.format[User]
}

object User {
  val createUserForm = Form(
    mapping(
      "age" -> number(min = 1, max = 110),
      "firstName" -> nonEmptyText,
      "lastName" -> nonEmptyText)
    (User.apply)(User.unapply)
  )
}

