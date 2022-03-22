package useCases

import entities.{ErrorTypeOne, ErrorTypeThree, ErrorTypeTwo, MyCaseClass}
import repositories.Repository
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

class UseCase(repo: Repository) {

  def function(param: String, param2: String): Future[Either[ErrorTypeOne | ErrorTypeTwo | ErrorTypeThree, MyCaseClass]] = {
    for {
      repoCaseClass <- repo.function(param)
      repoCaseClass2 <- repo.function2(param2)
    } yield {
      for {
        repoCaseClassResult <- repoCaseClass
        repoCaseClass2Result <- repoCaseClass2
      } yield {
        MyCaseClass(repoCaseClassResult.param, repoCaseClass2Result.param)
      }
    }
  }
}
