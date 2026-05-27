public class App{
    public static void main (String args []){
        int [][] matriz = {
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 1, 0, 1},
            {0, 1, 0, 0}
        };

        int [] visitados = new int[4];

        boolean r = alcavel(3, matriz, visitados, 0, false);
        System.out.println("---------");
        System.out.println(r);
    }

    public static boolean alcavel(int destino, int [][] matriz, int [] visitados, int atual, boolean r){
        if(atual == destino){
            r = true;
        }

        if(visitados[visitados.length - 1] != 0){
            r = false;
        }

        else{
            for(int i = 0; i < matriz[atual].length; i++){
                if(matriz[atual][i] != 0 && i != atual){
                    if(visitados[i] == 0){
                        visitados[i] = atual;
                    }
                    
                    alcavel(destino, matriz, visitados, matriz[atual][i], r);
                }
            }
        }

        return r;
    }
}