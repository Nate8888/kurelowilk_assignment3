package kurelowilk_problem2;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount(double bal) {
		this.savingsBalance = bal;
	}
	
	public double calculateMonthlyInterest() {
		double extra = annualInterestRate*savingsBalance/12.0;
		savingsBalance += extra;
		return savingsBalance;
	}
	
	public static void modifyInterestRate(double newRate) {
		annualInterestRate = newRate;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
