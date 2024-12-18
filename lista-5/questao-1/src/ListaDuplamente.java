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

    /* M�todo auxiliar para busca. */
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

    public static ListaDuplamente intersecao(ListaDuplamente l1, ListaDuplamente l2){
        ListaDuplamente retorno = new ListaDuplamente();

        for(Elo p1 = l1.prim; p1 != null; p1 = p1.prox){
            for(Elo p2 = l2.prim; p2 != null; p2 = p2.prox){
                if(p1.dado == p2.dado){
                    retorno.insere(p1.dado);
                    break;
                }
            }
        }

        return retorno;
    }
}
