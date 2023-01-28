


package blbyrd_Bank;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Brandon L. Byrd
 * COMP 167-001
 * November 28, 2022
 * This class initializes a JDialog box that allows you to edit an account. This includes depositing and withdrawing 
 *
 */

public class Blbyrd_EditAccount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	JLabel lblName;
	JLabel lblID;
	JLabel lblBalance;
	Blbyrd_BankAccount ba;
	int previousBalance;
	JList list;
	private DefaultListModel<String> alTransactions;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Blbyrd_EditAccount dialog = new Blbyrd_EditAccount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public Blbyrd_EditAccount(Blbyrd_BankAccount ba) {
		this.ba = ba;
		init();
		lblName.setText(ba.getCustomerName());
		lblID.setText(ba.getCustomerId());
		lblBalance.setText(Integer.toString(ba.getBalance()));
		previousBalance = ba.getBalance(); // stores original amount in the case that the end user decides to cancel their transaction
	}
	
	public Blbyrd_EditAccount() {
		ba = new Blbyrd_BankAccount("Test User", "Test ID");
		ba.setBalance(100);
		init();
		lblName.setText(ba.getCustomerName());
		lblID.setText(ba.getCustomerId());
		lblBalance.setText(Integer.toString(ba.getBalance()));
		
	}
	
	private void init() {
		alTransactions = new DefaultListModel<String>();
		setTitle("Edit Account");
		setBounds(100, 100, 539, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(29, 37, 61, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(29, 75, 61, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Balance");
		lblNewLabel_2.setBounds(29, 119, 61, 16);
		contentPanel.add(lblNewLabel_2);
		
		lblName = new JLabel("New label");
		lblName.setBounds(102, 37, 160, 16);
		contentPanel.add(lblName);
		
		lblID = new JLabel("New label");
		lblID.setBounds(102, 75, 160, 16);
		contentPanel.add(lblID);
		
		lblBalance = new JLabel("New label");
		lblBalance.setBounds(102, 119, 160, 16);
		contentPanel.add(lblBalance);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ba.deposit(Integer.parseInt(txtAmount.getText()));
				lblBalance.setText(Integer.toString(ba.getBalance()));
				updateTransactionList("Deposit: "+txtAmount.getText());
				txtAmount.setText("");
			}
		});
		btnDeposit.setBounds(29, 243, 117, 29);
		contentPanel.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ba.withdraw(Integer.parseInt(txtAmount.getText()));
				lblBalance.setText(Integer.toString(ba.getBalance()));
				updateTransactionList("Withdrawal: "+txtAmount.getText());
				txtAmount.setText("");
			}
		});
		btnWithdraw.setBounds(145, 243, 117, 29);
		contentPanel.add(btnWithdraw);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(29, 205, 233, 26);
		contentPanel.add(txtAmount);
		txtAmount.setColumns(10);
		
		list = new JList();
		list.setBounds(298, 65, 221, 207);
		contentPanel.add(list);
		
		JLabel lblNewLabel_6 = new JLabel("Previous Transactions");
		lblNewLabel_6.setBounds(298, 37, 214, 16);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ba.setBalance(previousBalance); // resets balance to its original value
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	/**
	 * This method updates the transaction list
	 * @param transaction
	 */
	private void updateTransactionList(String transaction) {
		alTransactions.addElement(transaction);	// adds transactions to the JList to be displayed
		list.setModel(alTransactions);
	}
}
