public class Pilha {
    private int n;
    private int vetor[];
    private int topo;
    private int contadorPares;

    public Pilha()
    {
        n = 10;
        vetor = new int[n];
        topo = -1;
        contadorPares = 0;
    }

    public Pilha(int tamanho)
    {
        n = tamanho;
        vetor = new int[tamanho];
        topo = -1;
        contadorPares = 0;
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
            if(c%2==0){
                contadorPares--;
            }
            topo--;
        }
        else
        {
            System.out.println("Pilha vazia: pop n�o funcionou.");
        }

        return c;
    }

    public boolean push(int elemento)
    {
        if (!this.cheia())
        {
            vetor[++topo] = elemento;
            if(elemento%2==0){
                contadorPares++;
            }
            return true;
        }
        else
        {
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public int qtdPares(){
        return contadorPares;
    }
}

