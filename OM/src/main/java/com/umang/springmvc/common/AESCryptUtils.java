package com.umang.springmvc.common;
import java.security.Key;
import java.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Maheshwar.Prasad
 */
public class AESCryptUtils {
   // private static final Logger log = LogManager.getLogger(AESCryptUtils.class);
	private static final String ALGORITHM = "AES";

	private static final byte[] SALT = "DMJIPAEAELEAMPST".getBytes();

	public String decrypt(String cryptedText) throws Exception {

		if (cryptedText == null) {
			return null;
		}

		Key salt = getSalt();
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, salt);
			byte[] decodedValue = Base64.getDecoder().decode(cryptedText.getBytes());
			byte[] decValue = cipher.doFinal(decodedValue);
			return new String(decValue);
		} catch (Exception e) {
			
		}
		return null;
	}
	// Add for  Cipla API User name Encryption Internally.
	public  String encrypt(String cryptedText)
    {
        try
        {
        	if (cryptedText == null) {
    			return null;
    		}

    		Key salt = getSalt();
    		Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, salt);
            return Base64.getEncoder().encodeToString(cipher.doFinal(cryptedText.getBytes()));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
	Key getSalt() {
		return new SecretKeySpec(SALT, ALGORITHM);
	}
	public String generaeOTP() {
        Random randomObj = new Random();
        	 int randomNumber = randomObj.nextInt(100000);
             String formatted = String.format("%05d", randomNumber); 
        return formatted;
    }
        public static void main(String []args) throws Exception{
        	//System.out.println(generaeOTP());
            AESCryptUtils as = new AESCryptUtils();
             //StoreKeyPair str= new StoreKeyPair();
            // String keyValue= str.licenseKey(5);
            // System.out.println("keyValue-->"+keyValue);
          String result =  as.encrypt("tina1234");
          System.out.println("Encryption result :"+result);
         String descresult=as.decrypt(result);    
         System.out.println("Desc Result : ==>"+descresult);
       // int result = generateRegRandom(4);
         //   System.out.println("Result ==>"+result);
        }
        
 public static int generateRegRandom(int length) {
    Random random = new Random();
    int randomNumber=0;
    for (int i = 1; i < 6; i++) {
             randomNumber = random.nextInt(100);
            System.out.println(i + " Random No: " + randomNumber);
        }
    return randomNumber;
}
}
