package indexa.busca;

/**
 *
 * @author Qih
 */

import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import java.io.BufferedReader;
import java.io.File;
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
            
            // Atualiza variáveis    
            HashSet set = new HashSet();
            while ((currentLine = br.readLine()) != null ) {                             
                String doc;
                Documento d = new Documento();
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
            }
            System.out.println(table.getInseridos());
//           System.out.println("Palavras Unicas: "+set.size());
//            System.out.println("Quantidade de documentos: "+ this.documentos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    


}
