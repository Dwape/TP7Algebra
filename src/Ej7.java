/**
 * Created by Gianni on 5/28/2017.
 */
public class Ej7 {
    double[] exercise7(double[][] coefficients, double[] independentTerms, Calculator calculator){
        int n = coefficients[0].length;
        if (n!=coefficients.length) throw new RuntimeException("Matrix is not squared");
        int l = 2;
        int h = 2;
        int r = 2;
        for (int i=0; i<n;i++){
            double divisor = coefficients[i][i];
            for (int j=i;j<l && j<n;j++){
                //coefficients[i][j]=coefficients[i][j]/divisor;
                //if (coefficients[i][j]/divisor==0) System.out.println("Operated on a cero");
                coefficients[i][j]=calculator.division(coefficients[i][j],divisor);
            }
            l++;
            //independentTerms[i]=independentTerms[i]/divisor;
            independentTerms[i]=calculator.division(independentTerms[i],divisor);

            for (int k = i+1;k<h && k<n;k++){
                double multiplier = coefficients[k][i];
                for (int j=i;j<r;j++){
                    //coefficients[k][j]=coefficients[k][j]-multiplier*coefficients[i][j];
                    //if (coefficients[k][j]==0||multiplier*coefficients[i][j]==0) System.out.println("Operated on a cero");
                    coefficients[k][j]=calculator.subtraction(coefficients[k][j],calculator.multiplication(multiplier,coefficients[i][j]));
                }
                //independentTerms[k]=independentTerms[k]-multiplier*independentTerms[i];
                independentTerms[k]=calculator.subtraction(independentTerms[k],calculator.multiplication(multiplier,independentTerms[i]));
                r++;
            }
            h++;
        }
        TP7 tp7 = new TP7(new Calc());
        return tp7.exercise1(coefficients, independentTerms);
    }
}
