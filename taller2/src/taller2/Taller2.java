package taller2;

import edu.princeton.cs.algs4.RandomSeq;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Taller2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Dataset conocidos = Dataset.generateClusters2D(5);
        double[][] points = conocidos.getPointsArray();

        double[][] desconocidos = new double[2][2];

        double[][] Datos = new double[2][2];

        int[] clases = new int[2];

        Datos[0][0] = 1;
        Datos[0][1] = 1;

        Datos[1][0] = 0;
        Datos[1][1] = 0;

        clases[0] = 1;
        clases[1] = 0;
        
        desconocidos[0][0] = 0.1;
        desconocidos[0][1] = 0.1;

        desconocidos[1][0] = 0.9;
        desconocidos[1][1] = 0.9;

        assert(KNN.clasificar(desconocidos, clases, desconocidos[0], 0) == 0);
        assert(KNN.clasificar(desconocidos, clases, desconocidos[1], 0) == 1);

        // for (double[] ds : desconocidos) {
        //     System.out.println("\n El clase mas cercana a la corrdenada es : "
        //             + KNN.clasificar(Datos, clases, ds, 1));
        // }
        
        // for (int i = 0; i < desconocidos.length; i++) {
        // desconocidos[i] = (double) (RandomSeq());
        // }

        

        // System.out.println("los datos en el vector conocidos son: ");

        // for (double[] x : points)
        // StdOut.println(Arrays.toString(x));

        // System.out.println("las cases son:");

        // for (int i = 0; i < conocidos.getLabelsArray().length; i++) {

        // System.out.println(conocidos.getLabelsArray()[i]);

        // }

    }
}
