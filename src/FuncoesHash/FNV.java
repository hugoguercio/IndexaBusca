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
public class FNV implements InterfaceHash{
    private static final int FNV_32_INIT = 0x811c9dc5;
    private static final int FNV_32_PRIME = 0x01000193;
    
    public int hash(String chave, int tamanhoTabela) {
        int rv = FNV_32_INIT;
        final int len = chave.length();
        for(int i = 0; i < len; i++) {
            rv ^= chave.charAt(i);
            rv *= FNV_32_PRIME;
        }
        return rv%tamanhoTabela;
    }
}
