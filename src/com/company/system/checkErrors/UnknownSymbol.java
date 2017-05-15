package com.company.system.checkErrors;

import com.company.system.charSet.CharSet;

import java.util.List;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class UnknownSymbol implements Error {

    private List<String> list;

    public UnknownSymbol(List<String> list) {
        this.list = list;
    }

    public boolean checkError() {
        CharSet charSet = new CharSet();
        boolean boolError = false;

        for (String i : list) {
            for (int j = 0; j < i.length(); j++) {
                if (charSet.charLetters(i.charAt(j))) {
                    System.out.println("Error: Unknown character.");
                    boolError = true;
                } else boolError = false;
                if (boolError) break;
            }
            if (boolError) break;
        }
        return boolError;
    }
}
