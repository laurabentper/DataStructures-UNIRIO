import java.util.NoSuchElementException;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor> {

    private No raiz; /* Raiz da �rvore. */

    private class No
    {
        private Chave chave;
        private Valor valor;
        private No esq, dir;

        /* Cria um n� com chave e valor fornecidos e esq = dir = null. */
        public No(Chave chave, Valor valor)
        {
            this.chave = chave;
            this.valor = valor;
            this.esq = null;
            this.dir = null;
        }

    }

    public ArvBinBusca()
    {
        raiz = null;
    }

    public boolean vazia()
    {
        return (raiz == null);
    }

    public void mostra()
    {
        mostra(raiz);
    }

    private void mostra(No x)
    {
        /* Caso base (crit�rio de parada). */
        if(x == null)
            return;

        System.out.print("[");

        /* Chamada recursiva para a esquerda. */
        mostra(x.esq);

        /* Imprime a chave do n� corrente. */
        System.out.print("<" + x.chave + ">");

        /* Chamada recursiva para a direita. */
        mostra(x.dir);

        System.out.print("]");
    }

    public Chave min()
    {
        if(vazia())
            throw new NoSuchElementException("�rvore est� vazia!");

        return min(raiz).chave;
    }

    private No min(No x) {
        if (x.esq == null)
            return x;
        else
            return min(x.esq);
    }

    public Chave max() {
        if(vazia())
            throw new NoSuchElementException("A �rvore est� vazia!");

        return max(raiz).chave;
    }

    private No max(No x) {
        if (x.dir == null)
            return x;
        else
            return max(x.dir);
    }

    public int tamanho()
    {
        return tamanho(raiz);
    }

    private int tamanho(No x)
    {
        /* Caso base (crit�rio de parada). */
        if(x == null)
            return 0;

        /* Chamada recursiva para sub�rvores esquerda e direita. */
        return 1 + tamanho(x.esq) + tamanho(x.dir);
    }

    public int altura()
    {
        return altura(raiz);
    }

    private int altura(No x)
    {
        if(x == null)
            return -1;

        int maxAltura = Math.max(altura(x.esq), altura(x.dir));

        return 1 + maxAltura;
    }

    public boolean contem(Chave chave) {
        if (chave == null)
            throw new IllegalArgumentException("A chave fornecida � null!");

        return get(chave) != null;
    }

    public Valor get(Chave chave)
    {
        return get(raiz, chave);
    }

    private Valor get(No x, Chave chave)
    {
        if(chave == null)
            throw new IllegalArgumentException("A chave fornecida � null!");

        /* A chave n�o se encontra na �rvore. */
        if(x == null)
            return null;

        int cmp = chave.compareTo(x.chave);

        if(cmp < 0) /* Deve-se ir para a esquerda. */
            return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
            return get(x.dir, chave);
        else /* Chave encontrada. */
            return x.valor;
    }

    public void put(Chave chave, Valor valor)
    {
        if(chave == null)
            throw new IllegalArgumentException("A chave fornecida � null!");

        if(valor == null) {
            delete(chave);
            return;
        }

        raiz = put(raiz, chave, valor);
    }

    private No put(No x, Chave chave, Valor valor)
    {
        if (x == null)
            return new No(chave, valor);

        int cmp = chave.compareTo(x.chave);

        if(cmp < 0)
            x.esq = put(x.esq, chave, valor);
        else if(cmp > 0)
            x.dir = put(x.dir, chave, valor);
        else
            x.valor = valor;

        return x;
    }

    public void deleteMin()
    {
        if(vazia())
            throw new NoSuchElementException("A �rvore est� vazia!");

        raiz = deleteMin(raiz);
    }

    private No deleteMin(No x)
    {
        /* Caso n�o haja filho � esquerda, o n� corrente possui a menor chave. */
        if(x.esq == null)
            return x.dir;

        x.esq = deleteMin(x.esq);

        return x;
    }

    public void deleteMax()
    {
        if(vazia())
            throw new NoSuchElementException("A Arvore esta vazia!");

        raiz = deleteMax(raiz);
    }

    private No deleteMax(No x)
    {
        if(x.dir == null)
            return x.esq;

        x.dir = deleteMax(x.dir);

        return x;
    }

    public void delete(Chave chave)
    {
        raiz = delete(raiz, chave);
    }

    private No delete(No x, Chave chave)
    {
        if (x == null)
            return null;

        int cmp = chave.compareTo(x.chave);

        if(cmp < 0)
            x.esq = delete(x.esq, chave);
        else if(cmp > 0)
            x.dir = delete(x.dir, chave);
        else
        {
            if(x.dir == null)
                return x.esq;
            if(x.esq  == null)
                return x.dir;

            No t = x;

            /* Pega o menor da sub�rvore direita (mais � esquerda). */
            x = min(t.dir);

            /* Remove o menor. */
            x.dir = deleteMin(t.dir);

            /* A sub�rvore esquerda se mant�m a mesma. */
            x.esq = t.esq;
        }

        return x;
    }

    public Chave piso(Chave chave)
    {
        if (chave == null)
            throw new IllegalArgumentException("A chave fornecida � null!");

        if (vazia())
            throw new NoSuchElementException("A �rvore est� vazia!");

        No x = piso(raiz, chave);

        if (x == null)
            return null;
        else
            return x.chave;
    }

    private No piso(No x, Chave chave)
    {
        if (x == null)
            return null;

        int cmp = chave.compareTo(x.chave);

        if (cmp == 0)
            return x;

        if (cmp <  0)
            return piso(x.esq, chave);

        No t = piso(x.dir, chave);

        if (t != null)
            return t;
        else
            return x;
    }

    public Chave topo(Chave chave)
    {
        if (chave == null)
            throw new IllegalArgumentException("A chave fornecida � null!");

        if (vazia())
            throw new NoSuchElementException("A �rvore est� vazia!");

        No x = topo(raiz, chave);

        if (x == null)
            return null;
        else
            return x.chave;
    }

    private No topo(No x, Chave chave)
    {
        if (x == null)
            return null;

        int cmp = chave.compareTo(x.chave);

        if (cmp == 0)
            return x;

        if (cmp < 0)
        {
            No t = topo(x.esq, chave);

            if (t != null)
                return t;
            else
                return x;
        }

        return topo(x.dir, chave);
    }

    //A complexidade do metodo eh O(n*h), com h dependendo da ordem dos elementos do vetor. Caso o vetor esteja ordenado
    // e forme uma arvore em formato de cadeia linear, a complexidade total do metodo sera O(n^2). Porém, caso o vetor
    // esteja desordenado e forme uma arvore relativamente balanceada, a complexidade total do metodo sera proxima de O(n log n).
    public void constroiArvore(int[] vetor){
        for (Integer valor : vetor){ //O(n)
            put((Chave) valor, (Valor) valor); //O(h).
        }
    }
}

