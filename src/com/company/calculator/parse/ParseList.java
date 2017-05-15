package com.company.calculator.parse;

import com.company.calculator.expressions.Expressions;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class ParseList {
    public String make(List<String> list) {
        for (String s : list) {
            if (s.equals("*") || s.equals("/")) {
                for (int i = 0; i < list.size(); i++) {
                    Double number;
                    Expressions exp = new Expressions();
                    if (list.get(i).equals("*")) {
                        number = exp.multiplication(Double.parseDouble(list.get(i - 1)), Double.parseDouble(list.get(i + 1)));
                        setList(list, i, number);
                    } else if (list.get(i).equals("/")) {
                        number = exp.division(Double.parseDouble(list.get(i - 1)), Double.parseDouble(list.get(i + 1)));
                        setList(list, i, number);
                    }
                }
            }
        }
        for (String s : list) {
            if (s.equals("+") || s.equals("-")) {
                for (int i = 0; i < list.size(); i++) {
                    Double number;
                    Expressions exp = new Expressions();
                    if (list.get(i).equals("+")) {
                        number = exp.addition(Double.parseDouble(list.get(i - 1)), Double.parseDouble(list.get(i + 1)));
                        setList(list, i, number);
                    } else if (list.get(i).equals("-")) {
                        number = exp.subtraction(Double.parseDouble(list.get(i - 1)), Double.parseDouble(list.get(i + 1)));
                        setList(list, i, number);
                    }
                }
            }
        }
        return list.get(0);
    }

    public void executeParse(List<String> list) {
        while (list.size() != 1) {
            List<String> tmp = new CopyOnWriteArrayList<>();
            int start = 0, finish;
            int listSize;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("(")) {
                    start = i;
                }
                if (list.get(i).equals(")")) {
                    finish = i;
                    listSize = finish - start;

                    tmp.addAll(list.subList(start + 1, finish));
                    String el = make(tmp);
                    for (int c = 0; c <= listSize; c++) {
                        list.remove(start);
                    }
                    list.add(start, el);
                    tmp.clear();
                }
            }
            try {
                make(list);
            } catch (Exception e) {
                continue;
            }
        }
    }

    private List<String> setList(List<String> list, int i, Double number) {
        list.set(i, number.toString());
        list = removeElementList(list, i);
        return list;
    }

    private List<String> removeElementList(List<String> list, int i) {
        list.remove(i + 1);
        list.remove(i - 1);
        return list;
    }
}