public class NodeTrie {
    boolean isChave;
    NodeTrie [] filhos = new NodeTrie[54];

    public NodeTrie(boolean isChave, NodeTrie[] filhos) {
        this.isChave = isChave;
        this.filhos = filhos;
    }

    public NodeTrie() {
    }
}
