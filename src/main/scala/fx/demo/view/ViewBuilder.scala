package fx.demo.view

import fx.demo.Builder
import fx.demo.Util.by
import fx.demo.model.Model

import scalafx.beans.property.{BooleanProperty, StringProperty}
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Node
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.layout.{BorderPane, HBox, Region, VBox}

class ViewBuilder(private val model: Model, private val actionHandler: (() => Unit) => Unit) extends Builder[Region]:
  override def build(): Region =
    new BorderPane by { pane =>
      pane.center = mainBox
      pane.bottom = button
      pane.minWidth = 300
      pane.minHeight = 200
    }

  private def mainBox: Node =
    new VBox by { box =>
      box.spacing = 10.0
      box.padding = Insets(20.0)
      box.children += new HBox(6.0, new Label("Value 1"), createBoundTextField(model.property1Property))
      box.children += new HBox(6.0, new Label("Value 2"), createBoundTextField(model.property2Property))
    }
  private def button: Node =
    new HBox by { box =>
      box.alignment = Pos.CenterRight
      box.children += new Button("Save"):
        private val saveRunning = BooleanProperty(false)
        disable <== !model.property3Property || saveRunning
        defaultButton = true
        onAction = e =>
          saveRunning.value = true
          actionHandler(() => saveRunning.value = false)
    }
  private def createBoundTextField(boundProperty: StringProperty): Node =
    new TextField by (_.text <==> boundProperty)
end ViewBuilder
