package fx.demo.function3

class Interactor(private val model: Model):
  def convertToUpperCase(): Unit = model.ucPlanet = model.planet.toUpperCase
