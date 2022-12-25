package fx.demo.starwars.api

enum ApiResult[T]:
  case Error(statusCode: Int, statusMessage: String) extends ApiResult[T]
  case Value(value: T) extends ApiResult[T]

case class ApiError(statusCode: Int, statusMessage: String)

object Api:
  def get(path: String, searchQuery: Option[String] = None): ApiResult[ujson.Value.Value] =
    try
      val response = searchQuery match
        case Some(s) => requests.get(s"https://swapi.dev/api/$path", params = Map("search" -> s))
        case None    => requests.get(s"https://swapi.dev/api/$path/")
      read(response)
    catch case e: requests.RequestFailedException => ApiResult.Error(e.response.statusCode, e.response.statusMessage)

  private def read(response: requests.Response): ApiResult[ujson.Value.Value] =
    if response.statusCode != 200 then ApiResult.Error(response.statusCode, response.statusMessage)
    else ApiResult.Value(ujson.read(response.text()))
end Api
