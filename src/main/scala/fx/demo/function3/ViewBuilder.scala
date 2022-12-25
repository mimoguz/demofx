package fx.demo.function3

import fx.demo.Builder
import fx.demo.Util.by
import fx.demo.widgets.texts.Labels

import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.scene.control.Button
import scalafx.scene.layout.{HBox, Region, StackPane, VBox}

class ViewBuilder(private val model: Model, private val convertAction: () => Unit) extends Builder[Region]:
  override def build(): Region = ???

  private def upperCaseBox: Node =
    val lcPlanet = Labels.data(model.planetProperty)
    val ucPlanet = Labels.data(model.ucPlanetProperty)
    val button = new Button("To Upper Case") by (_.onAction = _ => convertAction())
    new VBox(
      6.0,
      new HBox(10, lcPlanet, button),
      new HBox(
        6.0,
        Labels.prompt("In Upper Case: "),
        ucPlanet
      )
    )
end ViewBuilder
