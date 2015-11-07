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
public class FuncaoHashFactory {

    public enum Funcao {

        MURMUR,DJB2,SDBM,FNV,CRC32,FUNCAOHASHJAVA
    }

    public static InterfaceHash criaHash(Funcao funcao) {

        switch (funcao) {
            case MURMUR:
                return new Murmur();
            case DJB2:
                return new djb2();
            case SDBM:
                return new SDBM();
            case FNV:
                return new FNV();
            case CRC32:
                return new CRC32();     
            case FUNCAOHASHJAVA:
                return new FuncaoHashJava();    
        }

        return null;

    }
}