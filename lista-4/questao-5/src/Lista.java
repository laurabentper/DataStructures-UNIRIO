public class Lista {

    protected Elo prim;

    protected class EloChar
    {
        protected char c;
        protected EloChar prox;

        public EloChar(char c){
            this.c = c;
            this.prox = null;
        }
    }

    protected class Elo
    {
        protected String token;
        protected EloChar primeiroChar;
        protected Elo prox;

        public Elo(String elem)
        {
            token = elem;
            primeiroChar = null;
            prox = null;
        }

        public void insereChar(char c){
            EloChar novo = new EloChar(c);
            novo.prox = primeiroChar;
            primeiroChar = novo;
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

    public void insere(String novo) //complexidade O(n), pois o for irá percorrer todas as letras da palavra inserida
    {
        Elo p = new Elo(novo);
        EloChar s;
        for(int i=0; i<novo.length(); i++){
            s = new EloChar(novo.charAt(i));
            s.prox = p.primeiroChar;
            p.primeiroChar = s;
        }
        p.prox = prim;
        prim = p;
    }

    public boolean remove(String elem) //complexidade O(n), pois no pior caso o for irá percorrer todos os elos da
    // lista em busca do elemento desejado
    {
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (!p.token.equals(elem))); p = p.prox)
            ant = p;

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        return true;
    }

    public String obterFrase() {
        StringBuilder frase = new StringBuilder();
        Elo atual = prim;

        while (atual != null) { //complexidade O(n)
            if(atual.token.equals("!") || atual.token.equals("?") || atual.token.equals(".") || atual.token.equals(",")){
                frase.append(atual.token);
                atual = atual.prox;
            } else {
                EloChar atualCaractere = atual.primeiroChar;
                while (atualCaractere != null) { //complexidade O(m)
                    frase.append(atualCaractere.c);
                    atualCaractere = atualCaractere.prox;
                }
                frase.append(" ");
                atual = atual.prox;
            }
        }
        return frase.toString().trim();
    } /*A complexidade do metodo obterFrase() é O(n*m), onde n é o numero total de tokens na lista e m é o numero de
     caracteres de cada token. Logo, a função é O(n^2)*/
}
