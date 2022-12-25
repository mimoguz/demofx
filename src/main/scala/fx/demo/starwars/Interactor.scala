package fx.demo.starwars

import fx.demo.starwars.api.{Api, ApiResult}

import ujson.Value

import scala.util.{Failure, Success, Try}

class Interactor(viewModel: Model):
  private var person: Option[ujson.Value] = None
  private var planet: Option[ujson.Value] = None

  def lookupPerson(): Unit =
    person = None
    planet = None
    val api = Api()
    for
      people <- api.get("people", Option(viewModel.name.value)).toOption
      prs <- Try(people("results").asInstanceOf[ujson.Arr](0)).toOption
      homePlanet <- api.getEntry(prs("homeworld").value.toString).toOption
    do
      person = Option(prs)
      planet = Option(homePlanet)

  def updateModelAfterLookup(): Unit =
    viewModel.name.value = person.map(_("name").value.toString).getOrElse("Nothing Found")
    viewModel.gender.value = person.map(_("gender").value.toString).getOrElse("")
    viewModel.homePlanet.value = planet.map(_("name").value.toString).getOrElse("")

end Interactor
