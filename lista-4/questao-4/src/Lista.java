public class Lista {
    protected Elo prim;

    protected class Elo
    {
        protected String token;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(String elem)
        {
            token = elem;
            prox = null;
        }

        public Elo(String elem, Elo proxElem)
        {
            token = elem;
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

    public void insere(String novo) {/*A complexidade do metodo  é O(n), pois no caso da lista nao estar vazia, o
    while ira percorrer-la até o final para inserir o elemento na ultima posição.*/

        Elo p = new Elo(novo);
        if(prim == null){
            prim = p;
        } else {
            Elo atual = prim;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            atual.prox = p;
        }
    }

    public boolean busca (String elem){ //complexidade O(n)
        Elo p;

        for(p = prim; p != null; p = p.prox)
        {
            if(p.token.equals(elem))
                return true;
        }

        return false;
    }

    public boolean remove(String elem) { /*A complexidade do metodo é O(n), pois no pior caso o while
    ira percorrer a lista até o final para achar o elemento que deve ser removido*/
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (!p.token.equals(elem))); p = p.prox)
            ant = p;

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do in�cio. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */

        p = null;

        return true;
    }

    public String obtemFrase() {
        StringBuilder frase = new StringBuilder();
        Elo p = prim;

        while (p != null) { //complexidae O(n)
            if(p.token.equals("!") || p.token.equals("?") || p.token.equals(".") || p.token.equals(",")){
                frase.deleteCharAt(frase.length()-1);
            }
            frase.append(p.token).append(" ");
            p = p.prox;
        }
        return frase.toString().trim();
    } /*A complexidade do metodo obterFrase é O(n), onde n é o numero de elementos na lista encadeada.
       Isso ocorre pois a iteração da lista tem complexidade O(n) e as outras operaçãoes tem complexidade O(1),
       logo a complexidade dominante é O(n)*/

}
