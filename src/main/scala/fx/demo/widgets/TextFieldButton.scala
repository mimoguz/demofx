package fx.demo.widgets

import fx.demo.Util.by
import fx.demo.widgets.texts.{Labels, Texts}

import scalafx.Includes.*
import scalafx.beans.property.StringProperty
import scalafx.geometry.Pos
import scalafx.scene.control.Button
import scalafx.scene.layout.HBox

class TextFieldButton(
    private val label: String,
    private val buttonText: String,
    private val boundValue: StringProperty,
    private val buttonAction: (() => Unit) => Unit
) extends HBox:
  private var preRunAction: Option[() => Unit] = None
  private var postRunAction: Option[() => Unit] = None

  spacing = 6.0
  alignment = Pos.CenterLeft
  
  {
    val textField = Texts.textField(boundValue)
    val button = new Button(buttonText) by { btn =>
      btn.onAction = e =>
        btn.disable = true
        preRunAction.foreach(_())
        buttonAction { () =>
          postRunAction.foreach(_())
          btn.disable = false
        }
      btn.defaultButton <== textField.focused && textField.text =!= ""
    }
    children ++= Seq(Labels.prompt(label), textField, button)
  }

  def withPreRunAction(action: () => Unit): TextFieldButton =
    preRunAction = Option(action)
    this

  def withPostRunAction(action: () => Unit): TextFieldButton =
    postRunAction = Option(action)
    this
end TextFieldButton
