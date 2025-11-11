import java.util.Hashtable;
import java.util.Map;

public class FibonacciThreads implements Runnable {

    // Tabla de memoización estática para compartir entre hilos
    static Map<Long, Long> memo = new Hashtable<>();
    
    // Inicializamos los casos base que usa el algoritmo
    static {
        memo.put(0L, 1L); // F(0) = 1 (según el código original)
        memo.put(1L, 1L); // F(1) = 1
    }

    long fi;
    int num;

    public FibonacciThreads(int n, long f) {
        num = n;
        fi = f;
    }

    @Override
    public void run() {
        IO.println("Starte #" + num);
        long res = fibonacci(fi);
        System.out.println("Abschlussverfahren: " + num +
                " - " + "fibonacci(" + fi + ") =" + res);
    }

    // --- FUNCIÓN MODIFICADA CON MEMORIA ---
    long fibonacci(long f) {
        // 1. Revisar si ya está en la memoria
        if (memo.containsKey(f)) {
            return memo.get(f);
        }
        
        // 2. Si no está, calcularlo recursivamente
        long res = fibonacci(f - 1) + fibonacci(f - 2);
        
        // 3. Guardar el resultado antes de devolverlo
        memo.put(f, res);
        
        return res;
    }

    static void main() {
        Thread[] threads = new Thread[10];

        // Aumentamos el rango para probar la eficiencia (ej. hasta 90)
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new FibonacciThreads(i,
                    (long) (Math.random() * 90) + 1)); // Ahora puede calcular n > 50
        }

        for (int i = 0; i < 10; i++) threads[i].start();
    }
}