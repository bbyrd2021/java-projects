/**
 * @author Brandon Byrd
 * COMP 167001
 * November 28, 2022
 * 
 * This class represents a bank account
 * @version 2.0
 * 
 */


package blbyrd_Bank;

public class Blbyrd_BankAccount {
	/**
	 * The balance of the bank account
	 */
	private int _balance;
	
	/**
	 * The customer's ID number
	 */
	private String _customerID;
	
	/**
	 * The customers name
	 */
	private String _customerName;
	
	/**
	 * The amount of the previous transaction
	 */
	private int _previousTransaction;
	
	/** Returns the accounts balance
	 * @return Returns an int representing the balance of the account
	 */
	public int getBalance() {return _balance;}
	
	/**
	 * Sets the balance of the account
	 * @param balance
	 */
	public void setBalance(int balance) {_balance = balance;}
	
	/**
	 * Returns the customer's ID
	 * @return an String value representing the customer's ID
	 */
	public String getCustomerId() {return _customerID;}
	
	/**
	 * Sets the customer's ID
	 * @param customerID
	 */
	public void setCustomerId(String customerID) {_customerID = customerID;}
	
	/**
	 * Retrieves the customer's name
	 * @return a String representing the customer's name
	 */
	public String getCustomerName() {return _customerName;}
	
	/**
	 * Sets the customer's name
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {_customerName = customerName;}
	
	/**
	 * Prints the previous transaction
	 */
	public void getPreviousTransaction() {System.out.println(_previousTransaction);}
	
	/**
	 * Sets the previous transaction
	 * @param previousTransaction
	 */
	public void setPreviousTransaction(int previousTransaction) { _previousTransaction = previousTransaction;}
	
	
	/**
	 * Default constructor initializing _customerNmae to "" and _customerID to ""
	 */
	public Blbyrd_BankAccount() {
		_customerName = "";
		_customerID = "";
	}
	
	/**
	 * Constructor initializing _customerName to customerName and _customerID to customerID
	 * @param CustomerName
	 * @param string
	 */
	public Blbyrd_BankAccount(String CustomerName, String CustomerID) { //overload constructor
		_customerName = CustomerName;
		_customerID = CustomerID;
	}
	
	/**
	 * Withdraws Amount by subtracting from the balance
	 * @param Amount
	 */
	public void withdraw(int Amount) {
		_balance -= Amount;
	}
	
	/**
	 * Deposits Amount by adding to the balance
	 * @param Amount
	 */
	public void deposit(int Amount) {
		_balance += Amount;
	}
	
	public String toString() {
		return this._customerName+" "+this._customerID;
	}
	
}
