import java.util.Scanner;

public class Converter{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		

		System.out.print("What is the temerature? ");
		int temprature = keyboard.nextInt();
		System.out.print("Is that in Kelvin (K) or Celsius (C)? ");
		String temptype = keyboard.next();
		Double c = temprature + 273.15;
		Double d = temprature - 273.15;
		int a = c.intValue();
		int b = d.intValue();

		if (temptype.equals("C") || temptype.equals("c")){
			//int answer1 = Integer.valueOf(temprature + 273.15);
			System.out.println("That is " + a + " Kelvin.");
		}
		else if (temptype.equals("K") || temptype.equals("k")){
			//int answer2 = Integer.valueOf(temprature - 273.15);

			System.out.println("That is " + b + " Celsius.");
		}
		else{
			System.out.println("That is not valid, please enter either K or C.");
		}

	}
}





