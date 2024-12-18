public class Main {
    public static void main(String[] args) {
        Lista<String> diretorio = new Lista<>();

        diretorio.insereDiretorio("Jogos");
        diretorio.insere("Campo Minado","Jogos");
        diretorio.insere("Paciência","Jogos");
        diretorio.insere("World of Warcraft","Jogos");

        diretorio.insereDiretorio("Faculdade");
        diretorio.insere("EDD1","Faculdade");
        diretorio.insere("EDD2","Faculdade");
        diretorio.insere("AA","Faculdade");
        diretorio.insere("ACEs","Faculdade");
        diretorio.insere("ACE1","ACEs");
        diretorio.insere("ACE2","ACEs");
        diretorio.insere("ACE3","ACEs");
        diretorio.insere("TPD","Faculdade");

        diretorio.insereDiretorio("Filmes");
        diretorio.insere("Super-heróicos","Filmes");
        diretorio.insere("Marvel","Super-heróicos");
        diretorio.insere("Vingadores","Marvel");
        diretorio.insere("Homem-Aranha","Marvel");
        diretorio.insere("DC","Super-heróicos");
        diretorio.insere("Superman","DC");
        diretorio.insere("Drama","Filmes");
        diretorio.insere("Brilho Eterno de Uma Mente Sem Lembranças","Drama");
        diretorio.insere("Comédias Românticas","Filmes");
        diretorio.insere("(Pasta Vazia)","Comédias Românticas");

        System.out.println(diretorio);

        /*Os métodos utilizados possuem complexidade O(n).*/
    }
}
