import java.util.*;
import java.lang.Math;
public class FractionQuiz{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		String input="";
		int right=0;
		int wrong=0;
		while(true){
		
			Fraction f1=new Fraction();
			Fraction f2=new Fraction();
			f1.reduce();
			f2.reduce();
			double rand=Math.random();
			Fraction correctAnswer=new Fraction();
			if(rand<0.25){
				correctAnswer=Fraction.add(f1, f2);
				System.out.print(f1+" + "+f2 + " = ");
			}
			else if(rand<0.5){
				correctAnswer=Fraction.subtract(f1, f2);
				System.out.print(f1+" - "+f2 + " = ");
			}
			else if(rand<0.75){
				correctAnswer=Fraction.multiply(f1, f2);
				System.out.print(f1+" * "+f2 + " = ");
			}
			else{
				correctAnswer=Fraction.divide(f1, f2);
				System.out.print(f1+" / "+f2 + " = ");
			}
			correctAnswer.reduce();
			input=sc.nextLine();
			if(input.toLowerCase().equals("quit"))break;
			Fraction answer=new Fraction(input);
			if(answer.isEqual(correctAnswer)){
				System.out.println("CORRECT");
				right+=1;
			} 
			else{
				System.out.println("WRONG");
				wrong+=1;
			}
		}
		Fraction output=new Fraction(right, right+wrong);
		System.out.println("u answered "+output+" correct, "+ "for a score of "+(output.toDouble()*100)+"%");
		
		
		
	} 
}
