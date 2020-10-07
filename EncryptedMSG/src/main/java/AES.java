import java.security.Key;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

public class AES{
    
    public  void encryptor() throws Exception{
        byte[] key = "ThisIsTheSecret!".getBytes();
        byte[] dataToSend = "Hey Bob this is a text from Allice".getBytes();//This will be our secret key

        Cipher enc = Cipher.getInstance("AES");//Create the Cipher using AES
        SecretKeySpec skey = new SecretKeySpec(key, "AES");//Initialize the secretkey
        enc.init(Cipher.ENCRYPT_MODE, skey);//Initialize the Cipher in encryption mode
        byte[] messageForBob = enc.doFinal(dataToSend);//The Cipher object encrypts dataToSend here.
        
        //Test to see if the Cipher is working.
        System.out.println(new String(messageForBob,"UTF8"));
        
        byte[] dataToDec = messageForBob;

        Cipher dec = Cipher.getInstance("AES");//Create the Cipher needed to decrypt
        
        dec.init(Cipher.DECRYPT_MODE, skey);//Initialize the Cipher in decrypt mode.
        byte[] decryptedData = dec.doFinal(dataToDec);//Decrypt the data
        
        //Test to seee if its working
        System.out.println(new String(decryptedData));}
     
public static void main(String args[])throws Exception{
        
        AES object = new AES();//Creat object from AES
        object.encryptor(); //Call the method  
    }    
        
       
}
    
       
      
  
