trait Validator[T] {
  def validate(t: T): Option[ApiError]
}

object CalculateExpressionValidator extends Validator[String] {

  def validate(expression: String): Option[ApiError] =
    if (expression.isEmpty)
      Some(ApiError.mathExpressionNotValid(expression))
    else
      None
}

