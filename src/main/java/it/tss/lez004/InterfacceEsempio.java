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
    private static void ordina(ArrayList<Sortable> list) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                Sortable corrente = list.get(i);
                Sortable successiva = list.get(i + 1);
                if (corrente.confrontaCon(successiva) > 0) {
                    list.set(i, successiva);
                    list.set(i + 1, corrente);
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }
}
interface Sortable<T>{
   int confrontaCon(T o);
}
class Computer implements Sortable<Computer>{
int ram;

    public Computer(int ram) {
        this.ram = ram;
    }

    @Override
    public int confrontaCon(Computer o) {
        if(this.ram==o.ram){
            return 0;
        } else if(this.ram>o.ram){
             return 1;
        }
    return 0;
    }
   
}
