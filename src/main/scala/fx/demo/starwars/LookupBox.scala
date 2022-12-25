package fx.demo.starwars

import fx.demo.Util.by

import scalafx.Includes.*
import scalafx.concurrent.Task
import scalafx.scene.control.{Button, Label, TextField}
import scalafx.scene.layout.{HBox, Region, StackPane}

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
    new HBox().by { box =>
      box.spacing = 6.0
      box.children += Label("Name: ")
      box.children += new TextField by { txt =>
        txt.styleClass += "prompt"
        txt.text <==> viewModel.name
      }
      box.children += new Button("Search") by { btn =>
        btn.onAction = _ =>
          disable = true
          searchForCharacter(() => disable = false)
      }
    }
end LookupBox
