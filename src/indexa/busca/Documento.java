/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

import java.text.Normalizer;
import java.util.HashMap;

/**
 *
 * @author Qih
 */

/*
    Essa classe tem como objetivo representar um documento
*/
public class Documento {
    String id;        
    /*
        Esse método trata uma linha removendo acentos, pontuação e substituindo
    maiúsculas por minúsculas.
    */
    public String trataLinha(String linha){
        //Passa tudo para minúscula  35s
        linha.toLowerCase();
        
        //Remove os aentos // 50s
        linha = Normalizer.normalize(linha, Normalizer.Form.NFD);        
        linha = linha.replaceAll("[^\\p{ASCII}]", "");
        
        /*
        Remove pontuação, regex Po // 1m10s
        "any kind of punctuation character that is not a dash, bracket, quote or connector"
        Fonte:http://www.regular-expressions.info/unicode.html#prop
        */
        linha = linha.replaceAll("\\p{Po}", "");        
        
        return linha;
    }
    
    
    /*
        Esse método separa em um ArrayList todas as palavras de uma string
    */
    public void identificaPalavras(String linha){
        String[] palavras = linha.split(" ");
        
    }
    
    
    /*
        Esse método retorna uma coleção contendo a contagem de cada
    palavra em um dado documento a partir de um ArrayList de Palavras.
    */
    public HashMap contaPalavras(String[] palavras, String documento){        
        //Hashmap representando <Palavra,Contagem>
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();        
                        
        //Para cada palavra identificada no documento
        int i;
        for (i=0; i<palavras.length;i++){
            String p= palavras[i];
            //Se a coleção contem a palavra, então soma 1 na contagem
            if(hashMap.containsKey(p)){
                hashMap.put(p, hashMap.get(p)+1);                
            }else{
                //Se a coleção não tem a palavra insere com contagem 1
                hashMap.put(p, 1);
            }
        }
        return hashMap;
    }
    
}
