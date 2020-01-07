/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class AppRubrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }

    class Rubrica {

        private final List<Contatto> contatti = new ArrayList<>();

        public void add(Contatto t) {
            contatti.add(t);

        }

        public void update(Contatto t) {
            int idx = contatti.indexOf(t);
            if (idx != -1) {
                contatti.set(idx, t);
            }

        }

        public List<Contatto> cerca(String ricerca) {
            return contatti.stream()
                    .filter(c -> c.getNome().contains(ricerca)
                    || c.getMail().contains(ricerca)
                    || c.getTelefono().contains(ricerca))
                    .collect(Collectors.toList());

        }

        public void delete(Contatto t) {
            contatti.remove(t);

        }

        public Contatto find(long id) {

            return contatti.stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .get();
        }

        public void stampa() {
            contatti.stream().forEach(c -> System.out.println(c));
        }
    }

    class Contatto {

        private String nome, mail, telefono;
        private long id;

        public Contatto(String nome, String mail, String telefono, long id) {
            this.nome = nome;
            this.mail = mail;
            this.telefono = telefono;
            this.id = id;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
            final Contatto other = (Contatto) obj;
            if (this.id != other.id) {
                return false;
            }
            return true;
        }
//per rendere immodificabile l' oggetto bisogna non implementare i SET.
        public long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

    }
}

