package fx.demo.widgets.texts

import fx.demo.Util.*

import scalafx.Includes.*
import scalafx.beans.property.{ObjectProperty, Property, StringProperty}
import scalafx.beans.value.ObservableValue
import scalafx.scene.control.{TextField, TextFormatter}
import scalafx.scene.text.Text
import scalafx.util.StringConverter
import scalafx.util.converter.NumberStringConverter

import java.text.DecimalFormat

object Texts:
  def styled(contents: ObservableStringValue, styleClass: String): Text = new Text by { txt =>
    txt.styleClass += styleClass
    txt.text <== contents
  }

  def styled(contents: String, styleClass: String): Text = new Text by { txt =>
    txt.styleClass += styleClass
    txt.text.value = contents
  }

  inline def data(contents: ObservableStringValue): Text = styled(contents, "data-text")

  inline def h1(textValue: String): Text = styled(textValue, "text-h1")

  inline def h1(textValue: ObservableStringValue): Text = styled(textValue, "text-h1")

  inline def h2(textValue: String): Text = styled(textValue, "text-h2")

  inline def h2(textValue: ObservableStringValue): Text = styled(textValue, "text-h2")

  inline def h3(textValue: String): Text = styled(textValue, "text-h3")

  inline def h3(textValue: ObservableStringValue): Text = styled(textValue, "text-h3")

  inline def h4(textValue: String): Text = styled(textValue, "text-h4")

  inline def h4(textValue: ObservableStringValue): Text = styled(textValue, "text-h4")

  inline def label(textValue: String): Text = styled(textValue, "label-text")

  def textField(contents: StringProperty): TextField = new TextField by { txt =>
    txt.text <==> contents
    txt.styleClass += "data-text"
  }

  def decimalField(contents: NumberProperty): TextField = new TextField by { txt =>
    val formatter = DecimalFormat("#.00")
    txt.text.bindBidirectional(contents, NumberStringConverter(java.util.Locale.getDefault))
    txt.styleClass += "data-text"
  }

  def decimalField(contents: NumberProperty, maxWidth: Double): TextField =
    decimalField(contents) by (_.maxWidth = maxWidth)

  def fixedDecimalField(boundProperty: Property[Double, Double], decimalPlaces: Int, maxWidth: Double): TextField =
    new TextField by { txt =>
      txt.maxWidth = maxWidth
      val formatter = TextFormatter(
        FixedDecimalConverter(decimalPlaces),
        boundProperty.value,
        FixedDecimalFilter(decimalPlaces)
      )
    }

  def integerField(boundProperty: Property[Int, Int], maxWidth: Double): TextField =
    new TextField by { txt =>
      txt.maxWidth = maxWidth
      val textFormatter = TextFormatter[Int](integerStringConverter)
      txt.textFormatter = textFormatter
      boundProperty <==> textFormatter.value
    }

  private def integerStringConverter: StringConverter[Int] =
    new StringConverter[Int]:
      override def fromString(string: String): Int = if string.isEmpty then 0 else string.toInt
      override def toString(t: Int): String = t.toString

end Texts
