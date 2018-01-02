package mathlib.test.number
import mathlib.number.RealInt

class RealIntSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    val n = new RealInt(2)
    n must_== new RealInt(2)
  }
  "#abs" >> {
    "case: abs of positive integer" >>
    {
      val n = new RealInt(3)
      n.abs must_== 3
    }
    "case: abs of zero integer" >> {
      val n = new RealInt(0)
      n.abs must_== 0
    }
    "case: abs of negative integer" >> {
      val n = new RealInt(-3)
      n.abs must_== 3
    }
  }
}
