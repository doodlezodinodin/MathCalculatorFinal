package com.company.system.checkErrors;

import com.company.calculator.Calculator;
import com.company.system.charSet.CharSet;

import java.util.List;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class CheckErrors {
    public boolean searchErrors(String text) {
        Calculator calculator = new Calculator();
        List<String> list = calculator.parseString(text);
        CharSet charSet = new CharSet();

        boolean boolCheckError = false;

        for (String i : list) {
            for (int j = 0; j < i.length(); j++) {
                if (charSet.charLetters(i.charAt(j))) {
                    System.out.println("Error: Unknown character.");
                    boolCheckError = true;
                } else if (correctBrackets(list)) {
                    System.out.println("Error: Invalid character after the parentheses.");
                    boolCheckError = true;
                } else if (correctNumberBrackets(list)) {
                    System.out.println("Error: Not the right number of brackets");
                    boolCheckError = true;
                } else boolCheckError = false;

                if (boolCheckError) break;
            }
            if (boolCheckError) break;
        }
        return boolCheckError;
    }

    private boolean correctBrackets(List<String> list) {
        boolean boolError = false;
        CharSet charSet = new CharSet();

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals("(")) {
                if (charSet.charBracket(list.get(i + 1))) {
                    boolError = true;
                    break;
                } else {
                    boolError = false;
                }
            }
        }
        return boolError;
    }

    private boolean correctNumberBrackets(List<String> list) {
        int countOpenBracket = 0;
        int countCloseBracket = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("(")) {
                countOpenBracket++;
            } else if (list.get(i).equals(")")) {
                countCloseBracket++;
            }
        }

        if (countOpenBracket != countCloseBracket) return true;
        else return false;
    }
}







