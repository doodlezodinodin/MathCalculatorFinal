package com.company.calculator;

import com.company.calculator.parse.*;
import com.company.system.checkErrors.Errors;
import com.company.system.stringInput.StringInput;

import java.util.List;

/**
 * Created by alex on 14.05.2017.
 */
public class Calculator {

    private String example = "";

    public void execute() {
        inputExample();

        Errors checkErrors = new Errors();


        if (!checkErrors.execute(example)) {
            ParseString parseString = new ParseString();
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
