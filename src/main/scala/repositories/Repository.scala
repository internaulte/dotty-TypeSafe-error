package repositories

import entities.{ErrorTypeOne, ErrorTypeThree, ErrorTypeTwo, MyRepoCaseClass, MyRepoCaseClass2}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

class Repository {
  def function(param: String): Future[Either[ErrorTypeOne | ErrorTypeTwo, MyRepoCaseClass]] = {
    Future {
      param match {
        case "truc" => Right(MyRepoCaseClass("toto"))
        case "machin" => Left(ErrorTypeOne())
        case _ => Left(ErrorTypeTwo())
      }
    }
  }

  def function2(param: String): Future[Either[ErrorTypeThree | ErrorTypeTwo, MyRepoCaseClass2]] = {
    Future {
      param match {
        case "machin" => Right(MyRepoCaseClass2(5L))
        case "truc" => Left(ErrorTypeThree())
        case _ => Left(ErrorTypeTwo())
      }
    }
  }
}
