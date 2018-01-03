package mathlib.test.number
import mathlib.number.RealComplex

class RealComplexSpec extends org.specs2.mutable.Specification {
  "#Init" >> {
    "#WithAllArguments" >> {
      val z = new RealComplex(1, 2)
      z must_== new RealComplex(1, 2)
    }
    "#WithOnlyRealArgument" >> {
      val z = new RealComplex(2)
      z must_== new RealComplex(2, 0)
    }
  }
  "#real" >> {
    val z = new RealComplex(1, 2)
    z.real must_== 1
  }
  "#conjugate" >> {
    val z = new RealComplex(1, 2)
    z.conjugate must_== new RealComplex(1, -2)
  }
  "#abs" >> {
    val z = new RealComplex(3, 4)
    z.abs must_== 5.0
  }
  "#abs2" >> {
    val z = new RealComplex(3, 4)
    z.abs2 must_== 25.0
  }
  "#isApproximated" >> {
    val z1 = new RealComplex(1.0, 2.0)
    val z2 = new RealComplex(1.0, 2.0)
    val isOk = z1.isApproximated(z2)
    isOk must beTrue
  }
  "#isApproximated2" >> {
    val z1 = new RealComplex(1.0, 2.0)
    val z2 = new RealComplex(2.0, 3.0)
    val isOk = z1.isApproximated(z2)
    isOk must beFalse
  }
  "#unary_+" >> {
    val z = new RealComplex(1, 2)
    +z must_== new RealComplex(1, 2)
  }
  "#unary_-" >> {
    val z = new RealComplex(1, 2)
    -z must_== new RealComplex(-1, -2)
  }
  "implicit" >> {
    val z = new RealComplex(1, 2)
    2 + z must_== new RealComplex(3, 2)
  }
  "#+" >> {
    "for RealComplex" >> {
      val z1 = new RealComplex(2, 3)
      val z2 = new RealComplex(5, 7)
      (z1 + z2) must_== new RealComplex(7, 10)
    }
    "for Double" >> {
      val z = new RealComplex(1, 2)
      z + 2 must_== new RealComplex(3, 2)
    }
  }
  "#-" >> {
    "for RealComplex" >> {
      val z1 = new RealComplex(2, 3)
      val z2 = new RealComplex(5, 7)
      (z1 - z2) must_== new RealComplex(-3, -4)
    }
    "for Double" >> {
      val z = new RealComplex(1, 2)
      (z - 2) must_== new RealComplex(-1, 2)
    }
  }
  "#*" >> {
    "for RealComplex" >> {
      val z1 = new RealComplex(1, 2)
      val z2 = new RealComplex(3, 5)
      (z1 * z2) must_== new RealComplex(-7, 11)
    }
    "for Double" >> {
      val z = new RealComplex(1, 2)
      z * 2 must_== new RealComplex(2, 4)
    }
  }
  "#/" >> {
    "for RealComplex" >> {
      val z1 = new RealComplex(1, 2)
      val z2 = new RealComplex(3, 5)
      val isOk = (z1 / z2 * z2).isApproximated(new RealComplex(1, 2))
      isOk must beTrue
    }
    "for Double" >> {
      val z = new RealComplex(1, 2)
      z / 2 must_== new RealComplex(0.5, 1.0)
    }
  }
  "toString" >> {
    "toString1" >> {
      val z = new RealComplex(1, 2)
      z.toString must_== "1.0 + 2.0 i"
    }
    "toString2" >> {
      val z = new RealComplex(1, -2)
      z.toString must_== "1.0 - 2.0 i"
    }
    "toString3" >> {
      val z = new RealComplex(0.0, -2)
      z.toString must_== "- 2.0 i"
    }
    "toString4" >> {
      val z = new RealComplex(0.0, 0.0)
      z.toString must_== "0.0"
    }
  }
  "zero" >> {
    RealComplex.zero must_== new RealComplex(0)
  }
  "one" >> {
    RealComplex.one must_== new RealComplex(1)
  }
  "i" >> {
    RealComplex.i must_== new RealComplex(0, 1)
  }
  "fromPolar" >> {
    val real = RealComplex.fromPolar(2, Math.PI / 6)
    val expected = new RealComplex(Math.sqrt(3), 1.0)
    val isOk = real.isApproximated(expected)
    isOk must beTrue
  }
}
