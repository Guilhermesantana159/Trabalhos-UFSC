package ProjetoSo;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class ConsumidorPar implements Runnable {
    Numero n;

    public ConsumidorPar(Numero n) {
        this.n = n;
    }

    public void run() {

        while (true) {
            // Solicita permissão para acessar o numero
            try {
                n.protegeNumero.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorPar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorPar.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Verifica se o numero é par ou impar
            if (n.RetornaNumero() % 2 == 0)
                System.out.println("Consumidor par executando.... => numero: " + n.RetornaNumero());

            // Libera o acesso ao numero
            n.protegeNumero.release();

        }
    }
}
