public class Lista<T extends Comparable<T>> {

    protected Elo<T> prim;

    protected static class Elo<T extends Comparable<T>> implements Comparable<Elo<T>> {
        protected T dado;

        protected Elo<T> prox;
        protected Elo<T> diretorio;
        protected Elo<T> subPasta;
        protected Elo<T> primSub;

        public Elo() { prox = null;}

        public Elo(T elem) {
            dado = elem;
            prox = null;
            subPasta = null;
            diretorio = null;
            primSub = null;
        }

        public Elo(T elem, Elo<T> pasta) {
            dado = elem;
            prox = null;
            subPasta = null;
            diretorio = pasta;
            primSub = null;
        }

        public int compareTo(Elo<T> elo) {
            return elo.dado.compareTo(dado);
        }
    }

    public Lista() {
        prim = null;
    }

    public boolean vazia() {
        return prim == null;
    }

    public void insereDiretorio(T novo) {
        Elo<T> p = new Elo<>(novo);
        p.prox = prim;
        prim = p;
    }

    public void insere(T novo, T diretorio) {
        Elo<T> q = buscaRecursiva(diretorio);
        if (q != null) {
            Elo<T> p = new Elo<>(novo, q);
            p.diretorio.subPasta = p;
            p.prox = p.diretorio.primSub;
            p.diretorio.primSub = p;
        } else
            System.out.println("Pasta nao existe");
    }

    public Elo<T> buscaRecursiva(T elem) {
        if (this.vazia())
            return null;
        return buscaRecursiva(elem, prim, false);
    }

    private Elo<T> buscaRecursiva(T elem, Elo<T> p, boolean falso) {
        if (p == null)
            return null;
        if (p.dado.equals(elem))
            return p;
        if (p.subPasta != null && !falso)
            p = p.subPasta;
        else if (p.prox == null && p.diretorio != null && p.diretorio.prox != null) {
            p = p.diretorio.prox;
            falso = false;
        } else if (p.prox == null && p.diretorio != null) {
            p = p.diretorio;
            falso = true;
        } else if (p.prox != null)
            p = p.prox;
        else
            p = null;
        return buscaRecursiva(elem, p, falso);
    }

    private String imprime(Elo<T> p, int espaco, boolean falso) {
        StringBuilder sb = new StringBuilder();

        if (p == null)
            return sb.toString();

        if (!falso) {
            for (int i = 0; i < espaco; i++) {
                sb.append("  ");
            }
        }
        if (!falso && p.subPasta == null)
            sb.append(p.dado).append("\n");
        else if (!falso && p.subPasta != null)
            sb.append(p.dado).append(" ");
        if (p.subPasta != null && !falso) {
            espaco++;
            sb.append("\n");
            p = p.subPasta;
        } else if (p.prox == null && p.diretorio != null && p.diretorio.prox != null) {
            espaco--;
            p = p.diretorio.prox;
            falso = false;
        } else if (p.prox == null && p.diretorio != null) {
            espaco--;
            p = p.diretorio;
            falso = true;
        } else if (p.prox != null) {
            p = p.prox;
            falso = false;
        } else
            p = null;

        sb.append(imprime(p, espaco, falso));
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.vazia())
            return sb.toString();

        sb.append(imprime(prim,0,false));
        sb.append("\n");

        return sb.toString();
    }
}
