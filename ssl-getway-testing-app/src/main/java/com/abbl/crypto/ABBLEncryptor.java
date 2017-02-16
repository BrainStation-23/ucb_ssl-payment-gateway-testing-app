package com.abbl.crypto;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nasir
 */
@Component
public class ABBLEncryptor {

    @Autowired
    private StandardPBEStringEncryptor standardPBEStringEncryptor;

    @Autowired
    private Helper helper;

    public String encrypt(String text){
        try {
            String encryptionKey = helper.getEncryptionKey();
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return standardPBEStringEncryptor.encrypt(text);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public String encryptPaymentGatway(String text){
        try {
            String encryptionKey = helper.getEncryptionKey();
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return standardPBEStringEncryptor.encrypt(text);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
