package fx.demo.view

import scalafx.scene.Node

// ScalaFx doesn't have a Builder trait.
// Using JavaFx version means I would need to unbox just to re-box the ui delegate.
trait Builder[T <: Node]:
  def build(): T
