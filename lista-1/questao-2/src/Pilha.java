public class Pilha {

    private int n;
    private char vetor[];
    private int topo;

    public Pilha()
    {
        n = 10;
        vetor = new char[n];
        topo = -1;
    }

    public Pilha(int tamanho)
    {
        n = tamanho;
        vetor = new char[tamanho];
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

    public char pop()
    {
        char c = '\0';

        if (!this.vazia())
        {
            c = vetor[topo];

            //Decrementando o topo, o elemento � "removido"
            topo--;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop n�o funcionou.");
        }

        return c;
    }

    public boolean push(char elemento)
    {
        if (!this.cheia())
        {
            vetor[++topo] = elemento;
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push n�o funcionou.\n");
            return false;
        }
    }

    public char retornaTopo()
    {
        char elemento = '\0';

        if(!this.vazia())
        {
            elemento = vetor[topo];
        }
        else
        {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    private boolean validaForma(){

        char c;
        String inverso = "";

        while(!this.vazia()){
            c = pop();
            if(c == 'C') return comparaCadeia(inverso);
            if(c != 'A' && c != 'B') return false;

            inverso += c;
        }
        return false;
    }

    public boolean comparaCadeia(String inverso){

        if (inverso.length() != topo+1) return false;

        for(int i = 0; i < inverso.length(); i++){
            if(inverso.charAt(i) != vetor[i]){
                return false;
            }
            pop();
        }
        return true;
    }

    public boolean ehDaForma(){
        char c;
        boolean valido = true;
        Pilha cadeia = new Pilha(n);

        while(!this.vazia()){
            c = pop();

            if(c != 'A' && c != 'B' && c != 'C' && c != 'D') return false;

            if(c == 'D'){
                valido = cadeia.validaForma();
                if(!valido) return false;
            } else if(this.vazia()){
                cadeia.push(c);
                return cadeia.validaForma();
            } else {
                cadeia.push(c);
            }
        }

        return true;
    }
}
