public class Main {
    public static void main(String[] args) {
       ListaOrdenada<String> listaNomes = new ListaOrdenada<>();

       listaNomes.insere("Laura");
       listaNomes.insere("Amanda");
       listaNomes.insere("Carlos");
       listaNomes.insere("Julia");
       listaNomes.insere("Marcelo");

       listaNomes.imprime();
    }
}
