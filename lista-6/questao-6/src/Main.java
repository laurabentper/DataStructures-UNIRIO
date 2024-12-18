import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();
        int n;

        System.out.println("Preencha a arvore.");
        for(int i=0; i<10; i++){
            System.out.print("Digite um numero: ");
            n = sc.nextInt();
            arvore.put(n,n);
        }

        if(arvore.eBalanceada())
            System.out.println("É balanceada!");
        else System.out.println("Não é balanceada.");
    }
}
