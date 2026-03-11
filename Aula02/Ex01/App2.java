public class App2 {
    static int vet1 [] = {1, 2, 5, 6, 7};
    static int vet2[] = {2, 3, 12, 21, 22, 67};

    // DÁ ERRO //
    // {1, 2, 4, 6, 7}
    // {3, 2, 12, 21, 22, 67}

    public static void main(String[] args) {
        try{
            int vet [] = gerar(vet1, vet2, 11);
        
            System.out.println("----------");
            for(int i = 0; i < vet.length; i++){
                System.out.println(vet[i]);
            }
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }

        
    }

    public static int [] gerar(int vet1 [], int vet2 [], int tamanho){
        int vetR[] = new int[tamanho];
        int indice1 = 0;
        int indice2 = 0;
        int indice3 = 0;

        for(int i = 0; i < tamanho; tamanho--){
            if(indice1 < vet1.length && indice2 < vet2.length){
                if(vet1[indice1] >= vet2[indice2]){
                    vetR[indice3] = vet2[indice2];
                    indice2++;
                }

                else{
                    vetR[indice3] = vet1[indice1];
                    indice1++;
                }
            }

            else{
                if(indice1 < vet1.length){
                    vetR[indice3] = vet1[indice1];
                    indice1++;
                }

                else{
                    vetR[indice3] = vet2[indice2];
                    indice2++;
                }   
            }
            

            indice3++;
        }

        return vetR;
    }
}
