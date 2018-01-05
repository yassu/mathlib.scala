package mathlib.test.variable
import mathlib.variable.RealVariable

class RealVariableSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    "default constructor" >> {
      val x = new RealVariable('x)
      x must_== new RealVariable('x)
    }
    "charactor constructor" >> {
      val x = new RealVariable('x')
      x must_== new RealVariable('x')
    }
    "string constructor" >> {
      val x = new RealVariable("x")
      x must_== new RealVariable("x")
    }
  }
}
