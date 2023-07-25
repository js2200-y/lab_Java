package edu.java.class08;

public class ClassMain08 {

	public static void main(String[] args) {
		Account account = new Account(123456, 5000);
		Account to = new Account(987654,0);
		account.printInfo();
		
		account.deposit(1000);
		account.printInfo();
		
		account.withdraw(500);
		account.printInfo();
		
		account.transfer(2000, to);
		
		to.printInfo();
		
		account.printInfo();
		
		
		
	}

}
