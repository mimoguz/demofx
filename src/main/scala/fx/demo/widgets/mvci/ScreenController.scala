package fx.demo.widgets.mvci

import fx.demo.Builder

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

import scalafx.scene.layout.Region

abstract class ScreenController[ViewModelClass]:
  protected def viewBuilder: Builder[Region]
  protected def interactor: ScreenInteractor[ViewModelClass]
  protected lazy val view: Region = viewBuilder.build()

  protected def load(postFetchGui: () => Unit): Unit =
    val fetchFuture = Future(interactor.fetchData())
    fetchFuture.onComplete {
      case Success(_) =>
        interactor.updateModel()
        postFetchGui()
      case Failure(e) => e.printStackTrace()
    }


