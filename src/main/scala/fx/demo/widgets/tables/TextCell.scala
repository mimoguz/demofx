package fx.demo.widgets.tables

import fx.demo.Util.by

import scalafx.scene.control.TableCell
import scalafx.scene.text.Text

class TextCell[TableModel] extends TableCell[TableModel, String]:
  private val txt = new Text by (_.styleClass += "data-text-cell")
  txt.text <== item
  graphic = txt

object TextCell:
  def apply[TableModel](): TextCell[TableModel] = new TextCell[TableModel]()

  def apply[TableModel](wrappingWidth: Double): TextCell[TableModel] =
    new TextCell[TableModel] by (_.txt.wrappingWidth = wrappingWidth)
