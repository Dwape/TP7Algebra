import java.util.Random;

/**
 * Created by Gianni on 5/28/2017.
 */
public class Main2 {
    public static void main(String[] args) {
        testEj5a();
        //testEj5b();
        //compareEj5();
        testEj6();//works
    }

    public static void compareEj5(){
        Random rand = new Random();
        Ej5 ej5 = new Ej5();
        double[][] coefficients1 = new double[3][3];
        double[] independentTerms1 = new double[3];

        double[][] coefficients2 = new double[3][3];
        double[] independentTerms2 = new double[3];

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                int random = rand.nextInt(10)+1;
                coefficients1[i][j]=random;
                coefficients2[i][j]=random;
            }
        }

        for (int i=0;i<3;i++){
            int random = rand.nextInt(10)+1;
            independentTerms1[i]=random;
            independentTerms2[i]=random;
        }

        double[] result = ej5.exercise5WithoutPivoteo(coefficients1,independentTerms1);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        System.out.println("");

        double[] result2 = ej5.exercise5PartialPivoteo(coefficients2,independentTerms2);

        for (int i=0;i<result2.length;i++){
            System.out.println(result2[i]);
        }
        System.out.println("");
    }

    public static void testEj5a(){
        Ej5 ej5 = new Ej5();

        double[][] coefficients = new double[3][3];
        coefficients[0][0]=3;
        coefficients[0][1]=2;
        coefficients[0][2]=1;
        coefficients[1][0]=5;
        coefficients[1][1]=3;
        coefficients[1][2]=4;
        coefficients[2][0]=1;
        coefficients[2][1]=1;
        coefficients[2][2]=-1;

        double[] independentTerms = new double[3];
        independentTerms[0]=1;
        independentTerms[1]=2;
        independentTerms[2]=1;

        double[] result = ej5.exercise5WithoutPivoteo(coefficients,independentTerms);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        System.out.println("");

        /*
        double[][] result = ej5.exercise5WithoutPivoteo(coefficients,independentTerms);

        for (int i=0;i<result.length;i++){
            for (int j=0;j<result.length;j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println("");
        }
        */

        double[][] coefficients1 = new double[4][4];
        coefficients1[0][0]=1;
        coefficients1[0][1]=4;
        coefficients1[0][2]=2;
        coefficients1[0][3]=3;
        coefficients1[1][0]=3;
        coefficients1[1][1]=4;
        coefficients1[1][2]=1;
        coefficients1[1][3]=7;
        coefficients1[2][0]=0;
        coefficients1[2][1]=2;
        coefficients1[2][2]=3;
        coefficients1[2][3]=4;
        coefficients1[3][0]=0;
        coefficients1[3][1]=0;
        coefficients1[3][2]=1;
        coefficients1[3][3]=3;

        double[] independentTerms1 = new double[4];
        independentTerms1[0]=1;
        independentTerms1[1]=2;
        independentTerms1[2]=3;
        independentTerms1[2]=4;

        double[] result2 = ej5.exercise5WithoutPivoteo(coefficients1,independentTerms1);

        for (int i=0;i<result2.length;i++){
            System.out.println(result2[i]);
        }
        System.out.println("");
    }

    public static void testEj5b(){
        Ej5 ej5 = new Ej5();

        double[][] coefficients = new double[3][3];
        coefficients[0][0]=3;
        coefficients[0][1]=2;
        coefficients[0][2]=1;
        coefficients[1][0]=5;
        coefficients[1][1]=3;
        coefficients[1][2]=4;
        coefficients[2][0]=1;
        coefficients[2][1]=1;
        coefficients[2][2]=-1;

        double[] independentTerms = new double[3];
        independentTerms[0]=1;
        independentTerms[1]=2;
        independentTerms[2]=1;

        double[] result = ej5.exercise5PartialPivoteo(coefficients,independentTerms);

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        System.out.println("");
        /*
        double[][] result2 = ej5.exercise5PartialPivoteo(coefficients,independentTerms);

        for (int i=0;i<result2.length;i++){
            for (int j=0;j<result2.length;j++){
                System.out.print(result2[i][j]+"\t");
            }
            System.out.println("");
        }
        */
    }

    public static void testEj6(){
        Ej6 ej6 = new Ej6();

        double[][] coefficients = new double[4][4];
        coefficients[0][0]=1;
        coefficients[0][1]=4;
        coefficients[0][2]=2;
        coefficients[0][3]=3;
        coefficients[1][0]=3;
        coefficients[1][1]=4;
        coefficients[1][2]=1;
        coefficients[1][3]=7;
        coefficients[2][0]=0;
        coefficients[2][1]=2;
        coefficients[2][2]=3;
        coefficients[2][3]=4;
        coefficients[3][0]=0;
        coefficients[3][1]=0;
        coefficients[3][2]=1;
        coefficients[3][3]=3;

        double[] independentTerms = new double[4];
        independentTerms[0]=1;
        independentTerms[1]=2;
        independentTerms[2]=3;
        independentTerms[2]=4;

        double[] result = ej6.exercise6(coefficients,independentTerms,new Calc());

        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        System.out.println("");
    }



}

