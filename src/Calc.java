/**
 * Created by Dwape on 5/23/17.
 */
public class Calc implements Calculator{

    // The equivalent for sum(5,10) is 5+10=15;
    public double sum(double a, double b){
        return a+b;
    }

    // The equivalent for subtraction(5,10) is 5-10=-5;
    public double subtraction(double a, double b){
        return a-b;
    }

    // The equivalent for multiplication(5,10) is 5*10=-50;
    public double multiplication(double a, double b){
        return a*b;
    }

    // The equivalent for division(5,10) is 5/10=0.5;
    public double division(double a, double b){
        return a/b;
    }
}
