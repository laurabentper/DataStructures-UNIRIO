import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista inimigos = new Lista();
        Scanner scanner = new Scanner(System.in);

        double dano;
        int vida, opcao;
        boolean rep = true;

        while (rep) {
            System.out.println("1. Inserir Inimigo");
            System.out.println("2. Localizar Inimigo");
            System.out.println("3. Efetuar Dano");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a vida do inimigo: ");
                    vida = scanner.nextInt();
                    System.out.print("Digite o dano por segundo do inimigo: ");
                    dano = scanner.nextDouble();
                    Inimigo novoInimigo = new Inimigo(vida, dano);
                    inimigos.inserir(novoInimigo);
                    System.out.println("Inimigo inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a vida do inimigo a ser localizado: ");
                    vida = scanner.nextInt();
                    System.out.print("Digite o dano do inimigo a ser localizado: ");
                    dano = scanner.nextDouble();
                    Inimigo inimigoLocalizado = inimigos.localizar(new Inimigo(vida, dano));
                    if (inimigoLocalizado != null) {
                        System.out.println("Inimigo encontrado: " + inimigoLocalizado);
                    } else {
                        System.out.println("Inimigo não encontrado na lista.");
                    }
                    break;

                case 3:
                    System.out.print("Digite a vida do inimigo a ser atacado: ");
                    vida = scanner.nextInt();
                    System.out.print("Digite o dano do inimigo a ser atacado: ");
                    dano = scanner.nextDouble();
                    System.out.print("Digite a quantidade de dano a ser causada: ");
                    double danoC = scanner.nextDouble();
                    int vidaRestante = inimigos.efetuarDano(new Inimigo(vida, dano), danoC);
                    if (vidaRestante >= 0) {
                        System.out.println("Dano causado! Vida restante do inimigo: " + vidaRestante);
                    } else {
                        System.out.println("Inimigo não encontrado na lista.");
                    }
                    break;

                case 0:
                    rep = false;
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
