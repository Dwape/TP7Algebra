/**
 * Created by Dwape on 5/23/17.
 */
public class Main {

    public static void main(String[] args) {

        //testEj1();

        //testEj2();

        //testEj9();

        testEj8();
    }

    public static void testEj1(){
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
        double[] solution = tp.exercise1(coefficients, terms);
        for (int i=0; i<solution.length; i++){
            System.out.println(solution[i]);
        }
    }

    public static void testEj2(){
        TP7 tp = new TP7(new Calc());

        double[][] coefficients = new double[3][3];
        coefficients[0][0] = 3;
        coefficients[0][1] = 0;
        coefficients[0][2] = 0;
        coefficients[1][0] = -1;
        coefficients[1][1] = 2;
        coefficients[1][2] = 0;
        coefficients[2][0] = 2;
        coefficients[2][1] = 1;
        coefficients[2][2] = 4;

        double[] terms = new double[3];
        terms[0] = -3;
        terms[1] = 7;
        terms[2] = 9;
        double[] solution = tp.exercise2(coefficients, terms);
        for (int i=0; i<solution.length; i++){
            System.out.println(solution[i]);
        }
    }

    public static void testEj8(){
        TP7 tp = new TP7(new Calc());

        double[][] coefficients = new double[3][3];
        coefficients[0][0] = 3;
        coefficients[0][1] = 1;
        coefficients[0][2] = -3;
        coefficients[1][0] = 2;
        coefficients[1][1] = 6;
        coefficients[1][2] = 3;
        coefficients[2][0] = 1;
        coefficients[2][1] = 4;
        coefficients[2][2] = -2;

        double[][] inverse = tp.exercise8(coefficients);
        for (int i=0; i<inverse.length; i++){
            for (int j=0; j<inverse[0].length; j++){
                System.out.println(inverse[i][j]);
            }
        }
    }

    public static void testEj9(){
        TP7 tp = new TP7(new Calc());
        double[][] coefficients = new double[3][3];

        coefficients[0][0] = 2;
        coefficients[0][1] = -1;
        coefficients[0][2] = 5;
        coefficients[1][0] = 1;
        coefficients[1][1] = -6;
        coefficients[1][2] = 2;
        coefficients[2][0] = 3;
        coefficients[2][1] = 4;
        coefficients[2][2] = -1;

        double[] terms = new double[3];
        terms[0] = 16;
        terms[1] = -9;
        terms[2] = 32;

        double[] solution = tp.exercise9(coefficients, terms);
        //for (int i=0; i<solution.length; i++){
            //System.out.println(solution[i]);
        //}
        //System.out.println("");

        double[][] bigMatrix = new double[6][6];

        bigMatrix[0][0] =1;
        bigMatrix[0][1] =1;
        bigMatrix[0][2] =-2;
        bigMatrix[0][3] =1;
        bigMatrix[0][4] =3;
        bigMatrix[0][5] =-1;
        bigMatrix[1][0] =2;
        bigMatrix[1][1] =-1;
        bigMatrix[1][2] =1;
        bigMatrix[1][3] =2;
        bigMatrix[1][4] =1;
        bigMatrix[1][5] =-3;
        bigMatrix[2][0] =1;
        bigMatrix[2][1] =3;
        bigMatrix[2][2] =-3;
        bigMatrix[2][3] =-1;
        bigMatrix[2][4] =2;
        bigMatrix[2][5] =1;
        bigMatrix[3][0] =5;
        bigMatrix[3][1] =2;
        bigMatrix[3][2] =-1;
        bigMatrix[3][3] =-1;
        bigMatrix[3][4] =2;
        bigMatrix[3][5] =1;
        bigMatrix[4][0] =-3;
        bigMatrix[4][1] =-1;
        bigMatrix[4][2] =2;
        bigMatrix[4][3] =3;
        bigMatrix[4][4] =1;
        bigMatrix[4][5] =3;
        bigMatrix[5][0] =4;
        bigMatrix[5][1] =3;
        bigMatrix[5][2] =1;
        bigMatrix[5][3] =-6;
        bigMatrix[5][4] =-3;
        bigMatrix[5][5] =-2;

        double[] bigTerms = new double[6];
        bigTerms[0] = 4;
        bigTerms[1] = 20;
        bigTerms[2] = -15;
        bigTerms[3] = -3;
        bigTerms[4] = 16;
        bigTerms[5] = -27;

        double[] bigSolution = tp.exercise9(bigMatrix, bigTerms);
        for (int i=0; i<bigSolution.length; i++){
            System.out.println(bigSolution[i]);
        }
    }
}
