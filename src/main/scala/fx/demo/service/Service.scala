package fx.demo.service

class Service:
  def saveDataSomewhere(s: String): DomainObject =
    Thread.sleep(3000)
    DomainObject(s"$s - Saved")
