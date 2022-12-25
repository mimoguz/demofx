package fx.demo.starwars

class Interactor(model: Model):
  private var noDataFound = false
  private var person: AnyRef = null
  private var planet: AnyRef = null

  def lookupPerson(): Unit =
    noDataFound = false

  def updateModelAfterLookup(): Unit = ???
