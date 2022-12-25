package fx.demo.widgets.texts

import scalafx.util.converter.DoubleStringConverter

class FixedDecimalConverter(private val decimalPlaces: Int) extends DoubleStringConverter:
  override def toString(value: Double): String = String.format(s"%.${decimalPlaces}f", value)

  override def fromString(string: String): Double =
    if string.isEmpty then 0.0
    else super.fromString(string)
