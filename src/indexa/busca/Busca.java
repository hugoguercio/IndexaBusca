/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

import indexa.busca.Estruturas.PalavraUnica;
import indexa.busca.Estruturas.Par;
import indexa.busca.Estruturas.TabelaHash;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Qih
 */
public class Busca {
    
    
    
    public void busca(String chave, TabelaHash tabela){

        FuncoesHash funcoes = new FuncoesHash();
        int posicaoIdentificada = funcoes.hash1(chave,tabela.getTabela().length);
        if(posicaoIdentificada <0){
            posicaoIdentificada = -posicaoIdentificada;            
        }
        posicaoIdentificada = posicaoIdentificada % tabela.getTabela().length; 
        
        ArrayList<PalavraUnica> listaPalavrasNaPosicao = tabela.getPosicao(posicaoIdentificada);
        Par parAux;
        for(int i=0 ;i<listaPalavrasNaPosicao.size();i++){
                PalavraUnica pTeste = listaPalavrasNaPosicao.get(i);
                //Achou a lista de pares da palavra buscada
                if(pTeste.getPalavra().equals(chave)){
                    //Para cada par calcula o idf 
                    for (int j = 0; j < pTeste.getPares().size();j++) {
                    
                        parAux = pTeste.getPares().get(j);
                        parAux.setIdf(calculaIdf(pTeste.getPares().get(j).getCount(), tabela.getQuantidadeDocumentos(), pTeste.getPares().size()));
                    }
                    Collections.sort(pTeste.getPares());
                }
            }
    }
    
    public double calculaIdf(int count, int totalDocumentos, int totalDocumentosComPalavra){
        if(totalDocumentosComPalavra == 0){
            return 0;
        }
        double d= count * ((Math.log((double)totalDocumentos)/ Math.log(2))/ (double)totalDocumentosComPalavra);
        return d;
    }

}
