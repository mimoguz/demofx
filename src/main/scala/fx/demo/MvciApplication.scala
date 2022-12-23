package fx.demo

import fx.demo.mvci.Controller
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene

object MvciApplication extends JFXApp3:
  override def start(): Unit =
    stage = new PrimaryStage:
      private val controller = Controller()
      scene = Scene(controller.view)
    stage.show()
