public class ListaCircular extends Lista {
    /* Imprime todos os elementos da lista */
    public void imprime()
    {
        Elo p;
        System.out.println("Elementos da lista");

        p = prim;

        if (p != null)
        {
            do
            {
                System.out.print(p.dado + " ");
                p = p.prox;

            } while (p != prim);
        }

        System.out.println();
    }

    public void imprimeRecursivo()
    {
        System.out.println("Elementos da lista:");

        if(this.vazia())
            return;

        imprimeRecursivo(prim);

        System.out.println();
    }

    private void imprimeRecursivo(Elo p)
    {
        System.out.print(p.dado + " ");

        if(p.prox == prim)
            return;

        imprimeRecursivo(p.prox);
    }

    /* Insere elemento no fim da lista. */
    public void insere(int novo)
    {
        Elo p, q;
        q = new Elo(novo);
        p = prim;

        if (p != null)
        {
            /* Percorre at� alcancar o fim. */
            while (p.prox != prim)
            {
                p = p.prox;
            }

            p.prox = q;
            q.prox = prim;
        }
        else
        {
            prim = q;
            prim.prox = q;
        }
    }

    /* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
    public boolean remove(int elem)
    {
        Elo p = null;
        Elo ant = null;

        if (prim == null) return false;

        for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
            ant = p;

        /* Achou */
        if ( p.dado == elem )
        {
            /* � o primeiro */
            if ( p == prim )
            {
                /* � o �nico */
                if ( prim == prim.prox )
                {
                    prim = null;
                }
                else
                {
                    /* Guarda o anterior ao primeiro */
                    for( ant = prim; ( ant.prox != prim ); ant = ant.prox);

                    ant.prox = prim.prox;
                    prim = prim.prox;
                }
            }
            else
            {
                /* No meio */
                ant.prox = p.prox;
            }

            /* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
             * o Garbage Collector ir� liberar essa mem�ria. */
            p = null;

            return true;
        }
        else
            return false;
    }

    public ListaCircular inverteLista(){
        inverteListaRec(prim);
        return this;
    }

    private Elo inverteListaRec(Elo p){
        if(p.prox == prim) {
            this.prim = p;
            return p;
        }

        Elo pos = inverteListaRec(p.prox);
        pos.prox = p;
        p.prox = prim;
        return p;
    }
    /*Complexidade O(n), pois o metodo percorre ate o final da lista e volta invertendo a direcao dos ponteiros
    recursivamente */
}
