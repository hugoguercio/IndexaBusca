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
public class FuncaoHashJava implements InterfaceHash{
    public int hash(String palavra, int tamanhoTabela){
        return Math.abs(palavra.hashCode()%tamanhoTabela);
    }
}
