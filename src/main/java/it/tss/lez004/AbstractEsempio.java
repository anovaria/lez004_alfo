/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

/**
 *
 * @author tss
 */
public class AbstractEsempio {
    public static void main(String[] args) {
        Ordinabile x = new Ordinabile() {
            @Override
            public int confrontaCon(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    
}
    }
abstract class Ordinabile{
    public abstract int confrontaCon(Object o);
}
class Veicolo extends Ordinabile{
    int anno;
    @Override
    public int confrontaCon(Object o) {
        if(o instanceof Veicolo){
            Veicolo veicolo=(Veicolo)o;
            if(this.anno>veicolo.anno){
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("Tipo errato");
        
    }
    
}
class Phone extends Ordinabile{
int num;
    @Override
    public int confrontaCon(Object o) {
        if(o instanceof Phone){
            Phone phone=(Phone)o;
            if(this.num>0){
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("Tipo errato");
        
       
    }
    
}