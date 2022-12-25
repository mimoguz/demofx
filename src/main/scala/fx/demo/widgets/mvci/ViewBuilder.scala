package fx.demo.widgets.mvci

import fx.demo.Builder

import scalafx.scene.layout.Region

abstract class ViewBuilder[ViewModelClass](protected val viewModel: ViewModelClass) extends Builder[Region]
