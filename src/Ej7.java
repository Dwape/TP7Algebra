/**
 * Created by Gianni on 5/28/2017.
 */
public class Ej7 {
    double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator){
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
        TP7 tp7 = new TP7(new Calc());
        return tp7.exercise1(coefficients, independentTerms);
    }
}
