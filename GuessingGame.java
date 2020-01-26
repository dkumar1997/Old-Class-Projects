import java.util.Scanner;
import java.util.Random;

public class GuessingGame{
	private static int maxDefault = 10;
	private static int minDefault = 0;
	private int minGuess;
	private int maxGuess;
	private int numToGuess;
	//sets the random num
	void setRandominDefaultmNum(){
		numToGuess = new Random().nextInt((maxGuess - minGuess) + minGuess);
		System.out.println("Num to guess: "+numToGuess);	
	}
	// constructor for values of min and max
	public GuessingGame(int min, int max){
		this.setMaxGuess(max);
		this.setMinGuess(min);
	}
	//constructor for no data being put in
	public GuessingGame(){
		this(minDefault, maxDefault);
	}
	//constructor for only the max
	public GuessingGame(int max){
		this(minDefault, max);
	}
	
	//sets the max number
	void setMaxGuess(int userNum){
		if(userNum > minGuess && userNum != 0){
			maxGuess = userNum;
		}
	}
	//sets the minimum guess
	void setMinGuess(int userNum){
		if(userNum < maxGuess && userNum >= 0){
			minGuess = userNum;
		}
		
	}
	//returns the min guess
	public int getMinGuess(){
		return minGuess;
	}
	//returns max guess
	public int getMaxGuess(){
		return maxGuess;
	}
	//checks the guess to ensure its ok
	public boolean isValidGuess(String userGuess){
		Scanner keyboard = new Scanner(System.in);
		boolean guessCheck = false;
		int userNum;
		//makes sure the length is greater than 0
		if( userGuess.length() > 0){
			//if the length is 2, it checks both characters, to make sure they both are digits
			if(userGuess.length() == 2){
				if(Character.isDigit(userGuess.charAt(0)) == true && Character.isDigit(userGuess.charAt(1)) == true ){
					userNum = Integer.parseInt(userGuess);
					//if the user guesses a number within the proper range, its fine
					if(userNum >=minGuess  && userNum < maxGuess){
						guessCheck = true;
					}
					else{
						System.out.println("Error, out of Range.");
					}
				}
				else{
					System.out.println("Invalid guess");
				}
			}
			//checks to make sure the input is a digit
			else if(Character.isDigit(userGuess.charAt(0)) == true){
				userNum = Integer.parseInt(userGuess);
				//if the user guesses a number within the proper range, its fine
				if(userNum >=minGuess  && userNum < maxGuess){
					guessCheck = true;
				}
				else{
					System.out.println("Error, out of Range.");
				}
			}
			else{
			System.out.println("Invalid guess");
			}
		}
		else{
			//prints an error message
			System.out.println("Invalid Guess");
			
		}
		return guessCheck;
	}
		
	public void play(){
		Scanner keyboard = new Scanner(System.in);
		//Variables in the method are intialized
		int userGuess = -1;
		setRandominDefaultmNum();
		String guess = "";
		boolean guessOk = false;
		System.out.println("Max: " + getMaxGuess() + " Min: " + getMinGuess());
		while(userGuess != numToGuess){
			//guess ok is set to false, so the error check loop runs each time
			guessOk = false;
			while(guessOk == false){
				//Loop asks for input and error checks
				System.out.print("What is your guess?: ");
				guess = keyboard.next();
				guessOk = isValidGuess(guess);
			}
			//converts the string guess into an integer
			userGuess = Integer.parseInt(guess);
			if (userGuess != numToGuess){
				System.out.println("Try again!");
			}
		}
		System.out.println("Correct!");
		
	
	}
}