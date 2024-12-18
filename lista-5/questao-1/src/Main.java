public class Main {
    public static void main(String[] args) {

        ListaDuplamente l1 = new ListaDuplamente();
        ListaDuplamente l2 = new ListaDuplamente();

        l1.insere(9);
        l1.insere(8);
        l1.insere(5);
        l1.insere(6);
        l1.insere(1);
        l1.insere(3);

        l2.insere(5);
        l2.insere(2);
        l2.insere(9);
        l2.insere(3);
        l2.insere(4);
        l2.insere(7);
        l2.insere(8);

        System.out.println("===========L1");
        l1.imprime();
        System.out.println("===========L2");
        l2.imprime();

        System.out.println("===========Intersecao");
        ListaDuplamente.intersecao(l1, l2).imprime();

        /*Complexidade O(n*m), onde n e m sao os numeros de elementos nas listas l1 e l2*/
    }
}
