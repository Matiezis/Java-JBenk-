/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbenk;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Mateusz
 */
public class Account implements java.io.Serializable {
    public int id;
    private String name;
    private String surname;
    private String adress;
    private String accountType;
    private double balance;
    
    public void insertInformation(JTextArea textArea)
    {
        NumberFormat formatter = new DecimalFormat("#0.00"); 
        String text="";
        text = "Account ID : " + String.valueOf(id) + 
                "\nAccount Type : "+ accountType +
                "\nName : "+ name + " " + surname +
                "\nAdress : "+ adress +
                "\nBalance : " + String.valueOf(formatter.format(balance));
        
        textArea.setText(text);
    }
    public double editBalance(double Amount)
    {
        NumberFormat formatter = new DecimalFormat("#0.00");
        formatter.format(balance+=Amount);
        return balance;
    }
    public Account()
    {
        id = GlobalVariables.Accounts.get(GlobalVariables.Accounts.size()-1).id+1;
        name="Test";
        surname="Testowsky";
        adress="TestCity";
        accountType = "Deposit";
        balance=0;
    }
    public Account(String Name, String Surname, String Adress, String AccountType)
    {
        id = GlobalVariables.Accounts.get(GlobalVariables.Accounts.size()-1).id+1;
        name=Name;
        surname=Surname;
        adress=Adress;
        accountType = AccountType;
        balance=0;
    }
    public void editInfo(String Name, String Surname, String Adress, String AccountType)
    {
        name=Name;
        surname=Surname;
        adress=Adress;
        accountType = AccountType;
        balance=0;
    }
}
