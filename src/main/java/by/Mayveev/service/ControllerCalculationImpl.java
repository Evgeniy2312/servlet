package by.Mayveev.service;

public class ControllerCalculationImpl implements ControllerCalculation {
    @Override
    public String getResult(int i1, int i2, String calculation) {
        int result = 0;
        switch (calculation){
            case "add" : result=  i1 + i2;
                break;
            case "sub": result = i1 - i2;
                break;
            case "mul": result = i1 * i2;
                break;
            case "div": result = i1 / i2;
                break;
        }
        String result1 = String.valueOf(result);
        return result1;
    }
}
