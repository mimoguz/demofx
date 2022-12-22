package fx.demo.view

import fx.demo.model.Model

import javafx.scene.layout.Region
import javafx.util.Builder
import scalafx.beans.property.{BooleanProperty, StringProperty}
import scalafx.geometry.Insets
import scalafx.scene.Node
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.layout.{BorderPane, HBox, VBox}

class ViewBuilder(private val model: Model, private val actionHandler: (() => Unit) => Unit) extends Builder[Region]:

  override def build(): Region =
    val result = new BorderPane:
      center = mainBox
      bottom = button
      minWidth = 300
      minHeight = 200

    result.delegate

  private def mainBox: Node =
    new VBox:
      spacing = 10.0
      padding = Insets(20.0)
      children += new HBox(6.0, new Label("Value 1"), createBoundTextField(model.property1Property))
      children += new HBox(6.0, new Label("Value 2"), createBoundTextField(model.property2Property))

  private def button: Node =
    new Button("Save"):
      private val saveRunning = BooleanProperty(false)
      disable <== !model.property3Property || saveRunning
      defaultButton = true
      onAction = _ =>
        saveRunning.value = true
        actionHandler(() => saveRunning.value = false)

  private def createBoundTextField(boundProperty: StringProperty): Node =
    new TextField:
      text <==> boundProperty
end ViewBuilder
