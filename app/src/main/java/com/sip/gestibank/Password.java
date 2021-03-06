package com.sip.gestibank;

import java.util.Random;

public class Password {
    public static String valeur = "";
    static Random rand;
   static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678910";


   public Password(){

   }
    public static String genPassword(){
        rand = new Random();
        String interPWD = "";
        valeur = interPWD;
        for( int i = 0; i< 5; i++){
             int k = rand.nextInt(alphabet.length());
            valeur = valeur + alphabet.charAt(k);
        }
        return(valeur);
    }
}

