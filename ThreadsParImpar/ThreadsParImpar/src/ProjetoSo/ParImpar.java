package ProjetoSo;

public class ParImpar {
    public static void main(String[] args) {

        // Cria uma instância do recurso => número
        Numero numero = new Numero();
        ProduzNumero produzNumero = new ProduzNumero(numero);
        Thread consumidorPar = new Thread(new ConsumidorPar(numero));
        ConsumidorImpar consumidorImpar = new ConsumidorImpar(numero);

        // Coloca as threads em execução
        produzNumero.start();
        consumidorImpar.start();
        consumidorPar.start();

        while (true);
    }
}
