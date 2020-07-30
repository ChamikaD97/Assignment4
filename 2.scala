class Rational(numer:Int,denom:Int){
  val numerator = numer;
  val denominator = denom;
  def + (r:Rational) = new Rational((this.numerator*r.denominator)+(this.denominator*r.numerator),this.denominator*r.denominator);
  def negative = new Rational(-this.numerator,this.denominator);
  def - (r:Rational) = this + r.negative;
  override def toString: String = this.numerator + "/" +  this.denominator;
}