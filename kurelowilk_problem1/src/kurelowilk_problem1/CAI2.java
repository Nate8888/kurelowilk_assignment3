package kurelowilk_assignment3;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;

public class CAI2 {

//	The program shall generate random numbers with a SecureRandom object
//	The program shall ask the student to solve a multiplication problem
//	A multiplication problem shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
//	The program shall display the message "Very good!" if the student provides a correct response
//	The program shall display the message "No. Please try again." if the student provides an incorrect response
//	The program shall terminate when a correct response is provided by the student
//	The program shall continue to ask the student to solve the original multiplication problem until the student provides the correct answer
//	Create a method called "quiz" that contains the program logic
//	Create a method called "askQuestion" that prints the problem to the screen
//	Create a method called "readResponse" that reads the answer from the student
//	Create a method called "isAnswerCorrect" that checks to see if the student's answer matches the correct answer to the problem
//	Create a method called "displayCorrectResponse" that prints out the response when a student enters a correct answer
//	Create a method called "displayIncorrectResponse" that prints out the response when a student enters an incorrect answer
//	Create a main method that runs your program by calling the "quiz" method
	
	
	public static void quiz() {
		SecureRandom secureRandom = new SecureRandom();
		int secureNumberOne = secureRandom.nextInt(10);
		int secureNumberTwo = secureRandom.nextInt(10);
		
		int actualResult = secureNumberOne*secureNumberTwo;
		
		askQuestion(secureNumberOne, secureNumberTwo);
		int userAnswer = readResponse();
		
		boolean isCorrect = isAnswerCorrect(userAnswer, actualResult);
		while(isCorrect == false) {
			isCorrect = isAnswerCorrect(readResponse(), actualResult);
		}
		
	}
	
	public static void askQuestion(int secOne, int secTwo) {
		
		System.out.println("How much is "+ secOne +" times "+secTwo +"?");
	}
	
	public static int readResponse() {
		Scanner sc = new Scanner(System.in);
		int userAnswer = sc.nextInt();
		return userAnswer;
	}
	
	public static boolean isAnswerCorrect(int userAnswer, int actualAnswer) {
		if(userAnswer == actualAnswer) {
			displayCorrectResponse();
			return true;
		}
		else {
			displayIncorrectResponse();
			return false;
		}
	}
	
	public static void displayCorrectResponse() {

		SecureRandom rand = new SecureRandom();
		
		int randomMessageIndex = rand.nextInt(4)+1;
		
		switch(randomMessageIndex) {
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	
	public static void displayIncorrectResponse() {
		
		SecureRandom secureRandom = new SecureRandom();
		
		int randomMessageIndex = secureRandom.nextInt(4)+1;
		
		switch(randomMessageIndex) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don’t give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	public static void main(String[] args) {
		quiz();
	}

}
