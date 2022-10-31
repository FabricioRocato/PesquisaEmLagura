import javax.management.Query;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> tabela =
                new Hashtable<String, ArrayList<String>>();

        ArrayList<String> vizinhosMilena
                = new ArrayList<String>();
        vizinhosMilena.add("Yadira");
        vizinhosMilena.add("Juan");

        ArrayList<String> vizinhosAndres
                = new ArrayList<String>();
        vizinhosAndres.add("Maria");

        ArrayList<String> vizinhosJavier
                = new ArrayList<String>();
        vizinhosJavier.add("Andres");
        vizinhosJavier.add("Milena");
        vizinhosJavier.add("yadira");

        ArrayList<String> vizinhosYadira
           = new ArrayList<String>();
        vizinhosYadira.add("Lucia");

        ArrayList<String> vizinhosLucia
           = new ArrayList<String>();


        ArrayList<String> vizinhosJuan
           = new ArrayList<String>();
        vizinhosJuan.add("Milena");
        vizinhosJuan.add("Maria");
        vizinhosJuan.add("Lucia");

        ArrayList<String> vizinhosMaria
         = new ArrayList<String>();




        tabela.put("Milena", vizinhosMilena);
        tabela.put("Andres", vizinhosAndres);
        tabela.put("Javier", vizinhosJavier);
        tabela.put("Yadira", vizinhosYadira);
        tabela.put("Lucia", vizinhosLucia);
        tabela.put("Juan", vizinhosJuan);
        tabela.put("Maria", vizinhosMaria);

        showData(tabela);

        System.out.println(pesquisaEmLargura(tabela, "Yadira"));
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> tabela, String verticeInicial){
        Queue<String> fila = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        fila = enfileirar(fila, (ArrayList<String>)tabela.get(verticeInicial));

        while(fila.size() > 0){
            String pessoa = fila.poll();

            if ("Maria".equals(pessoa))
                return "Maria foi encontrada!";

            if (verificados.contains(pessoa))
                continue;

            fila = enfileirar(fila, (ArrayList<String>)tabela.get(pessoa));
            verificados.add(pessoa);
        }

        return "Maria não foi encontrada!";
    }

    private static Queue<String> enfileirar(Queue<String> fila, ArrayList<String> lista){
        if (lista == null)
            return fila;

        for (String item : lista){
            fila.offer(item);
        }

        return fila;
    }

    private static void showData(Hashtable<String, ArrayList<String>> tabela){
        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String chave = entry.getKey();
            ArrayList<String> dados = entry.getValue();

            System.out.println("Chave: " + chave + " Dados: " + dados);
        }
    }
}