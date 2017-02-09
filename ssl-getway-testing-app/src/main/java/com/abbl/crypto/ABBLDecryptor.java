package com.abbl.crypto;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nasir
 */
@Component
public class ABBLDecryptor {

    @Autowired
    private StandardPBEStringEncryptor standardPBEStringEncryptor;

    @Autowired
    private Helper helper;

    public String decrypt(String text){
        try {
            String encryptionKey = helper.getEncryptionKey();
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return standardPBEStringEncryptor.decrypt(text);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String decryptPaymentGetway(String text){
        try {
            String encryptionKey = helper.getEncryptionKey();
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return standardPBEStringEncryptor.decrypt(text);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
