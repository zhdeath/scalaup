/*
  a class that models rational number -- immutable object style
*/

class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g
  
  def this(n: Int) = this(n, 1)
  
  override def toString = numer + "/" + denom
  
  // greatest common divisor -- Euclidean's Algorithm
  private def gcd(a: Int, b: Int): Int = {
    if(b == 0) a else gcd(b, a%b)
  }
  
  def lessThan(that: Rational) = {
    (this.denom * that.denom > 0 && this.numer * that.denom < that.numer * this.denom) || 
      (this.denom * that.denom < 0 && this.numer * that.denom > that.numer * this.denom)
  }
  def max(that: Rational) = {
    if(lessThan(that)) that
    else this
  }
  
  def + (that: Rational) = {
    new Rational(numer * that.denom + denom * that.numer, 
      denom * that.denom)
  }
  def * (that: Rational) = {
    new Rational(numer * that.numer, denom * that.denom)
  }
  def - (that: Rational) = {
    new Rational(numer * that.denom - denom * that.numer,
      denom * that.denom)
  }
  def / (that: Rational) = {
    new Rational(numer * that.denom, denom * that.numer)
  }
  
  // methods overload
  def + (i: Int) = {
    new Rational(numer + i * denom, denom)
  }
  def - (i: Int) = {
    new Rational(numer - i * denom, denom)
  }
  def * (i: Int) = {
    new Rational(numer * i, denom)
  }
  def / (i: Int) = {
    new Rational(numer, denom * i)
  }
}

// implicit convention from Int to Rational when needed
implicit def initToRational(x: Int) = new Rational(x)
