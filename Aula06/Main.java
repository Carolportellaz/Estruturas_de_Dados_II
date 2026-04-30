import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        int [][] distancias = {
            // MNU BH SP RJ VT FL CU PO
            { 0 , 283 , 748 , 430 , 234 , 1449 , 1155 , 1884} ,
            {283 ,0 , 584 , 441 , 515 , 1344 , 1208 , 1809} ,
            {748 , 584 ,0 , 446 , 938 , 709 , 419 , 1144} ,
            {430 , 441 , 446 ,0 , 517 , 1136 , 842 , 1571} ,
            {234 , 515 , 938 , 517 ,0 , 1638 , 1345 , 2073} ,
            {1449 , 1344 , 709 , 1136 , 1638 ,0 , 306 , 463} ,
            {1155 , 1208 , 419 , 842 , 1345 , 306 , 0 , 741} ,
            {1884 , 1809 , 1144 , 1571 , 2073 , 463 , 741 , 0}
        };

        int origem = 0;
        int destino = 0;
        int total = 0;

        boolean vet [] = new boolean[distancias[0].length];

        for(int i = 0; i < vet.length; i++){
            vet[i] = false;
        }

        vet[0] = true;

        origem = 0;

        /*for(int i = origem; i < distancias[0].length; i++){
             
            // SÓ POSSO IR PARA FRENTE
            if(i == 0){
                

                int j = 0;

                for(j = 0; j < distancias[0].length; j++){
                    if(distancias[i][j] < menor && distancias[i][j] != 0 && vet[j] == false){
                        menor = distancias[i][j];
                    }
                }

                vet[j] = true;
                total = distancias[i][j] + total;
                
            }
        }*/

        for(int k = 0; k < vet.length; k++){
            // PEGAR O MAIOR DA LINHA //
            int menorL = 0;
            boolean primeiraL = true;
            int indiceL = 0;

            int i = 0;

            for(i = 0; i < distancias[0].length; i++){
                if(primeiraL){
                    if(distancias[origem][i] != 0 && vet[i] == false){
                        menorL = distancias[origem][i];
                        primeiraL = false;
                    } 
                }

                else{
                    if(menorL > distancias[origem][i] && vet[i] == false){
                        menorL = distancias[origem][i];
                        indiceL = i;
                    }
                }
            }

            // PEGAR O MAIOR DA COLUNA //
            int menorC = 0;
            int indiceC = 0;
            boolean primeiraC = true;

            int j = 0;
            for(j = 0; j < distancias[0].length; j++){
                if(primeiraC){
                    if(distancias[j][destino] != 0 && vet[j] == false){
                        menorC = distancias[j][destino];
                        primeiraC = false;
                    } 
                }

                else{
                    if(menorC > distancias[j][destino] && vet[j] == false){
                        menorC = distancias[j][destino];
                        indiceC = j;
                    }
                }
            }

            // VÊ QUAL DOS DOIS É MAIOR //
            if(menorC < menorL){
                vet[j] = true;
                System.out.println("O indiceC é " + indiceC);
                total = total + distancias[indiceC][destino];
                destino = j;
            }

            else{
                vet[i] = true;
                total = total + distancias[origem][indiceL];
                origem = i;
            }
    
        }
    }
        
}