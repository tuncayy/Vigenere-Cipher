/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenerecipher;

import java.util.Scanner;

/**
 *
 * @author tuncaymsi
 */
public class VigenereCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            char[] alp = new char[26];
            int k = 0;
            for(int i = 0; i < 26; i++){
             alp[i] = (char)(97 + (k++));
            }

            Scanner read = new Scanner(System.in);
            System.out.println("key: ");
            String key = read.next();
            System.out.println("plain text");
            String plaintext = read.next();
            int size = plaintext.length();
            int[] keynumbers = new int[100];
            int[] plaintextnumbers = new int[size];
            char[] ciphedtext = new char[size];
            int[] ciphedtextnumbers = new int[size];
            for (int i = 0; i < key.length(); i++) {
                for (int j = 0; j < alp.length; j++) {
                    if(alp[j] == key.charAt(i))
                    {
                        keynumbers[i] = j;
                    }
                }
            }
             for (int i = 0; i < plaintext.length(); i++) {
                for (int j = 0; j < alp.length; j++) {
                    if(alp[j] == plaintext.charAt(i))
                    {
                        plaintextnumbers[i] = j;
                    }
                }
            }
             
            
            int i = 0, x = 0;
            while(i < plaintext.length())
            {
                ciphedtext[i] = alp[(plaintextnumbers[i] + keynumbers[i % key.length()]) % 26];
                ciphedtextnumbers[i] = (plaintextnumbers[i] + keynumbers[i % key.length()]) % 26;
                i++;
            }
            
            for (int j = 0; j < i; j++) {
                System.out.print("" + ciphedtext[j]);
            
        }
            
            //decryp
            i = 0;
            String dec = "";
            while(i < plaintext.length())
            {
                if((ciphedtextnumbers[i] - keynumbers[i % key.length()]) % 26 <0)
                {
                    dec += alp[(((ciphedtextnumbers[i] - keynumbers[i % key.length()]) % 26) + 26) % 26];
                }
                else
                    dec += alp[(ciphedtextnumbers[i] - keynumbers[i % key.length()]) % 26];
               
                i++;
            }
            System.out.println("");
            System.out.print(dec);
            
            
            
    }
    
}
