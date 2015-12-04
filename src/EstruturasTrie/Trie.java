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
    private int qtdPalavras;
    private ArrayList<Documento> documentos;
    
    
    
    public void insereDocumento(Documento d){
        if(this.documentos == null){
            this.documentos = new ArrayList<Documento>();
        }
        this.documentos.add(d);
    }
}
