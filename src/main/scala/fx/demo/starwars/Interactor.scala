package fx.demo.starwars

import fx.demo.starwars.api.{Api, ApiResult}

import ujson.Value

import scala.util.{Failure, Success, Try}

class Interactor(viewModel: Model):
  private var person: Option[ujson.Value] = None
  private var planet: Option[ujson.Value] = None

  def lookupPerson(): Unit =
    val api = Api()
    api.get("people", Option(viewModel.name.value)) match
      case ApiResult.Error(code, msg) => println(s"Error $code: $msg")
      case ApiResult.Value(people) =>
        Try(people("results").asInstanceOf[ujson.Arr](0)) match
          case Success(prs) =>
            person = Option(prs)
            planet = api.getEntry(prs("homeworld").value.toString).toOption
          case Failure(_) => ()

  def updateModelAfterLookup(): Unit =
    viewModel.name.value = person.map(_("name").value.toString).getOrElse("Nothing Found")
    viewModel.gender.value = person.map(_("gender").value.toString).getOrElse("")
    viewModel.homePlanet.value = planet.map(_("name").value.toString).getOrElse("")

end Interactor
