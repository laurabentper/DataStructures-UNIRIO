public class SistemaOperacional {

    protected int tamanho;
    protected Processo[] fila;
    protected int ini;
    protected int n;

    public SistemaOperacional() {
        tamanho = 10;
        fila = new Processo[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    public Processo remove() {
        Processo p = null;

        if(!this.vazia()){
            p = fila[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }
        return p;
    }

    public boolean insere(Processo p) {
        int fim;
        if(!this.cheia()){
            fim = (ini + n) % tamanho;
            fila[fim] = p;
            n++;
            return true;
        }
        return false;
    }

    public void imprime(){
        if (this.vazia())
            System.out.println("Fila esta vazia.");
        else{
            int i=ini, j=1;

            while(j<=n){
                System.out.println(j + " " + fila[i]);
                j++;
                i = (i + 1) % tamanho;
            }
        }

    }




}
