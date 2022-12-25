package fx.demo.starwars

import fx.demo.Builder
import fx.demo.Util.by

import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.scene.layout.{BorderPane, ColumnConstraints, GridPane, Region}

class ViewBuilder extends Builder[Region]:
  override def build(): Region =
    new BorderPane().by { pane =>
      pane.styleClass += "sw-pane"
      pane.padding = Insets(10.0)
      pane.top = top
      pane.center = centre
      pane.bottom = bottom
    }

  private def top: Node =
    new GridPane().by(_.columnConstraints.addAll(new ColumnConstraints(), new ColumnConstraints()))

  private def centre: Node = ???
  private def bottom: Node = ???
end ViewBuilder
