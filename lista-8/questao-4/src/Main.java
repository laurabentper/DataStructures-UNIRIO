public class Main {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> arvRB = new RedBlackBST<>();

     /*   for(int i = 1; i <= 15; i++){
            arvRB.put(i,i);
        }

        //testes
        arvRB.get(9);

        arvRB.get(3);

        arvRB.put(16, 10);

        arvRB.put(22, 22);

        System.out.println("Chave do ultimo nó acessado: " + arvRB.getUltimoAcesso());
*/

        arvRB.put(1, 1);
        arvRB.put(2, 2);
        arvRB.put(3, 3);
        arvRB.put(4, 4);
        arvRB.put(5, 5);
        arvRB.put(6, 6);
        arvRB.put(7, 7);



        arvRB.mostra();
    }
}

