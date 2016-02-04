/**
 * 
 */
package com.app.myapp.security;

/**
 * @author Mayank Verma
 *
 */
public interface UtilityService {

    String generatePassword();
    
    String encryptMD5(String input);
    
}
