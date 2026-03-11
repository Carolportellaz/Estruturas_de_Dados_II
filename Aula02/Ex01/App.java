public class App{
    public static void main(String[] args) {
        int [] vet = {12, 5, 2, 10, 3, 1, 0, 9, 3, 2};
        
        int r = par(vet, 0, 10, 0);

        System.out.println("O valor é " + r);
        
    }

    public static int par(int [] vet, int inicio, int fim, int qtd){
        if(inicio == fim){
            return qtd;
        }

        int meio = (inicio + fim) / 2;

        int nE = par(vet, inicio, meio, qtd);
        int nD = par(vet, inicio, meio + 1, fim);

        if(nE % 2 == 0){
            qtd++;
        }

        if(nD % 2 == 0){
            qtd++;
        }

        return qtd;

    }
}