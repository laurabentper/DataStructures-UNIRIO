public class Infixa {

    private PilhaGenerica<Integer> pilhaNumeros;
    private PilhaGenerica<Character> pilhaOperadores;

    public Infixa() {
        pilhaNumeros = new PilhaGenerica<>(10);
        pilhaOperadores = new PilhaGenerica<>(10);
    }

    private boolean eOperador(char simbolo) {
        return simbolo == '*' || simbolo == '+' || simbolo == '-' || simbolo == '/';
    }

    public int avaliaExpressao(String expressao) {
        char c, d;
        int operandoX, operandoY;

        for(int i = 0; i < expressao.length(); i++) {

            c = expressao.charAt(i);

            if (!Character.isDigit(c) && !eOperador(c) && c != '(' && c != ')' && c != ' ') {
                System.out.println("Erro: Caractere invalido encontrado.");
                return Integer.MIN_VALUE;
            }

            if (c == '(' || eOperador(c)) {
                pilhaOperadores.push(c);
            } else if (c == ')') {
                d = pilhaOperadores.pop();
                while ((!pilhaOperadores.vazia()) && (d != '(')) {
                    operandoX = pilhaNumeros.pop();
                    operandoY = pilhaNumeros.pop();

                    if (d == '*') pilhaNumeros.push(operandoX * operandoY);
                    else if (d == '+') pilhaNumeros.push(operandoX + operandoY);
                    else if (d == '/') pilhaNumeros.push(operandoY / operandoX);
                    else if (d == '-') pilhaNumeros.push(operandoY - operandoX);
                    d = pilhaOperadores.pop();
                }

            } else if (c != ' ') pilhaNumeros.push(Character.getNumericValue(c));
        }
        return pilhaNumeros.pop();
    }
}