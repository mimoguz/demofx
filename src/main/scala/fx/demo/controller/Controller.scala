package fx.demo.controller

import fx.demo.interactor.Interactor
import fx.demo.model.Model
import fx.demo.view.ViewBuilder

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

import scalafx.Includes.*
import scalafx.scene.layout.Region

class Controller:
  private val model = Model()
  private val interactor = Interactor(model)
  private val viewBuilder = ViewBuilder(model, saveData)

  setProperty1Listener()

  def view: Region = viewBuilder.build()

  private def saveData(postActionGuiCleanUp: () => Unit): Unit =
    val saveFuture = Future(interactor.saveData())
    saveFuture.onComplete {
      case Success(_) =>
        interactor.updateModelAfterSave()
        postActionGuiCleanUp()
      case Failure(e) => e.printStackTrace()
    }

  private def setProperty1Listener(): Unit =
    model.property1Property.addListener((_, _, _) => interactor.updateChangeCount())
end Controller
