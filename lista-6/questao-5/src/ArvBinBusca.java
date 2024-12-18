import java.util.NoSuchElementException;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor>  {
    private No raiz; /* Raiz da �rvore. */

    private class No
    {
        private Chave chave; /* Chave usada nas compara��es. */
        private Valor valor; /* Informa��o armazenada. */
        private No esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */

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

    public No get(Chave chave)
    {
        return get(raiz, chave);
    }

    private No get(No x, Chave chave)
    {
        if(chave == null)
            throw new IllegalArgumentException("A chave fornecida eh null!");

        /* A chave n�o se encontra na �rvore. */
        if(x == null)
            return null;

        int cmp = chave.compareTo(x.chave);

        if(cmp < 0) /* Deve-se ir para a esquerda. */
            return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
            return get(x.dir, chave);
        else /* Chave encontrada. */
            return x;
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
        /* Caso base: encontrou a posi��o de inser��o. */
        if (x == null)
            return new No(chave, valor);

        int cmp = chave.compareTo(x.chave);

        if(cmp < 0) /* Deve-se ir para a esquerda. */
            x.esq = put(x.esq, chave, valor);
        else if(cmp > 0) /* Deve-se ir para a direita. */
            x.dir = put(x.dir, chave, valor);
        else /* Caso tenha encontrado n� de mesma chave. */
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
            throw new NoSuchElementException("A �rvore est� vazia!");

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

    public void achaAncestral(Chave c1, Chave c2) {
        No n1 = get(c1); //O(h)
        No n2 = get(c2); //O(h)

        if(n1 == null || n2 == null){
            System.out.println("Chave invalida.");
            return;
        }

        No ancestral = obtemAncestralComum(n1, n2);
        if (ancestral != null) {
            System.out.println("O menor ancestral comum é: " + ancestral.chave);
        } else {
            System.out.println("Não há ancestral comum para os nós dados.");
        }
    }

    //complexidade total O(h), onde h é a altura da arvore binaria (log n ou n, a depender se a arvore esta balanceada
    // ou não), pois no pior caso, onde os dois nós são iguais ou sao folhas de um mesmo nó, o algoritmo percorrera
    // recursivamente da raiz até esse nó.
    public No obtemAncestralComum(No primeiroNo, No segundoNo) {

        return obtemAncestralComumRec(raiz, primeiroNo, segundoNo);

    }

    private No obtemAncestralComumRec(No x, No primeiroNo, No segundoNo) {
        if (x == null) {
            return null;
        }

        if (primeiroNo.chave.compareTo(x.chave) < 0 && segundoNo.chave.compareTo(x.chave) < 0) {
            return obtemAncestralComumRec(x.esq, primeiroNo, segundoNo);
        } else if (primeiroNo.chave.compareTo(x.chave) > 0 && segundoNo.chave.compareTo(x.chave) > 0) {
            return obtemAncestralComumRec(x.dir, primeiroNo, segundoNo);
        } else {
            return x;
        }
    }
}