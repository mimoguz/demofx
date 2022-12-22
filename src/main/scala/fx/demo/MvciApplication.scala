package fx.demo

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene

import fx.demo.controller.Controller

object MvciApplication extends JFXApp3:
  override def start(): Unit =
    stage = new PrimaryStage:
      val controller = Controller()
      scene = Scene(controller.view)
    stage.show()
