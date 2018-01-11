package mathlib.variable

case class RealIntVariable(val sym: Symbol) {
  def this(s: String) = this(Symbol(s))
  def to_sym: Symbol = sym
  override def toString: String = s"V<${sym.name}>"
}
