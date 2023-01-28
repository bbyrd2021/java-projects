/**
 * @author Brandon Byrd
 * COMP 167-001
 * November 28, 2022
 * This class represents a dialog box, used to add an account to a list of Bank Account objects.
 */

package blbyrd_Bank;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class Blbyrd_AddAccount extends JDialog {
	private Blbyrd_GuiBanking gb;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField textBalance;
	/**
	 * Launch the application.
	 */
	
	/**
	 * 
	 * @param args
	 * Main method
	 */
	public static void main(String[] args) {
		try {
			Blbyrd_AddAccount dialog = new Blbyrd_AddAccount(); 
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	/**
	 * Constructor for Add Account
	 * @param window
	 */
	public Blbyrd_AddAccount(Blbyrd_GuiBanking window) {
		gb = window;
		init();
	}
	
	/**
	 * Default Constructor for Add Account
	 */
	public Blbyrd_AddAccount() {
		init();
	}
	
	/**
	 * Helper method for the constructors above
	 * Initializes a JDialog Box w/ its components.
	 */
	private void init() {
		setTitle("Add Account");
		setBounds(100, 100, 452, 231);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 160, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Blbyrd_BankAccount account = new Blbyrd_BankAccount(txtName.getText(), txtID.getText());
						account.setBalance(Integer.parseInt(textBalance.getText()));
						gb.updateAccountData(account);
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblTextName = new JLabel("Name");
		lblTextName.setBounds(28, 30, 61, 16);
		getContentPane().add(lblTextName);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(28, 73, 61, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Balance");
		lblNewLabel_2.setBounds(28, 110, 61, 16);
		getContentPane().add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setBounds(101, 25, 130, 26);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtID = new JTextField();
		txtID.setBounds(101, 68, 130, 26);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		textBalance = new JTextField();
		textBalance.setBounds(101, 105, 130, 26);
		getContentPane().add(textBalance);
		textBalance.setColumns(10);
	}
}
