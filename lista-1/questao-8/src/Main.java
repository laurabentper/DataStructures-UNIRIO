import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha();

        System.out.print("Digite o tamanho de N: ");
        int n = sc.nextInt();

        int elemento, paresOrdenados = 0;

        for(int i = 0; i < n; i++){
            pilha.push(i+1);
        }


        while(!pilha.vazia()) {
            elemento = pilha.pop();
            if(pilha.retornaTopo() != Integer.MIN_VALUE) {
                paresOrdenados += 1;
                System.out.println("(" + elemento + "," + pilha.retornaTopo() + ")");
            }
        }

        System.out.println( paresOrdenados + " pares ordenados.");

    }
}
