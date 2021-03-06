package com.company.system.checkErrors;

import com.company.calculator.parse.ParseString;

import java.util.List;

/**
 * Created by alexander.grankin on 5/15/2017.
 */
public class Errors {

    Error errorState;

    public boolean execute(String text) {
        boolean boolError;

        ParseString parseString = new ParseString();
        List<String> list = parseString.parse(text);

        errorState = new CountBrackets(list);
        boolError = checkError();

        int i = 0;
        while (i < 4) {
            if (!boolError) {
                nextErrors(list);
                boolError = checkError();
                i++;
            } else break;
        }

        return boolError;
    }

    private void setErrorState(Error errorState) {
        this.errorState = errorState;
    }

    public void nextErrors(List<String> list) {
        if (errorState instanceof CountBrackets) {
            setErrorState(new SymbolForOpenParenthesis(list));
        } else if (errorState instanceof SymbolForOpenParenthesis) {
            setErrorState(new UnknownSymbol(list));
        } else if (errorState instanceof UnknownSymbol) {
            setErrorState(new SymbolForCloseParenthesis(list));
        } else if (errorState instanceof SymbolForCloseParenthesis) {
            setErrorState(new CountBrackets(list));
        }
    }

    private boolean checkError() {
        return errorState.checkError();
    }

}







