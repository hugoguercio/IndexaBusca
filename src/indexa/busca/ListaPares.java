/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexa.busca;

/**
 *
 * @author Qih
 */
public class ListaPares {
    private No cabeça=null;
    
    /*
        Esse método insere pares <doc_id, count> na lista de pares de uma palavra contida na tabela de hash
    */
    public void insereOrdenado(Par par){
        No novo = new No(par);
        //Se a lista está vazia
        if(this.cabeça == null){
            this.cabeça = novo;
        }else{
            No aux = this.cabeça;
            //Acha a posição da lista que o novo par deve ser inserido
            while(aux.getProx() !=null && aux.getPar().getCount()< novo.getPar().getCount()){
                aux = aux.getProx();
            }
            //Par estava no fim da lista
            if(aux.getProx()==null){
                aux.setProx(novo);
                novo.setAnt(aux);
            }else{
                //Par é a cabeça
                if(aux==this.cabeça){
                    this.cabeça = novo;
                    this.cabeça.setProx(aux);
                    aux.setAnt(novo);
                //Par estava no meio da lista
                }else{
                    novo.setProx(aux);
                    novo.setAnt(aux.getAnt());
                    aux.setAnt(novo);
                    novo.getAnt().setProx(novo);
                }
            }
        }
    }
}
