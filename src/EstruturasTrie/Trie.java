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
    private NoTernario raiz;
    private ArrayList<Documento> documentos;
    
    public void insereDocumento(Documento d){
        if(this.documentos == null){
            this.documentos = new ArrayList<Documento>();
        }
        this.documentos.add(d);
    }        
    public Documento getIndex(int i){
        return this.documentos.get(i);
    }
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
    
    
    public Trie() {
        raiz = new NoTernario();
    }

    //Insere uma palavra
    public void insere(String palavra) {
        if (palavra != null && !palavra.isEmpty()){
            //chama o insere passando a raiz
            insere(palavra, 0, raiz);
        }
    }

    private NoTernario insere(String palavra, int posicao, NoTernario no) {
        char ch = palavra.charAt(posicao);
        //Nó não existe
        if (no == null){
            no = new NoTernario(ch);
        }
        
        if (ch < no.letra){
            no.esquerda = insere(palavra, posicao, no.esquerda);
        }
        else if (ch > no.letra){
            no.direita = insere(palavra, posicao, no.direita);
        }
        else if (posicao < palavra.length() - 1){
            no.meio = insere(palavra, posicao + 1, no.meio);
        }
        else{
            no.folha = true;
        }
        return no;
    }
    
    public boolean contido(String palavra) {
        //Palavra vazia ou null
        if (palavra == null || palavra.isEmpty()){
            return false;
        }
        
        return contido(palavra, 0, raiz);
    }

    private boolean contido(String word, int index, NoTernario node) {
        if (node == null){
            return false;
        }
        char ch = word.charAt(index);
        if (ch < node.letra){
            return contido(word, index, node.esquerda);
        }
        if (ch > node.letra){
            return contido(word, index, node.direita);
        }
        if (index < word.length() - 1){
            return contido(word, index + 1, node.meio);
        }
        return node.folha;
    }

    
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()){
            return false;
        }
        return startsWith(prefix, 0, raiz);
    }

    private boolean startsWith(String prefix, int index, NoTernario node) {
        if (node == null){
            return false;
        }
        char ch = prefix.charAt(index);
        if (ch < node.letra){
            return startsWith(prefix, index, node.esquerda);
        }
        if (ch > node.letra){
            return startsWith(prefix, index, node.direita);
        }
        if (index == prefix.length() - 1){
            return true;
        }
        return startsWith(prefix, index + 1, node.meio);
    }
}

