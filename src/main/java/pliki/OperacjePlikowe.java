package pliki;

import model.Sklep;

public interface OperacjePlikowe {

    public abstract void zapisz(Sklep sklep) throws Exception;
    Sklep wczytaj() throws Exception;
}
