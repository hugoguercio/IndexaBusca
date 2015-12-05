/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasTrie;

import EstruturasHashTable.PalavraUnica;

/**
 *
 * @author Qih
 */
public class NoTernario {
    char letra;
    NoTernario esquerda,meio, direita;
    boolean folha;
    PalavraUnica listaDocumentosComPalavra;
    /*
        Construtores    
    */
    public NoTernario() {
    }

    public NoTernario(char val) {
        this.letra = val;
    }
}