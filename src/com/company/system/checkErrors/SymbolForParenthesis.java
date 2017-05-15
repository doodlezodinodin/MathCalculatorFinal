package com.company.system.checkErrors;

import com.company.system.charSet.CharSet;

import java.util.List;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class SymbolForParenthesis implements Error{

    private List<String> list;

    public SymbolForParenthesis(List<String> list) {
        this.list = list;
    }

     public boolean checkError() {
        boolean boolError = false;
        CharSet charSet = new CharSet();

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals("(")) {
                if (charSet.charBracket(list.get(i + 1))) {
                    System.out.println("Error: Invalid character after the parentheses.");
                    boolError = true;
                    break;
                } else {
                    boolError = false;
                }
            }
        }
        return boolError;
    }
}
