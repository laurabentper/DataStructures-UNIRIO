public class Sequencia {

    private static int converteEmBinario(int n){
        int resultado = 0, resto = 0;
        String numero ="";
        Fila binario = new Fila(15);

        if(n == 1)
            return 1;

        while(n!= 1){
            resultado = n / 2;
            resto = n % 2;
            binario.insere(resto);
            n = resultado;
        }

        binario.insere(1);

        while(!binario.vazia()){
            numero += (char) (binario.removeFim() + '0');
        }

        return Integer.parseInt(numero);
    }

    public static void geraBinarios(int n){
        for (int i=1; i <=n; i++){
            System.out.print((converteEmBinario(i)) + " ");
        }
    }
}
