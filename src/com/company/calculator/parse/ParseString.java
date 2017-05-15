package com.company.calculator.parse;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class ParseString {
    public List<String> parse(String str) {
        List<String> list = new CopyOnWriteArrayList<>();

        String delimiters = "+-*/()";
        StringTokenizer sTok = new StringTokenizer(str, delimiters, true);

        while (sTok.hasMoreTokens()) {
            list.add(sTok.nextToken());
        }

        return list;
    }
}
