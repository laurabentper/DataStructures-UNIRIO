public class Main {
    public static void main(String[] args) {

        ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();
        int[] vetor = {5, 6, 2, 4, 3, 7, 12, 9, 10, 8, 1};
        arvore.constroiArvore(vetor);
        arvore.mostra();
    }
}
