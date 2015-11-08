/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncoesHash;

/**
 *
 * @author Qih
 */
public class HashSoma implements InterfaceHash{
    public int hash(String palavra, int tamanhoTabela) {
        char ch[];
        ch = palavra.toCharArray();
        int tamanhoPalavra = palavra.length();

        int i, sum;
        for (sum=0, i=0; i < palavra.length(); i++){
            sum += ch[i];
        }            
        return sum % tamanhoTabela;
    }
}
