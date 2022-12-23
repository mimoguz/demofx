package fx.demo.starwars

import scalafx.beans.property.StringProperty

class Model:
  val name: StringProperty = StringProperty("George")
  val gender: StringProperty = StringProperty("Unknown")
  val homePlanet: StringProperty = StringProperty("Earth")