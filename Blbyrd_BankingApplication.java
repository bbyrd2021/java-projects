package blbyrd_Bank;
import java.util.Scanner;

/**
 * @author Brandon L. Byrd
 * COMP167001
 * November 3rd 2022
 * 
 * This program simulates an ATM, where a user can create an account, deposit and withdraw money, check their balance, and see their previous transaction.
 * @version 1.0
 */
public class Blbyrd_BankingApplication {
	/**
	 * Asks for customer's name ad ID then prints a welcome message followed by a menu
	 * @param customerName
	 * @param customerID
	 */
	public static void showMenu(String customerName, String customerID) {
		System.out.println("************************************************************");
		System.out.println(" ,--.____                                     ____.--.       ");
		System.out.println("/  .'.'\"``--...----------.___.----------...--''\"`.`.  \\   ");
		System.out.println("| .'.'         .                       .         `.`. |      ");
		System.out.println("`. .'|     . ' - . _    `-----'    _ . - ' .     |`. .'      ");
		System.out.println(" `.' `|   .'   _     \"-._     _.-\"     _   `.   |' `.'     ");
		System.out.println("      |  |        \" -.           .- \"        |  |          ");
		System.out.println("       \\|        ;;..  \"|i. .i|\"  ..;;        |/          ");
		System.out.println("       `|      ,---.``.   ' '   .'',---.      |'             ");
		System.out.println("        |    <'(__.'>.'---` '---`.<`.__)`>    |              ");
		System.out.println("        |   `. `~  .'  ,-------.  `.  ~'.'    |              ");
		System.out.println("        |  |=_\"`=.'  . `-.___.-' .  `.='\"_=|  |            ");
		System.out.println("        |  |  ==/  : ` :   i   : ' :  \\==  |  |             ");
		System.out.println("        |  | ==/      /\\___|___/\\      \\== |  |           ");
		System.out.println("         `.| =Y      .' \"\"\"_\"\"\" `.      Y= |.'         ");
		System.out.println("           L ||      ;  .==\"==.  ;      || J                ");
		System.out.println("            \\ ;     .' '       ` `.     ; /                 ");
		System.out.println("             `.     ;             ;     .'                   ");
		System.out.println("              ;    ;'\\           /`;    ;                   ");
		System.out.println("              `;  .'.'/.       ,\\`.`.  ;'                   ");
		System.out.println("               `-=;_-'  `-----'  `-_;=-'                     ");
		System.out.println("");
		System.out.println("************************************************************");
		System.out.println("");
		System.out.println("               Welcome to the Aggie Bank");
		System.out.println("");
		System.out.println("************************************************************");
		System.out.println("");
		System.out.println("Welcome " + customerName);
		System.out.println("Your Customer ID is " + customerID);
		System.out.println("");
		System.out.println("");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		System.out.println("");
	}
	
	/**
	 * Prompts the user for an menu option
	 * @return an character representing the user's choice
	 */
	public static char getMenuOption() {
		Scanner scnr = new Scanner(System.in);
		char userOption;
		System.out.println("");
		System.out.println("=============================================================");
		System.out.println("Enter an option: ");
		System.out.println("=============================================================");
		System.out.println("");
		userOption = Character.toUpperCase(scnr.next().charAt(0));
		return userOption;
		
	}
	/**
	 * Prints welcome message an menu, prompts user for their choice until they enter E.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Blbyrd_BankAccount account = new Blbyrd_BankAccount(); // Instantiates an BankAccount object
		char choice; // stores the choice of the user
		String customerName, customerID, transactionType; // stores customerName and transactionType
		int  depositAmount, withdrawalAmount; // stores costumerID, depositAmount, withrawalAmount
		
		//sets default transactionType
		transactionType = "No Transaction Occured.";
		System.out.println("Aggie Bank Account");

		//Reads and sets customerName
		System.out.print("Customer Name: ");
		customerName = scnr.nextLine();
		account.setCustomerName(customerName);
		
		//Reads and sets customerID
		System.out.print("Customer ID: ");
		customerID = scnr.next();
		account.setCustomerId(customerID);
		
		//Prints welcome message and menu
		showMenu(account.getCustomerName(), account.getCustomerId());
		
		//Prompts user for a choice until they choose 'E' for Exit
		do {
			choice = getMenuOption();
			switch (choice) {
				//prints account balance
				case 'A': 
					System.out.println("");
					System.out.println("Your account balance is: $" + account.getBalance());
					System.out.println("");
					break;
				
				// deposits amount to the account
				case 'B':
					System.out.println("");
					System.out.println("-------------------------------------------------------------");
					System.out.println("Enter the amount you would like to deposit: ");
					System.out.println("-------------------------------------------------------------");
					System.out.println("");
					
					transactionType = "Deposited $";
					depositAmount = scnr.nextInt();
					if (depositAmount > 0) {
						account.deposit(depositAmount);
						account.setPreviousTransaction(depositAmount);
						System.out.println("");
						System.out.println("You deposited $" + depositAmount);
						System.out.println("");
						
					} else {
						System.out.println("");
						System.out.println("You must enter a non-negative number. Try again.");
						System.out.println("");
					}
					break;
					
				//withdraws amount from account
				case 'C':
					System.out.println("");
					System.out.println("-------------------------------------------------------------");
					System.out.println("Enter the amount you would like to withdraw: ");
					System.out.println("-------------------------------------------------------------");
					System.out.println("");
					
					transactionType = "Withdrawn $";
					withdrawalAmount = scnr.nextInt();
					if (withdrawalAmount < 0) {
						System.out.println("");
						System.out.println("You must enter a non-negative number. Try again.");
						System.out.println("");
					}
					else if (withdrawalAmount <= account.getBalance()) {
						account.withdraw(withdrawalAmount);
						account.setPreviousTransaction(withdrawalAmount);
						System.out.println("");
						System.out.println("You've withdrawn $"+withdrawalAmount);
						System.out.println("");
						
					} 
					else {
						System.out.println("");
						System.out.println("You have insufficient funds. Please add funds and try again.");
						System.out.println("");
					}
					
					break;
				
				// prints previous transaction
				case 'D':
					if (transactionType == "No Transaction Occured.") {
						System.out.println(transactionType);
					} else {

						System.out.println("");
						System.out.print(transactionType);
						account.getPreviousTransaction();
					}
					break;
					
				case 'E':
					break;
				
				default:
					System.out.println("");
					System.out.println("Menu option invalid");
					System.out.println("");
			}
		}
		while (choice != 'E');
		
		// prints goodbye message
		System.out.println("");
 		System.out.print("Thank you "+account.getCustomerName()+" for using Aggie Bank. Have a good day!!");
 		scnr.close();
	}
	
}
