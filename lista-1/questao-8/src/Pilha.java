public class Pilha {

    private int n;
    private int vetor[];
    private int topo;

    public Pilha()
    {
        n = 20;
        vetor = new int[n];
        topo = -1;
    }

    public Pilha(int tamanho)
    {
        n = tamanho;
        vetor = new int[tamanho];
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

    public int pop()
    {
        int c = Integer.MIN_VALUE;

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

    public boolean push(int elemento)
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

    public int retornaTopo()
    {
        int elemento = Integer.MIN_VALUE;

        if(!this.vazia())
        {
            elemento = vetor[topo];
        }

        return elemento;
    }





}
