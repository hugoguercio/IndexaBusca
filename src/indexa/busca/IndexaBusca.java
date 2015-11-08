
package indexa.busca;

import indexa.busca.Estruturas.TabelaHash;
import indexa.busca.GUI.FrameInicio;

/**
 *
 * @author Hugo Guércio
 */
public class IndexaBusca {

    /**
     * Main
     * 
     */

    
    public TabelaHash table;
    public static void main(String[] args) {
        FrameInicio frame = new FrameInicio();
        frame.setVisible(true);
        
 /**       
        //TabelaHash t = c.criaTabela();
        //t.busca("screenwriter");
        //Busca b = new Busca();
        //b.busca("screenwriter", t);
//         teste do idf
//        
//        Busca b = new Busca();
//        Par p1 = new Par(1, 3);
//        Par p2 = new Par(2,1);
//        p1.setIdf(b.calculaIdf(3, 2, 2));
//        p2.setIdf(b.calculaIdf(1, 2, 2));
//        System.out.println("IDF da palavra p1: "+p1.getIdf());
//        System.out.println("IDF da palavra p2: "+p2.getIdf());
//        
//        ArrayList<Par> arr = new ArrayList();
//        arr.add(p1);
//        arr.add(p2);
//        System.out.println("\n prin antes de ordenar");
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println(arr.get(i).getDoc_id());
//        }
//        Collections.sort(arr);
//        
//        System.out.println("\n prin depos de ordenar");
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println(arr.get(i).getDoc_id());
//        }
//        
//        
//        Documento d = new Documento();
//        String x = "quem casa quer casa porem ninguem casa ninguem quer casa tambem quer apartamento";
//        String y = "ninguem em casa todos sairam todos quer entrar quem quem";

        
//        
//        Documento d = new Documento();
//         String x = "quem casa quer casa porem ninguem casa ninguem quer casa tambem quer apartamento";
//         String y = "ninguem em casa todos sairam todos quer entrar quem quem";
//         
//        String[] p = {"oi", "mundo", "oi", "legal", "mundo", "oi"};
//        x = d.trataLinha(x);
//        String[] p = d.identificaPalavras(x);
//         
//        
//        ArrayList<Palavra> listaPalavras = d.contaPalavras(p);
//        for (int i=0; i<listaPalavras.size(); i++){
//            System.out.println(listaPalavras.get(i).getPalavra() +" - "+listaPalavras.get(i).getCount()  );
//            
//        }

//Teste verifica palavra igual con contagem diferente        
//        Palavra p1 = new Palavra("oi", 2);
//        Palavra p2 = new Palavra("oi", 22);
//        Palavra p3 = new Palavra("ae",13);
//        ArrayList<Palavra> p = new ArrayList<Palavra>();
//        p.add(p3);
//        p.add(p1);
//        System.out.println(p.size());
//
//        
//        for (int i=0; i<p.size();i++){
//            System.out.println(p.get(i).equals(p2));
//        }
        
        
//        //teste manipulando linhas
//        
//        String teste = "St!ring, de é teste. Oi-oi.";
//        
//        //Funcionando 
//        teste=teste.toLowerCase();
//        teste=teste.replaceAll("\\p{Po}", "");
//        String[] parts = teste.split(" ");
//        
//        String normalizada = Normalizer.normalize(teste, Normalizer.Form.NFD);        
//        String semAcento = normalizada.replaceAll("[^\\p{ASCII}]", "");
//        teste= semAcento;
//        System.out.println(semAcento);
//        //Fim manipulações
//        
//        //Imprime
//        int aux=0;
//        while(aux<parts.length){
//            System.out.println(parts[aux]);
//            aux++;
//        }
//        // Fim teste manipulando linhas
//        
        
        */
    }    
    
}
