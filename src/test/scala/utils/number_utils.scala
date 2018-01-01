package mathlib.test.utils
import mathlib.utils._
import org.specs2._

class NumberUtilsSpec extends org.specs2.mutable.Specification {
  "#termString" >> {
    "case: positive term" >> {
      NumberUtils.termString(2.0, "i") must_== "2.0 i"
    }
    "case: 1 term" >> {
      NumberUtils.termString(2.0, "1") must_== "2.0"
    }
    "case: negative term" >> {
      NumberUtils.termString(-2.0, "i") must_== "- 2.0 i"
    }
    "case: negative 1 term" >> {
      NumberUtils.termString(-2.0, "1") must_== "- 2.0"
    }
    "case: with positive sgn" >> {
      NumberUtils.termString(2.0, "i", withPositiveSgn=true) must_== "+ 2.0 i"
    }
    "case: with positive sgn2" >> {
      NumberUtils.termString(-2.0, "i", withPositiveSgn=true) must_== "- 2.0 i"
    }
    "case: 0.0" >> {
      NumberUtils.termString(0.0, "i") must_== "0.0"
    }
  }
  "numberString" >> {
    "case 2.0 i" >> {
      NumberUtils.numberString(List(2.0), List("i")) must_== "2.0 i"
    }
    "case 2.0 + 3.0 i" >> {
      NumberUtils.numberString(List(2.0, 3.0), List("1", "i")) must_== "2.0 + 3.0 i"
    }
    "case -2.0 + 3.0 i" >> {
      NumberUtils.numberString(List(-2.0, 3.0), List("1", "i")) must_== "- 2.0 + 3.0 i"
    }
    "case 0.0 + 3.0 i + 0.0 j - 2.0 k" >> {
      NumberUtils.numberString(List(0.0, 3.0, 0.0, -2.0), List("1", "i", "j", "k")) must_==
        "3.0 i - 2.0 k"
    }
    "case 0.0" >> {
      NumberUtils.numberString(List(0.0), List("1")) must_== "0.0"
    }
  }
}

