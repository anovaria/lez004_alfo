/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class InterfacceEsempio {
    public static void main(String[] args) {
        Sortable s;
        List<Computer> c = new ArrayList<>();
    }
    private static <T extends Sortable> void ordina(ArrayList<T> list) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                T corrente = list.get(i);
                T successiva = list.get(i + 1);
                if (corrente.confrontaCon(successiva) > 0) {
                    list.set(i, successiva);
                    list.set(i + 1, corrente);
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }
}
interface Sortable{
   int confrontaCon(Object o);
}
class Computer implements Sortable{

    @Override
    public int confrontaCon(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
