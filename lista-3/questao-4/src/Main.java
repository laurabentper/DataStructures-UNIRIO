import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pilha pilha = new Pilha(10);
        int resposta, elemento;

        do{
            System.out.println("=====MENU=====");
            System.out.println("1- Adicionar elemento");
            System.out.println("2- Remover elemento");
            System.out.println("0- Encerrar");
            resposta = sc.nextInt();

            if(resposta == 1){
                System.out.print("Digite um numero: ");
                elemento = sc.nextInt();
                pilha.push(elemento);
                System.out.println();
            } else if(resposta == 2){
                pilha.pop();
                System.out.println("Elemento removido");
                System.out.println();
            }
        }while(resposta != 0);

        System.out.printf("Quantidade de numeros pares na pilha: %d", pilha.qtdPares());
    }
}