package com.bank.transection;

//Bank.java
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class  Bank{
	private BankAccount[] accounts;
	private int                      size;

	private Scanner scanner;
	private AtomicLong accNumGenerator ;
	
	public Bank(){
		accounts = new BankAccount[10];
	    size	 = 0;
		scanner	 = new Scanner(System.in);

		try{
		
			@SuppressWarnings("resource")
			BufferedReader accNumReader = new BufferedReader(new FileReader("accNumSeq.txt"));
			Long accNumSeq	= Long.parseLong(accNumReader.readLine());
			accNumGenerator = new AtomicLong(accNumSeq);

		}catch(FileNotFoundException e){
			System.out.println("accNumSeq.txt is not found");
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void openAccount(){

		long accNum = this.accNumGenerator.incrementAndGet();

		System.out.print("Enter Account Holder Name: ");
		String accHName = scanner.nextLine();

		System.out.print("Enter balance: ");
		double balance = scanner.nextDouble(); scanner.nextLine();

		System.out.println("BankAccount object creation started....");
		try{Thread.sleep(2000);}
		catch(InterruptedException e){}

		BankAccount account = new BankAccount(accNum, accHName, balance);
		System.out.println("BankAccount object is created");
		try{Thread.sleep(2000);}
		catch(InterruptedException e){}

		accounts[size++] = account;

		System.out.println("BankAccount object is stored in Bank");
		try{Thread.sleep(2000);}
		catch(InterruptedException e){}

	}

	public void deposit(long accNum, double amt) throws IllegalArgumentException{
		System.out.println("deposit operation start");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }
		
		if(accNum <= 0)
			throw new IllegalArgumentException("Account can not be -VE number and ZERO");
		
		if(amt <= 0)
			throw new IllegalArgumentException("Amount can not be -VE number ZERO");

		System.out.println("Searching for given accountNumber  object");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

		//Linear search algorithm 
		for(int i=0; i<size; i++){ //for finding BankAccount object for the given accnumber
			BankAccount account = accounts[i];

			if(account.getAccNum() == accNum){
				account.deposit(amt);
				System.out.println("Cash RS "+ amt + " is credited to your account");
				try{Thread.sleep(2000);}
				catch(InterruptedException e ){ }
				return;
			}
		}//for loop closed
		
		throw new IllegalArgumentException("Account is not found with the given details");

	}//deposit close

	public void withdraw(long accNum, double amt) throws IllegalArgumentException{

		System.out.println("withdraw operation start");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }
		
		if(accNum <= 0)
			throw new IllegalArgumentException("Account can not be -VE number and ZERO");

		if(amt <= 0)
			throw new IllegalArgumentException("Amount can not be -VE number and ZERO");

		System.out.println("Searching for given accountNumber  object");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

		//Linear search algorithm 
		for(int i=0; i<size; i++){ //for finding BankAccount object for the given accnumber
			BankAccount account = accounts[i];

			if(account.getAccNum() == accNum){
				account.withdraw(amt);
				System.out.println("Cash Rs "+ amt + " is debited from your account");
				try{Thread.sleep(2000);}
				catch(InterruptedException e ){ }
				return;
			}
		}//for loop closed
		
		throw new IllegalArgumentException("Account is not found with the given details");

	}//withdraw close

	public void balanceEnquiry(long accNum) throws IllegalArgumentException{

		System.out.println("balance equiry operation start");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }
		
		if(accNum <= 0)
			throw new IllegalArgumentException("Account can not be -VE number and ZERO");
		
		System.out.println("Searching for given accountNumber  object");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

		//Linear search algorithm 
		for(int i=0; i<size; i++){ //for finding BankAccount object for the given accnumber
			BankAccount account = accounts[i];

			if(account.getAccNum() == accNum){
				System.out.print("Current Balance: ");
				account.currentBalance();

				try{Thread.sleep(2000);}
				catch(InterruptedException e ){ }
				return;
			}
		}//for loop closed
		
		throw new IllegalArgumentException("Account is not found with the given details");

	}

	public void transferMoney(long sourceAccNum, long destinationAccNum, double amt) 
																										throws IllegalArgumentException{
		System.out.println("transfer money operation start");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

		withdraw(sourceAccNum, amt);
		deposit(destinationAccNum, amt);

		System.out.println("transfer money operation end");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

	}

	public void updateAccount(long accNum){
			//we will develop in future
	}

	public void closeAccount(long accNum) throws IllegalArgumentException{
		System.out.println("closeAccount operation start");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }
						
		if(accNum <= 0)
			throw new IllegalArgumentException("Account can not be -VE number and ZERO");

		System.out.println("Searching for given accountNumber  object");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

		//Linear search algorithm 
		for(int i=0; i<size; i++){ //for finding BankAccount object for the given accnumber
			BankAccount account = accounts[i];

			if(account.getAccNum() == accNum){
				
				for(int j = i; j<size-1; j++){			//removing current location object
					accounts[i] = accounts[i+1];		//by moving next object one location LEFT	
				}

				accounts[size-1] = null;				//removing reference from last location
				size--;											//decreasing size by one

				System.out.println("account is deleted");
				try{Thread.sleep(2000);}
				catch(InterruptedException e ){ }
				return;
			}
		}//for loop closed
		
		throw new IllegalArgumentException("Account is not found with the given details");

	} //closeAccount() end

	public void displayAccount(long accNum) throws IllegalArgumentException{
		System.out.println("displayAccount operation start");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }
						
		if(accNum <= 0)
			throw new IllegalArgumentException("Account can not be -VE number and ZERO");

		System.out.println("Searching for given accountNumber  object");
		try{Thread.sleep(2000);}
		catch(InterruptedException e ){ }

		//Linear search algorithm 
		for(int i=0; i<size; i++){ //for finding BankAccount object for the given accnumber
			BankAccount account = accounts[i];

			if(account.getAccNum() == accNum){
				System.out.println("account details");
				System.out.println(account);

				try{Thread.sleep(2000);}
				catch(InterruptedException e ){ }
				return;
			}
		}//for loop closed
		
		throw new IllegalArgumentException("Account is not found with the given details");
	}

	public String toString(){
		StringBuilder accountsBuilder = new StringBuilder();

		if(size == 0)
			return "No accounts found";

		for(int i=0; i<size; i++){
			accountsBuilder.append("\naccount "+(i+1)+ " details: ");
			accountsBuilder.append(accounts[i]+"\n");
		}

		return accountsBuilder.toString();
	}

}
