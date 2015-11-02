/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Qih
 */

/*
    Essa classe tem como objetivo representar um documento
*/
public class Documento {
    /*
        Variáveis
    */
    private String doc_id;
    private int totalPalavras;

    /*
        Construtor, Getters e Setters
    */
    public Documento(){
        
    }
    
    public Documento(String doc_id, int totalPalavras) {
        this.doc_id = doc_id;
        this.totalPalavras = totalPalavras;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public int getTotalPalavras() {
        return totalPalavras;
    }

    public void setTotalPalavras(int totalPalavras) {
        this.totalPalavras = totalPalavras;
    }
    
    /*
        Métodos
    */
    
    /*
        Esse método recebe a linha do arquivo e retorna o id_doc
    */
    public String identificaDocumento(String linha){
        Pattern pattern = Pattern.compile("<http://dbpedia.org/resource/(.*?)>");
        Matcher matcher = pattern.matcher(linha);        
        while (matcher.find()) {
            return matcher.group(1);
        }
        return "id não encontrado";
    }
    
    /*
        Esse método recebe a linha do arquivo e retorna somente as palavras a serem tratadas
    */
    public String stringDocumento(String linha){
        Pattern pattern = Pattern.compile("comment> \"(.*?)\"@en .");
        Matcher matcher = pattern.matcher(linha);        
        while (matcher.find()) {
            //System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return "ERRO: id não encontrado";
        
    }
    
    
    /*
        Esse método trata uma linha removendo acentos, pontuação e substituindo
    maiúsculas por minúsculas.
    */
    public String trataLinha(String linha){
        //Passa tudo para minúscula
        linha = linha.toLowerCase();
        
        //Remove os aentos
        linha = Normalizer.normalize(linha, Normalizer.Form.NFD);        
        linha = linha.replaceAll("[^\\p{ASCII}]", "");
        
        /*
        Remove pontuação, regex P
        Fonte:http://www.regular-expressions.info/unicode.html#prop
        */
        linha = linha.replaceAll("\\p{P}", "");        
        
        return linha;
    }
    
    
    /*
        Esse método separa em um ArrayList todas as palavras de uma string
    */
    public String[] identificaPalavras(String linha){
        String[] palavras = linha.split(" ");
        return palavras;
    }
    
    
    /*
        Esse método retorna um ArrayList contendo a contagem de cada
    palavra em um dado documento a partir de um ArrayList de Palavras.
    */
            
    public ArrayList<Palavra> contaPalavras(String[] palavras){        
        ArrayList<Palavra> palavrasContadas = new ArrayList<Palavra>();
                        
        int i;
        //Para cada palavra identificada no documento
        for (i=0; i<palavras.length;i++){
            Palavra auxPalavra = new Palavra( palavras[i], 1);
            boolean achou=false;
            //Percorre a lista de palavras encontradas
            for (int k=0; k<palavrasContadas.size();k++){
                //Palavra já existe no palavraContada                
                if(palavrasContadas.get(k).equals(auxPalavra)){                    
                    auxPalavra = palavrasContadas.get(k);
                    auxPalavra.setCount(auxPalavra.getCount()+1);
                    palavrasContadas.remove(k);
                    palavrasContadas.add(auxPalavra);
                    achou=true;
                    break;
                }
            }
            //Palavra não existe no palavraContada
            if(achou == false){                
                palavrasContadas.add(auxPalavra);
            }
        }
        return palavrasContadas;
    }
    
    /*
        Esse método recebe uma string qualquer e retorna uma string de tamanho 20.
    Caso a string recebida seja menor que 20 caracteres ele preenche com espaços
    */
    public String ajustaTamanhoPalavra(String s) {
        if(s.length() > 20){
            s = s.substring(0,20);
        }
        return String.format("%1$-" + 20 + "s", s);
    }
    
    /*
        Esse método recebe um ArrayList da contagem de palavras de um doc, assim
    como o id_doc e deve:
    -chamar ajustatamanhopalavra
    -chamar a funlção de hash para achar a posição
    -verificar se a palavra está contida na lista da posição da tabela hash
    -inserir <id_doc,count> na lista de palavras    
    */
    
    
}
