package com.bank.transection;

//BankAccount.java
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("resource")
public class  BankAccount{

		private static String bankName;
		private static String branchName;
		private static String ifsc;

		private long accNum;
		private String accHName;
		private double balance;

		static{
			out.println("\nBankAccount class is loaded");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			out.println("SV memory allocated with default values");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			out.println("Reading Static variables values from file and intializing them");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			try {
				/*Connecting to file */
				BufferedReader fileReader = 
					new BufferedReader(new FileReader("bankdetails.txt"));

				/*Reading values file and storing in static variables*/
				bankName		= fileReader.readLine();
				branchName	= fileReader.readLine();
				ifsc					= fileReader.readLine();

				out.println("SV are initialized with file values \n");

			}catch(FileNotFoundException e){
				System.out.println("Error: bankdetails.txt file is not found");
			}catch(IOException e){
				e.printStackTrace();
			}

			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

		}//staic block end

		public BankAccount(long accNum, String accHName, double balance){
			out.println("NSVs memory allocated with default values");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			out.println("NSVs are being initialized with given values\n");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			this.accNum		= accNum;
			this.accHName	= accHName;
			this.balance			= balance;

			out.println("NSVs are initialized with given object values\n");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

		}//constructor closed

		@SuppressWarnings("static-access")
		public void setBankName(String bankName){
			this.bankName = bankName;

			out.println("value is set to bankName");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }
		}

		public String getBankName(){
			out.println("bankName value is returned");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			return bankName;
		}

		@SuppressWarnings("static-access")
		public void setBranchName(String branchName){
			this.branchName = branchName;

			out.println("value is set to branchName");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }
		}

		public String getBranchName(){
			out.println("branchName value is returned");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			return branchName;
		}

		@SuppressWarnings("static-access")
		public void setIfsc(String ifsc){
			this.ifsc = ifsc;

			out.println("value is set to ifsc");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }
		}

		public String getIfsc(){
			out.println("ifsc value is returned");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			return ifsc;
		}

		public long getAccNum(){
			out.println("accNum value is returned");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			return accNum;
		}

		public void setAccHName(String accHName){
			this.accHName = accHName;

			out.println("value is set to accHName");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }
		}

		public String getAccHName(){
			out.println("accHName value is returned");
			try{Thread.sleep(1000);}
			catch(InterruptedException e){ }

			return accHName;
		}

		public void deposit(double amt){
			this.balance = this.balance + amt;
		}

		public void withdraw(double amt){
			this.balance = this.balance - amt;
		}

		public void currentBalance(){
			out.println(balance);
		}

		public String toString(){
			return	("\n  bankName\t: "+ bankName) + "\n" +
						("  branchName\t: "+ branchName) + "\n" +
						("  ifsc\t\t: "+ ifsc)  + "\n" +
						("  accNum\t: "+ accNum)  + "\n" +
						("  accHName\t: "+ accHName)  + "\n" +
						("  balance\t: "+ balance);
		}
}