package fx.demo.widgets.texts

import javafx.scene.control.TextFormatter

import java.util.function.UnaryOperator

class FixedDecimalFilter(private val decimalPlaces: Int) extends UnaryOperator[TextFormatter.Change]:
  override def apply(change: TextFormatter.Change): TextFormatter.Change =
    val decimalPos = change.getControlText.indexOf('.')
    val caretPos = change.getControlCaretPosition
    {
      import change.*
      getText match
        case "." =>
          setText("")
          setRange(0, 0)
          if caretPos <= decimalPos then
            setCaretPosition(decimalPos + 1)
            setAnchor(getControlText.length)
          else
            setCaretPosition(decimalPos)
            setAnchor(0)
          change
        case "-" =>
          if getControlText.startsWith("-") then
            setText("")
            setRange(0, 1)
            setCaretPosition(getCaretPosition - 2)
            setAnchor(getAnchor - 2)
          else setRange(0, 0)
          change
        case _ if getSelection.getStart == 0 && getSelection.getEnd == getControlText.length =>
          selectRange(0, decimalPos)
          change
        case _ if getAnchor < decimalPos && getCaretPosition > decimalPos =>
          selectRange(0, decimalPos)
          change
        case _ if getAnchor > decimalPos && getCaretPosition <= decimalPos =>
          selectRange(decimalPos + 1, getControlText.length)
          change
        case _ if isContentChange =>
          if caretPos > decimalPos then
            val newText = getControlNewText
            val decimalSize = newText.length - (decimalPos + 1)
            if decimalSize < decimalPlaces then setText(getText + "0")
            else if decimalSize > decimalSize then
              setRange(decimalPos + 1, decimalPos + 1 + decimalPlaces)
              if caretPos == newText.length then
                setText(newText.substring(decimalPos + 2, decimalPos + 2 + decimalPlaces))
              else setText(newText.substring(decimalPos + 1, decimalPos + 1 + decimalPlaces))
          if getControlNewText.matches("-?([0-9]*)?(\\.[0-9]*)?") then change
          else null
      end match
    }
  end apply
end FixedDecimalFilter
