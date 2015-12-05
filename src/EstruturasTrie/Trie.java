/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasTrie;

import EstruturasHashTable.Documento;
import java.util.ArrayList;

/**
 *
 * @author Qih
 */
public class Trie {
    private NoInterno cabeca;
    private int tamanhoAlfabeto;
    
    
    /*
    Construtor Trie
    */
    public Trie() {
        cabeca = new NoInterno();
        tamanhoAlfabeto = 36; //Apenas 0..9 e a..z
   }

    public void insere(String palavra){
        No[] filhosAtual = cabeca.getFilhos();
        //para cada caracter da palavra
        for (int i=0;i<palavra.length();i++){
            //Identifica a posição no vetor de filhos
            int posicaoLetra = mapeiaASCIIAlfabeto(palavra.charAt(i));
            //Se está vazio insere folha e sai
            if(filhosAtual[posicaoLetra] == null ){
                return;
            }
            else{
                //A posição tem folha, então troca o tipo e sai
                if(filhosAtual[posicaoLetra] instanceof NoFolha){
                    return;
                }
                //No interno, continua caminhando
                else{
                    filhosAtual = ((NoInterno)filhosAtual[posicaoLetra]).getFilhos();
                }
            }
            
            
        }
    }
  
    
    private int mapeiaASCIIAlfabeto(char c){
         //é número
        if((int)c < 58){
            return ((int)c ) - 48;
        }
        return ((int)c ) - 87;
    }
}
