package mathlib.test.variable
import mathlib.variable.RealIntVariable

class RealIntVariableSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    "with symbol argument" >> {
      val n = new RealIntVariable('x)
      n must_== new RealIntVariable('x)
    }
    "with string argument" >> {
      val n = new RealIntVariable("x")
      n must_== new RealIntVariable('x)
    }
  }
  "#to_sym" >> {
    val n = new RealIntVariable('x)
    n.to_sym must_== 'x
  }
  "#toString" >> {
    val n = new RealIntVariable('x)
    n.toString must_== "V<x>"
  }
}

