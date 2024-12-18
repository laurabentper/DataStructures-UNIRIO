import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();
        System.out.println("Preencha a arvore.");
        for(int i=0; i<8; i++){
            System.out.print("Digite um numero: ");
            int n = sc.nextInt();
            arvore.put(n,n);
        }
        System.out.println();
        System.out.println("Chave 1:");
        int c1 = sc.nextInt();
        System.out.println("Chave 2:");
        int c2 = sc.nextInt();

        arvore.achaAncestral(c1, c2);
    }
}
