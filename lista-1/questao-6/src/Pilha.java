public class Pilha {

    private int n;
    private char vetor[];
    private int topo;

    public Pilha()
    {
        n = 10;
        vetor = new char[n];
        topo = -1;
    }

    public Pilha(int tamanho)
    {
        n = tamanho;
        vetor = new char[tamanho];
        topo = -1;
    }

    public boolean vazia()
    {
        return topo == -1 ? true : false;
    }

    public boolean cheia()
    {
        return topo == n - 1 ? true : false;
    }

    public char pop()
    {
        char c = '\0';

        if (!this.vazia())
        {
            c = vetor[topo];

            //Decrementando o topo, o elemento � "removido"
            topo--;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop n�o funcionou.");
        }

        return c;
    }

    public boolean push(char elemento)
    {
        if (!this.cheia())
        {
            vetor[++topo] = elemento;
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public char retornaTopo()
    {
        char elemento = '\0';

        if(!this.vazia())
        {
            elemento = vetor[topo];
        }
        else
        {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public String inverteFrase(String frase){
        char c;
        String invertida = "";

        for(int i = 0; i < frase.length(); i++){
            c = frase.charAt(i);
            if (c != ' ') push(c);
            else {
                while(!vazia()){
                    invertida += pop();
                }
                invertida += c;
            }
        }

        while(!vazia()){
            invertida += pop();
        }

        return invertida;
    }

}
