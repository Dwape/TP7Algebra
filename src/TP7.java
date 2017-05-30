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
        int n = coefficients[0].length;
        if (n!=coefficients.length) throw new RuntimeException("Matrix is not squared");

        for (int i=0; i<n;i++){//maneja los caso 2, el interior maneja los caso 1;
            double divisor = coefficients[i][i];
            for (int j=i;j<n;j++){
                coefficients[i][j]=coefficients[i][j]/divisor;
            }
            independentTerms[i]=independentTerms[i]/divisor;
            for (int k = i+1;k<n;k++){
                double multiplier = coefficients[k][i];
                for (int j=i;j<n;j++){
                    coefficients[k][j]=coefficients[k][j]-multiplier*coefficients[i][j];
                }
                independentTerms[k]=independentTerms[k]-multiplier*independentTerms[i];
            }

        }
        return exercise1(coefficients, independentTerms);
    }

    public double[] exercise5PartialPivoteo(double[][] coefficients, double[] independentTerms){
        int n = coefficients[0].length;
        if (n!=coefficients.length) throw new RuntimeException("Matrix is not squared");

        for (int i=0; i<n;i++){
            int maxIndex = i;
            for (int l = i+1;l<n;l++){
                if (coefficients[l][i]>coefficients[maxIndex][i]){
                    maxIndex=l;
                }
            }
            double prevValue = independentTerms[i];
            independentTerms[i]=independentTerms[maxIndex];
            independentTerms[maxIndex]=prevValue;
            for (int t=0;t<n;t++){
                double prevValue2 = coefficients[i][t];
                coefficients[i][t]=coefficients[maxIndex][t];
                coefficients[maxIndex][t]=prevValue2;
            }
            double divisor = coefficients[i][i];
            for (int j=i;j<n;j++){
                coefficients[i][j]=coefficients[i][j]/divisor;
            }
            independentTerms[i]=independentTerms[i]/divisor;
            for (int k = i+1;k<n;k++){
                double multiplier = coefficients[k][i];
                for (int j=i;j<n;j++){
                    coefficients[k][j]=coefficients[k][j]-multiplier*coefficients[i][j];
                }
                independentTerms[k]=independentTerms[k]-multiplier*independentTerms[i];
            }
        }
        return exercise1(coefficients, independentTerms);
    }

    public double[] exercise6(double[][] coefficients, double[] independentTerms, Calculator calculator){
        int n = coefficients[0].length;
        if (n!=coefficients.length) throw new RuntimeException("Matrix is not squared");

        for (int i=0; i<n-1;i++){//maneja los caso 2, el interior maneja los caso 1;
            double divisor = coefficients[i][i];
            for (int j=i;j<n;j++){
                //coefficients[i][j]=coefficients[i][j]/divisor;
                //if (coefficients[i][j]/divisor==0) System.out.println("Operated on a cero");
                coefficients[i][j]=calculator.division(coefficients[i][j],divisor);
            }
            //independentTerms[i]=independentTerms[i]/divisor;
            independentTerms[i]=calculator.division(independentTerms[i],divisor);

            //for (int k = i+1;k<l && k<n;k++){
            double multiplier = coefficients[i+1][i];
            for (int j=i;j<n;j++){
                //coefficients[k][j]=coefficients[k][j]-multiplier*coefficients[i][j];
                //if (coefficients[k][j]==0||multiplier*coefficients[i][j]==0) System.out.println("Operated on a cero");
                coefficients[i+1][j]=calculator.subtraction(coefficients[i+1][j],calculator.multiplication(multiplier,coefficients[i][j]));
            }
            //independentTerms[k]=independentTerms[k]-multiplier*independentTerms[i];
            independentTerms[i+1]=calculator.subtraction(independentTerms[i+1],calculator.multiplication(multiplier,independentTerms[i]));
        }
        double divisor = coefficients[n-1][n-1];
        coefficients[n-1][n-1]=calculator.division(coefficients[n-1][n-1],divisor);
        independentTerms[n-1]=calculator.division(independentTerms[n-1],divisor);

        return exercise1(coefficients, independentTerms);
    }

    public double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator){
        int n = coefficients[0].length;
        if (n!=coefficients.length) throw new RuntimeException("Matrix is not squared");
        int l = 2;
        int r = 2;
        for (int i=0; i<n-1;i++){
            double divisor = coefficients[i][i];
            for (int j=i;j<l && j<n;j++){
                //coefficients[i][j]=coefficients[i][j]/divisor;
                //if (coefficients[i][j]/divisor==0) System.out.println("Operated on a cero");
                coefficients[i][j]=calculator.division(coefficients[i][j],divisor);
            }
            l++;
            //independentTerms[i]=independentTerms[i]/divisor;
            independentTerms[i]=calculator.division(independentTerms[i],divisor);

            //for (int k = i+1;k<h && k<n;k++){
            double multiplier = coefficients[i+1][i];
            for (int j=i;j<r;j++){
                //coefficients[k][j]=coefficients[k][j]-multiplier*coefficients[i][j];
                //if (coefficients[k][j]==0||multiplier*coefficients[i][j]==0) System.out.println("Operated on a cero");
                coefficients[i+1][j]=calculator.subtraction(coefficients[i+1][j],calculator.multiplication(multiplier,coefficients[i][j]));
            }
            //independentTerms[k]=independentTerms[k]-multiplier*independentTerms[i];
            independentTerms[i+1]=calculator.subtraction(independentTerms[i+1],calculator.multiplication(multiplier,independentTerms[i]));
            r++;
        }
        double divisor = coefficients[n-1][n-1];
        coefficients[n-1][n-1]=calculator.division(coefficients[n-1][n-1],divisor);
        independentTerms[n-1]=calculator.division(independentTerms[n-1],divisor);
        return exercise1(coefficients, independentTerms);
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
