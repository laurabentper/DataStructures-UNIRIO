public class Lista {

/* A complexidade do metodo tamanho() originalmente é O(n), pois percorre uma vez todas as posições da lista.
   É possível melhorar sua complexidade criando um atributo tam que contabiliza toda vez que um objeto é adicionado
   ou excluído da lista. Assim, o metodo realizara apenas uma operacao elemental, alcançando a complexidade O(1).
 */

    protected int tam;
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
        tam++;
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
        tam--;
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

    public int tamanho() // // Complexidade O(1), pois realiza apenas uma operação elemental.
    {
        return tam;
    }

}
