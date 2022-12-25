package fx.demo.starwars

import fx.demo.Builder
import fx.demo.Util.by

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Node
import scalafx.scene.control.Button
import scalafx.scene.layout.*

class ViewBuilder(viewModel: Model)(searchHandler: (() => Unit) => Unit) extends Builder[Region]:
  override def build(): Region =
    new BorderPane by { pane =>
      pane.styleClass += "sw-pane"
      pane.padding = Insets(10.0)
      pane.top = top
      centre.foreach(pane.center = _)
      pane.bottom = bottom
    }

  private def top: Node =
    new GridPane by (_.columnConstraints.addAll(new ColumnConstraints, new ColumnConstraints))

  private def centre: Option[Node] = None

  private def bottom: Node =
    val searchButton = new Button("Search") by { btn =>
      btn.onAction = _ =>
        btn.disable = true
        searchHandler(() => btn.disable = false)
    }
    new HBox(searchButton) by (_.alignment = Pos.CenterRight)
end ViewBuilder
