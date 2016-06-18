/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbenk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Mateusz
 */
public final class GlobalVariables {
    public static ArrayList<Account> Accounts = new ArrayList<Account>();    
    private GlobalVariables()
    {
        Accounts = new ArrayList<Account>();
    }
    public static void Serialize()
    {
        try
             {
                FileOutputStream fileOut =
                new FileOutputStream("Accounts.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                for(Account acc:Accounts)
                {
                    out.writeObject(acc);
                }
                out.close();
                fileOut.close();
            }catch(IOException i)
            {
                i.printStackTrace();
            }
    }
    public static void Deserialize()
    {
         try
        {
         Account acc;
         FileInputStream fileIn = new FileInputStream("Accounts.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         acc = (Account) in.readObject();
         Accounts.clear();
         while(acc!=null){
             Accounts.add(acc);
             acc=(Account) in.readObject();
         }
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Account class not found");
         c.printStackTrace();
         return;
        
    }
    }
}
