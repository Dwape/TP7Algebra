import java.util.Random;

/**
 * Created by Gianni on 5/28/2017.
 */
public class Main2 {
    public static void main(String[] args) {
        testEj5a();
        testEj5b();
        compareEj5();
        testEj6();
        testEj7();
    }

    private static void compareEj5(){
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

    private static void testEj5a(){
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

        double[][] coefficients2 = new double[3][3];
        coefficients2[0][0]=1;
        coefficients2[0][1]=4;
        coefficients2[0][2]=2;
        coefficients2[1][0]=3;
        coefficients2[1][1]=4;
        coefficients2[1][2]=1;
        coefficients2[2][0]=0;
        coefficients2[2][1]=2;
        coefficients2[2][2]=3;


        double[] independentTerms2 = new double[3];
        independentTerms2[0]=1;
        independentTerms2[1]=2;
        independentTerms2[2]=3;

        double[] result3 = ej5.exercise5WithoutPivoteo(coefficients2,independentTerms2);

        for (int i=0;i<result3.length;i++){
            System.out.println(result3[i]);
        }
        System.out.println("");


        double[][] coefficients4 = new double[4][4];
        coefficients4[0][0]=3;
        coefficients4[0][1]=2;
        coefficients4[0][2]=0;
        coefficients4[0][3]=0;
        coefficients4[1][0]=2;
        coefficients4[1][1]=6;
        coefficients4[1][2]=1;
        coefficients4[1][3]=0;
        coefficients4[2][0]=0;
        coefficients4[2][1]=1;
        coefficients4[2][2]=5;
        coefficients4[2][3]=7;
        coefficients4[3][0]=0;
        coefficients4[3][1]=0;
        coefficients4[3][2]=7;
        coefficients4[3][3]=9;

        double[] independentTerms4 = new double[4];
        independentTerms4[0]=1;
        independentTerms4[1]=2;
        independentTerms4[2]=3;
        independentTerms4[2]=4;

        double[] result4 = ej5.exercise5WithoutPivoteo(coefficients4,independentTerms4);

        for (int i=0;i<result4.length;i++){
            System.out.println(result4[i]);
        }
        System.out.println("");



        double[][] coefficients5 = new double[3][3];
        coefficients5[0][0]=3;
        coefficients5[0][1]=2;
        coefficients5[0][2]=0;
        coefficients5[1][0]=2;
        coefficients5[1][1]=6;
        coefficients5[1][2]=1;
        coefficients5[2][0]=0;
        coefficients5[2][1]=1;
        coefficients5[2][2]=5;

        double[] independentTerms5 = new double[3];
        independentTerms5[0]=1;
        independentTerms5[1]=2;
        independentTerms5[2]=3;

        double[] result5 = ej5.exercise5WithoutPivoteo(coefficients5,independentTerms5);

        for (int i=0;i<result5.length;i++){
            System.out.println(result5[i]);
        }
        System.out.println("");
    }

    private static void testEj5b(){
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

    private static void testEj6(){
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

        double[][] coefficients2 = new double[3][3];
        coefficients2[0][0]=1;
        coefficients2[0][1]=4;
        coefficients2[0][2]=2;
        coefficients2[1][0]=3;
        coefficients2[1][1]=4;
        coefficients2[1][2]=1;
        coefficients2[2][0]=0;
        coefficients2[2][1]=2;
        coefficients2[2][2]=3;


        double[] independentTerms2 = new double[3];
        independentTerms2[0]=1;
        independentTerms2[1]=2;
        independentTerms2[2]=3;

        double[] result3 = ej6.exercise6(coefficients2,independentTerms2,new Calc());

        for (int i=0;i<result3.length;i++){
            System.out.println(result3[i]);
        }
    }

    private static void testEj7(){
        Ej7 ej7 = new Ej7();

        double[][] coefficients1 = new double[4][4];
        coefficients1[0][0]=3;
        coefficients1[0][1]=2;
        coefficients1[0][2]=0;
        coefficients1[0][3]=0;
        coefficients1[1][0]=2;
        coefficients1[1][1]=6;
        coefficients1[1][2]=1;
        coefficients1[1][3]=0;
        coefficients1[2][0]=0;
        coefficients1[2][1]=1;
        coefficients1[2][2]=5;
        coefficients1[2][3]=7;
        coefficients1[3][0]=0;
        coefficients1[3][1]=0;
        coefficients1[3][2]=7;
        coefficients1[3][3]=9;

        double[] independentTerms1 = new double[4];
        independentTerms1[0]=1;
        independentTerms1[1]=2;
        independentTerms1[2]=3;
        independentTerms1[2]=4;

        double[] result1 = ej7.exercise7(coefficients1,independentTerms1,new Calc());

        for (int i=0;i<result1.length;i++){
            System.out.println(result1[i]);
        }
        System.out.println("");

        double[][] coefficients2 = new double[3][3];
        coefficients2[0][0]=3;
        coefficients2[0][1]=2;
        coefficients2[0][2]=0;
        coefficients2[1][0]=2;
        coefficients2[1][1]=6;
        coefficients2[1][2]=1;
        coefficients2[2][0]=0;
        coefficients2[2][1]=1;
        coefficients2[2][2]=5;

        double[] independentTerms2 = new double[3];
        independentTerms2[0]=1;
        independentTerms2[1]=2;
        independentTerms2[2]=3;

        double[] result2 = ej7.exercise7(coefficients2,independentTerms2,new Calc());

        for (int i=0;i<result2.length;i++){
            System.out.println(result2[i]);
        }
        System.out.println("");
    }

}

