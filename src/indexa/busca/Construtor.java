package indexa.busca;

/**
 *
 * @author Qih
 */

import EstruturasHashTable.Documento;
import EstruturasHashTable.TabelaHash;
import EstruturasHashTable.Palavra;
import EstruturasHashTable.Par;
import EstruturasTrie.Trie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Construtor {

   
    /*
    Esse método deve criar a tabela a partir do arquivo
        -Ler o arquivo
        Chamar:
            -identificaDocumento        (pega id_doc)
            -stringDocument             (pega a string q contem o documento)
            -trataLinha                 (trata as linhas removendo tudo)
            -identificaPalavras         (pega as palavras uma a uma)
            -contaPalavras              (conta as palavras identificadas)
            -insereHashTable            (insere um par na tabela de hash)
            
    */ 
    public TabelaHash criaTabela (File file, int qtdDocumentos, int tamanhoTabela){
        long startTime = System.nanoTime();
        
        String currentLine;
        if(qtdDocumentos == 0){
            qtdDocumentos=Integer.MAX_VALUE;
        }
        if(tamanhoTabela == 0){
            tamanhoTabela = 300007;
        }
        TabelaHash table = new TabelaHash(tamanhoTabela);
        int rs = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
        //try {            
            //FileReader fr = new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl");
            //BufferedReader br = new BufferedReader(fr);
                      
            String doc;
            while ((currentLine = br.readLine()) != null && rs<qtdDocumentos) {                
                //Inicializa um documento
                Documento d = new Documento();
                //Se existe um documento na posição
                if(d.identificaDocumento(currentLine) != "id não encontrado"){
                    //Atribui os campos do objeto documento a partir da linha lida
                    d = new Documento(d.identificaDocumento(currentLine), d.identificaPalavras(currentLine).length);
                    
                    //Captura o texto do documento e faz o tratamento
                    doc = d.stringDocumento(currentLine);                
                    doc = d.trataLinha(doc);                
                    ArrayList<Palavra> listaPalavras = d.contaPalavras(d.identificaPalavras(doc));
                    d.setPalavrasDistintas(listaPalavras.size());
                    //this.insereDocumento(d);
                    table.insereDocumento(d);
                    //Para cada palavra, cria o par <doc_id,count> e insere na tabela de hash
                    for (int percorre = 0; percorre<listaPalavras.size();percorre++){
                        //System.out.println(listaPalavras.get(percorre).getPalavra());
                        Par par = new Par(d.getDoc_id(),listaPalavras.get(percorre).getCount());
                        table.insere(listaPalavras.get(percorre).getPalavra(), par);
                        
                    }
                    table.addDocumentosInseridos();
                    
                    if((qtdDocumentos % 100000) == 0){
                        System.gc();
                    }
                }
                rs++;
            }
            
            table.setPosicoesDistintasDeColisao(table.getArrayTamanhoBaldes().size());
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); 
            double seconds = (double)duration / 1000000000.0;
            /*
                Prints
            */
            System.out.println("Tamanho da tabela                 : "+table.getTabela().length);
            System.out.println("Documentos inseridos              : "+table.getDocumentos().size());
            System.out.println("Posicoes usadas                   : "+table.getPosicoesUsadas());
            System.out.println("Percentagem de posicoes usadas    : "+(table.getPosicoesUsadas()*100/table.getTabela().length)+"%");
            
            System.out.println("Palavras únicas                   : "+ (table.getPosicoesUsadas()+table.getPalavrasNovas()));
            System.out.println("Quantidade colisões               : " + (table.getPalavrasNovas()));
            System.out.println("Posicoes distintas de colisao     : " + table.getPosicoesDistintasDeColisao() );
            System.out.println("Distribuição de colisões          : "+(table.getPosicoesDistintasDeColisao()*100/table.getPosicoesUsadas()) +"%");
            
            if(table.getPosicoesDistintasDeColisao()!=0){
            System.out.println("Média de colisões por posição   : " +(table.getColisoes()/table.getPosicoesDistintasDeColisao()));
            }
            System.out.println("Tempo de execução: "+seconds+"segundos");
            br.close();
            //fr.close();
            
        } catch (IOException e) {
            System.out.println("deu erro no documento: "+table.getDocumentos().size());
            e.printStackTrace();
        }
        return table;
    }
    
    public Trie criaTrie(File file, int qtdDocumentos){
        long startTime = System.nanoTime();
        int rs = 0;
        String currentLine;
        if(qtdDocumentos == 0){
            qtdDocumentos=Integer.MAX_VALUE;
        }
        
        Trie trie = new Trie();
              
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
        //try {            
            //FileReader fr = new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl");
            //BufferedReader br = new BufferedReader(fr);                    
            String doc;
            while ((currentLine = br.readLine()) != null && rs<qtdDocumentos) {                
                //Inicializa um documento
                Documento d = new Documento();
                //Se existe um documento na posição
                if(d.identificaDocumento(currentLine) != "id não encontrado"){
                    //Atribui os campos do objeto documento a partir da linha lida
                    d = new Documento(d.identificaDocumento(currentLine), d.identificaPalavras(currentLine).length);
                    
                    //Captura o texto do documento e faz o tratamento
                    doc = d.stringDocumento(currentLine);                
                    doc = d.trataLinha(doc);                
                    ArrayList<Palavra> listaPalavras = d.contaPalavras(d.identificaPalavras(doc));
                    d.setPalavrasDistintas(listaPalavras.size());
                    
                    trie.insereDocumento(d);                    
                    
                    //Para cada palavra, cria o par <doc_id,count> e insere na tabela de hash
                    for (int percorre = 0; percorre<listaPalavras.size();percorre++){
                        //System.out.println(listaPalavras.get(percorre).getPalavra());
                        Par par = new Par(d.getDoc_id(),listaPalavras.get(percorre).getCount());
                        //table.insere(listaPalavras.get(percorre).getPalavra(), par);
                        
                    }
                   // table.addDocumentosInseridos();
                    
                    if((qtdDocumentos % 100000) == 0){
                        System.gc();
                    }
                }
                rs++;
            }
            
            
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); 
            double seconds = (double)duration / 1000000000.0;
            /*
                Prints
            */
       
                        
            System.out.println("Tempo de execução: "+seconds+"segundos");
            br.close();
            //fr.close();
            
        } catch (IOException e) {
            //System.out.println("deu erro no documento: "+table.getoDcumentos().size());
            e.printStackTrace();
        }
        
        
        return trie;
    }
    
    
    /*
        Conta a quantidade de documentos em um arquivo.
    
    */
    public int qtdDocumentos(File file){
        //Variaveis para contagem de tempo
        long startTime = System.nanoTime();
        double duracaoContaPalavrasSegundos=0;
        
        //Variaveis do método
        int qtdDocumentos=0;
        String currentLine;
        ArrayList<String> todasPalavras = new ArrayList<String>();
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            Documento d = new Documento();
            String[] palavras;
            
            //Se existe documento na linha, insere as palavras em um array.
            while ((currentLine = br.readLine()) != null) {                
                if(d.identificaDocumento(currentLine) != "id não encontrado"){
                    palavras = d.identificaPalavras(d.trataLinha(d.stringDocumento(currentLine)));
                    for(int i=0;i<palavras.length;i++){
                        todasPalavras.add(palavras[i]);
                    }
                    qtdDocumentos++;
                }
            }
            
            long endTimeContaPalavras = System.nanoTime();
            long duracaoContaPalavras = (endTimeContaPalavras - startTime); 
            duracaoContaPalavrasSegundos = (double)duracaoContaPalavras / 1000000000.0;
            System.out.println("Temos "+ todasPalavras.size() +" palavras em "+qtdDocumentos+" documentos.");
            System.out.println("Tempo gasto na contagem de palavras: "+duracaoContaPalavrasSegundos+"segundos");
            
            //Ordena as palavras
            Collections.sort(todasPalavras);
            int contagem=1;
            
            ArrayList<Palavra> palavrasUnicas = new ArrayList<>();
            
            class compara implements Comparator<Palavra> {
                @Override
                public int compare(Palavra arg0, Palavra arg1) {
                return arg1.getCount() - arg0.getCount();
                }
            }
            
            //Conta a ocorrência de cada palavra
            for(int i=1;i<todasPalavras.size();i++){
                //igual
                if(todasPalavras.get(i-1).equals(todasPalavras.get(i))){
                    contagem++;
                }else{//diferente
                   Palavra p = new Palavra(todasPalavras.get(i-1), contagem);
                   palavrasUnicas.add(p);
                   contagem=1;
                }
                
            }

            System.out.println("\nTemos "+palavrasUnicas.size() +"palavras únicas.\n");
            Collections.sort(palavrasUnicas, new compara());
            int qtdusadas=0;
            for(int i=0;i<100;i++){
                System.out.println("Palavra "+i+ " : "+palavrasUnicas.get(i).getPalavra() +" apareceu "+palavrasUnicas.get(i).getCount()+" vezes.");
                qtdusadas+=palavrasUnicas.get(i).getCount();
            }            
            System.out.println("Top 100 palavras tem contagem total de:" +qtdusadas+" representando "+(qtdusadas*100/todasPalavras.size())+"% de todas as palavras do documento.");
            
            //System.out.println("Palavra mais frenquente: " +palavrasUnicas.get(0).getPalavra()+ " com: "+palavrasUnicas.get(0).getCount()+" ocorrencias.");
            //System.out.println("Segunda Palavra mais frenquente:" +palavrasUnicas.get(1).getPalavra()+ " com: "+palavrasUnicas.get(1).getCount()+" ocorrencias.");
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        return qtdDocumentos-2;//desconsidera a primeira e ultima linha
    }

}
