package mathlib.number
import mathlib.utils.NumberUtils

case class Complex(x: Double, y: Double) {
  def unary_+(): Complex = this
  def unary_-(): Complex = new Complex(-x, -y)
  def +(that: Complex): Complex = new Complex(
    x + that.x,
    y + that.y
  )
  def -(that: Complex): Complex = this + (-that)
  def *(that: Complex): Complex = new Complex(
    this.x * that.x - this.y * that.y,
    this.x * that.y + this.y * that.x
  )
  def /(that: Complex): Complex = this * new Complex(
    that.x / (that.x * that.x + that.y * that.y),
    -that.y / (that.x * that.x + that.y * that.y)
  )
  override def toString(): String = NumberUtils.numberString(List(x, y), List("1", "i"))
}
