package com.company.calculator;

import com.company.system.charSet.CharSet;
import com.company.calculator.parse.*;
import com.company.system.checkErrors.CheckErrors;
import com.company.system.stringInput.StringInput;

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

        CheckErrors checkErrors = new CheckErrors();
        ParseString parseString = new ParseString();

        if (!checkErrors.execute(example)) {
            List<String> list = parseString.parse(example);

            ParseList parseList = new ParseList();
            parseList.executeParse(list);

            System.out.println("Result: " + list.get(0));
        }
    }

    private void inputExample() {
        StringInput stringInput = new StringInput();

        System.out.print("Enter example: ");
        example = stringInput.enter();
    }


}
