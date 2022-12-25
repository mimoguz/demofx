import fx.demo.starwars.api.*

val switcher = ArgumentSwitcher()
switcher.switch("planets", null)

val model = fx.demo.starwars.Model()
model.name.value = "Han Solo"
val interactor = fx.demo.starwars.Interactor(model)
interactor.lookupPerson()
interactor.updateModelAfterLookup()
model.name.value
model.gender.value
model.homePlanet.value
