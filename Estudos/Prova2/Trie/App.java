import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();

        try{
            trie.dividir("carol");

            ArrayList<String> array = trie.imprimir(trie.raiz, "", new ArrayList<>());
            for (int i = 0; i < array.size(); i++) {
                System.out.println(array.get(i));
            }
        }

        catch(Exception e){
            System.out.println("Ocoreu o seguinte erro " + e.getMessage());
        }
    }
}
