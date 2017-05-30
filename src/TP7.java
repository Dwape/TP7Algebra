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
        for (int i=coefficients.length-1; i>=0; i--){
            double result = 0;
            for (int k=i+1; k<coefficients[0].length; k++){
                double product = calculator.multiplication(solution[k], coefficients[i][k]);
                result = calculator.sum(result, product);
            }
            solution[i] = calculator.subtraction(independentTerms[i], result);
        }
        return solution;
    }

    public double[] exercise2(double[][] coefficients, double[] independentTerms){
        double[] solution = new double[independentTerms.length];
        for (int i=0; i<coefficients.length; i++){
            double result = 0;
            for (int k=0; k<i; k++){ //index is wrong //coefficients[0].length-1-i
                double product = calculator.multiplication(solution[k], coefficients[i][k]); //solution in k-i-1
                result = calculator.sum(result, product);
            }
            double partialResult = calculator.subtraction(independentTerms[i], result); //use calc
            solution[i] = calculator.division(partialResult, coefficients[i][i]);
        }
        return solution;
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
        double[][] enlargedMatrix = new double[coefficients.length][coefficients.length*2];
        for (int i=0; i<coefficients.length; i++){
            for (int j=0; j<coefficients[0].length; j++){
                enlargedMatrix[i][j] = coefficients[i][j];
            }
        }
        for (int i=0; i<coefficients.length; i++){
            enlargedMatrix[i][i+coefficients.length] = 1;
        }
        for (int i=0; i<coefficients.length; i++){
            double divisor = enlargedMatrix[i][i];
            for (int j=0; j<coefficients[0].length+i+1; j++){ //check index to see if it works as expected.
                enlargedMatrix[i][j] = enlargedMatrix[i][j]/divisor;
            }
            for (int j=0; j<coefficients.length; j++){ //j!=i
                double multiplier = enlargedMatrix[j][i];
                for (int k=0; k<enlargedMatrix[0].length; k++){
                    if (j != i) {
                        enlargedMatrix[j][k] = enlargedMatrix[j][k] - multiplier * enlargedMatrix[i][k];
                    }
                }
            }
        }
        double[][] inverse = new double[coefficients.length][coefficients[0].length];
        for (int i=0; i<inverse.length; i++){
            for (int j=0; j<inverse[0].length; j++){
                inverse[i][j] = enlargedMatrix[i][j+coefficients.length];
            }
        }
        return inverse;
    }

    public double[] exercise9(double[][] coefficients, double[] independentTerms){ //square matrix
        double[][] L = new double[coefficients.length][coefficients[0].length];
        double[][] U = new double[coefficients.length][coefficients[0].length];
        for (int i=0; i<coefficients.length; i++){ //fills diagonal with ones.
            L[i][i] = 1;
        }
        for (int i=0; i<coefficients.length; i++){
            for (int j=i; j<coefficients[0].length; j++){
                double result = 0;
                for (int k=0; k<i; k++){
                    double product = calculator.multiplication(L[i][k], U[k][j]);
                    result = calculator.sum(result, product);
                }
                U[i][j] = calculator.subtraction(coefficients[i][j], result);
            }
            for (int j=i+1; j<coefficients.length; j++){
                double result = 0;
                for (int k=0; k<i; k++){
                    double product = calculator.multiplication(L[j][k], U[k][i]);
                    result = calculator.sum(result, product);
                }
                double partialResult = calculator.subtraction(coefficients[j][i], result);
                L[j][i] = calculator.division(partialResult, U[i][i]);
            }
        }
        double[] z = solveLowerMatrix(L, independentTerms);
        return solveUpperMatrix(U, z);
    }

    public double[] solveUpperMatrix(double[][] coefficients, double[] independentTerms){
        double[] solution = new double[independentTerms.length];
        for (int i=coefficients.length-1; i>=0; i--){
            double result = 0;
            for (int k=i; k<coefficients[0].length; k++){
                double product = calculator.multiplication(solution[k], coefficients[i][k]);
                result = calculator.sum(result, product);
            }
            double partialResult = calculator.subtraction(independentTerms[i], result);
            solution[i] = calculator.division(partialResult, coefficients[i][i]);
        }
        return solution;
    }

    public double[] solveLowerMatrix(double[][] coefficients, double[] independentTerms){
        double[] solution = new double[independentTerms.length];
        for (int i=0; i<coefficients.length; i++){
            double result = 0;
            for (int k=0; k<i; k++){
                double product = calculator.multiplication(solution[k], coefficients[i][k]);
                result = calculator.sum(result, product);
            }
            solution[i] = calculator.subtraction(independentTerms[i], result);
        }
        return solution;
    }
}
