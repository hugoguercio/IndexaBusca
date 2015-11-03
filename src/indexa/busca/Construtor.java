package indexa.busca;

/**
 *
 * @author Qih
 */

import indexa.busca.Estruturas.Documento;
import indexa.busca.Estruturas.TabelaHash;
import indexa.busca.Estruturas.Palavra;
import indexa.busca.Estruturas.Par;
import indexa.busca.Estruturas.NoPalavra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Construtor {
    private ArrayList<Documento> documentos;
    
    public void insereDocumento(Documento d){
        if(this.documentos == null){
            this.documentos = new ArrayList<Documento>();
        }
        this.documentos.add(d);
    }
    public Documento getIndex(int i){
        return this.documentos.get(i);
    }
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
    
    
    public void readFile (){//File file){
        String currentLine;
        TabelaHash table = new TabelaHash();

        
        //try (BufferedReader br = new BufferedReader(new FileReader(file))){
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl"))){            
            
            
            HashSet set = new HashSet();
            int rs = 0;
            while ((currentLine = br.readLine()) != null && rs<1000 ) {                             
                String doc;
                Documento d = new Documento();
                //Se existe um documento na posição
                if(d.identificaDocumento(currentLine) != "id não encontrado"){
                    d = new Documento(d.identificaDocumento(currentLine), d.identificaPalavras(currentLine).length);
                    this.insereDocumento(d);
                    doc = d.stringDocumento(currentLine);                
                    doc = d.trataLinha(doc);                
                    ArrayList<Palavra> listaPalavras = d.contaPalavras(d.identificaPalavras(doc));
                    for (int percorre = 0; percorre<listaPalavras.size();percorre++){
                        //set.add(listaPalavras.get(percorre).getPalavra());
                        Par par = new Par(d.getDoc_id(),listaPalavras.get(percorre).getCount());
                        table.insere(listaPalavras.get(percorre).getPalavra(), par);
                    }
                }
                rs++;
            }
            
            
            ///////////////////////////////////////
            
            int var=0;
            
            // para cada posicao da tabela
            for (int l=0;l<4000000;l++){
                //se nao esta vazia
                if(table.getPosicao(l) !=null){
                    if(table.getPosicao(l).tamanhoFilhos()>var){
                        var = table.getPosicao(l).tamanhoFilhos();
                    }
                    
                }   
            }
            System.out.println("Posicoes usadas: "+table.getPosicoesUsadas());
            //System.out.println("Porcentagem das posições utilizadas: "+posicoesUsadas/40000+"%");

            System.out.println("Quantidade de colisões:" + "?");
            System.out.println("Tamanho do maior filho"+var);
            
            
            
//           System.out.println("Palavras Unicas: "+set.size());
//            System.out.println("Quantidade de documentos: "+ this.documentos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    


}
