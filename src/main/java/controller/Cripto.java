
package controller;

import java.security.MessageDigest;


public class Cripto {

   
    public static String criptografar(String senha) {
        String senhaNova = "";
        
        try{
            
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] informacao = senha.getBytes();
            
            byte[] assinatura = md.digest(informacao);
            
           
            senhaNova = new String(assinatura);
            
            return senhaNova;
            
            
        }catch(Exception e){
        
        
        
        }
         return senhaNova;
    }
}
    

