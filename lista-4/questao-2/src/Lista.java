public class Lista {
/*A complexidade do algoritmo que intercala duas listas ordenadas (alternaListas()) é O(n+m), onde n é o número
 de elementos na lista 1 e m é o número de elementos restantes na lista 2.*/

    protected Elo prim;

    protected class Elo
    {
        protected int dado;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(int elem, Elo proxElem)
        {
            dado = elem;
            prox = proxElem;
        }
    }

    public Lista()
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
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
    }

    /* Verifica se um determinado elemento est� na lista. */
    public boolean busca(int elem)
    {
        Elo p;

        for(p = prim; p != null; p = p.prox)
        {
            if(p.dado == elem)
                return true;
        }

        return false;
    }

    /* Implementa��o recursiva do m�todo de busca. */
    public boolean buscaRecursiva(int elem)
    {
        if(this.vazia())
            return false;

        return buscaRecursiva(elem, prim);
    }

    private boolean buscaRecursiva(int elem, Elo p)
    {
        if(p == null)
            return false;

        if(p.dado == elem)
            return true;

        return buscaRecursiva(elem, p.prox);
    }

    /* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
    public boolean remove(int elem)
    {
        Elo p;
        Elo ant = null; /* Refer�ncia para anterior. */

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

    /* Implementa��o recursiva da fun��o de impress�o. */
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
        if(p == null)
            return;

        System.out.print(p.dado + " ");

        imprimeRecursivo(p.prox);
    }

    public void alternaListas(ListaOrdenada l1, ListaOrdenada l2) {

        Elo e1 = l1.prim;
        Elo e2 = l2.prim;
        Elo p = this.prim;

        while (e1 != null && e2 != null) { //complexidade O(n), pois executa ate o fim da menor lista
            if(e1.dado < e2.dado){
                if (this.prim == null){
                    p = new Elo(e1.dado);
                    prim = p;
                } else {
                    p.prox = new Elo(e1.dado);
                    p = p.prox;
                }
                e1 = e1.prox;

            } else if (e2.dado < e1.dado){
                if(this.prim == null){
                    p = new Elo(e2.dado);
                    prim = p;
                } else {
                    p.prox = new Elo(e2.dado);
                    p = p.prox;
                }
                e2 = e2.prox;

            } else {
                if(this.prim == null){
                    p = new Elo(e1.dado);
                    prim = p;
                } else {
                    p.prox = new Elo(e1.dado);
                    p = p.prox;
                }
                e1 = e1.prox;
                e2 = e2.prox;

            }
        }

        while(e1 != null){ //complexidade O(m), executa o resto da lista 1
            if (this.prim == null) {
                p = new Elo(e1.dado);
                prim = p;
            } else {
                p.prox = new Elo(e1.dado);
                p = p.prox;
            }
            e1 = e1.prox;
        }

        while(e2 != null){ //complexidade O(p), executa o resto da lista 2
            if(this.prim == null){
                p = new Elo(e2.dado);
                prim = p;
            } else {
                p.prox = new Elo(e2.dado);
                p = p.prox;
            }
            e2 = e2.prox;
        }
//complexidade total do metodo = O(n+m) ou O(n+p), ou seja: é uma função linear do tipo O(n).
    }
}
