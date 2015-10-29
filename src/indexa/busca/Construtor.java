package indexa.busca;

/**
 *
 * @author Qih
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.StrictMath.sqrt;

public class Construtor {
    
    
    //
    public void readFile (){
        /*
            Variáveis
        */
      
        String currentLine;
        int lineCount,sum;
        double varianciaSum;
        lineCount = 0;
        sum = 0;
        varianciaSum=0;
        
        /*
        HARD CODED
        */
        int media = 395;
        //
        
        
        //ArrayList<String> lines = new ArrayList<String>();
        /*
            Lê o arquivo
        */
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl"))){            
            // Atualiza variáveis
            
            while ((currentLine = br.readLine()) != null) {                             
               lineCount++;
               sum += currentLine.length();
               varianciaSum += (currentLine.length()-media)*(currentLine.length()-media);
               //lines.add(currentLine);
               
            }
            
             
           
            //Imprime alguma informação
            System.out.println("Document Count: " + lineCount);
            System.out.println("Media:" + this.media(sum, lineCount));
            System.out.println("Variancia:" + this.variancia(varianciaSum, lineCount));
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public double media(int sum, int count){
        return sum/count;
    }
    
    public double variancia(double somaQuadrados, int tamanho)
    {
        return somaQuadrados/tamanho;
    }
    
   

    
     
     
     
//    public String trataLinha(String linha) {            
//        
//        String normalizada = Normalizer.normalize(linha, Normalizer.Form.NFKD);
//        String semAcento = normalizada.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");        
//        return semAcento;
//    }
    
    
    
    
    
    

}
