package ProjetoSo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumidorImpar extends Thread {
    Numero n;

    public ConsumidorImpar(Numero n) {
        this.n = n;
    }

    public void run() {

        while (true) {

            try {
                // Verifica se o numero está disponível
                n.protegeNumero.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorImpar.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorImpar.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Verifica se o numero é par ou impar
            if (n.RetornaNumero() % 2 != 0)
                System.out.println("Consumidor impar executando => numero: " + n.RetornaNumero());

            // Libera o semáforo
            n.protegeNumero.release();
        }
    }
}
