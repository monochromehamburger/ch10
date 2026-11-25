public class Fraction{
	
	private int numerator;
	private int denominator;
	public Fraction(){
		numerator=(int)Math.ceil(Math.random()*10);
		denominator=(int)Math.ceil(Math.random()*10);
	}
	public Fraction(int num1, int num2){
		numerator=num1;
		denominator=num2;
		if(denominator==0){
			denominator=1;
			System.out.println("Error: Denominator cannot be 0");
		}
	}
	public Fraction(String input){
		numerator=Integer.parseInt(input.substring(0,input.indexOf('/')));
		denominator=Integer.parseInt(input.substring(input.indexOf('/')+1));
		if(denominator==0){
			denominator=1;
			System.out.println("Error: Denominator cannot be 0");
		}
	}
	public Fraction(Fraction f){
		numerator=f.numerator;
		denominator=f.denominator;
		if(denominator==0){
			denominator=1;
			System.out.println("Error: Denominator cannot be 0");
		}
	}
	public int getNum(){
		return numerator;
	}
	public int getDenom(){
		return denominator;
	}
	public boolean isEqual(Fraction f2){
		if(numerator==f2.getNum() && denominator==f2.getDenom())return true;
		if(Math.abs(numerator)==Math.abs(f2.getNum()) && Math.abs(denominator)==Math.abs(f2.getDenom()) && numerator*denominator == f2.getNum()*f2.getDenom())return true;
		return false;
	}
	public String toString(){
		return numerator+"/"+denominator;
	}
	public double toDouble(){
		return (double)numerator/denominator;
	}
	public void reduce(){
		int gcf=Fraction.GCF(numerator, denominator);
		numerator/=gcf;
		denominator/=gcf;
	}
	private static int GCF(int num1, int num2){
		while(num1!=num2){
			if(num1>num2){
				num1-=num2;
			}
			else{
				num2-=num1;
			}
		}
		return num1;
	}
	public void setNum(int input){
		numerator=input;
	}
	public void setDenom(int input){
		denominator=input;
	} 
	public static Fraction multiply(Fraction a, Fraction b){
		Fraction output=new Fraction(a.getNum()*b.getNum()+"/"+a.getDenom()*b.getDenom());
		output.reduce();
		return output;
	}
	public static Fraction divide(Fraction a, Fraction b){
		Fraction newB=new Fraction(b.denominator+"/"+b.numerator);
		Fraction output=Fraction.multiply(a,newB);
		return output;
	}
	public static Fraction add(Fraction a, Fraction b){
		int gcf=Fraction.GCF(a.denominator, b.denominator);
		int newDenominator=a.denominator*b.denominator/gcf;
		int newA=a.numerator*newDenominator/a.denominator;
		int newB=b.numerator*newDenominator/b.denominator;
		Fraction output=new Fraction((newA+newB)+"/"+newDenominator);
		return output;
	}
	public static Fraction subtract(Fraction a, Fraction b){
		int gcf=Fraction.GCF(Math.abs(a.denominator), Math.abs(b.denominator));
		int newDenominator=a.denominator*b.denominator/gcf;
		int newA=a.numerator*newDenominator/a.denominator;
		int newB=b.numerator*newDenominator/b.denominator;
		Fraction output=new Fraction((newA-newB)+"/"+newDenominator);

		return output;
	}
		
	
	
}
