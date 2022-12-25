package fx.demo.widgets.tables

import fx.demo.Util.by

import scalafx.beans.value.ObservableValue
import scalafx.scene.control.TableColumn
import scalafx.scene.control.TableColumn.CellDataFeatures

import java.time.LocalDate

class DateColumn[TableModel] private (heading: String)
    extends ConfigurableColumn[DateColumn[TableModel], TableModel, LocalDate](heading):
  def self: DateColumn[TableModel] = this

  minWidth = 80
  maxWidth = 80
  cellFactory = (_: TableColumn[TableModel, LocalDate]) => DateCell[TableModel]()

object DateColumn:
  def apply[TableModel](heading: String): DateColumn[TableModel] = new DateColumn[TableModel](heading)

  def apply[TableModel](heading: String)(
      cellValueFactory: CellDataFeatures[TableModel, LocalDate] => ObservableValue[LocalDate, LocalDate]
  ): DateColumn[TableModel] = new DateColumn[TableModel](heading) by (_.cellValueFactory = cellValueFactory)
