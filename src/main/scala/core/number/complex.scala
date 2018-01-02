package mathlib.number
import mathlib.utils.NumberUtils

case class Complex(x: Double, y: Double) {
  def this(x: Double) = this(x, 0)
  def real(): Double = x
  def conjugate(): Complex = new Complex(
    x,
    -y
  )
  def abs(): Double = Math.sqrt(abs2)
  def abs2(): Double = (this * this.conjugate).real
  def isApproximated(that: Complex) =
    mathlib.utils.NumberUtils.isApproximated(
      List(x,y), List(that.x, that.y))
  def unary_+(): Complex = this
  def unary_-(): Complex = new Complex(-x, -y)
  def +(that: Complex): Complex = new Complex(
    x + that.x,
    y + that.y
  )
  def +(x2: Double): Complex = new Complex(x + x2, y)
  def -(that: Complex): Complex = this + (-that)
  def -(x2: Double): Complex = this + (-x2)
  def *(that: Complex): Complex = new Complex(
    this.x * that.x - this.y * that.y,
    this.x * that.y + this.y * that.x
  )
  def *(x2: Double): Complex = new Complex(x * x2, y * x2)
  def /(that: Complex): Complex = this * new Complex(
    that.x / (that.x * that.x + that.y * that.y),
    -that.y / (that.x * that.x + that.y * that.y)
  )
  def /(x2: Double): Complex = this * (1.0/x2)
  override def toString(): String = NumberUtils.numberString(List(x, y), List("1", "i"))
}

object Complex {
  def zero: Complex = new Complex(0.0)
  def one: Complex = new Complex(1.0)
  def fromPolar(d: Double, theta: Double): Complex =
    new Complex(d * Math.cos(theta), d * Math.sin(theta))
  implicit def DoubleToComplex(x: Double): Complex = new Complex(x)
}
