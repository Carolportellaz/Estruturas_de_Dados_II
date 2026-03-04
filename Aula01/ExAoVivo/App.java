import java.util.Scanner;

public class App {
    static int n;
    static int vet [];
    static int tamanho;
    static int ultima = -1;
    static int indice_pai;
    static int soma = 0;
    static int custo = 0;

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

    public static void add(int n){
        vet[++ultima] = n;

        heapfy(n);
    }

    public static void heapfy(int n){
        int i = ultima;

        while(i > 0){
            indice_pai = i / 2;

            if(vet[i] < vet[indice_pai]){
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

    public static void remover(){
        custo = 0;
        soma = 0;

        for(int i = 0; i < vet.length- 1; i++){
            soma = vet[i] + vet[i + 1];

            vet[i + 1] = soma;
            custo = custo + soma;
        }
    }
}
