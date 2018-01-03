package mathlib.utils

private trait numberTrait

object NumberUtils {

  def isApproximated[T](xs: List[T], ys: List[T], precision: T = 0.00001)(implicit num:Numeric[T]): Boolean =
    xs.zip(ys).foldLeft(true) { (b, t) => b && num.lt(num.abs(num.minus(t._1, t._2)), precision)}
  def termString[T](x: T, unit: String, withPositiveSgn: Boolean=false)(implicit num:Numeric[T]): String = {
    if (x == 0.0)
      return "0.0"

    (
      if (num.gt(x, num.zero) && withPositiveSgn)
        "+ "
      else if (num.gteq(x, num.zero))
        ""
      else
        "- "
    ) +
    num.abs(x) + (
      if (unit == "1")
        ""
      else
        s" $unit"
    )
  }
  def replNumberString[T](xs: List[T], units: List[String])(implicit num:Numeric[T]): String = 
    xs.zip(units).collect { case t if t._1 != 0.0 => t }.
      map(term => termString(term._1, term._2, withPositiveSgn=true)).mkString(" ")
  def numberString[T](xs: List[T], units: List[String])(implicit num:Numeric[T]): String = {
    val replString = replNumberString(xs, units)
    if (replString == "")
      "0.0"
    else if(replString.startsWith("+ "))
      replString.drop("+ ".size)
    else
      replString
  }
}
