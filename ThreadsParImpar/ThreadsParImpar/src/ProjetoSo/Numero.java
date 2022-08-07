package ProjetoSo;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Numero {
    private int numero;
    public Semaphore protegeNumero;
    Random random = new Random();

    public Numero() {
        protegeNumero  = new Semaphore(1);
        numero     = random.nextInt(100);
    }
    public int RetornaNumero() {
        return numero;
    }
    public void CriarNumero() {
         numero = random.nextInt(100);
    }

}
