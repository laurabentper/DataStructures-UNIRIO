public class Main {
    public static void main(String[] args) {
        Lista ex = new Lista();
        ex.insere("Isso");
        ex.insere("é");
        ex.insere("uma");
        ex.insere("lista");
        ex.insere("formada");
        ex.insere("por");
        ex.insere("tokens");
        ex.insere("invertidos");
        ex.insere("!");
        System.out.println(ex.obterFrase());
        System.out.println();
    }
}
