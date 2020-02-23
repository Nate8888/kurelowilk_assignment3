package kurelowilk_problem1;
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;

public class CAI5 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void quiz() {
		int correct = 0;
		int incorrect = 0;
		int count = 1;
		
		int difficulty = readDifficulty();
		int problemType = readProblemType();
		int maxNumber = generateQuestionArgument(difficulty);
		
		
		while(count<=10) {
			int secureNumberOne = generateQuestionArgument(difficulty);
			int secureNumberTwo = generateQuestionArgument(difficulty);
			
			double actualResult = askQuestion(secureNumberOne, secureNumberTwo, problemType);
			double userAnswer = readResponse();
			
			boolean isCorrect = isAnswerCorrect(userAnswer, actualResult);
			if(isCorrect == true) {
				correct++;
			}
			else {
				incorrect++;
			}
			count++;
		}
		displayCompletionMessage(correct/10.0);
		System.out.println("Do you want to solve a new problem set? [1 = yes, 0 = no]");
		int ans = sc.nextInt();
		if(ans==1) {
			quiz();
		}
		else{
			return;
		}
		
	}
	
	public static int readProblemType() {
		System.out.println("Enter Problem type Number: (+,*,-,/,mixed) [1-5]");
		System.out.println("Note: Tolerance is .01");
		return sc.nextInt();
	}

	public static int generateQuestionArgument(int difficulty) {
		SecureRandom secureRandom = new SecureRandom();
		return secureRandom.nextInt((int) Math.pow(10, difficulty));
	}

	public static int readDifficulty() {
		System.out.println("Enter Difficulty: [1-4]");
		return sc.nextInt();
	}

	public static void displayCompletionMessage(double percentage) {
		if(percentage >= 0.75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
		}
		
	}
	public static double askQuestion(int secOne, int secTwo, int operation) {
		String[] arr = {"plus","times","minus","divided by"};
		if(operation == 5) {
			SecureRandom secureRandom = new SecureRandom();
			int nr = secureRandom.nextInt(4); //Ignore the 5th and generates random question
			System.out.println("How much is "+ secOne +" "+arr[nr]+" "+secTwo+"?");
			
			return arithmeticOperation(secOne,secTwo,nr+1);
		}
		System.out.println("How much is "+ secOne +" "+arr[operation-1]+" "+secTwo+"?");
		
		return arithmeticOperation(secOne,secTwo,operation);
	}
	
	public static double arithmeticOperation(int secOne, int secTwo, int operation) {
		switch(operation) {
		case 1:
			return secOne+secTwo;
		case 2:
			return secOne*secTwo;
		case 3:
			return secOne-secTwo;
		case 4:
			return ((double) secOne)/secTwo;
		}
		return 0;
	}
	
	public static double readResponse() {
		double userAnswer = sc.nextDouble();
		return userAnswer;
	}
	
	public static boolean isAnswerCorrect(double userAnswer, double actualResult) {
		if((Math.abs(actualResult - userAnswer) < .01)) {
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
