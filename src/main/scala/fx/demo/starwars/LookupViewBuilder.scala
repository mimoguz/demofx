package fx.demo.starwars

import fx.demo.Builder
import fx.demo.Util.by

import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.{HBox, Region}

class LookupViewBuilder(private val viewModel: Model)(private val searchHandler: (() => Unit) => Unit)
  extends Builder[Region]:
  override def build(): Region = new HBox by { box =>
    box.spacing = 6.0
    box.children ++= Seq(
      new TextField by (_.text <==> viewModel.name),
      new Button("Search") by { btn =>
        btn.onAction = e =>
          btn.disable = true
          searchHandler(() => btn.disable = false)
      }
    )
  }
