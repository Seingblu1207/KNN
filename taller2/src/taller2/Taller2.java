/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller2;


/**
 *
 * @author sebas
 */
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
public class Taller2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dataset conocidos = Dataset.generateClusters2D(5);

        double[] desconocidos = new double[10];

        for (int i = 0; i < desconocidos.length; i++) {
            desconocidos[i] = (double) (Math.random() * (100 - 1) + 1);
        }
        System.out.println("los datos en el vector conocidos son: ");
        double[][] points = conocidos.getPointsArray();
        for(double[] x: points)
             StdOut.println(Arrays.toString(x));
        System.out.println("las cases son:");
        for (int i = 0; i < conocidos.getLabelsArray().length; i++) {
            System.out.println(conocidos.getLabelsArray()[i]);
        }

        System.out.println("el resutado de clasificar es: "
                +KNN.clasificar(conocidos.getPointsArray(), conocidos.getLabelsArray(), desconocidos, 5));
    }
    }
    

