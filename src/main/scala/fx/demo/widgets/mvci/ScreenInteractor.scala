package fx.demo.widgets.mvci

abstract class ScreenInteractor[ViewModelClass](protected val viewModel: ViewModelClass) :
  def fetchData(): Unit
  def updateModel(): Unit