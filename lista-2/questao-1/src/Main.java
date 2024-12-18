import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SistemaOperacional so = new SistemaOperacional();

        int escolha, id;
        Processo p;

        do{
            System.out.println("Deseja:");
            System.out.println("1- Adicionar processo na fila.");
            System.out.println("2- Remover processo da fila.");
            System.out.println("3- Imprimir fila");
            System.out.println("0- Encerrar.");
            escolha = sc.nextInt();

            if(escolha == 1){
                System.out.print("Digite o id do processo: ");
                id = sc.nextInt();
                p = new Processo(id);
                if(so.insere(p)){
                    System.out.println("Processo inserido com sucesso.");
                    System.out.println();
                } else {
                    System.out.println("Fila cheia.");
                    System.out.println();
                }
            } else if (escolha == 2){
                if(so.remove() != null){
                    System.out.println("Processo removido com sucesso.");
                    System.out.println();
                } else {
                    System.out.println("Fila vazia.");
                    System.out.println();
                }
            } else if (escolha == 3){
                System.out.println("====== SISTEMA OPERACIONAL ======");
                System.out.println("Fila:");
                so.imprime();
                System.out.println();
            }
        } while (escolha != 0);

        sc.close();

    }
}
