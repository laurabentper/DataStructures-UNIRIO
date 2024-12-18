import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p;

        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(6);

        for(int i=0; i<6;i++){
            System.out.println("Digite um numero para adicionar na pilha:");
            p = sc.nextInt();
            pilha.push(p);
        }

        System.out.print("Pilha original: ");
        pilha.imprimirElementos();

        System.out.println("Digite o numero que deseja remover:");
        p = sc.nextInt();

        pilha.removeElemento(p);

        System.out.print("Pilha após a remoção: ");
        pilha.imprimirElementos();

        sc.close();
    }
}
