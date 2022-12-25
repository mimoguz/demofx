package fx.demo.widgets.tables

import fx.demo.Util.by

import scalafx.beans.value.ObservableValue
import scalafx.scene.control.TableColumn
import scalafx.scene.control.TableColumn.CellDataFeatures

import java.time.LocalDate

class TextColumn[TableModel] private (heading: String)
    extends ConfigurableColumn[TextColumn[TableModel], TableModel, String](heading):
  def self: TextColumn[TableModel] = this

  def withWrappingWidth(w: Double): TextColumn[TableModel] =
    cellFactory = (_: TableColumn[TableModel, String]) => TextCell[TableModel](w)
    this

object TextColumn:
  def apply[TableModel](heading: String): TextColumn[TableModel] =
    new TextColumn[TableModel](heading) by { col =>
      col.cellFactory = (_: TableColumn[TableModel, String]) => TextCell[TableModel]()
    }

  def apply[TableModel](heading: String)(
      cellValueFactory: CellDataFeatures[TableModel, String] => ObservableValue[String, String]
  ): TextColumn[TableModel] =
    new TextColumn[TableModel](heading) by { col =>
      col.cellValueFactory = cellValueFactory
      col.cellFactory = (_: TableColumn[TableModel, String]) => TextCell[TableModel]()
    }
