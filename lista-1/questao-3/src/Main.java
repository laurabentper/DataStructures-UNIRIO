import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o tamanho total da pilha: ");
        int tam = sc.nextInt();

        Pilha pilha = new Pilha(tam);


        while (true) {
            System.out.println("======Escolha uma operacao:======");
            System.out.println("1. Adicionar elemento a pilha 1");
            System.out.println("2. Remover elemento da pilha 1");
            System.out.println("3. Adicionar elemento a pilha 2");
            System.out.println("4. Remover elemento da pilha 2");
            System.out.println("5. Imprimir pilha 1");
            System.out.println("6. Imprimir pilha 2");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um caractere para adicionar à pilha 1: ");
                    char elementoEsq = sc.nextLine().charAt(0);
                    pilha.pushEsq(elementoEsq);
                    break;
                case 2:
                    char removidoEsq = pilha.popEsq();
                    if (removidoEsq != '\0') {
                        System.out.println("Elemento removido da pilha 1: " + removidoEsq);
                    }
                    break;
                case 3:
                    System.out.print("Digite um caractere para adicionar à pilha 2: ");
                    char elementoDir = sc.nextLine().charAt(0);
                    pilha.pushDir(elementoDir);
                    break;
                case 4:
                    char removidoDir = pilha.popDir();
                    if (removidoDir != '\0') {
                        System.out.println("Elemento removido da pilha 2: " + removidoDir);
                    }
                    break;
                case 5:
                    System.out.println("Pilha 1:");
                    pilha.printEsq();
                    break;
                case 6:
                    System.out.println("Pilha 2:");
                    pilha.printDir();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

    }
}
