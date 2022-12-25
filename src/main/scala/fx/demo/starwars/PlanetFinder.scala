package fx.demo.starwars

import scalafx.beans.property.ReadOnlyStringProperty

class PlanetFinder extends LookupBox:
  def planetProperty: ReadOnlyStringProperty = viewModel.homePlanet
