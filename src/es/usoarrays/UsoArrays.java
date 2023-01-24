package es.usoarrays;

import es.usoarrays.OperacionesArrays;

public class UsoArrays extends OperacionesArrays {

    public static final int NUM_ALUMNOS = 40; // Menú -> Refactor -> Introduce -> Constant...
// Menú -> Refactor -> Introduce -> Constant...
    
    public static void main(String[] args) {

        int[] control = new int[NUM_ALUMNOS];
        int[] practicas = new int[NUM_ALUMNOS];
        float[] calificaciones = new float[NUM_ALUMNOS];
        int maxNota = 0;
        int minNota = 0;
        int countAprobados = 0;
        int countSuspensos = 0;
        float[] estadistica = new float[10];

        generarNotas(control);

        minNota = buscarMenor(control, minNota);

        maxNota = buscarMayor(control, maxNota);
        
        generarNotas(practicas);

        generarCalificaciones(control, calificaciones, practicas);

        generarEstadisticas(control, calificaciones, estadistica);

        //Método generarAprobadosSuspensos
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            if (calificaciones[i] < 5) {
                countAprobados += 1;
            } else {
                countSuspensos += 1;
            }
        }
        //Método generarAprobadosSuspensos
        mostrarResultados(minNota, maxNota, control, practicas, calificaciones, countAprobados, countSuspensos);
    }

}
