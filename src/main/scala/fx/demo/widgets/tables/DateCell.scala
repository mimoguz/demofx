package fx.demo.widgets.tables

import fx.demo.widgets.DateWidgets

import java.time.LocalDate

class DateCell[TableModel] extends AbstractCell[TableModel, LocalDate](DateWidgets.formatDate)
