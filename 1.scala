class Rational(n:Int,d:Int){
  val num = n;
  val den = d;
  def + (r:Rational) = new Rational((this.num*r.den)+(this.den*r.num),this.den*r.den);
  def negative = new Rational(-this.num,this.den);
}