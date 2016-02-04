/**
 * 
 */
package com.app.myapp.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



import org.springframework.stereotype.Service;

/**
 * @author Mayank Verma
 *
 */

@Service("utilityService")
public class UtilityServiceImpl implements UtilityService {

    
    public UtilityServiceImpl() {
        
    	
    }

    @Override
    public String generatePassword() {
        SecureRandom random = new SecureRandom();
        String password = new BigInteger(48, random).toString(32);
        return password;
    }

    @Override
    public String encryptMD5(String input) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.reset();
        md.update(input.getBytes());
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ) {
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }

}
