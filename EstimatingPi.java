import java.util.*;
import java.lang.Math;
public class EstimatingPi{
	public static void main(String[] args){
		Fraction MILU = new Fraction("56778/18073");
		Fraction betterOption=new Fraction("56778/18073");
		double EPSILON = Math.abs( Math.PI - MILU.toDouble() );
		while(true){
			
			while(Math.abs(Math.PI-betterOption.toDouble())>=EPSILON){
				double value=Math.PI-betterOption.toDouble();
				if(value<0){
					betterOption.setDenom(betterOption.getDenom()+1);
				}
				else{
					betterOption.setNum(betterOption.getNum()+1);
				}
			}
			MILU.setNum(betterOption.getNum());
			MILU.setDenom(betterOption.getDenom());
			EPSILON = Math.abs( Math.PI - MILU.toDouble() );
			System.out.println(betterOption);
		}
		
	} 
}
