package com.abbl.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nasir
 */
@Component
public class Helper {

    public String getEncryptionKey() {
        return "A13(2)&P@a#WAY";
    }

}
