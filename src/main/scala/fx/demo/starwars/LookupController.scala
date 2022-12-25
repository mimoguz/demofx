package fx.demo.starwars

import scalafx.beans.property.StringProperty
import scalafx.scene.layout.Region

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class LookupController(val planetNameProperty: StringProperty):
  private val viewModel = Model()
  private val interactor = Interactor(viewModel)
  private val viewBuilder = ViewBuilder(viewModel)(searchForCharacter)

  private def searchForCharacter(postSearchAction: () => Unit): Unit =
    val searchFuture = Future(interactor.lookupPerson())
    searchFuture.onComplete {
      case Success(_) =>
        interactor.updateModelAfterLookup()
        postSearchAction()
      case Failure(e) => e.printStackTrace()
    }

  def view: Region = viewBuilder.build()
end LookupController
