import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArvBinBusca<Integer, Integer> arv1 = new ArvBinBusca<>();
        ArvBinBusca<Integer,Integer> arv2 = new ArvBinBusca<>();
        int n;

        System.out.println("ARVORE 1:");

        for(int i=0; i<7; i++){
            System.out.print("Digite um numero: ");
            n = sc.nextInt();
            arv1.put(n,n);
        }

        System.out.println("ARVORE 2:");

        for(int i=0; i<7; i++){
            System.out.print("Digite um numero: ");
            n = sc.nextInt();
            arv2.put(n,n);
        }

        if(arv1.eSimilar(arv2))
            System.out.println("Sao similares!");
        else System.out.println("Nao sao similares.");
    }
}
