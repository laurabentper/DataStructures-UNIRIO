public class Main {
    public static void main(String[] args) {
        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();

        l1.insere(1);
        l1.insere(2);
        l1.insere(3);
        l1.insere(4);
        l1.insere(5);

        l2.insere(1);
        l2.insere(2);
        l2.insere(3);
        l2.insere(4);
        l2.insere(5);

        if(l1.verificaIgualdade(l2))
            System.out.println("Listas iguais.");
        else
            System.out.println("Lista diferentes.");
    }
}
