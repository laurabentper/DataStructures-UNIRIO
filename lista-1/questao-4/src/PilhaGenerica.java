import java.util.Vector;

public class PilhaGenerica<T>
{
    private int n;
    private Vector<T> vetor;
    private int topo;

    public PilhaGenerica(int tamanho)
    {
        n = tamanho;
        vetor = new Vector<T>(tamanho);
        topo = -1;
    }

    public boolean vazia()
    {
        return topo == -1 ? true : false;
    }

    public boolean cheia()
    {
        return topo == n - 1 ? true : false;
    }

    public T pop()
    {
        T elemento;

        if (!this.vazia())
        {
            elemento = vetor.get(topo--);
            return elemento;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop nao funcionou.");
            return null;
        }
    }

    public boolean push(T elemento)
    {
        if (!this.cheia())
        {
            vetor.add(++topo, elemento);
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }

    public boolean retornaTopo(T elemento)
    {
        if(!this.vazia()){
            elemento = vetor.get(topo);
            return true;
        }
        else
            return false;
    }

    public void removeElemento (T elemento) {
        PilhaGenerica<T> pilhaAuxiliar = new PilhaGenerica<>(n);
        T elementoRemovido = null;

        while (!this.vazia()) {
            T elementoAtual = this.pop();
            if (elemento.equals(elementoAtual)) {
                elementoRemovido = elementoAtual;
            } else {
                pilhaAuxiliar.push(elementoAtual);
            }
        }

        while (!pilhaAuxiliar.vazia()) {
            this.push(pilhaAuxiliar.pop());
        }

        if (elementoRemovido != null) {
            System.out.println("Elemento removido: " + elementoRemovido);
        }
    }

    public void imprimirElementos() {
        for (int i=0; i<= topo; i++) {
            System.out.print(vetor.get(i) + " ");
        }
        System.out.println();
    }
}