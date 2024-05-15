
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolabonomi
 */
public class Resoconto {
    String nome;
    HashMap<String, ResocontoProdotti> menu;
    public Resoconto(String nome) {
        this.nome = nome;
        this.menu = new HashMap<>();
    }
    public void aggiungiOggetto(String codice, ResocontoProdotti prodotto) {
        menu.put(codice, prodotto);
    }
    public boolean contieneOggetto(String codice) {
        return menu.containsKey(codice);
    }
}
