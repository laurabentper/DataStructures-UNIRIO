public class Lista<T>{


    protected Elo<T> prim;

    protected class Elo<T> {

        protected T dado;
        protected Elo<T> prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo<T> proxElem)
        {
            dado = elem;
            prox = proxElem;
        }
    }

    public Lista()
    {
        prim = null;
    }

    public boolean vazia()
    {
        return prim == null;
    }

    public void insere(T novo)
    {
        Elo<T> p = new Elo<>(novo);
        p.prox = prim;
        prim = p;
    }

    public boolean busca(T elem)
    {
        Elo<T> p;

        for(p = prim; p != null; p = p.prox)
        {
            if(p.dado == elem)
                return true;
        }

        return false;
    }

    public boolean remove(T elem)
    {
        Elo<T> p;
        Elo<T> ant = null; /* Refer�ncia para anterior. */

        for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;

        /* Se p � null, ent�o n�o encontrou elemento. */
        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do in�cio. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */

        /* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
         * o Garbage Collector ir� liberar essa mem�ria. */
        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime()
    {
        Elo<T> p;

        System.out.println("Elementos da lista:");

        for(p = prim; p != null; p = p.prox)
        {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

}
