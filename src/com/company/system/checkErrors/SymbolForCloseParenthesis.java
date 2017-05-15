package com.company.system.checkErrors;

import com.company.system.charSet.CharSet;

import java.util.List;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class SymbolForCloseParenthesis implements Error{
    private List<String> list;

    public SymbolForCloseParenthesis(List<String> list) {
        this.list = list;
    }

    public boolean checkError() {
        CharSet charSet = new CharSet();
        boolean boolError = false;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals("(")) {
                if (!charSet.charSign(list.get(i + 1))) {
                    System.out.println("Error: After the brackets must be of arithmetic sign.");
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
