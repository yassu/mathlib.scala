package mathlib.number
import mathlib.utils.NumberUtils

case class RealComplex(x: Double, y: Double) {
  def this(x: Double) = this(x, 0)
  def real(): Double = x
  def conjugate(): RealComplex = new RealComplex(
    x,
    -y
  )
  def abs(): Double = Math.sqrt(abs2)
  def abs2(): Double = (this * this.conjugate).real
  def isApproximated(that: RealComplex) =
    mathlib.utils.NumberUtils.isApproximated(
      List(x,y), List(that.x, that.y))
  def unary_+(): RealComplex = this
  def unary_-(): RealComplex = new RealComplex(-x, -y)
  def +(that: RealComplex): RealComplex = new RealComplex(
    x + that.x,
    y + that.y
  )
  def +(x2: Double): RealComplex = new RealComplex(x + x2, y)
  def -(that: RealComplex): RealComplex = this + (-that)
  def -(x2: Double): RealComplex = this + (-x2)
  def *(that: RealComplex): RealComplex = new RealComplex(
    this.x * that.x - this.y * that.y,
    this.x * that.y + this.y * that.x
  )
  def *(x2: Double): RealComplex = new RealComplex(x * x2, y * x2)
  def /(that: RealComplex): RealComplex = this * that.conjugate / that.abs2
  def /(x2: Double): RealComplex = this * (1.0/x2)
  override def toString(): String = NumberUtils.numberString(List(x, y), List("1", "i"))
}

object RealComplex {
  def zero: RealComplex = new RealComplex(0.0)
  def one: RealComplex = new RealComplex(1.0)
  def fromPolar(d: Double, theta: Double): RealComplex =
    new RealComplex(d * Math.cos(theta), d * Math.sin(theta))
  implicit def DoubleToRealComplex(x: Double): RealComplex = new RealComplex(x)
}
