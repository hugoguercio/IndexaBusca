
package indexa.busca;

import java.text.Normalizer;

/**
 *
 * @author Hugo Guércio
 */
public class IndexaBusca {

    /**
     * Main
     * 
     */
    public static void main(String[] args) {
        Construtor c = new Construtor();
        c.readFile();
        
        
        
        /*
        //teste manipulando linhas
        
        String teste = "St!ring, de é teste. Oi-oi.";
        
        //Funcionando 
        teste=teste.toLowerCase();
        teste=teste.replaceAll("\\p{Po}", "");
        String[] parts = teste.split(" ");
        
        String normalizada = Normalizer.normalize(teste, Normalizer.Form.NFD);        
        String semAcento = normalizada.replaceAll("[^\\p{ASCII}]", "");
        teste= semAcento;
        System.out.println(semAcento);
        //Fim manipulações
        
        //Imprime
        int aux=0;
        while(aux<parts.length){
            System.out.println(parts[aux]);
            aux++;
        }
        // Fim teste manipulando linhas
        */
    }    
    
}
