package controller

import useCases.UseCase
import repositories.Repository
import entities.{ErrorTypeOne, ErrorTypeThree, ErrorTypeTwo, MyCaseClass}

import scala.concurrent.ExecutionContext.Implicits.global


object Main {

  val useCase = new UseCase(new Repository)

  for {
    result <- useCase.function("truc", "machin")
  } yield {
    result match {
      case Left(value) =>
        value match {
          case _: ErrorTypeOne => println("one")
          case _: ErrorTypeTwo => println("two")
          case _: ErrorTypeThree => println("three")
        }
      case Right(value) => println(value)
    }
  }
}
