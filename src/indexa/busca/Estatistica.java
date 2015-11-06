/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

import indexa.busca.Estruturas.Documento;
import indexa.busca.Estruturas.Palavra;
import indexa.busca.Estruturas.Par;
import indexa.busca.Estruturas.TabelaHash;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Qih
 */
/*
    Palavras únicas:    3.573.717
    Documentos:         4.305.028
    Pares:              155.687.931
*/
public class Estatistica {
    private int palavrasUnicas;
    private int quantidadeDocumentos;
    private long quantidadePares;
    
    public void captura (){
        String currentLine;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Qih\\Desktop\\IndexaBusca\\short-abstracts_en.ttl"))){     
            
            HashSet set = new HashSet();
            while ((currentLine = br.readLine()) != null) {                             
                String doc;
                Documento d = new Documento();
                //Se existe um documento na posição
                if(d.identificaDocumento(currentLine) != "id não encontrado"){
                    d = new Documento(d.identificaDocumento(currentLine), d.identificaPalavras(currentLine).length);
                    quantidadeDocumentos++;
                    doc = d.stringDocumento(currentLine);                
                    doc = d.trataLinha(doc);                
                    ArrayList<Palavra> listaPalavras = d.contaPalavras(d.identificaPalavras(doc));
                                      
                    for (int percorre = 0; percorre<listaPalavras.size();percorre++){
                        set.add(listaPalavras.get(percorre).getPalavra()); 
                        quantidadePares++;
                    }
                }                
            }
            palavrasUnicas = set.size();
            System.out.println("Palavras únicas: "+palavrasUnicas);
            System.out.println("Quantidade de pares: "+quantidadePares);
            System.out.println("Documentos: "+quantidadeDocumentos);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList getArrayTamanhoBaldes(TabelaHash table){
         ArrayList<Integer> tamanhoDosBaldes = new ArrayList<Integer>();
        // para cada posicao da tabela
        for (int l=0;l<table.getTabela().length;l++){
            //se nao esta vazia
            if(table.getPosicao(l) !=null){               
                if(table.tamanhoBalde(l)>1){
                    //System.out.println("Tamanho do balde da posição"+l+": "+table.getPosicao(l).size());
                    tamanhoDosBaldes.add(table.tamanhoBalde(l));
                    
                }
            }   
        }
        table.setPosicoesDistintasDeColisao(tamanhoDosBaldes.size());
        return tamanhoDosBaldes;
    }
    
    
    public double media(int sum, int count){
        return sum/count;
    }
    
    public double variancia(double somaQuadrados, int tamanho)
    {
        return somaQuadrados/tamanho;
    }
}
