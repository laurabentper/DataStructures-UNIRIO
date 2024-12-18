public class ListaDuplamente {

    protected Chamada prim;

    protected class Chamada
    {
        protected int id;
        protected double custo;
        protected Chamada ant;
        protected Chamada prox;

        public Chamada(int id, double custo)
        {
            this.id = id;
            this.custo = custo;
            ant = null;
            prox = null;
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

    public void insere(int id, double custo)
    {
        Chamada p = new Chamada(id,custo);
        Chamada q, ant = null;

        for (q = prim; q != null; q = q.prox) { // O(n)
            if (p.custo > q.custo)
                break;
            ant = q;
        }

        p.prox = q;
        p.ant = ant;

        if(ant == null)
            prim = p;
        else
            ant.prox = p;

        if(q != null)
            p.prox.ant = p;

        p = null;
        ant = null;
        q = null;
    } /*Complexidade O(n), pois no pior caso (elemento inserido no final da lista) o algoritmo precisara percorrer
    a lista ate o final*/

    private Chamada busca(int id)
    {
        Chamada p;

        for(p = prim; ((p != null) && (p.id != id)); p = p.prox);

        return p;
    }

    public boolean remove(int id)
    {
        Chamada p = busca(id);

        if (p == null)
            return false;

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

    public void imprime()
    {
        Chamada p;

        System.out.println("Chamadas na lista:");

        for(p = prim; p != null; p = p.prox)
        {
            System.out.print("[ID: " + p.id + ", Custo: " + p.custo + "] ");
        }
        System.out.println();
    } // complexidade O(n).
}
