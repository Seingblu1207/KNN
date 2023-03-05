package taller2;

import java.util.*;

public class KNN {
    public static int clasificar(double[][] conocidos, int[] clases, double[] muestra, int k) {
        // Calcular la distancia entre la muestra desconocida y todas las muestras
        // conocidas
        List<Distancia> distancias = new ArrayList<>();
        for (int i = 0; i < conocidos.length; i++) {
            double distancia = distanciaEuclidiana(conocidos[i], muestra);
            distancias.add(new Distancia(distancia, clases[i]));
        }

        // Ordenar las distancias de menor a mayor
        Collections.sort(distancias, new Comparator<Distancia>() {
            public int compare(Distancia d1, Distancia d2) {
                if (d1.distancia < d2.distancia) {
                    return -1;
                } else if (d1.distancia > d2.distancia) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        // Contar las clases de los k puntos más cercanos
        Map<Integer, Integer> conteos = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int clase = distancias.get(i).clase;
            if (conteos.containsKey(clase)) {
                conteos.put(clase, conteos.get(clase) + 1);
            } else {
                conteos.put(clase, 1);
            }
        }

        // Encontrar la clase con mayor conteo
        int claseMaxima = -1;
        int conteoMaximo = -1;
        for (Map.Entry<Integer, Integer> entry : conteos.entrySet()) {
            int clase = entry.getKey();
            int conteo = entry.getValue();
            if (conteo > conteoMaximo) {
                claseMaxima = clase;
                conteoMaximo = conteo;
            }
        }

        return claseMaxima;
    }

    private static double distanciaEuclidiana(double[] vector1, double[] vector2) {
        double suma = 0;
        for (int i = 0; i < vector1.length; i++) {
            double diff = vector1[i] - vector2[i];
            suma += diff * diff;
        }
        return Math.sqrt(suma);
    }

    private static class Distancia {
        double distancia;
        int clase;

        public Distancia(double distancia, int clase) {
            this.distancia = distancia;
            this.clase = clase;
        }
    }
}
