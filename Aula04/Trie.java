import java.util.ArrayList;

public class Trie {
    NodeTrie raiz = new NodeTrie();
    String palavra_formada = "";

    public void add(String nome, NodeTrie atual){
        char [] vetNome = nome.toCharArray();

        for(int i = 0; i < vetNome.length; i++){
           int l = (char) vetNome[i];

           int posicao = verf(l);

           if(atual.filhos[posicao] == null){
                atual.filhos[posicao] = new NodeTrie();
           }

           atual = atual.filhos[posicao];
        }

        atual.isChave = true;
    }

    public ArrayList<String> prefixo(String nome, NodeTrie atual, ArrayList<String> filhos, boolean primeira){
        if(primeira){
            char [] vetNome = nome.toCharArray();

            for(int i = 0; i < vetNome.length; i++){
                int l = (char) vetNome[i];

                int p = verf(l);

                if(atual.filhos[p] != null){
                    atual = atual.filhos[p];
                }
            }
        }

        for(int i = 0; i < atual.filhos.length; i++){
            if(atual.filhos[i] != null && atual.filhos[i].isChave){
                filhos.add(nome);
            }

            atual = atual.filhos[i];
            prefixo(nome, atual, filhos, false);
        }
        return filhos;
    }

    public boolean buscar(String nome, NodeTrie atual, String palavra){
        char [] vetNome = nome.toCharArray();
        palavra_formada = "";

        for(int i = 0; i < vetNome.length; i++){
           int l = (char) vetNome[i];

           int posicao = verf(l);

           if(atual.filhos[posicao] != null){
                palavra_formada =  palavra_formada + vetNome[i];
           }

           atual = atual.filhos[posicao];
        }

        if(palavra_formada.equals(nome)){
            return true;
        }

        else{
            return false;
        }
    }

    public int verf(int l){
        int p;

        // MAIUSCULA //
        if(65 <= l && l <= 90){
            p = l - 'A';
            return p;
        }

            // MINUSCULA //
        if(97 <= l && l <= 122){
            p = l - 'a';
            return p;
        }

        if(l == 32){
            return 32;
        }

        if(l == 45){
            return 45;
        }

        else{
            return -1;
        }
    }
}
