package fx.demo.widgets.tables

import java.text.DecimalFormat

class DecimalCell[TableModel](formatter: Double => String) extends AbstractCell[TableModel, Double](formatter)

object DecimalCell:
  private val formatter = DecimalFormat("#.00")

  def apply[TableModel](): DecimalCell[TableModel] = new DecimalCell[TableModel](formatter.format)

  def apply[TableModel](formatString: String): DecimalCell[TableModel] =
    val df = DecimalFormat(formatString)
    new DecimalCell[TableModel](df.format)
