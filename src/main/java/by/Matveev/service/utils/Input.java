package by.Matveev.service.utils;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Input{

    private static List<String> calculations = Arrays.asList("add", "sub", "div", "mul" );

    public static boolean divZero(double i, String operation){
        return operation.equals("div") & i == 0;
    }

    public static String getMessage(String message){
        return message;
    }

    public static double[] parseToDouble(String[] numsStr){
        double[] nums = new double[numsStr.length];
        for (int i = 0; i < numsStr.length; i++ ) {
            nums[i] = Double.parseDouble(numsStr[i]);
        }
        return nums;
    }


    public static boolean checkTypeOfCalculation(String type) {
        boolean flag = false;
        for (String s : calculations) {
            if (Pattern.matches(s, type)) {
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
}
