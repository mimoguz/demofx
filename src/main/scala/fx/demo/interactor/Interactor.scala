package fx.demo.interactor

import fx.demo.model.Model
import fx.demo.service.*

class Interactor(private val model: Model):
  private var domainObject: Option[DomainObject] = None
  private var changeCount = 0
  private val service = Service()

  createModelBindings()

  def saveData(): Unit =
    domainObject = Option(service.saveDataSomewhere(s"${model.property1} --> $changeCount"))

  def updateModelAfterSave(): Unit =
    model.property1 = ""
    model.property2 = domainObject.map(_.someValue).getOrElse("")
    changeCount = 0

  def updateChangeCount(): Unit =
    changeCount += 1

  private def createModelBindings(): Unit =
    model.bindProperty3(model.property1Property =!= "")
end Interactor
