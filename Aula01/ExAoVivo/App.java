import java.util.Scanner;

public class App {
    static int n;
    static int vet [];
    static int tamanho;
    static int indice_ultimo = -1;
    static int indice_pai;
    static int soma = 0;
    static int custo = 0;
    static int ultimo_el = 0;
    static int pai = 0;
    static int indice_esquerda = 0;
    static int indice_direita = 0;
    static int indice_menor = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        tamanho = teclado.nextInt();
        vet = new int[tamanho];

        for(int i = 0; i < vet.length; i++){
            add(teclado.nextInt());
        }

        remover();

        System.out.println(custo);
    }


    public static void add (int n){
        vet[++indice_ultimo] = n;

        int i = indice_ultimo;

        while(i > 0){
            indice_pai = i / 2;

            if(vet[i] > vet[indice_pai]){
                int n1 = vet[i];
                int n2 = vet[indice_pai];

                vet[i] = n2;
                vet[indice_pai] = n1;

                i = indice_pai;
            }

            else{
                break;
            }
        }
    }

    public static int heapfy(int i){
        indice_esquerda = 2 * i + 1;
        indice_direita = 2 * i + 2;

        if(vet[indice_esquerda] < vet[indice_direita]){
            indice_menor = indice_esquerda;
        }

        else{
            indice_menor = indice_direita;
        }


        if(vet[i] < vet[indice_menor]){
            int n1 = vet[i];
            int n2 = vet[indice_menor];

            vet[indice_menor] = n1;
            vet[i] = n2;
            i = indice_menor;

            return heapfy(i);
        }

        else{
            return vet[i];
        }
    }

    public static int remover(){
        ultimo_el = vet[indice_ultimo];

        if(vet[0] != 0){
            vet[0] = vet[indice_ultimo];
            vet[indice_ultimo] = 0;

            indice_ultimo--;

            heapfy(0);
        }

        return vet[0];

    }
}
