public class Main{
	public static void main(String[] args){
		Fraction f=new Fraction("6/9");
		f.reduce();
		System.out.println(f.getNum()+" "+f.getDenom());
		Fraction f2=new Fraction("6/7");
		Fraction f3=Fraction.subtract(f,f2);
		System.out.println(f3);
	} 
}
