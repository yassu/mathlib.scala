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
  }
}

