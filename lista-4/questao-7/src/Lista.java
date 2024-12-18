public class Lista {

    protected Elo prim;

    protected class Elo {
        Inimigo inimigo;
        Elo prox;

        public Elo(Inimigo inimigo) {
            this.inimigo = inimigo;
            this.prox = null;
        }
    }

    public Lista() {
        this.prim = null;
    }

    public void inserir(Inimigo inimigo) {
        Elo p = new Elo(inimigo);
        p.prox = prim;
        prim = p;
    }
    /*A complexidade do metodo inserir(Inimigo inimigo) é O(1), pois ele só realiza operações com complexidade
    de tempo contínuo */

    public Inimigo localizar(Inimigo inimigo) {
        Elo atual = prim;
        while (atual != null) {
            if (atual.inimigo.getVida() == inimigo.getVida() && atual.inimigo.getDanoPorSegundo() == inimigo.getDanoPorSegundo()) {
                return atual.inimigo;
            }
            atual = atual.prox;
        }
        return null;
    } /*A complexidade do metodo localizar(Inimigo inimigo) é O(n), onde n é o numero de elementos na lista de inimigos*/

    public int efetuarDano(Inimigo inimigo, double dano) {
        Elo atual = prim;
        Elo ant = null;
        while (atual != null) {
            if (atual.inimigo.getVida()== inimigo.getVida() && atual.inimigo.getDanoPorSegundo()== inimigo.getDanoPorSegundo()) {
                inimigo.setVida(inimigo.getVida() - (int) dano);
                if (inimigo.getVida() <= 0) {
                    if (ant == null) {
                        prim = atual.prox;
                    } else {
                        ant.prox = atual.prox;
                    }
                    return 0;
                }
                return inimigo.getVida();
            }
            ant = atual;
            atual = atual.prox;
        }
        return -1;
    } /*A complexidade geral do metodo efetuarDano(Inimigo inimigo, double dano) é dominada pelo while, resultando
     em uma complexidade O(n). As operações de verificação da vida e do dano, atualização da vida e remoção da lista
     possuem complexidade O(1), logo nao alteram a complexidade geral do metodo.*/
}
