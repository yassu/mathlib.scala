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
  "#unary_+" >> {
    val n = new RealInt(-3)
    +n must_== new RealInt(-3)
  }
  "#unary_-" >> {
    val n = new RealInt(-3)
    -n must_== new RealInt(3)
  }
  "#+" >> {
    "for RealInt" >> {
      val n1 = new RealInt(2)
      val n2 = new RealInt(5)
      n1 + n2 must_== new RealInt(7)
    }
    "for Int" >> {
      val n = new RealInt(2)
      n + 3 must_== new RealInt(5)
    }
  }
  "#-" >> {
    "for RealInt" >> {
      val n1 = new RealInt(2)
      val n2 = new RealInt(5)
      n1 - n2 must_== new RealInt(-3)
    }
    "for Int" >> {
      val n = new RealInt(-3)
      n - 3 must_== new RealInt(-6)
    }
  }
  "#*" >> {
    "for RealInt" >> {
      val n1 = new RealInt(2)
      val n2 = new RealInt(5)
      n1 * n2 must_== new RealInt(2 * 5)
    }
    "for Int" >> {
      val n = new RealInt(2)
      n * 3 must_== new RealInt(2 * 3)
    }
  }
  "#/" >> {
    "for RealInt" >> {
      val n1 = new RealInt(-10)
      val n2 = new RealInt(3)
      n1 / n2 must_== new RealInt(-3)
    }
    "for Int" >> {
      val n = new RealInt(7)
      n / 3 must_== new RealInt(7 / 3)
    }
  }
  "toString" >> {
    val n = new RealInt(-10)
    n.toString must_== "- 10"
  }
  "#zero" >> {
    RealInt.zero must_== new RealInt(0)
  }
  "#one" >> {
    RealInt.one must_== new RealInt(1)
  }
}
