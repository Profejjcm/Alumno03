public class Arrays {

    public static void main(String[] args) {

        int[] control = new int[40];
        int[] practicas = new int[40];
        float[] calificaciones = new float[40];
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
        for (int i = 0; i < 40; i++) {
            if (calificaciones[i] < 5) {
                countAprobados += 1;
            } else {
                countSuspensos += 1;
            }
        }
        //Método generarAprobadosSuspensos
        mostrarResultados(minNota, maxNota, control, practicas, calificaciones, countAprobados, countSuspensos);
    }

    public static void mostrarResultados(int minNota, int maxNota, int[] control, int[] practicas, float[] calificaciones, int countAprobados, int countSuspensos) {
        //Método mostrarResultados
        System.out.println("La nota mínima es  : " + minNota);
        System.out.println("La nota máxima es  : " + maxNota);
        System.out.println("Array de Notas     :" + Arrays.toString(control));
        System.out.println("Prácticas          :" + Arrays.toString(practicas));
        System.out.println("Calificaciones     :" + Arrays.toString(calificaciones));
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
                estadistica[i] = ((float) count / 40);
            } else {
                estadistica[i] = 0;
            }
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <="
                    + (i + 1) + " = "
                    + sol + "%");
        }
        //Método generarEstadisticas   
    }

    public static void generarCalificaciones(int[] control, float[] calificaciones, int[] practicas) {
        //Método generarCalificaciones
        for (int i = 0; i < control.length; i++) {
            calificaciones[i]
                    = (((float) control[i]
                    + (float) practicas[i])
                    / 2);
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
