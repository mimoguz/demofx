package fx.demo.service

class Service:
  def saveDataSomeWhere(s: String): DomainObject =
    try Thread.sleep(3000)
    catch case e: InterruptedException => throw e
    DomainObject(s"$s - Saved")
