package org.atm.project;

import java.util.Scanner;

public class ATMMain {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome To AbC Bank ATM");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Your Accno");
		int accno = s.nextInt();
		ATMDAO ad =new ATMDAO();
		ATMpojo d = ad.getdata(accno);
		
		int syspin = d.getPin();
		String name = d.getName();
		int balance = d.getBalance();
		int withdrawlAmt=0;
		int depositAmt=0;
		System.out.println("Enter Your Pin Number");
		
		for (int i = 0; i<3; i++) {
			int userpin = s.nextInt();
		
		if (userpin == syspin) {
			System.out.println("Welcome "+name);
			while (true) {
				
				System.out.println("1: Check Balance");
				System.out.println("2: Withdraw");
				System.out.println("3: Deposit");
				System.out.println("4: Print Mini Statement");
				System.out.println("5: Exit");
				
				int options = s.nextInt();
				switch (options) {
				case 1: 
					System.out.println("Your Current Balance is :"+balance);
					break;
				case 2:
					System.out.println("Enter The Amount You Want To Withdraw:");
					withdrawlAmt = s.nextInt();
					if (withdrawlAmt>balance) {
						System.err.println("Your Have Insufficient Balance");
						System.out.println("Your Available Balance:"+balance);
						System.out.println("Enter Balance Less Than Your Available balance ");
					}else {
						Thread.sleep(1000);
						System.out.println("Please Collect Your Cash");
						Thread.sleep(1300);
						System.out.println("Amount Successfully Debited");
						balance= balance - withdrawlAmt;
						ad.updatedata(accno, balance);
						ATMpojo b = ad.getdata(accno);
						System.out.println("Your Available Balance:"+b.getBalance());
					}
					break;
				case 3:
					System.out.println("Enter The Amount you Want To Deposit");
					depositAmt = s.nextInt();
					System.out.println("Amount Successfully Credited");
					balance=balance+depositAmt;
					ad.updatedata(accno, balance);
					ATMpojo bb = ad.getdata(accno);
					System.out.println("Your Current Balance :"+bb.getBalance());
					break;
				case 4:
					System.out.println("Available Balance:"+balance);
					System.out.println("Amount Withdrawn:"+withdrawlAmt);
					System.out.println("Amount Deposited:"+depositAmt);
					System.out.println("Thanks For Using ABC Bank ATM");
					break;
				case 5:
					if (options==5) {
						System.out.println("Are You Sure You Want To Exit");
						System.out.println("1: Yes");
						System.out.println("2: No");
						byte opt2 = s.nextByte();
						if (opt2==1) {
							System.out.println("Thank You For Visiting ABC Bank ATM");
							System.exit(0);
						}else {
							break;
						}
					}
			}
		}
		}if (userpin==syspin==false) {
			if (i<2) {
				System.err.println("Your Pin Is Incorrect, Please Enter A Valid Pin");
			}else {
				System.err.println("Your Pin Is Incorrect \nYou Entered Incorrect Pin Too Many Times");
			}
			}}
	}
}

