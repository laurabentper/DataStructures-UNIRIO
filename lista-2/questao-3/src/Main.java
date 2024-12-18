import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fila<Character> f1 = new Fila<>(3);
        Fila<Character> f2 = new Fila<>(3);
        Fila<Character> f3 = new Fila<>(3);

        Pilha<Character> p1 = new Pilha<>(3);
        Pilha<Character> p2 = new Pilha<>(3);
        Pilha<Character> p3 = new Pilha<>(3);

        Fila<Pilha<Character>> filaDePilha = new Fila<>(5);
        Pilha<Fila<Character>> pilhaDeFila = new Pilha<>(5);
        Fila<Fila<Character>> filaDeFila = new Fila<>(5);

        System.out.println("Fila de Pilhas:");
        filaDePilha.insere(p1);
        filaDePilha.insere(p2);
        filaDePilha.insere(p3);
        filaDePilha.imprime();
        System.out.println();

        System.out.println("Pilha de Filas:");
        pilhaDeFila.push(f1);
        pilhaDeFila.push(f2);
        pilhaDeFila.push(f3);
        pilhaDeFila.imprime();
        System.out.println();

        System.out.println("Fila de Filas:");
        filaDeFila.insere(f1);
        filaDeFila.insere(f2);
        filaDeFila.insere(f3);
        filaDeFila.imprime();

    }
}

