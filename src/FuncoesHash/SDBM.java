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
public class SDBM implements InterfaceHash{
    
    public int hash(String str, int tamanhoTabela) {
        int hash = 0;
        for (int c : str.toCharArray()) {
            hash = c + (hash << 6) + (hash << 16) - hash;
        }
        return Math.abs(hash%tamanhoTabela);
    }
}
