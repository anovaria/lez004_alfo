/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Anagrafica> contatti = new ArrayList<>();
        contatti.add(new Anagrafica("Fabio", "Rossi", 33));
        contatti.add(new Anagrafica("Luigi", "Bianchi", 24));
        contatti.add(new Anagrafica("Mario", "Neri", 66));
        contatti.add(new Anagrafica("Fabio", "Verdi", 56));
        ordinaParametro(contatti);
        ArrayList<Calciatore> calciatori = new ArrayList<>();
        calciatori.add(new Calciatore("Attaccante", 1000, "Cristiano", "Ronaldi", 33));
        calciatori.add(new Calciatore("Difensore", 9999, "Paulo", "Angelo", 36));
        calciatori.add(new Calciatore("Centrocampista", 9000, "Paulo", "Angelo", 36));
        calciatori.add(new Calciatore("Difensore", 10000, "Anghel", "LoFazio", 42));
        ordinaParametro(calciatori);
        System.out.println(calciatori);
    }

    /**
     * ordina lista con bubble sort
     *
     * @param list
     */
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

class Anagrafica implements Comparable<Anagrafica>{

    String nome, cognome;
    int eta;

    public Anagrafica(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    /**
     * numero < 0 se sono piu piccolo, 0 se sono uguale, numero > se sono piu
     * grande
     *
     * @param a
     * @return
     */
    int confrontaCon(Anagrafica a) {
        if (this.eta == a.eta) {
            return 0;
        } else if (this.eta > a.eta) {
            return 1;
        }
        return -1;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.cognome);
        hash = 79 * hash + this.eta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anagrafica other = (Anagrafica) obj;
        if (this.eta != other.eta) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Anagrafica " + "nome:" + nome + ", cognome:" + cognome + ", eta:" + eta + "\n";
    }

    @Override
    public int compareTo(Anagrafica t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class Calciatore extends Anagrafica {

    String ruolo;
    int valutazione;

    public Calciatore(String ruolo, int valutazione, String nome, String cognome, int eta) {
        super(nome, cognome, eta);
        this.ruolo = ruolo;
        this.valutazione = valutazione;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Calciatore" + "ruolo:" + ruolo + ", valutazione:" + valutazione +"\n";
    }

    @Override
    int confrontaCon(Anagrafica a) {
        if (a instanceof Calciatore) {
            Calciatore calciatore = (Calciatore) a;

            if (this.valutazione == calciatore.valutazione) {
                return 0;
            } else if (this.valutazione > calciatore.valutazione) {
                return 1;
            }

        }
        return -1;
    }
}