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
            -insereHashTable            (insere um par na tabela de hash)
            
    */ 
    public TabelaHash readFile (){//File file){
        String currentLine;
        TabelaHash table = new TabelaHash(300000);

        
        //try (BufferedReader br = new BufferedReader(new FileReader(file))){
        try {            
            FileReader fr = new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl");
            BufferedReader br = new BufferedReader(fr);

            int rs = 0;
            String doc;
            while ((currentLine = br.readLine()) != null && rs<458000) {                
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
                    this.insereDocumento(d);
                    //Para cada palavra, cria o par <doc_id,count> e insere na tabela de hash
                    for (int percorre = 0; percorre<listaPalavras.size();percorre++){
                        Par par = new Par(d.getDoc_id(),listaPalavras.get(percorre).getCount());
                        table.insere(listaPalavras.get(percorre).getPalavra(), par);
                    }
                }
                rs++;
            }
            Estatistica estatistica = new Estatistica();
            table.setPosicoesDistintasDeColisao(estatistica.getArrayTamanhoBaldes(table).size());
            
            /*
                Prints
            */
            System.out.println("Posicoes usadas: "+table.getPosicoesUsadas());
            System.out.println("Posicoes usadas em %: "+(table.getPosicoesUsadas()*100/table.getTabela().length)+"%");
            
            System.out.println("Palavras únicas: "+ (table.getPosicoesUsadas()+table.getColisoes()));
            System.out.println("Quantidade colisões: " + (table.getColisoes()));
            System.out.println("Posicoes distintas de colisao: " + table.getPosicoesDistintasDeColisao() );
            System.out.println("As colisões foram distribuidas em "+(table.getPosicoesDistintasDeColisao()*100/table.getPosicoesUsadas()) +"% das posições da tabela.");
            System.out.println("\nMédia de colisões por posição: " +(table.getColisoes()/table.getPosicoesDistintasDeColisao()));
            System.out.println("\natr nao colodiu: " + (table.getNaoColidiu())+"  que porra é essa?");
            

            br.close();
            fr.close();
            
        } catch (IOException e) {
            System.out.println("deu erro no documento: "+this.documentos.size());
            e.printStackTrace();
        }
        return table;
    }
    
    
    


}
