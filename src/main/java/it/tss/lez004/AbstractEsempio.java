/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class AbstractEsempio {

    public static void main(String[] args) {
        Ordinabile x = new Ordinabile() {
            @Override
            public int confrontaCon(Object o) {
                return 0;

            }
        };

    }
    private static <T extends Anagrafica> void ordinaParametro(ArrayList<T> list) {
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

abstract class Ordinabile {

    public abstract int confrontaCon(Object o);
}

class Veicolo extends Ordinabile {

    int anno;

    @Override
    public int confrontaCon(Object o) {
        if (o instanceof Veicolo) {
            Veicolo veicolo = (Veicolo) o;
            if (this.anno > veicolo.anno) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("Tipo errato");

    }

}

class Phone extends Ordinabile {

    int num;

    @Override
    public int confrontaCon(Object o) {
        if (o instanceof Phone) {
            Phone phone = (Phone) o;
            if (this.num > 0) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("Tipo errato");

    }

}
