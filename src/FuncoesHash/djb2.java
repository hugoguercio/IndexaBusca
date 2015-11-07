/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncoesHash;

/**
 * Hash function based on Bernstein algorithm at: http://www.partow.net/programming/hashfunctions/#DJBHashFunction.
 *
 * @author Arash Partow
 * @author Sergio Bossa
 */
public class djb2 {
    public int hash(String chave, int tamanhoTabela) {
        long hash = doHash(chave);
        return (int) Math.abs(hash) % tamanhoTabela;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    private long doHash(String str) {
        long hash = 5381;

        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) + hash) + str.charAt(i);
        }

        return hash;
    }
}
