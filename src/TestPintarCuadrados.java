
public class TestPintarCuadrados {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        mostrarMatriz(obtenerMatrizRandom(9, 9));

    }

    public static int[][] obtenerMatrizRandom(int fila, int columna) {
        int[][] miMatriz = new int[fila][columna];

        for (int i = 0; i < miMatriz.length; i++) {
            for (int j = 0; j < miMatriz[i].length; j++) {
                miMatriz[i][j] = 0;//(int)(Math.random() * 100);
            }
        }
        return miMatriz;
    }

    public static void mostrarMatriz(int[][] unaMatriz) {
        for (int i = 0; i < unaMatriz.length; i++) {
            for (int j = 0; j < unaMatriz[i].length; j++) {

                if (midoDistancia(i, j, 4)) {
                    System.out.print(" " + ANSI_RED + unaMatriz[i][j] + ANSI_RESET + " ");
                } else {
                    System.out.print(" " + unaMatriz[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    public static boolean midoDistancia(int i, int j, int cuadradoAmedir) {
        int diferencia1 = 0;
        int dif3 = 0;

        switch (cuadradoAmedir) {
            case 1:
                diferencia1 = 1;
                dif3 = diferencia1 + 1;
                break;
            case 2:
                diferencia1 = 2;
                dif3 = diferencia1 + 1;
                break;
            case 3:
                diferencia1 = 3;
                dif3 = diferencia1 + 1;
                break;
            case 4://Revisar para este caso en particular, cuando lo que debemos pintar es el cuadrado exterior
                diferencia1 = 4;
                dif3 = diferencia1 + 1;
                break;
            case 5:
                diferencia1 = 5;
                dif3 = diferencia1 + 1;
                break;
            case 6:
                diferencia1 = 6;
                dif3 = diferencia1 + 1;
            default:
                break;
        }

        boolean bandera = false;

        if ((Math.abs((i - 6)) == diferencia1) || (Math.abs((j - 6)) == diferencia1)) {

            if (Math.abs((i - 6)) != dif3 && (Math.abs((j - 6)) != dif3)
                    && Math.abs((i - 6)) != 6 && (Math.abs((j - 6)) != 6)) {
                bandera = true;
            }       
        }
        return bandera;
    }
}
