package fx.demo.widgets.tables

import fx.demo.Util.by
import fx.demo.widgets.texts.Texts

import scalafx.geometry.Pos
import scalafx.scene.control.ProgressIndicator
import scalafx.scene.layout.VBox

class ProgressPlaceholder(message: String) extends VBox():
  spacing = 10.0
  fillWidth = true
  alignment = Pos.Center
  children ++= Seq(new ProgressIndicator() by (_.progress = -1.0), Texts.label(message))
