package ProblemaArray;

import java.util.Arrays;
import java.util.Random;

public class EjercicioArrays {

    public static void main(String[] args) {
        int numAlumnos = 40;
        int[] control = new int[numAlumnos];
        int[] practicas = new int[numAlumnos];
        float[] calificaciones = new float[numAlumnos];
        float[] estadistica = new float[10];

        // Generar notas aleatorias
        generarNotas(control);
        generarNotas(practicas);

        // Calcular calificaciones
        calcularCalificaciones(control, practicas, calificaciones);

        // Obtener nota mínima y máxima con sus posiciones
        int minNota = control[0];
        int maxNota = control[0];
        int indMinNota = 0, indMaxNota = 0;

        for (int i = 1; i < numAlumnos; i++) {
            if (control[i] < minNota) {
                minNota = control[i];
                indMinNota = i;
            }
            if (control[i] > maxNota) {
                maxNota = control[i];
                indMaxNota = i;
            }
        }

        // Imprimir resultados
        System.out.println("Mínimo es: " + minNota);
        System.out.println("Máximo es: " + maxNota);
        System.out.println("Indice del mínimo es: " + (indMinNota + 1));
        System.out.println("Indice del máximo es: " + (indMaxNota + 1));
        System.out.println("Lista de clase: " + Arrays.toString(generarListaClase(numAlumnos)));
        System.out.println("Array de Notas: " + Arrays.toString(control));

        System.out.println("Prácticas: " + Arrays.toString(practicas));
        System.out.println("Calificaciones: " + Arrays.toString(calificaciones));

        // Estadística de calificaciones
        calcularEstadistica(calificaciones, estadistica, numAlumnos);

        // Aprobados y suspensos
        int[] aprobados = new int[numAlumnos];
        int[] suspensos = new int[numAlumnos];
        int countAprobados = 0, countSuspensos = 0;

        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] < 5) {
                suspensos[countSuspensos++] = i + 1;
            } else {
                aprobados[countAprobados++] = i + 1;
            }
        }

        // Imprimir aprobados y suspensos
        System.out.println("Relación de aprobados por nº de lista: " + Arrays.toString(Arrays.copyOf(aprobados, countAprobados)));
        System.out.println("Relación de suspensos por nº de lista: " + Arrays.toString(Arrays.copyOf(suspensos, countSuspensos)));

        // Modificar la nota del alumno 4
        double[] calif = new double[40];
        for (int j = 0; j < 31; j++) {
            calif[j] = (int) (Math.random() * 11);
        }

        System.out.println("Nota antigua alumno nº4: " + calif[3]);
        calif[3] = 6;
        System.out.println("Nota nueva alumno nº4: " + calif[3]);
    }

    // Método para generar notas aleatorias entre 1 y 10
    public static void generarNotas(int[] notas) {
        Random rand = new Random();
        for (int i = 0; i < notas.length; i++) {
            notas[i] = rand.nextInt(11);
        }
    }

    // Método para calcular calificaciones haciendo la media entre control y prácticas
    public static void calcularCalificaciones(int[] control, int[] practicas, float[] calificaciones) {
        for (int i = 0; i < control.length; i++) {
            calificaciones[i] = (control[i] + practicas[i]) / 2.0f;
        }
    }

    // Método para generar la lista de alumnos
    public static int[] generarListaClase(int numAlumnos) {
        int[] listaClase = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++) {
            listaClase[i] = i + 1;
        }
        return listaClase;
    }

    // Método para calcular la estadística de las claificaciones
    public static void calcularEstadistica(float[] calificaciones, float[] estadistica, int numAlumnos) {
        for (int i = 0; i < 10; i++) {
            float contador = 0;
            for (float nota : calificaciones) {
                if (i < nota && nota <= (i + 1)) {
                    contador++;
                }
            }
            estadistica[i] = (contador / numAlumnos) * 100;
            System.out.println("Estadística nota tramo <=" + (i + 1) + " = " + Math.round(estadistica[i] * 100.0) / 100.0 + "%");
        }
    }
}
