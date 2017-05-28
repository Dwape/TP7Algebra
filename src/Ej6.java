/**
 * Created by Gianni on 5/28/2017.
 */
public class Ej6 {
    double[] exercise6(double[][] coefficients, double[] independentTerms, Calculator calculator){
        int n = coefficients[0].length;
        if (n!=coefficients.length) throw new RuntimeException("Matrix is not squared");

        for (int i=0; i<n;i++){//maneja los caso 2, el interior maneja los caso 1;
            double divisor = coefficients[i][i];
            for (int j=i;j<n;j++){
                //coefficients[i][j]=coefficients[i][j]/divisor;
                //if (coefficients[i][j]/divisor==0) System.out.println("Operated on a cero");
                coefficients[i][j]=calculator.division(coefficients[i][j],divisor);
            }
            //independentTerms[i]=independentTerms[i]/divisor;
            independentTerms[i]=calculator.division(independentTerms[i],divisor);
            for (int k = i+1;k<n-2+i && i+1<n;k++){
                double multiplier = coefficients[k][i];
                for (int j=i;j<n;j++){
                    //coefficients[k][j]=coefficients[k][j]-multiplier*coefficients[i][j];
                    //if (coefficients[k][j]==0||multiplier*coefficients[i][j]==0) System.out.println("Operated on a cero");
                    coefficients[k][j]=calculator.subtraction(coefficients[k][j],calculator.multiplication(multiplier,coefficients[i][j]));
                }
                //independentTerms[k]=independentTerms[k]-multiplier*independentTerms[i];
                independentTerms[k]=calculator.subtraction(independentTerms[k],calculator.multiplication(multiplier,independentTerms[i]));
            }

        }
        TP7 tp7 = new TP7(new Calc());
        return tp7.exercise1(coefficients, independentTerms);
    }
}
