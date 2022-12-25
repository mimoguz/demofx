package fx.demo.widgets.tables

import fx.demo.Util.by

import scalafx.beans.value.ObservableValue
import scalafx.scene.control.TableColumn
import scalafx.scene.control.TableColumn.CellDataFeatures

import java.time.LocalDate

class DecimalColumn[TableModel] private (heading: String)
    extends ConfigurableColumn[DecimalColumn[TableModel], TableModel, Double](heading):
  def self: DecimalColumn[TableModel] = this

object DecimalColumn:
  def apply[TableModel](heading: String): DecimalColumn[TableModel] = new DecimalColumn[TableModel](heading) by { col =>
    col.cellFactory = (_: TableColumn[TableModel, Double]) => DecimalCell[TableModel]()
  }

  def apply[TableModel](heading: String, formatString: String): DecimalColumn[TableModel] =
    new DecimalColumn[TableModel](heading) by { col =>
      col.cellFactory = (_: TableColumn[TableModel, Double]) => DecimalCell[TableModel](formatString)
    }

  def apply[TableModel](heading: String)(
      cellValueFactory: CellDataFeatures[TableModel, Double] => ObservableValue[Double, Double]
  ): DecimalColumn[TableModel] = new DecimalColumn[TableModel](heading) by { col =>
    col.cellValueFactory = cellValueFactory
    col.cellFactory = (_: TableColumn[TableModel, Double]) => DecimalCell[TableModel]()
  }
end DecimalColumn
