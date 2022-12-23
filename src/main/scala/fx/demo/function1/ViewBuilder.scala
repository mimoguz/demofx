package fx.demo.function1

import fx.demo.Builder

import scalafx.geometry.Insets
import scalafx.scene.layout.{Region, StackPane}

class ViewBuilder(private val swContent: Region) extends Builder[Region]:
  override def build(): Region =
    new StackPane:
      padding = Insets(4)
      children += swContent
