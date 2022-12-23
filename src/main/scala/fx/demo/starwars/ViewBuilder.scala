package fx.demo.starwars
import fx.demo.Builder

import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.scene.layout.{BorderPane, ColumnConstraints, GridPane, Region}


class ViewBuilder extends Builder[Region]:
  override def build(): Region =
    new BorderPane:
      styleClass += "sw-pane"
      padding = Insets(10.0)
      top = createTop
      center = createCentre
      bottom = createBottom


  private def createTop: Node =
    new GridPane:
      columnConstraints.addAll(new ColumnConstraints(), new ColumnConstraints())



  private def createCentre: Node = ???
  private def createBottom: Node = ???

