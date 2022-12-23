package fx.demo.function2

import fx.demo.Builder
import fx.demo.starwars

import javafx.scene.control.Label
import scalafx.geometry.Insets
import scalafx.scene.layout.{Region, StackPane, VBox}

class ViewBuilder extends Builder[Region]:
  override def build(): Region =
    new VBox:
      spacing = 6
      padding = Insets(4)
      children += new Label("Star Wars Lookup"):
        styleClass += "h3"
      children += starwars.LookupBox()
