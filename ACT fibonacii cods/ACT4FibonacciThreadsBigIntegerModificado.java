import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Map;

public class FibonacciThreadsBigInteger implements Runnable {

    // Tabla de memoización estática para BigInteger
    static Map<BigInteger, BigInteger> memo = new Hashtable<>();
    
    // Casos base
    static final BigInteger DOS = BigInteger.TWO;
    static {
        memo.put(BigInteger.ZERO, BigInteger.ONE); // F(0) = 1
        memo.put(BigInteger.ONE, BigInteger.ONE);  // F(1) = 1
    }

    BigInteger fi;
    int num;

    public FibonacciThreadsBigInteger(int n, BigInteger f) {
        num = n;
        fi = f;
    }

    @Override
    public void run() {
        IO.println("Starte #" + num);
        BigInteger res = fibonacci(fi);
        System.out.println("Abschlussverfahren: " + num +
                " - " + "fibonacci(" + fi + ") =" + res);
    }

    // --- FUNCIÓN MODIFICADA CON MEMORIA ---
    public BigInteger fibonacci(BigInteger f) {
        // 1. Revisar si ya está en la memoria
        if (memo.containsKey(f)) {
            return memo.get(f);
        }
        
        // 2. Si no está, calcularlo (f-1) y (f-2)
        BigInteger f_menos_1 = f.subtract(BigInteger.ONE);
        BigInteger f_menos_2 = f.subtract(DOS);
        
        BigInteger res = fibonacci(f_menos_1).add(fibonacci(f_menos_2));
        
        // 3. Guardar el resultado en memoria
        memo.put(f, res);
        
        return res;
    }

    static void main() {
        Thread[] threads = new Thread[10];

        // Aumentamos el rango (ej. hasta 500)
        for (int i = 0; i < 10; i++) {
            long algo = (long) (Math.random() * 500) + 1; // Ahora puede calcular n > 50
            threads[i] = new Thread(
                    new FibonacciThreadsBigInteger(i, BigInteger.valueOf(algo)));
        }
        for (int i = 0; i < 10; i++) threads[i].start();
    }
}