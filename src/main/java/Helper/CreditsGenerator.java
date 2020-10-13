package Helper;

import java.util.Random;

public class CreditsGenerator {
    private static final String symbols = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final int EMAIL_LENGTH = 10;
    private static final int PASSWORD_LENGTH = 6;

    public static String generateEmail(){
        return generateRandomSequence(EMAIL_LENGTH) + "@test.com";
    }

    public static String generatePassword(){
        return generateRandomSequence(PASSWORD_LENGTH);
    }

    private static String generateRandomSequence(int length){
        String seq = "";
        Random random = new Random();
        while (seq.length() < length) {
            seq += symbols.split("")[random.nextInt(symbols.length())];
        }

        return seq;
    }
}
