package mathlib.variable

case class RealVariable(sym: Symbol) {
  def this(c: Char) = this(Symbol(c.toString))
  def this(s: String) = this(Symbol(s))
}
