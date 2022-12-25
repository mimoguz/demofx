package fx.demo.starwars.api

class ArgumentSwitcher:
  private val api = Api()
  private val printer = Printer()

  def switch(command: String, searchQuery: String): Unit =
    command match
      case "films" =>
        api.get("films", Option(searchQuery)).foreach { res =>
          printer.printDetailsFilms(res("results").asInstanceOf[ujson.Arr])
        }
      case "planets" =>
        api.get("planets", Option(searchQuery)).foreach { res =>
          printer.printDetailsPlanets(res("results").asInstanceOf[ujson.Arr])
        }
      case "starships" =>
        api.get("starships", Option(searchQuery)).foreach { res =>
          printer.printDetailsStarships(res("results").asInstanceOf[ujson.Arr])
        }
      case _ => println(s"\"$command\" is not an available command.")
end ArgumentSwitcher
