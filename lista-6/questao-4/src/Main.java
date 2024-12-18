import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();

        System.out.println("Preencha a arvore.");
        for(int i=0; i < 10; i++){
            System.out.print("Digite um numero: ");
            int n = sc.nextInt();
            arvore.put(n,n);
        }
        arvore.mostra();
        System.out.println();

        System.out.print("Intervalo valor min: ");
        int min = sc.nextInt();
        System.out.print("Intervalo valor max: ");
        int max = sc.nextInt();

        if(min > max) {
            System.out.println("Entrada invalida. minimo deve ser menor que o maximo.");
            System.exit(0);
        }

        if(arvore.removeForaIntervalo(min, max)) {
            System.out.println("Removido com sucesso.");
        } else System.out.println("Nenhum numero foi removido.");
        arvore.mostra();
    }
}
