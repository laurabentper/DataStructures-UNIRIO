public class Main {
    public static void main(String[] args) {
        Lista mista = new Lista();
        ListaOrdenada l1 = new ListaOrdenada();
        ListaOrdenada l2 = new ListaOrdenada();

        l1.insere(7);
        l1.insere(2);
        l1.insere(4);
        l1.insere(11);
        l1.insere(1);

        l2.insere(5);
        l2.insere(3);
        l2.insere(6);
        l2.insere(10);
        l2.insere(8);
        l2.insere(9);

        System.out.println("======Lista 1");
        l1.imprimeRecursivo();
        System.out.println("======Lista 2");
        l2.imprimeRecursivo();

        mista.alternaListas(l1, l2);
        System.out.println("======Lista Mista");
        mista.imprimeRecursivo();

    }
}
