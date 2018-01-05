/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinantes;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Alvarado
 */
public class Determinantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new algebraLineal();
       
        
        
        
//        int orden_de_Matriz = solicitarOrden();
//        switch ((orden_de_Matriz - 1)) {
//            case 1:
//                determinante2x2(solicitarValores(orden_de_Matriz));
//                break;
//
//            case 2:
//                determinante3x3(solicitarValores(orden_de_Matriz));
//                break;
//
//            case 3:
//                determinante4x4(solicitarValores(orden_de_Matriz));
//                break;
//
//            default:
//                JOptionPane.showMessageDialog(null, "Hasta el momento solo se pueden calcular determinantes de orden 2 y 3\nSeleccione una opción valida.");
//        }

    }

    //FUNCIONES
    public static int solicitarOrden() {

        // Solicitando el tamaño de la matriz (orden).
        int orden_de_Matriz = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el orden de la matriz"));
        return orden_de_Matriz;
    }

    // Esta función se encarga de solicitar los valores de la matriz
    public static double[][] solicitarValores(int orden_de_Matriz) {

        Scanner s = new Scanner(System.in); // Creando instancia del objeto Scanner para solicitar valores

        // Arreglo para almacenar valores
        double[][] matriz = new double[orden_de_Matriz][orden_de_Matriz];

        // Se solicita cada valor de la matriz
        for (int i = 0; i < orden_de_Matriz; i++) {
            for (int j = 0; j < orden_de_Matriz; j++) {

                System.out.print("Ingrese el valor de la posición (" + (i + 1) + "," + (j + 1) + ") : ");
                matriz[i][j] = s.nextDouble();
            }
        }

        return matriz;
    }

    //CALCULO DE DETERMINANTES
    public static void determinante2x2(double[][] matriz) {

        System.out.println("(matriz[0][0]*matriz[1][1]) = " + (matriz[0][0] * matriz[1][1]));
        System.out.println("(matriz[0][1]*matriz[0][0])) = " + (matriz[0][1] * matriz[1][0]));
        double resultado = (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        System.out.println("El determinante de la matriz es: " + resultado);
    }

    public static double determinante3x3(double[][] matriz) {

        double resultado = ((matriz[0][0] * matriz[1][1] * matriz[2][2]) + (matriz[0][1] * matriz[1][2] * matriz[2][0])
                + (matriz[0][2] * matriz[1][0] * matriz[2][1]))
                - ((matriz[2][0] * matriz[1][1] * matriz[0][2]) + (matriz[2][1] * matriz[1][2] * matriz[0][0])
                + (matriz[2][2] * matriz[1][0] * matriz[0][1]));
        System.out.println("El determinante de la matriz es: " + resultado);

        return resultado;
    }

    public static double determinante4x4(double[][] matriz) {

        double[][] matrizA = new double[3][3];
        double[][] matrizB = new double[3][3];
        double[][] matrizC = new double[3][3];
        double[][] matrizD = new double[3][3];

        //Llenando matrices de su valor
        for (int i = 0, x = 1; i < 3; i++, x++) {

            for (int j = 0, y = 1; j < 3; j++, y++) {

                matrizA[i][j] = matriz[x][y];

                if (y == 1) {
                    matrizB[i][j] = matriz[x][(y - 1)];
                    matrizC[i][j] = matriz[x][(y - 1)];
                    matrizD[i][j] = matriz[x][(y - 1)];

                } else if (y == 2) {

                    matrizB[i][j] = matriz[x][y];
                    matrizC[i][j] = matriz[x][(y - 1)];
                    matrizD[i][j] = matriz[x][(y - 1)];

                } else {
                    matrizB[i][j] = matriz[x][y];
                    matrizC[i][j] = matriz[x][y];
                    matrizD[i][j] = matriz[x][y - 1];
                }

            }
        }

        double detA = determinante3x3(matrizA);
        double detB = determinante3x3(matrizB);
        double detC = determinante3x3(matrizC);
        double detD = determinante3x3(matrizD);
        double resultado = ((matriz[0][0] * detA) + (-matriz[0][1] * detB) + (matriz[0][2] * detC) + (-matriz[0][3] * detD));

        System.out.println("El cofactor de A es: " + matriz[0][0]);
        System.out.println("El cofactor de B es: " + matriz[0][1]);
        System.out.println("El cofactor de C es: " + matriz[0][2]);
        System.out.println("El cofactor de D es: " + matriz[0][3]);
        System.out.println("El determinante de A es: " + detA);
        System.out.println("El determinante de B es: " + detB);
        System.out.println("El determinante de C es: " + detC);
        System.out.println("El determinante de D es: " + detD);
        System.out.println("El determinante de la matriz es: " + resultado);

        return resultado;
    }

    public static double determinante5x5(double[][] matriz) {
        double resultado = 0;

        double[][] matrizA = new double[4][4];
        double[][] matrizB = new double[4][4];
        double[][] matrizC = new double[4][4];
        double[][] matrizD = new double[4][4];
        double[][] matrizE = new double[4][4];

        //Llenando matrices de su valor
        for (int i = 0, x = 1; i < 3; i++, x++) {

            for (int j = 0, y = 1; j < 3; j++, y++) {

                matrizA[i][j] = matriz[x][y];

                if (y == 1) {
                    matrizB[i][j] = matriz[x][(y - 1)];
                    matrizC[i][j] = matriz[x][(y - 1)];
                    matrizD[i][j] = matriz[x][(y - 1)];

                } else if (y == 2) {

                    matrizB[i][j] = matriz[x][y];
                    matrizC[i][j] = matriz[x][(y - 1)];
                    matrizD[i][j] = matriz[x][(y - 1)];

                } else {
                    matrizB[i][j] = matriz[x][y];
                    matrizC[i][j] = matriz[x][y];
                    matrizD[i][j] = matriz[x][y - 1];
                }

            }
        }

        double detA = determinante3x3(matrizA);
        double detB = determinante3x3(matrizB);
        double detC = determinante3x3(matrizC);
        double detD = determinante3x3(matrizD);
        resultado = ((matriz[0][0] * detA) + (-matriz[0][1] * detB) + (matriz[0][2] * detC) + (-matriz[0][3] * detD));

        System.out.println("El cofactor de A es: " + matriz[0][0]);
        System.out.println("El cofactor de B es: " + matriz[0][1]);
        System.out.println("El cofactor de C es: " + matriz[0][2]);
        System.out.println("El cofactor de D es: " + matriz[0][3]);
        System.out.println("El determinante de A es: " + detA);
        System.out.println("El determinante de B es: " + detB);
        System.out.println("El determinante de C es: " + detC);
        System.out.println("El determinante de D es: " + detD);
        System.out.println("El determinante de la matriz es: " + resultado);

        return resultado;
    }   
}
