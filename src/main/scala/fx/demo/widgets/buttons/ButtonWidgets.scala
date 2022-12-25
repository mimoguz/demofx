package fx.demo.widgets.buttons

import fx.demo.Util.by

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Button

object ButtonWidgets:
  def actionButton(buttonText: String, actionEventHandler: EventHandler[ActionEvent]): Button =
    Button(buttonText) by (_.onAction = actionEventHandler)

  def styledButton(buttonText: String, buttonStyle: String, actionEventHandler: EventHandler[ActionEvent]): Button =
    Button(buttonText) by { b =>
      b.onAction = actionEventHandler
      b.styleClass += buttonStyle
    }
