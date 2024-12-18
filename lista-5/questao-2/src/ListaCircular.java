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

    public ListaCircular merge(ListaCircular lista2){

        ListaCircular mista = new ListaCircular();
        Elo p1 = this.prim;
        Elo p2 = lista2.prim;

        if(this.vazia() && lista2.vazia())
            return  mista;

        if(this.vazia()){

            do{
               mista.insere(p2.dado);
               p2 = p2.prox;
            } while (p2 != lista2.prim);

        } else if(lista2.vazia()){

            do{
                mista.insere(p1.dado);
                p1 = p1.prox;
            } while (p1 != this.prim);

        } else {

            do{
                mista.insere(p1.dado);
                mista.insere(p2.dado);
                p1 = p1.prox;
                p2 = p2.prox;
            } while (p1 != this.prim && p2 != lista2.prim);

            while(p1 != this.prim){
                mista.insere(p1.dado);
                p1 = p1.prox;
            }

            while(p2 != lista2.prim){
                mista.insere(p2.dado);
                p2 = p2.prox;
            }
        }

        return mista;
    }

}
