package indexa.busca;

/**
 *
 * @author Qih
 */

import indexa.busca.Estruturas.Documento;
import indexa.busca.Estruturas.TabelaHash;
import indexa.busca.Estruturas.Palavra;
import indexa.busca.Estruturas.Par;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    
    
    public TabelaHash readFile (){//File file){
        String currentLine;
        TabelaHash table = new TabelaHash(300);

        
        //try (BufferedReader br = new BufferedReader(new FileReader(file))){
        try {            
            FileReader fr = new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl");
            BufferedReader br = new BufferedReader(fr);
            //HashSet set = new HashSet();
            int rs = 0;
            while ((currentLine = br.readLine()) != null && rs<3) {                             
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
                        Par par = new Par(d.getDoc_id(),listaPalavras.get(percorre).getCount());
                        table.insere(listaPalavras.get(percorre).getPalavra(), par);
                        //set.add(listaPalavras.get(percorre));
                    }
                }
                rs++;
            }
            
            
            

            ArrayList<Integer> tamanhoDosBaldes = new ArrayList<Integer>();
            // para cada posicao da tabela
            for (int l=0;l<table.getTabela().length;l++){
                //se nao esta vazia
                if(table.getPosicao(l) !=null){               
                    if(table.tamanhoBalde(l)>1){
                        System.out.println("Tamanho do balde da posição"+l+": "+table.getPosicao(l).size());
                        table.addPosicoesDistintasDeColisao();
                        tamanhoDosBaldes.add(table.tamanhoBalde(l));
                    }
                }   
            }
            
            
            /*
                Prints
            */
            System.out.println("Posicoes usadas: "+table.getPosicoesUsadas());                        
            System.out.println("Palavras únicas: "+ (table.getPosicoesUsadas()+table.getColisoes()));
            System.out.println("Quantidade colisões: " + (table.getColisoes())+"\n");            
            
            System.out.println("Posicoes distintas de colisao: " + table.getPosicoesDistintasDeColisao() +"\n");            
            
            System.out.println("atr nao colodiu: " + (table.getNaoColidiu())+"  que porra é essa?");
        
            //Usando Set 
            /*
            System.out.println("Palavras únicas inseridas: "+set.size());
            System.out.println("Quantidade de colisões :" + (set.size()-table.getPosicoesUsadas()));
            */
            br.close();
            fr.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }
    
    
    


}
