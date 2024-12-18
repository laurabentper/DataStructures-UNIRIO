import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha(30);
        char c;

        System.out.println("Digite a sequencia de caracteres: ");
        String caracter = sc.nextLine();

        for(int i = 0; i < caracter.length(); i++) {
            c = caracter.charAt(i);
            if(c == '[' || c == '{' || c == '(') {
                pilha.push(c);
            }
            else if(c == ']' || c == '}' || c == ')') {
                if(pilha.balanceado(c)){
                    pilha.pop();
                } else {
                    System.out.println("Nao balanceado.");
                    sc.close();
                    System.exit(0);
                }
            }
        }

        if(!pilha.vazia()) System.out.println("Nao balanceado.");
        else System.out.println("Balanceado.");
        sc.close();

    }
}
