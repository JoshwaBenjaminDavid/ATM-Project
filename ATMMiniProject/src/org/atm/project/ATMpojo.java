package org.atm.project;

public class ATMpojo {

	private int accno;
	private String name;
	private int pin;
	private int balance;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public ATMpojo(int accno, String name, int pin, int balance) {
		this.accno=accno;
		this.name=name;
		this.pin=pin;
		this.balance=balance;
	}
	@Override
	public String toString() {
		return "ATMpojo [accno=" + accno + ", name=" + name + ", pin=" + pin + ", balance=" + balance + "]";
	}
	public ATMpojo() {
		
	}
}
