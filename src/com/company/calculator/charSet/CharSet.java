package com.company.calculator.charSet;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class CharSet {
    public boolean charLetters(char symbol) {
        boolean boolCharLetters = false;
        String text = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

        for (int i = 0; i < text.length(); i++)
            if (symbol == text.charAt(i)) {
                boolCharLetters = true;
                break;
            } else boolCharLetters = false;
        return boolCharLetters;
    }

    public boolean charBracket(String symbol) {
        boolean boolCharBracket;
        switch (symbol) {
            case "*": boolCharBracket = true;
            break;
            case "/": boolCharBracket = true;
                break;
            case "+": boolCharBracket = true;
                break;
            case "-": boolCharBracket = true;
                break;
            default: boolCharBracket = false;
        }
        return boolCharBracket;
    }
}
