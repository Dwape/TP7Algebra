/**
 * Created by Dwape on 5/23/17.
 */
public class TP7 implements TP4{

    private Calc calculator;

    public TP7(Calculator calc){
        calculator = (Calc) calc;
    }

    public double[] exercise1(double[][] coefficients, double[] independentTerms){
        double[] solution = new double[independentTerms.length];
        int counter = 0;
        for (int i=coefficients.length-1; i>=0; i--){
            double result = 0;
            for (int k=i; k>coefficients[0].length-i+1; k--){ //index is wrong //coefficients[0].length-1-i
                double product = calculator.multiplication(solution[k-i], coefficients[i][k+i]);
                result = calculator.sum(result, product);
            }
            solution[counter] = independentTerms[i] - result; //use calc
            System.out.println(solution[counter]);
            counter++;
        }
        return solution;
    }

    public double[] exercise2(double[][] coefficients, double[] independentTerms){
        return new double[1];
    }

    public double[] exercise5WithoutPivoteo(double[][] coefficients, double[] independentTerms){
        return new double[1];
    }

    public double[] exercise5PartialPivoteo(double[][] coefficients, double[] independentTerms){
        return new double[1];
    }

    public double[] exercise6(double[][] coefficients, double[] independentTerms, Calculator calculator){
        return new double[1];
    }

    public double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator){
        return new double[1];
    }

    public double[][] exercise8(double[][] coefficients){
        return new double[1][1];
    }

    public double[] exercise9(double[][] coefficients, double[] independentTerms){
        return new double[1];
    }
}
