package fx.demo.widgets.buttons

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class ButtonAction(val backgroundJob: () => Unit)(postNonGuiAction: () => Unit = () => ())
  extends Function[() => Unit, Unit]:
  override def apply(postGuiAction: () => Unit): Unit =
    val backgroundFuture = Future(backgroundJob())
    backgroundFuture.onComplete {
      case Success(_) =>
        postNonGuiAction()
        postGuiAction()
      case Failure(e) => e.printStackTrace()
    }

