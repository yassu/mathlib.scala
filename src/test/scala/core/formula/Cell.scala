package mathlib.test.formula
import mathlib.formula.Cell
import mathlib.variable.RealIntVariable

class CellSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    val n = new RealIntVariable('x)
    val c = new Cell(n)
    val n2 = new RealIntVariable('x)
    val c2= new Cell(n)
    c must_== c2
  }
}

