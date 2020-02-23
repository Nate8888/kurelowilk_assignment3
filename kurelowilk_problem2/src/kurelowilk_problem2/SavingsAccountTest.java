package kurelowilk_problem2;

//Write a program called SavingsAccountTest to test class SavingsAccount. Instantiate two SavingsAccount objects, saver1 and saver2, 
//with balances of $2000.00 and $3000.00, respectively. Set annualInterestRate to 4%, then calculate the monthly interest 
//for each of 12 months and print the monthly balances for both savers.
//Next, set the annualInterestRate to 5%, calculate the next month’s interest and print the new balances for both savers.

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		SavingsAccount.modifyInterestRate(0.04);
		for(int x = 0;x<12;x++) {
			System.out.println("Month "+(x+1)+": ");
			System.out.printf("Saver 1: %.2f%n", saver1.calculateMonthlyInterest());
			System.out.printf("Saver 2: %.2f%n", saver2.calculateMonthlyInterest());
			System.out.println();
		}
		SavingsAccount.modifyInterestRate(0.05);
		System.out.printf("Saver 1: %.2f%n", saver1.calculateMonthlyInterest());
		System.out.printf("Saver 2: %.2f%n", saver2.calculateMonthlyInterest());

	}

}
