package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typ")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Komputer.class, name = "komputer"),
        @JsonSubTypes.Type(value = Dron.class, name = "dron")
})
public abstract class Produkt implements Comparable<Produkt>, Serializable {

    protected String nazwa;
    protected BigDecimal cena;
    protected long id;
    private static long generatorId =0L;

    public Produkt(){}
    public Produkt(String nazwa, BigDecimal cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        generatorId++;
        this.id = generatorId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Produkt o) {
        if(this.cena.compareTo(o.cena) > 0){
            return 1;
        } else if(this.cena.compareTo(o.cena) < 0) {
            return -1;
        } else
        return 0;
    }
}
