import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha(30);

        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();


        System.out.println("Invertida: ");
        System.out.println(pilha.inverteFrase(frase));

        sc.close();
    }
}
