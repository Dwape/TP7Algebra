/**
 * Created by Gianni on 5/28/2017.
 */
public class Ej5 {
    double[] exercise5WithoutPivoteo(double[][] coefficients, double[] independentTerms){
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
        TP7 tp7 = new TP7(new Calc());
        return tp7.exercise1(coefficients, independentTerms);
    }

    double[] exercise5PartialPivoteo(double[][] coefficients, double[] independentTerms){//check if result is correct
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
        TP7 tp7 = new TP7(new Calc());
        return tp7.exercise1(coefficients, independentTerms);
    }
}
