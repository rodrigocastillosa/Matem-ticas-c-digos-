/**
 * Título: Temporizador Funcional en Java
 * Descripción: Demuestra el paso de una función (comportamiento) como parámetro
 * en Java, usando una interfaz funcional (Runnable) y una
 * referencia a método (::).
 *
 * Curso: MCA 1 2026-1 FCiencias (Ejemplo adaptado de Scala)
 * Tema: Paso de una función como parámetro / Programación Funcional en Java
 *
 * Castillo Sandoval Rodrigo de Jesús
 * Fecha: 4 Nov 2025
 */
public class TemporizadorJava {

    public static void unaVezPorSegundo(Runnable fcallback) throws InterruptedException {

        int n = 0;
        boolean continueLoop = true; // Se usa 'continueLoop' porque 'continue' es palabra reservada en Java

        while (continueLoop) {
            // 1. Ejecutamos el comportamiento (función) que nos pasaron
            fcallback.run();

            // 2. Dormimos el hilo por 1000 milisegundos (1 segundo)
            //    En Java, 'Thread.sleep' puede lanzar una excepción, por eso se maneja.
            Thread.sleep(1000);

            // 3. Verificamos la condición de salida
            if (n == 6) {
                continueLoop = false;
            }
            n++; // n = n + 1;
        }
    }

    public static void tiempoVuela() {
        System.out.println("The time fly and never comeback...");
    }


    public static void main(String[] args) {

        System.out.println("Iniciando el temporizador funcional en Java...");

        try {

            unaVezPorSegundo(TemporizadorJava::tiempoVuela);

        } catch (InterruptedException e) {

            System.err.println("El temporizador fue interrumpido.");

        }

        System.out.println("Temporizador finalizado.");
    }
}