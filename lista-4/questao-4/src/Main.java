public class Main {
    public static void main(String[] args) {
        Lista ex = new Lista();

        ex.insere("Isto");
        ex.insere("é");
        ex.insere("uma");
        ex.insere("frase");
        ex.insere("formada");
        ex.insere("por");
        ex.insere("tokens");
        ex.insere(".");
        System.out.println(ex.obtemFrase());

    }
}
