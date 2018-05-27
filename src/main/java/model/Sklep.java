package model;

import java.io.Serializable;
import java.util.*;

public class Sklep implements Serializable {

    //    skladowe
    private Collection<Produkt> produkty;
    private String nazwa;

    public Sklep(){}
    public Sklep(String nazwa) {
        this.produkty = new ArrayList<>();
        this.nazwa = nazwa;
    }
// gettery

    public Collection<Produkt> getProdukty() {
        return produkty;
    }

    public String getNazwa() {
        return nazwa;
    }

    //    metody
    public void dodaj(Produkt produkt) {
        produkty.add(produkt);
    }

    public void usun(long id) {

        Iterator<Produkt> iterator = produkty.iterator();
        while (iterator.hasNext()) {
            Produkt produkt = iterator.next();
            if (produkt.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void wyswietl() {

        for (Produkt temp : produkty) {
            System.out.println(temp);
        }
    }

    public void wyswietlPosortowaneCenowo() {
        List<Produkt> kopiaProdukty = new ArrayList<>(produkty);
        Collections.sort(kopiaProdukty);
        for (Produkt temp : produkty) {
            System.out.println(temp);
        }
    }

    public void wyswietlPosortowanePoNazwie() {
        Comparator<Produkt> nazwaKomparator = new Comparator<Produkt>() {
            @Override
            public int compare(Produkt o1, Produkt o2) {

//                return o1.nazwa.compareTo(o2.nazwa);
                if(o1.nazwa.compareTo(o2.nazwa) > 0){
                    return 1;
                } else if(o1.nazwa.compareTo(o2.nazwa) < 0) {
                    return -1;
                } else
                    return 0;

            }
        };
        List<Produkt> kopiaProdukty = new ArrayList<>(produkty);
        Collections.sort(kopiaProdukty, nazwaKomparator);
        for (Produkt temp : produkty) {
            System.out.println(temp);
        }
    }
}


