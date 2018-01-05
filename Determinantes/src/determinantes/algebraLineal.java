/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinantes;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando Alvarado
 */
public class algebraLineal {

    public algebraLineal() {
        double m[][];
        double mTraspuesta[][];
        double determinante;
        int N = solicitarOrden();
        m = new double[N][N];
        m = escribirMatriz(N);
        //ES es una clase creada para leer de teclado

        int opcion = 0;
        do {
            opcion = (int)Opcion("Seleccione una opción\n---------------\n\t1.- Mostrar la matriz\n\t2.- Comprobar si la matriz es simétrica\n\t3.- Mostrar la matriz traspuesta\n\t4.- Calcular el determinante\n\t0.- Salir");
            switch (opcion) {
                case 1:
                    System.out.println("La matriz introducida es:");
                    mostrarMatriz(m);
                    break;
                case 2:
                    mTraspuesta = trasponerMatriz(m);
                    if (simetriaMatrices(m, mTraspuesta) == true) {
                        System.out.println("La matriz es simétrica");
                    } else {
                        System.out.println("La matriz NO es simétrica");
                    }
                    break;
                case 3:
                    mTraspuesta = trasponerMatriz(m);
                    System.out.println("Su traspuesta es:");
                    mostrarMatriz(mTraspuesta);
                    break;
                case 4:
                    determinante = determinanteMatriz(m, N);
                    System.out.println("El determinante es: " + determinante);
            }
        } while (opcion != 0);
    }

    public static int solicitarOrden() {

        // Solicitando el tamaño de la matriz (orden).
        int orden_de_Matriz = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el orden de la matriz"));
        return orden_de_Matriz;
    }

    public static double Opcion(String cad) {

        // Solicitando el tamaño de la matriz (orden).
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(cad));
        return opcion;
    }

    public static double[][] escribirMatriz(int orden_de_Matriz) {
        // Arreglo para almacenar valores
        double[][] x = new double[orden_de_Matriz][orden_de_Matriz];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                x[i][j] = Opcion("Introduzca el número de la fila " + (i + 1) + " y columna " + (j + 1) + ":");
            }
        }
        return x;
    }

    public static void mostrarMatriz(double x[][]) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static double[][] trasponerMatriz(double x[][]) {
        double[][] y = new double[x.length][x.length];
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y.length; j++) {
                y[i][j] = x[j][i];
            }
        }
        return y;
    }

    public static boolean simetriaMatrices(double x[][], double y[][]) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i][j] != y[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static double determinanteMatriz(double x[][], int N) {
        double det = 0;
        switch (N) {
            case 2:
                det = ((x[0][0] * x[1][1]) - (x[1][0] * x[0][1]));
                break;
            case 3:	//Método de Gauss
                det = ((x[0][0]) * (x[1][1]) * (x[2][2]) + (x[1][0]) * (x[2][1]) * (x[0][2]) + (x[2][0]) * (x[0][1]) * (x[1][2])) - ((x[2][0]) * (x[1][1]) * (x[0][2]) + (x[1][0]) * (x[0][1]) * (x[2][2]) + (x[0][0]) * (x[2][1]) * (x[1][2]));
                break;
            default:	//Desarrollo a partir de los elementos de una fila/columna			
                for (int z = 0; z < x.length; z++) {
                    det += (x[z][0] * adj(x, z, 0));
                }
        }
        return det;
    }

    public static double adj(double x[][], int i, int j) {
        double adjunto;
        double y[][] = new double[x.length - 1][x.length - 1];
        int m, n;
        for (int k = 0; k < y.length; k++) {
            if (k < i) {
                m = k;
            } else {
                m = k + 1;
            }
            for (int l = 0; l < y.length; l++) {
                if (l < j) {
                    n = l;
                } else {
                    n = l + 1;
                }
                y[k][l] = x[m][n];
            }
        }
        adjunto =  Math.pow(-1, i + j) * determinanteMatriz(y, y.length);
        return adjunto;
    }

}
