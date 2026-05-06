import java.util.ArrayList;

public class App {
    static int matriz [][] = {
        {0, 2, 3, 4},
        {1, 0, 0, 4},
        {1, 2, 0, 4},
        {0, 0, 3, 0},
    };

    public static void main(String[] args) {
        int n = 3;

        System.out.println("VÉRTICES ADJACENTES AO VÉRTICE");
        ArrayList<Integer> array = vertAdj(n - 1);
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }

        System.out.println("GRAU DO VERTICE");
        System.out.println(array.size());

        System.out.println("GRAFO COMPLETO?");
    }

    // VÉRTICES ADJACENTES AO VÉRTICE //
    public static ArrayList<Integer> vertAdj(int indice){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < matriz[indice].length; i++){
            if(matriz[indice][i] != 0){
                array.add(matriz[indice][i]);
            }
        }
        return array;
    }

    // GRAFO COMPLETO //
    public boolean completo(){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(matriz[i][j] == 0 && i != j){
                    return false;
                }
            }
        }

        return true;
    }
}
