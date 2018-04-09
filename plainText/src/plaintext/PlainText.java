/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plaintext;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Alhassan
 */
public class PlainText {

    void plainText(String plainText) throws Exception{
        
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        
        SecretKey Key = generator.generateKey();
        
        Cipher AES_Algorithm = Cipher.getInstance("AES");
        AES_Algorithm.init(Cipher.ENCRYPT_MODE, Key);
        
        byte[] byteCipherText = AES_Algorithm.doFinal(plainText.getBytes());
        
        AES_Algorithm.init(Cipher.DECRYPT_MODE, Key);
        
        byte[] bytePlainText = AES_Algorithm.doFinal(byteCipherText);
        String out = new String (bytePlainText);
        System.out.println("out: "+out);
        
    }
    void plainTextHashed() throws NoSuchAlgorithmException{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        SecretKey Key = generator.generateKey();
        
        
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update((Key.toString()).getBytes());
        String hashed  = new String(messageDigest.digest());
    }
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            PlainText obj = new PlainText();
            obj.plainText("hassan");
            
        } catch (Exception ex) {
            Logger.getLogger(PlainText.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
