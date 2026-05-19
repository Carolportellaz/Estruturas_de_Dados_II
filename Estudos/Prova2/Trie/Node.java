public class Node {
    Node [] filhos = new Node[26];
    boolean isChave;

    public Node(Node[] filhos, boolean isChave) {
        this.filhos = filhos;
        this.isChave = isChave;
    }

    public Node[] getFilhos() {
        return filhos;
    }

    public void setFilhos(Node[] filhos) {
        this.filhos = filhos;
    }

    public boolean isChave() {
        return isChave;
    }
    
    public void setChave(boolean isChave) {
        this.isChave = isChave;
    }

}
