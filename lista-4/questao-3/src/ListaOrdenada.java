public class ListaOrdenada<T extends Comparable<T>> extends Lista<T>{

    @Override
    public void insere(T novo) {
        Elo<T> p, q;
        Elo<T> ant = null;

        q = new Elo<T>(novo);

        for (p = prim; ((p != null) && (p.dado.compareTo(novo) < 0)); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
    } /*A complexidade do metodo insere(T novo) é O(n), onde n é o número de elementos na lista antes da chamada do metodo.
       As operações tem complexidade O(1) e o for tem complexidade O(n), logo O(n) é a complexidade dominante no metodo.*/

    @Override
    public boolean remove(T elem)
    {
        Elo<T> p;
        Elo<T> ant = null;

        for(p = prim; ((p != null) && (p.dado.compareTo(elem) < 0)); p = p.prox)
            ant = p;

        if ((p == null) || (!p.dado.equals(elem)))
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        return true;
    } /*A complexidade do metodo remove(T elem) é O(n), onde n é o número de elementos na lista encadeada.
       As operações antes e dentro do for tem complexidade O(1) e o for, que possui a complexidade dominante,
       no pior caso percorre a lista inteira uma vez, logo sua complexidade é O(n).*/
}
