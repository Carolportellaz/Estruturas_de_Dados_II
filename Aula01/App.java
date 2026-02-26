public class App{
    static Integer vet [] = new Integer[7];
    static Integer vetR [] = {10, 9, 6, 17, 36, 0, 5};
    static int ultimo = -1;
    static int indice_pai;
    static int cal1;
    static int cal2;
    static int indice_esquerda;
    static int indice_direita;
    static int indice_maior;

    public static void main(String[] args) {

        for(int i = 0; i < vet.length; i++){
            try{
                addEl(vetR[i]);
            }

            catch(Exception e){
                System.out.println("Ocorreu o seguinte erro " + e.getMessage());
            }
        }

        for(int i = 0; i < vet.length; i++){
            System.out.println(vet[i]);
        }


    }

    public static void addEl(int n) throws Exception{
        vet[++ultimo] = n;

        int indice = ultimo;
        int pai = vet[indice / 2];

        // enquanto (i > 0 && vet[i] > pai(vet[i]))
        // troca i <=> pai(i)

        while(indice > 0 && n > pai){
            vet[indice] = pai;
            vet[indice / 2] = n;
            
            // ATUALIZANDO OS VALORES //
            indice = indice / 2;
            pai = vet[indice / 2];
        }
    }
}