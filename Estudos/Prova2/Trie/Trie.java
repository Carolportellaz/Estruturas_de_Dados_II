import java.util.ArrayList;

public class Trie {
    Node raiz = new Node(new Node[26], false);
    Node no = raiz;

    public void dividir(String palavra){
        for (int i = 0; i < palavra.length(); i++) {
            char l = palavra.charAt(i);
            no = add(l, no, "", palavra);
        }
    }

    public Node add(char letra, Node no, String palavra_construida, String palavra){
        int p = letra - 97;

        if(no.filhos[p] == null){
            no.filhos[p] = new Node(new Node[26], false);
        }

        palavra_construida = palavra_construida + String.valueOf(letra);

        if(palavra.equals(palavra_construida)){
            no.filhos[p].isChave = true;
        }

        return no.filhos[p];
    }

    public ArrayList<String> imprimir(Node no, String palavra, ArrayList<String> array){
        if(no.isChave == true){
            array.add(palavra);
        }

        if(no.filhos != null){
            for (int i = 0; i < no.filhos.length; i++) {
                if(no.filhos[i] != null){
                    int p = i + 97;
                    char c = (char) p;
                    palavra = palavra + String.valueOf(c);
                    imprimir(no.filhos[i], palavra, array);
                }
            }
        }

        return array;
    }
}
