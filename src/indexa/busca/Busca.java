/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

import indexa.busca.Estruturas.PalavraUnica;
import indexa.busca.Estruturas.TabelaHash;
import java.util.ArrayList;

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
        
        ArrayList<PalavraUnica> arr = tabela.getPosicao(posicaoIdentificada);
        
        for(int i=0 ;i<arr.size();i++){
                PalavraUnica pTeste = arr.get(i);
                //Achou a lista de pares
                if(pTeste.getPalavra().equals(chave)){
                    for (int j = 0; j < pTeste.getPares().size();j++) {
                    //falta atribuir a algum lugar
                    calculaIdf(pTeste.getPares().get(j).getCount(), tabela.getQuantidadeDocumentos(), pTeste.getPares().size());
                    }
                }
            }
    }
    
    public double calculaIdf(int count, int totalDocumentos, int totalDocumentosComPalavra){
        if(totalDocumentosComPalavra == 0){
            return 0;
        }
        return count * Math.log((double)totalDocumentos / (double)totalDocumentosComPalavra);
    }

}
