package com.company.system.checkErrors;

import java.util.List;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class CountBrackets implements Error {

    private List<String> list;

    public CountBrackets(List<String> list) {
        this.list = list;
    }

    public boolean checkError() {
        int countOpenBracket = 0;
        int countCloseBracket = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("(")) {
                countOpenBracket++;
            } else if (list.get(i).equals(")")) {
                countCloseBracket++;
            }
        }

        if (countOpenBracket != countCloseBracket) {
            System.out.println("Error: Wrong number of brackets.");
            return true;
        }
        else return false;
    }
}
