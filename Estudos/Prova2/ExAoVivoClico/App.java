import java.util.Scanner;

public class App{
    public static void main (String args[]){
        Scanner teclado = new Scanner(System.in);
        int [][] matriz;

        int qtdAl = teclado.nextInt();
        int qtdAr = teclado.nextInt();

        // Carregando a matriz //
        matriz = new int[qtdAl][qtdAl];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = 0;
            }
        }

        while(qtdAr > 0){
            int n1 = teclado.nextInt() - 1;
            int n2 = teclado.nextInt() - 1;

            matriz[n1][n2] = 1;
            matriz[n2][n1] = 1;

            qtdAr--;
        }

        // VENDO SE TEM UM CICLO //
        boolean resultado = false;

        boolean[] vet_visitados = new boolean[matriz.length];


        for (int i = 0; i < matriz.length; i++) {  
            if(!vet_visitados[i]){
                resultado = (temCiclo(matriz, -1, i, vet_visitados));
            }    
            
            if(resultado){
                break;
            }
        }

        if(resultado){
            System.out.println("FOFOCA EM LOOP");
        }

        else{
            System.out.println("SEM LOOP");
        }
        teclado.close();
    }

    public static boolean temCiclo(int [][] matriz, int indice_pai, int indice_atual, boolean[] vet_visitados){
        // VETOR DE VISITADOS //
        vet_visitados[indice_atual] = true;

        for(int i = 0; matriz.length > i; i++){

            if(matriz[indice_atual][i] == 1){
                if(vet_visitados[i] == false){
                    if(temCiclo(matriz, indice_atual, i, vet_visitados)){
                        return true;
                    }
                }

                else if(i != indice_pai){
                    return true;
                }
            }
        }

        return false;
    }
}