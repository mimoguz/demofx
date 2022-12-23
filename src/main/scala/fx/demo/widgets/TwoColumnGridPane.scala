package fx.demo.widgets

import javafx.scene.layout.ColumnConstraints
import scalafx.Includes.*
import scalafx.beans.property.StringProperty
import scalafx.geometry.{HPos, Insets, Pos}
import scalafx.scene.control.{Label, TextField}
import scalafx.scene.layout.GridPane

class TwoColumnGridPane extends GridPane:
  columnConstraints.add(
    new ColumnConstraints:
      halignmentProperty.value = HPos.Right
  )
  hgap = 8.0
  padding = Insets(8.0)

  def addTextFieldRow(results: GridPane, row: Int, boundProperty: StringProperty): Unit =
    val nameField = TextField()
    nameField.text <==> boundProperty
    results.add(createPrompt("Name:"), 0, row)
    results.add(nameField, 1, row)

  def addDisplayRow(results: GridPane, row: Int, s: String, stringProperty: StringProperty): Unit =
    results.add(createPrompt(s), 0, row)
    results.add(createBoundDataLabel(stringProperty), 1, row)

  private def createPrompt(promptText: String): Label =
    new Label(promptText):
      styleClass += "label-prompt"

  private def createBoundDataLabel(stringProperty: StringProperty): Label =
    new Label:
      styleClass += "label-data"
      text <== stringProperty
