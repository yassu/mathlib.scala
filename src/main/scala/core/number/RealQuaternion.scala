package mathlib.number
import mathlib.utils.NumberUtils.{numberString, isApproximated}

case class RealQuaternion(x0: Double, x1: Double, x2: Double, x3: Double) {
  def this(x0: Double) = this(x0, 0, 0, 0)
  def real(): Double = x0
  def conjugate(): RealQuaternion = new RealQuaternion(x0, -x1, -x2, -x3)
  def abs():Double = Math.sqrt(this.abs2)
  def abs2(): Double = (this * this.conjugate).real
  def isApproximated(that: RealQuaternion, precision: Double) =
    mathlib.utils.NumberUtils.isApproximated(
      List(x0, x1, x2, x3), List(that.x0, that.x1, that.x2, that.x3))
  def unary_+ = this
  def unary_- = this * (-1)
  def +(that: RealQuaternion) = new RealQuaternion(
    x0 + that.x0,
    x1 + that.x1,
    x2 + that.x2,
    x3 + that.x3
  )
  def +(y: Double):RealQuaternion = this + new RealQuaternion(y, 0, 0, 0)
  def -(that: RealQuaternion):RealQuaternion = this + (-that)
  def -(y: Double):RealQuaternion = this + (-y)
  def *(that: RealQuaternion):RealQuaternion = new RealQuaternion(
    this.x0 * that.x0 - this.x1 * that.x1 - this.x2 * that.x2 - this.x3 * that.x3,
    this.x0 * that.x1 + this.x1 * that.x0 + this.x2 * that.x3 - this.x3 * that.x2,
    this.x0 * that.x2 - this.x1 * that.x3 + this.x2 * that.x0 + this.x3 * that.x1,
    this.x0 * that.x3 + this.x1 * that.x2 - this.x2 * that.x1 + this.x3 * that.x0
  )
  def *(y: Double):RealQuaternion = this * new RealQuaternion(y, 0, 0, 0)
  def /(that: RealQuaternion): RealQuaternion = this * that.conjugate / Math.pow(that.abs, 2)
  def /(y: Double): RealQuaternion = this * (1 / y)
  override def toString: String =
    numberString(List(x0, x1, x2, x3), List("1", "i", "j", "k"))
}

object RealQuaternion {
  def zero = new RealQuaternion(0, 0, 0, 0)
  def one = new RealQuaternion(1, 0, 0, 0)
  implicit def DoubleToRealQuaternion(x: Double) = new RealQuaternion(x)
}
