package com.company.calculator;

import com.company.calculator.parse.*;
import com.company.stringInput.StringInput;

import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by alex on 14.05.2017.
 */
public class Calculator {

    private String example = "";

    public void execute() {
        inputExample();
        List<String> list = parseString(example);

        ParseList parseList = new ParseList();
        parseList.executeParse(list);

        System.out.println("Result: " + list.get(0));
    }

    public void inputExample() {
        StringInput stringInput = new StringInput();

        System.out.print("Enter example: ");
        example = stringInput.enter();
    }

    public List<String> parseString(String str) {
        List<String> list = new CopyOnWriteArrayList<>();

        String delimiters = "+-*/()";
        StringTokenizer sTok = new StringTokenizer(str, delimiters, true);

        while (sTok.hasMoreTokens()) {
            list.add(sTok.nextToken());
        }

        return list;
    }
}
