package fx.demo.widgets

import fx.demo.Util.by
import fx.demo.widgets.texts.Labels

import javafx.scene.layout.ColumnConstraints
import scalafx.Includes.*
import scalafx.beans.property.StringProperty
import scalafx.geometry.{HPos, Insets, Pos}
import scalafx.scene.control.{Label, TextField}
import scalafx.scene.layout.GridPane

class TwoColumnGridPane extends GridPane:
  columnConstraints.add(new ColumnConstraints by (_.halignmentProperty.value = HPos.Right))
  hgap = 8.0
  padding = Insets(8.0)

object TwoColumnGridPane:
  extension (pane: GridPane)
    def addTextFieldRow(row: Int, boundProperty: StringProperty): Unit =
      val nameField = TextField() by (_.text <==> boundProperty)
      pane.add(Labels.prompt("Name:"), 0, row)
      pane.add(nameField, 1, row)

    def addDisplayRow(row: Int, s: String, stringProperty: StringProperty): Unit =
      pane.add(Labels.prompt(s), 0, row)
      pane.add(Labels.data(stringProperty), 1, row)
end TwoColumnGridPane
