package fx.demo.function2

import fx.demo.Util.by
import fx.demo.widgets.texts.Labels
import fx.demo.{Builder, starwars}

import scalafx.geometry.Insets
import scalafx.scene.control.Label
import scalafx.scene.layout.{Region, StackPane, VBox}

class ViewBuilder extends Builder[Region]:
  override def build(): Region =
    new VBox by { box =>
      box.spacing = 6
      box.padding = Insets(4)
      box.children ++= Seq(Labels.h3("Star Wars Lookup"), starwars.LookupBox())
    }