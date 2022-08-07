package ProjetoSo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduzNumero extends Thread{
    Numero n;

    public ProduzNumero(Numero n) {
        this.n = n;
    }

    public void run() {

        while (true) {

            try {
                // Pede permissão para o semáforo para acessar o numero
                n.protegeNumero.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProduzNumero.class.getName()).log(Level.SEVERE, null, ex);
            }

            n.CriarNumero();
            System.out.println("==========================================");
            System.out.println(" Produzindo numero.... => " + n.RetornaNumero());
            System.out.println("==========================================");

            // Libera o semáforo
            n.protegeNumero.release();

            try {
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProduzNumero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
