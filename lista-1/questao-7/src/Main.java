import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Infixa infixa = new Infixa();

        System.out.print("Entre com uma expressão aritmética: ");
        String expressao = sc.nextLine();

        int resultado = infixa.avaliaExpressao(expressao);

        if(resultado==Integer.MIN_VALUE)
            System.exit(0);
        else System.out.println("Resultado: " + resultado);

    }
}
