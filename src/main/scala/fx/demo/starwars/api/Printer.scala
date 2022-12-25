package fx.demo.starwars.api

class Printer:
  private val api = Api()

  def printDetailsFilms(results: ujson.Arr): Unit =
    if results.value.nonEmpty then
      for film <- results.value do
        println(s"Title: ${film("title").value}")
        println(s"Episode Number: ${film("episode_id").value}")
        println(s"Director: ${film("director").value}")
        println(s"Producer: ${film("producer").value}")
        println(s"Release Date: ${film("release_date").value}")
        println(s"Opening Crawl: ${film("opening_crawl").value.toString.replace("\r\n", " ")}")
        println()
    else println("Your search didn't get any results")

  def printDetailsPlanets(results: ujson.Arr): Unit =
    if results.value.nonEmpty then
      for planet <- results.value do
        println(s"Planet: ${planet("name").value}")
        println(s"Rotation Period: ${planet("rotation_period").value}")
        println(s"Orbital Period: ${planet("orbital_period").value}")
        println(s"Diameter: ${planet("diameter").value}")
        println(s"Gravity: ${planet("gravity").value}")
        println(s"Terrain: ${planet("terrain").value}")
        println(s"Surface Water: ${planet("surface_water").value}")
        println(s"Population: ${planet("population").value}")
        println()
    else println("Your search didn't get any results")

  def printDetailsStarships(results: ujson.Arr): Unit =
    if results.value.nonEmpty then
      for ship <- results.value do
        println(s"Name: ${ship("name").value}")
        println(s"Model: ${ship("model").value}")
        println(s"Cost: ${ship("cost_in_credits").value} credits")
        println(s"Length: ${ship("length").value}")
        println(s"Max Atmosphering Speed: ${ship("max_atmosphering_speed").value}")
        println(s"Crew: ${ship("crew").value}")
        println(s"Passengers: ${ship("passengers").value}")
        println(s"Cargo Capacity: ${ship("cargo_capacity").value}")
        println(s"Consumables: ${ship("consumables").value}")
        println(s"Hyperdrive Rating: ${ship("hyperdrive_rating").value}")
        println(s"MGLT: ${ship("MGLT").value}")
        println(s"Starship Class: ${ship("starship_class").value}")
        println()
    else println("Your search didn't get any results")
end Printer
