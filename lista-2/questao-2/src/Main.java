import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Fila filaMista = new Fila(20);
        Fila fila1 = new Fila(10);
        Fila fila2 = new Fila(10);

        for(int i=0; i<5; i++){
            fila1.insere(i+1);
        }

        for(int i=5; i<10; i++){
            fila2.insere(i+1);
        }

        System.out.println("Fila 1:");
        fila1.imprime();
        System.out.println();
        System.out.println("Fila 2:");
        fila2.imprime();
        System.out.println();

        filaMista.combinaFilas(fila1, fila2);

        System.out.println("Fila mista:");
        filaMista.imprime();

        sc.close();
    }
}
