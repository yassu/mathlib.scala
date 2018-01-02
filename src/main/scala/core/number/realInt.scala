package mathlib.number
import mathlib.utils.NumberUtils

case class RealInt(n: Int) {
  def abs(): Int = n.abs
  def unary_+(): RealInt = this
  def unary_-(): RealInt = new RealInt(-n)
  def +(that: RealInt): RealInt = new RealInt(n + that.n)
  def +(n2: Int): RealInt = new RealInt(n + n2)
  def -(that: RealInt): RealInt = this + (-that)
  def -(n2: Int): RealInt = this + (-n2)
  def *(that: RealInt): RealInt = new RealInt(this.n * that.n)
  def *(n2: Int): RealInt = new RealInt(n * n2)
  def /(that: RealInt): RealInt = new RealInt(this.n / that.n)
  def /(n2: Int): RealInt = new RealInt(n / n2)
  override def toString(): String = NumberUtils.numberString(List(n), List("1"))
}
