import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RedBlackBST<Integer, Integer> arv = new RedBlackBST<>();

        int n;
        for(int i=0; i<7; i++){
            System.out.print("Digite uma chave: ");
            n = sc.nextInt();
            arv.put(n, n);
        }

        System.out.println("Altura negra: " + arv.alturaNegra());

    }
}