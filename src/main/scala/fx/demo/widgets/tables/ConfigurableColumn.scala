package fx.demo.widgets.tables

import scalafx.scene.control.TableColumn

abstract class ConfigurableColumn[Child <: ConfigurableColumn[Child, S, T], S, T](heading: String)
    extends TableColumn[S, T](heading):
  def self: Child

  def withMinWidth(w: Double): Child =
    minWidth = w
    self

  def withMaxWidth(w: Double): Child =
    maxWidth = w
    self

  def withFixedWidth(w: Double): Child =
    minWidth = w
    maxWidth = w
    self
end ConfigurableColumn
