import java.lang.reflect.Array;
import java.util.ArrayList;

public class GrafosMetodos {
    static ArrayList<ArrayList<Integer>> listap = new ArrayList<>();

    static int nVert = 5;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            listap.add(new ArrayList<>());
        }

        listap.get(0).add(1);
        listap.get(1).add(2);
        listap.get(2).add(3);
        listap.get(2).add(1);
        listap.get(3).add(4);

        System.out.println(temLaco());
        System.out.println(grauS(2));
        System.out.println(temLaco());


    }

    public static boolean temLaco(){
        for (int i = 0; i < listap.size(); i++) {
            if(listap.get(i).contains(i)){
                return true;
            }
        }
        return false; 
    }


    /*      0 -> 1
            1 -> 2
            2 -> 3, 2
            3 -> 4
        */

    public static int grauS (int l){
        return listap.get(l).size();
    }

    public static int grauE(String l){
        int soma = 0;

        for (int i = 0; i < listap.size(); i++) {
            for (int j = 0; j < listap.get(i).size(); j++) {
                if(listap.get(i).get(j).equals(l)){
                    soma++;
                }
            }
        }

        return soma;
    }
}