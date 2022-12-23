package fx.demo.function1

import fx.demo.starwars

import scalafx.scene.layout.Region

class Controller:
  private val viewBuilder = ViewBuilder(starwars.Controller().view)
  def view: Region = viewBuilder.build()