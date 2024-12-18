public class Main {
    public static void main(String[] args) {

        Fila fila = new Fila(5);

        fila.insere(1);
        fila.insere(2);
        fila.insere(3);
        fila.insere(4);
        fila.insere(5);

        System.out.println("Fila Simples: ");
        fila.imprime();
        System.out.println();

        System.out.println("Fila Dupla: ");
        FilaDupla filaDupla = Fila.retornaFilaDupla(fila);
        filaDupla.imprime();
    }
}
