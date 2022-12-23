package fx.demo.starwars

import scalafx.concurrent.Task
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.layout.{HBox, Region, StackPane}
import scalafx.Includes.*

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class LookupBox extends StackPane():
  protected val viewModel: Model = Model()
  private val interactor = Interactor(viewModel)

  children += view

  private def searchForCharacter(postSearchAction: () => Unit): Unit =
    val searchFuture = Future(interactor.lookupPerson())
    searchFuture.onComplete {
      case Success(_) =>
        interactor.updateModelAfterLookup()
        postSearchAction
      case Failure(e) => e.printStackTrace()
    }

  private def view: Region =
    new HBox:
      spacing = 6.0
      children += Label("Name: ")
      children += new TextField:
        styleClass += "prompt"
        text <==> viewModel.name
      children += new Button("Search"):
        onAction = { _ =>
          disable = true
          searchForCharacter(() => disable = false)
        }