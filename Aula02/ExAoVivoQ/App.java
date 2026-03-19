import java.util.Scanner;

public class App {
    static int pivo = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int [] vet = new int[teclado.nextInt()];

        for(int i = 0; i < vet.length; i++){
            vet[i] = teclado.nextInt();
        }

        quick(vet, 0 , 0, 1, 0);

        for(int i = 0; i < pivo - 1; i++){
            int n1 = vet[i];
            int n2 = vet[i + 1];

            if(vet[i] < vet[i+1]){
                vet[i] = n2;
                vet[i+1] = n1;
            }
        }

        for(int i = pivo + 1; i < vet.length - 1; i++){
            int n1 = vet[i];
            int n2 = vet[i + 1];

            if(vet[i] > vet[i+1]){
                vet[i] = n2;
                vet[i+1] = n1;
            }
        }

        System.out.println("--------------");
        for(int i = 0; i < vet.length; i++){
            System.out.println(vet[i]);
        }

        System.exit(0);;

        teclado.close();
    }

    public static void quick(int vet [], int i, int j, int indice_atual, int ulJ){
        if(indice_atual < vet.length) {
            if(vet[indice_atual] > vet[pivo]){
                // EU PRECISO PEGAR O ÚLTIMO J //
                if(j == i){
                    j++;
                    ulJ = j;
                }

                indice_atual++;
            }

            else{
                // TROCAR O MEU ÚLTIMO J COM O MEU INDICE ATUAL //
                int n1 = vet[j];
                int n2 = vet[indice_atual];

                vet[indice_atual] = n1;
                vet[j] = n2;
                i++;
                indice_atual++;
            }

            quick(vet, i, j, indice_atual, ulJ);
        }

        else{
            if(i != indice_atual){
                int n1 = vet[0];
                int n2 = vet[i];

                vet[i] = n1;
                vet[0] = n2;
            }
            

        }
    }
}
