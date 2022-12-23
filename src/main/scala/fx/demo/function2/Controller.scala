package fx.demo.function2

import fx.demo.starwars

import scalafx.scene.layout.Region

class Controller:
  private val viewBuilder = ViewBuilder()
  def view: Region = viewBuilder.build()