public class ListaDuplamente {

    protected Elo prim;

    protected class Elo
    {
        protected int dado;
        protected Elo ant;
        protected Elo prox;

        public Elo()
        {
            ant = null;
            prox = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, Elo antElem, Elo proxElem)
        {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public ListaDuplamente()
    {
        prim = null;
    }

    /* Testa se a lista est� vazia. */
    public boolean vazia()
    {
        return prim == null;
    }

    /* Insere elemento no in�cio da lista. */
    public void insere(int novo)
    {
        Elo p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
    }

    /* Metodo auxiliar para busca. */
    private Elo busca(int elem)
    {
        Elo p = null;

        for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

        return p;
    }

    /* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
    public boolean remove(int elem)
    {
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        /* Retira primeiro elemento */
        if (p == prim)
            prim = prim.prox;
        else
            /* Retira elemento do meio */
            p.ant.prox = p.prox;

        /* Testa se � ultimo elemento */
        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime()
    {
        Elo p;

        System.out.println("Elementos da lista:");

        for(p = prim; p != null; p = p.prox)
        {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Imprime todos os elementos da lista em ordem reversa. */
    public void imprimeReversa()
    {
        Elo p;
        Elo ult = null;

        System.out.println("Elementos da lista em ordem reversa:");

        p = prim;

        while(p != null)
        {
            ult = p;
            p = p.prox;
        }

        for(p = ult; p != null; p = p.ant)
        {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    public void trocaElos(int indiceElo1, int indiceElo2){
        Elo e1 = null, e2 = null;
        int indice = 1;

        for(Elo p = prim; p != null; p = p.prox){

            if(indice == indiceElo1)
                e1 = p;
            else if (indice == indiceElo2)
                e2 = p;

            if(e1 != null && e2 != null)
                break;

            indice++;
        }

        if (e1 == null || e2 == null) {
            System.out.println("Indice invalido. Nao foi possivel realizar a troca.");
            return;
        } else {
            if (e1.ant != null) {
                e1.ant.prox = e2;
            } else {
                prim = e2;
            }

            if (e2.ant != null) {
                e2.ant.prox = e1;
            } else {
                prim = e1;
            }

            Elo auxAnt = e1.ant;
            e1.ant = e2.ant;
            e2.ant = auxAnt;

            Elo auxProx = e1.prox;
            e1.prox = e2.prox;
            e2.prox = auxProx;

        }
    } /* A complexidade do metodo é O(n), pois alem das operaçoes de tempo constante o algoritmo possui apenas
    um loop 'for' que percorre todos os elementos ate encontrar o indice especificado (no pior caso percorrera
    todos os elementos da lista) */
}

