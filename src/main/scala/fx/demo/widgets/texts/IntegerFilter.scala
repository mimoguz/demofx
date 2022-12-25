package fx.demo.widgets.texts

import javafx.scene.control.TextFormatter

import java.util.function.UnaryOperator
import scala.util.matching.Regex

class IntegerFilter extends UnaryOperator[TextFormatter.Change]:
  private val intRegex = "-?([1-9][0-9]*)?".r

  override def apply(change: TextFormatter.Change): TextFormatter.Change =
    import change.*
    val newText = getControlText
    if intRegex.matches(newText) || newText == "0" then change
    else if getControlText == "-" then
      if getControlText.startsWith("-") then
        setText("-")
        setRange(0, 1)
        setCaretPosition(getCaretPosition - 2)
        setAnchor(getAnchor - 2)
      else setRange(0, 0)
      change
    else null
end IntegerFilter
