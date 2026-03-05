import java.util.Scanner;

public class App{
    static Numero vet [];
    static int indice_ultimo = -1;
    static Scanner teclado = new Scanner(System.in);
    static int indice_pai;
    static int tamanho;
    static int indice_direita;
    static int indice_esquerda;
    static int indice_menor;
    static boolean trocou;

    public static void main(String[] args) {

        tamanho = teclado.nextInt();

        vet = new Numero[tamanho];

        for(int i = 0; i < vet.length; i++){
            add(teclado.nextInt(), teclado.nextInt());
        }

        try{
            sort(0);
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro com o sort " + e.getMessage());
        }

        for(int i = 0; i < vet.length; i++){
            System.out.println(vet[i].n);
        }

        teclado.close();
    }

    public static void add(int n, int tempo){
        vet[++indice_ultimo] = new Numero(n, tempo);
        

        // VENDO SE É MENOR QUE SEU PAI //
        if(indice_ultimo > 0){
            indice_pai = indice_pai / 2;

            if(vet[indice_pai].n > vet[indice_ultimo].n){
                Numero pai = vet[indice_pai];
                Numero ultimo = vet[indice_ultimo];

                vet[indice_pai] = ultimo;
                vet[indice_ultimo] = pai;
            }
        }
    }


    public static int sort(int i){
        indice_pai = i / 2;
        indice_esquerda = 2 * i + 1;
        indice_direita = 2 * i + 2;
        trocou = false;

        // TROCAR O PAI COM O MENOR DE SEUS FILHOS //
        if(i < vet.length - 1){
            if(vet[indice_direita].n != 0 && vet[indice_direita].n < vet[indice_esquerda].n){
                indice_menor = indice_direita;
            }

            if(vet[indice_direita].n != 0 && vet[indice_esquerda].n <= vet[indice_direita].n){
                indice_menor = indice_esquerda;
            }

            // VEERFICANDO COM O PAI //
            if(vet[indice_menor].n < vet[indice_pai].n){
                Numero menor = vet[indice_menor];
                Numero pai = vet[indice_pai];

                vet[indice_menor] = pai;
                vet[indice_pai] = menor;
                trocou = true;
            }

            // SÓ MUDO O I QUANDO JÁ CONFERI //
            if(!trocou){
                i++;
            }

            return sort(i);
        }

        return 0;
    }
}
