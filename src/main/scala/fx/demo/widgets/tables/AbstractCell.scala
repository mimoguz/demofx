package fx.demo.widgets.tables

import fx.demo.Util.by
import fx.demo.widgets.DateWidgets

import scalafx.Includes.*
import scalafx.geometry.Pos
import scalafx.scene.control.TableCell
import scalafx.scene.text.Text

import java.text.DecimalFormat
import java.time.LocalDate

class AbstractCell[TableModel, Value](private val formatter: Value => String) extends TableCell[TableModel, Value]:
  cell =>

  private val txt = new Text by { t =>
    t.styleClass += "data-text-cell"
    t.text <== when(cell.item =!= null) choose formatter(item.value) otherwise ""
  }

  graphic = txt
  alignment = Pos.CenterRight
