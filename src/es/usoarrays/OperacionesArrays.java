/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.usoarrays;

/**
 *
 * @author diegocasalrodriguez
 */
public class OperacionesArrays {
    
    public static final int NUM_ALUMNOS = 40; // Menú -> Refactor -> Introduce -> Constant...
    
    public static void mostrarResultados(int minNota, int maxNota, int[] control, int[] practicas, float[] calificaciones, int countAprobados, int countSuspensos) {
        //Método mostrarResultados
        System.out.println("La nota mínima es  : " + minNota);
        System.out.println("La nota máxima es  : " + maxNota);
        System.out.println("Array de Notas     :" + control.toString());
        System.out.println("Prácticas          :" + practicas.toString());
        System.out.println("Calificaciones     :" + calificaciones.toString());
        System.out.println("Número de aprobados: " + countAprobados);
        System.out.println("Número de suspensos: " + countSuspensos);
        //Método mostrarResultados
    }

    public static void generarEstadisticas(int[] control, float[] calificaciones, float[] estadistica) {
        //Método generarEstadisticas
        //Sacamos la estadística de calificaciones
        //hacemos un array de 10 para la estadística.
        for (int i = 0; i < 10; i++) {
            float count = 0;
            float sum = 0;
            for (int j = 0; j < control.length; j++) {
                if ((i < calificaciones[j]) && ((i + 1) >= calificaciones[j])) {
                    sum += calificaciones[j];
                    count += 1;
                }
            }
            if (count != 0) {
                estadistica[i] = ((float) count / NUM_ALUMNOS);
            } else {
                estadistica[i] = 0;
            }
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <=" + (i + 1) + " = " + sol + "%");
        }
        //Método generarEstadisticas
    }

    public static void generarCalificaciones(int[] control, float[] calificaciones, int[] practicas) {
        //Método generarCalificaciones
        for (int i = 0; i < control.length; i++) {
            calificaciones[i] = (((float) control[i] + (float) practicas[i]) / 2);
        }
        //Método generarCalificaciones
    }

    public static int buscarMayor(int[] control, int maxNota) {
        //Método buscarMayor
        int postEva2 = 0;
        for (int i = 0; i < control.length; i++) {
            int preEval = control[i];
            if (preEval > postEva2) {
                maxNota = preEval;
                postEva2 = control[i];
            }
        }
        return maxNota;
    }

    public static int buscarMenor(int[] control, int minNota) {
        //Método buscarMenor
        int postEval = 11;
        for (int i = 0; i < control.length; i++) {
            int preEval = control[i];
            if (preEval < postEval) {
                minNota = preEval;
                postEval = control[i];
            }
        }
        //Método buscarMenor
        return minNota;
    }

    public static void generarNotas(int[] control) {
        //Método generarNotas
        //Genera notas random entre 1 y 10
        for (int i = 0; i < control.length; i++) {
            control[i] = (int) (Math.random() * 11);
        }
        //Método generarNotas
    }
    
}
