package indexa.busca;

/**
 *
 * @author Qih
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Construtor {
    
    
    /*
    Esse método deve:
        -Ler o arquivo
        Chamar:
            -identificaDocumento        (pega id_doc)
            -stringDocument             (pega a string q contem o documento)
            -trataLinha                 (trata as linhas removendo tudo)
            -identificaPalavras         (pega as palavras uma a uma)
            -contaPalavras              (conta as palavras identificadas)
            -insereHashTable
            
    */
    
    
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
        
        
        Documento d = new Documento();
        /*
        HARD CODED
        */
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl"))){            
            // Atualiza variáveis            
            while ((currentLine = br.readLine()) != null ) {                             
//               lineCount++;
//               sum += currentLine.length();
//               varianciaSum += (currentLine.length()-media)*(currentLine.length()-media);

                String doc;
                //System.out.println("ID do documento: "+d.identificaDocumento(currentLine));
                //System.out.println("Documento: "+d.stringDocumento(currentLine));
                //System.out.println("Documento tratado: "+d.trataLinha(d.stringDocumento(currentLine)));
                doc = d.stringDocumento(currentLine);
                doc = d.trataLinha(doc);
                ArrayList<Palavra> listaPalavras = d.contaPalavras(d.identificaPalavras(doc));

                //System.out.println(currentLine);
            }

           
            //Imprime alguma informação
//            System.out.println("Document Count: " + lineCount);
//            System.out.println("Media:" + this.media(sum, lineCount));
//            System.out.println("Variancia:" + this.variancia(varianciaSum, lineCount));
            
            
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

}
