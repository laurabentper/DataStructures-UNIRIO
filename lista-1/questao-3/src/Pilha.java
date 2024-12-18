public class Pilha {

    private int n;
    private char vetor[];
    private int topoEsq, topoDir;

    public Pilha()
    {
        n = 10;
        vetor = new char[n];
        topoEsq = -1;
        topoDir = n;
    }

    public Pilha(int tamanho)
    {
        n = tamanho;
        vetor = new char[tamanho];
        topoEsq = -1;
        topoDir = tamanho;
    }

    public boolean vaziaEsq()
    {
        return topoEsq == -1 ? true : false;
    }

    public boolean vaziaDir()
    {
        return topoDir == n ? true : false;
    }

    public boolean cheia() {
        return topoEsq + 1 == topoDir;
    }

    public char popEsq() {
        char c = '\0';

        if (!this.vaziaEsq())
        {
            c = vetor[topoEsq];

            //Decrementando o topo, o elemento � "removido"
            topoEsq--;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop nao funcionou.");
        }

        return c;
    }

    public char popDir() {
        char c = '\0';

        if (!this.vaziaDir())
        {
            c = vetor[topoDir];
            topoDir++;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop nao funcionou.");
        }

        return c;
    }

    public boolean pushEsq(char elemento)
    {
        if (!this.cheia())
        {
            vetor[++topoEsq] = elemento;
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public boolean pushDir(char elemento)
    {
        if (!this.cheia())
        {
            vetor[--topoDir] = elemento;
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public char retornaTopoEsq()
    {
        char elemento = '\0';

        if(!this.vaziaEsq())
        {
            elemento = vetor[topoEsq];
        }
        else
        {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public char retornaTopoDir()
    {
        char elemento = '\0';

        if(!this.vaziaDir())
        {
            elemento = vetor[topoDir];
        }
        else
        {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public void printEsq() {
        if (vaziaEsq()) {
            System.out.println("A pilha 1 está vazia.");
            return;
        }

        for (int i = 0; i <= this.topoEsq; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public void printDir() {
        if (vaziaDir()) {
            System.out.println("A pilha 2 está vazia.");
            return;
        }

        for (int i = n - 1; i >= topoDir; i--) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

}
