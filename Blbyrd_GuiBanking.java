/**
 * @author Brandon L. Byrd
 * COMP 167-001
 * Nov 28, 2022
 * 
 * This program creates multiple bank accounts stored in a list. The balance of these bank accounts can be edited. 
 */

package blbyrd_Bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Blbyrd_GuiBanking {

	private JFrame frmBanking; // JFrame for the main application window
	JButton btnAdd; // Add button 
	static Blbyrd_GuiBanking window; // the GuiBanking window object 
	ArrayList <Blbyrd_BankAccount> alAccounts; // an ArrayList of bank account objects
	JList list; // JList that displays bank accounts 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Blbyrd_GuiBanking();
					window.frmBanking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Blbyrd_GuiBanking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alAccounts = new ArrayList<Blbyrd_BankAccount>();
		frmBanking = new JFrame();
		frmBanking.setTitle("Banking");
		frmBanking.setBounds(100, 100, 584, 472);
		frmBanking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBanking.getContentPane().setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Blbyrd_AddAccount addAccount = new Blbyrd_AddAccount(window);
				addAccount.setVisible(true);
			}
		});
		
		btnAdd.setBounds(161, 387, 117, 29);
		frmBanking.getContentPane().add(btnAdd);
		
		list = new JList();
		list.setBounds(139,68,302,285);
		frmBanking.getContentPane().add(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Blbyrd_EditAccount ea = new Blbyrd_EditAccount(alAccounts.get(list.getSelectedIndex()));
				ea.setVisible(true);
			}
		});
		btnEdit.setBounds(299, 387, 117, 29);
		frmBanking.getContentPane().add(btnEdit);
		
	}
	
	public void updateAccountData(Blbyrd_BankAccount ba) {
		alAccounts.add(ba);
		
		DefaultListModel <Blbyrd_BankAccount> dlmAccount = new DefaultListModel<Blbyrd_BankAccount>();
		
		alAccounts.forEach((account)->{
			dlmAccount.addElement(account);
		});
		
		list.setModel(dlmAccount);
		
	}
}
