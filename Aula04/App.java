import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("olaa", trie.raiz);
        trie.add("olala", trie.raiz);


        ArrayList<String> array = trie.prefixo("ola", trie.raiz, new ArrayList<>(), true);
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
    }
}
