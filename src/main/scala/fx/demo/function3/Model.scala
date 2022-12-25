package fx.demo.function3

import scalafx.beans.property.StringProperty

class Model:
  val planetProperty: StringProperty = StringProperty("")
  def planet: String = planetProperty.value
  def planet_=(planet: String): Unit = planetProperty.value = planet

  val ucPlanetProperty: StringProperty = StringProperty("")
  def ucPlanet: String = ucPlanetProperty.value
  def ucPlanet_=(ucPlanet: String): Unit = ucPlanetProperty.value = ucPlanet
