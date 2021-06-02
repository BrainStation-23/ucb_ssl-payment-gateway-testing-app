package com.abbl.helper;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dipanjal
 * @since 2/11/2020
 */
@Component
public final class RandomNumberProvider {

    public String generateSSLReferenceId() {
        // Prefix
        String prefix = "MO";

        // 7 digit random number
        int rowNum = generateRandomNumber(1000000, 9999999);

        // Current date in "YYMMdd" format
        String date = formatDate(new Date(), "YYMMdd");

        // 7 digit row number padded with zero(s) as prefix if necessary
        String formattedDate = String.format("%05d", rowNum);

        // 4 digit random number
        String randomNum = String.valueOf(generateRandomNumber(1000, 9999));

        return prefix.concat(date).concat(formattedDate).concat(randomNum);
    }

    private int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static String formatDate(Date date, String dateFormat) {
        DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        return dateFormatter.format(date);
    }
}
