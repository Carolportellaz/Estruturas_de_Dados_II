public class App {
    public static void main(String[] args) {
        int a [] = {2, 5, 3, 0};
        int b [];
        int c [];
        int k = a[0];

        b = new int[a.length];

        // PEGANDO O MAIOR ELEMENTO //
        for(int i = 0; i < a.length; i++){
            if(a[i] > k){
                k = a[i];
            }
        }

        c = new int[k + 1];

        for(int i = 0; i < k; i++){
            c[i] = 0;
        }

        try{
            for(int j = 0; j < a.length; j++){
                c[a[j]] = c[a[j]] + 1;
            }
        }

        catch(Exception e){
            System.out.println("Ocorreu o seguinte erro " + e.getMessage());
        }
        

        for(int l = 1; l < k; l++){
            System.out.println("Tamanho: " + l);
            c[l] = c[l] + c[l - 1];
        }

        for(int j = a.length - 1; j > 1; j--){
            b[c[a[j]]] = a[j];
            c[a[j]] = c[a[j]] - 1;
        }

        System.out.println("------------");
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
    }
}
