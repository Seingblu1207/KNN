package taller2;

import edu.princeton.cs.algs4.RandomSeq;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Taller2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Variable para datos conocidos
        double[][] Datos = new double[2][2];

        //Se llena con datos convenientes
        Datos[0][0] = 1;
        Datos[0][1] = 1;

        Datos[1][0] = 0;
        Datos[1][1] = 0;

        //Clases para datos conocidos
        int[] clases = new int[2];

        clases[0] = 1;
        clases[1] = 0;

        //Datos desconocidos
        double[][] desconocidos = new double[2][2];

        desconocidos[0][0] = 0.1;
        desconocidos[0][1] = 0.1;

        desconocidos[1][0] = 0.9;
        desconocidos[1][1] = 0.9;

        assert (KNN.clasificar(Datos, clases, desconocidos[0], 0) == 0);
        assert (KNN.clasificar(Datos, clases, desconocidos[1], 0) == 1);



// --------------------------------------------------------------------------------------------------------------------------------------------------------
// Aqui finalizan las pruebas unitarias y empieza el analisis de tiempo



        //Cantidad de N inicial
        int c = 500;

        //Cantidad de aumentos de C
        int t = 10;

        //Cantidad de valores desconocidos
        int cdesc = 10;

        //Matriz para almacenar los desconocidos
        double[][] desc = new double[cdesc][2];

        //For para los aumentos
        for (int i = 0; i < t; i++) {

            //Iniciar conteo de tiempo
            Stopwatch a = new Stopwatch();

            //Obtencion de datos aleatorios
            Dataset Dconocidos = Dataset.generateClusters2D(c);
            Dataset Ddesc = Dataset.generateClusters2D(cdesc);
            desc = Ddesc.getPointsArray();

            //Clasificar para cada dato desconocido
            for (int j = 0; j < cdesc; j++) {

                System.out.println("\n T= " + j);
                KNN.clasificar(Dconocidos.getPointsArray(), Dconocidos.getLabelsArray(), desc[j], 5);

            }
            
            System.out.println("\n Para un N de " + c + " el tiempo practico es de " + a.elapsedTime());
            System.out.println("------------------------------------------------------------------------------------------------------------- \n");
            c = c * 2;
        }
    }
}
