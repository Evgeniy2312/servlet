package by.Matveev.service.input;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Input{
    private static List<String> calculations = Arrays.asList("add", "sub", "div", "mul" );

    public static boolean checkTypeOfCalculation(String type){
        boolean flag = false;
        for(String s : calculations){
            if(Pattern.matches(s, type)){
                flag = true;
            }
        }
        return flag;
    }

    public static boolean getDouble(String i){
        boolean flag = false;
        if(Pattern.matches("^[0-9]*[.,]?[0-9]+$", i)){
            flag = true;
        }
        return flag;
    }

    public static boolean divZero(int i, String operation){
        boolean flag = true;
        String div = "div";
        if(operation.equals(div) & i == 0 ){
            flag = false;
        }
        return flag;
    }

    public static String getMessage(String message){
        return message;
    }
}
