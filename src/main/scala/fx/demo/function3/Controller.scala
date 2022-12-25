package fx.demo.function3

import fx.demo.starwars

import scalafx.scene.layout.Region

class Controller:
  private val model = Model()
  private val viewBuilder =
    val interactor = Interactor(model)
    ViewBuilder(model, interactor.convertToUpperCase)

  def view: Region = viewBuilder.build()
