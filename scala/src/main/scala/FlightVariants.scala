package org.whsv26.leetcode

object FlightVariants {
  def main(args: Array[String]): Unit = { }

  sealed trait Direction

  object Direction {
    case object To   extends Direction
    case object From extends Direction
  }

  case class Flight(code: String, departCity: String, arrivalCity: String, direction: Direction)

  case class FlightVariant(
    to: List[Flight],
    from: List[Flight]
  )

  /*
    Даны перелеты: номер, город вылета, город прилета, направление.
    Перелеты идут поочередно относясь к одному варианту перелета.
    Вариант перелета содержит перелеты туда и перелеты обратно, оба могут быть с пересадками.
   */
  val data = List(
    Flight("R3755", "Новосибирск", "Москва", Direction.To),
    Flight("R3756", "Москва", "Стамбул", Direction.To),
    Flight("R3757", "Стамбул", "Новосибирск", Direction.From),
    Flight("R3758", "Новосибирск", "Санакт-Питербург", Direction.To),
    Flight("R3759", "Санакт-Питербург", "Стамбул", Direction.To),
    Flight("R3760", "Стамбул", "Новосибирск", Direction.From)
  )

  val expectedResult = List(
    FlightVariant(
      to = List(
        Flight("R3755", "Новосибирск", "Москва", Direction.To),
        Flight("R3756", "Москва", "Стамбул", Direction.To)
      ),
      from = List(
        Flight("R3757", "Стамбул", "Новосибирск", Direction.From)
      )
    ),
    FlightVariant(
      to = List(
        Flight("R3758", "Новосибирск", "Санакт-Питербург", Direction.To),
        Flight("R3759", "Санакт-Питербург", "Стамбул", Direction.To)
      ),
      from = List(
        Flight("R3757", "Стамбул", "Новосибирск", Direction.From)
      )
    ),
    FlightVariant(
      to = List(
        Flight("R3755", "Новосибирск", "Москва", Direction.To),
        Flight("R3756", "Москва", "Стамбул", Direction.To)
      ),
      from = List(
        Flight("R3760", "Стамбул", "Новосибирск", Direction.From)
      )
    ),
    FlightVariant(
      to = List(
        Flight("R3758", "Новосибирск", "Санакт-Питербург", Direction.To),
        Flight("R3759", "Санакт-Питербург", "Стамбул", Direction.To)
      ),
      from = List(
        Flight("R3760", "Стамбул", "Новосибирск", Direction.From)
      )
    ),
  )

  /*
    Функция принимает перелеты.
    Должна вернуть список вариантов перелета для данных перелетов.

    Пример:
    на входе:
    List(
      Flight("R3555", "Москва", "Токио", Direction.To),
      Flight("R3556", "Токио", "Оасква", Direction.From)
    )

    на выходе:
    List(
      FlightVariant(
        to: List(
          Flight("R3555", "Москва", "Токио", Direction.To)
        ),
        from: List(
          Flight("R3556", "Токио", "Оасква", Direction.From)
        )
      )
    )
   */
  def extractVariants(flights: List[Flight]): List[FlightVariant] = {
    def iter(cur: Flight, remVars: List[Flight]): List[List[Flight]] = {
      val rems = remVars
        .filter(_ != cur)
        .filter(_.direction == cur.direction)
        .filter(_.departCity == cur.arrivalCity)

      if (rems.isEmpty) {
        List(List(cur))
      } else {
        for {
          rem <- rems
          acc <- iter(rem, remVars.filterNot(_ == rem))
        } yield cur :: acc
      }
    }

    val toVars = for {
      fl <- flights.filter(_.direction == Direction.To)
      to <- iter(fl, flights)
    } yield to

    val fromVars = for {
      fl <- flights.filter(_.direction == Direction.From)
      from <- iter(fl, flights)
    } yield from

    for {
      from <- fromVars if from.nonEmpty
      to <- toVars if to.nonEmpty

      fromFirst = from.head
      fromLast = from.last

      toFirst = to.head
      toLast = to.last

      if (toFirst.departCity == fromLast.arrivalCity)
      if (toLast.arrivalCity == fromFirst.departCity)

    } yield FlightVariant(to, from)
  }

  val result = extractVariants(data)

  require(result == expectedResult)
  println(result.mkString("\n"))
}
