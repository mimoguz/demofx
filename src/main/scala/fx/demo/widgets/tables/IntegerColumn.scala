package fx.demo.widgets.tables

import fx.demo.Util.by

import scalafx.beans.value.ObservableValue
import scalafx.scene.control.TableColumn
import scalafx.scene.control.TableColumn.CellDataFeatures

import java.time.LocalDate

class IntegerColumn[TableModel] private (heading: String)
    extends ConfigurableColumn[IntegerColumn[TableModel], TableModel, Int](heading):
  def self: IntegerColumn[TableModel] = this

  cellFactory = (_: TableColumn[TableModel, Int]) => IntegerCell[TableModel]()

  def withPrefWidth(w: Double): IntegerColumn[TableModel] =
    prefWidth = w
    this

object IntegerColumn:
  def apply[TableModel](heading: String): IntegerColumn[TableModel] = new IntegerColumn[TableModel](heading)

  def apply[TableModel](heading: String)(
      cellValueFactory: CellDataFeatures[TableModel, Int] => ObservableValue[Int, Int]
  ): IntegerColumn[TableModel] = new IntegerColumn[TableModel](heading) by { col =>
    col.cellValueFactory = cellValueFactory
    col.cellFactory = (_: TableColumn[TableModel, Int]) => IntegerCell[TableModel]()
  }
