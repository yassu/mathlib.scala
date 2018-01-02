package mathlib.utils

object NumberUtils {
  def isApproximated(xs: List[Double], ys: List[Double], precision: Double = 0.00001): Boolean =
    xs.zip(ys).foldLeft(true) { (b, t) => b && (t._1 - t._2).abs < precision}
  def termString(x: Double, unit: String, withPositiveSgn: Boolean=false): String = {
    if (x == 0.0)
      return "0.0"

    (
      if (x > 0.0 && withPositiveSgn)
        "+ "
      else if (x >= 0.0)
        ""
      else
        "- "
    ) +
    x.abs + (
      if (unit == "1")
        ""
      else
        s" $unit"
    )
  }
  def replNumberString(xs: List[Double], units: List[String]): String = 
    xs.zip(units).collect { case t if t._1 != 0.0 => t }.
      map(term => termString(term._1, term._2, withPositiveSgn=true)).mkString(" ")
  def numberString(xs: List[Double], units: List[String]): String = {
    val replString = replNumberString(xs, units)
    if (replString == "")
      "0.0"
    else if(replString.startsWith("+ "))
      replString.drop("+ ".size)
    else
      replString
  }
}
