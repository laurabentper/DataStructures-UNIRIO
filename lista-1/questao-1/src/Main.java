import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha(30);

        System.out.print("Digite uma cadeia de caracteres: ");
        String cadeia = sc.nextLine();

        for (int i = 0; i < cadeia.length(); i++) {
            pilha.push(cadeia.charAt(i));
        }

        if(pilha.validaForma()){
            System.out.println("A cadeia esta no formato correto!");
        } else {
            System.out.println("Formato invalido.");
        }

        sc.close();
    }
}
