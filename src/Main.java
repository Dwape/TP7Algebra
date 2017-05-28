/**
 * Created by Dwape on 5/23/17.
 */
public class Main {

    public static void main(String[] args) {

        TP7 tp = new TP7(new Calc());

        double[][] coefficients = new double[3][3];
        coefficients[0][0] = 1;
        coefficients[0][1] = 1;
        coefficients[0][2] = -1;
        coefficients[1][0] = 0;
        coefficients[1][1] = 1;
        coefficients[1][2] = -4;
        coefficients[2][0] = 0;
        coefficients[2][1] = 0;
        coefficients[2][2] = 1;

        double[] terms = new double[3];
        terms[0] = 1;
        terms[1] = 2;
        terms[2] = 1;
        tp.exercise1(coefficients, terms);

    }
}
