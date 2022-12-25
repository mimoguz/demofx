package fx.demo.starwars.api

enum ApiResult[+A]:
  case Error(statusCode: Int, statusMessage: String) extends ApiResult[Nothing]
  case Value(value: A) extends ApiResult[A]

  def map[B](f: A => B): ApiResult[B] = this match
    case Error(c, m) => Error(c, m)
    case Value(a)    => Value(f(a))

  def foreach(f: A => Unit): Unit = this match
    case Error(c, m) => ()
    case Value(a)    => f(a)

  def toOption: Option[A] = this match
    case Error(_, _) => None
    case Value(a)    => Option(a)
end ApiResult

case class ApiError(statusCode: Int, statusMessage: String)

class Api:
  def get(path: String, searchQuery: Option[String] = None): ApiResult[ujson.Value.Value] =
    try
      val response = searchQuery match
        case Some(s) => requests.get(s"https://swapi.dev/api/$path", params = Map("search" -> s))
        case None    => requests.get(s"https://swapi.dev/api/$path/")
      read(response)
    catch case e: requests.RequestFailedException => ApiResult.Error(e.response.statusCode, e.response.statusMessage)

  def getEntry(url: String): ApiResult[ujson.Value.Value] =
    try read(requests.get(url))
    catch case e: requests.RequestFailedException => ApiResult.Error(e.response.statusCode, e.response.statusMessage)

  private def read(response: requests.Response): ApiResult[ujson.Value.Value] =
    if response.statusCode != 200 then ApiResult.Error(response.statusCode, response.statusMessage)
    else ApiResult.Value(ujson.read(response.text()))
end Api
