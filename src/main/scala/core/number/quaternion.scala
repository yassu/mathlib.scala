package mathlib.number
import mathlib.utils.NumberUtils

case class Quaternion(x0: Double, x1: Double, x2: Double, x3: Double) {
  def this(x0: Double) = this(x0, 0, 0, 0)
  def real(): Double = x0
  def conjugate(): Quaternion = new Quaternion(x0, -x1, -x2, -x3)
  def abs():Double = Math.sqrt((this * this.conjugate).real)
  def isApproximated(that: Quaternion, precision: Double) =
    (x0 - that.x0).abs < precision &&
    (x1 - that.x1).abs < precision &&
    (x2 - that.x2).abs < precision &&
    (x3 - that.x3).abs < precision
  def unary_+ = this
  def unary_- = this * (-1)
  def +(that: Quaternion) = new Quaternion(
    x0 + that.x0,
    x1 + that.x1,
    x2 + that.x2,
    x3 + that.x3
  )
  def +(y: Double):Quaternion = this + new Quaternion(y, 0, 0, 0)
  def -(that: Quaternion):Quaternion = this + (-that)
  def -(y: Double):Quaternion = this + (-y)
  def *(that: Quaternion):Quaternion = new Quaternion(
    this.x0 * that.x0 - this.x1 * that.x1 - this.x2 * that.x2 - this.x3 * that.x3,
    this.x0 * that.x1 + this.x1 * that.x0 + this.x2 * that.x3 - this.x3 * that.x2,
    this.x0 * that.x2 - this.x1 * that.x3 + this.x2 * that.x0 + this.x3 * that.x1,
    this.x0 * that.x3 + this.x1 * that.x2 - this.x2 * that.x1 + this.x3 * that.x0
  )
  def *(y: Double):Quaternion = this * new Quaternion(y, 0, 0, 0)
  def /(that: Quaternion): Quaternion = this * that.conjugate / Math.pow(that.abs, 2)
  def /(y: Double): Quaternion = this * (1 / y)
  override def toString: String =
    NumberUtils.numberString(List(x0, x1, x2, x3), List("1", "i", "j", "k"))
}

object Quaternion {
  def zero = new Quaternion(0, 0, 0, 0)
  def one = new Quaternion(1, 0, 0, 0)
  implicit def DoubleToQuaternion(x: Double) = new Quaternion(x)
}
