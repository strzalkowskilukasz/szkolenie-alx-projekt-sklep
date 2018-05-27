package controller;

import model.Dron;
import model.Komputer;
import model.Sklep;
import pliki.OperacjePlikowe;
import pliki.PlikiBinarne;
import pliki.PlikiJson;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

//    public long id = 0L;

    public void wyswietlMenu(){

        //odczyt z pliku
        Scanner scanner = new Scanner(System.in);

        OperacjePlikowe pliki;

        System.out.println("Jakie pliki chcesz wczytać?");
        System.out.println("1- pliki binarne");
        System.out.println("2- pliki json");
        String wyborOdczytuPlikow = scanner.next();
        switch (wyborOdczytuPlikow){
            case "1" :
            pliki = new PlikiBinarne();
                break;
            case "2" :
            pliki = new PlikiJson();
                break;
            default:
            pliki = new PlikiJson();
                break;
        }

        Sklep sklep;
        try {
            sklep = pliki.wczytaj();
        } catch (Exception e) {
            System.out.println("Blad odczytu, starujemy z pustym plikiem.");
            e.printStackTrace();
            sklep = new Sklep("amazon.com");
        }



        String wybor;
        String wyborDodanie;

        System.out.println("1- dodaj produkt");
        System.out.println("2- usun produkt");
        System.out.println("3- wyswietl liste produktow");
        System.out.println("4- wyswietl posortowana liste produktow po cenie");
        System.out.println("5- wyswietl posortowana liste produktow po nazwie");
        System.out.println("q- wyjdz");

        do {

        System.out.print("Podaj wybor lub (L)ista poleceń: ");
        wybor = scanner.next();
            switch (wybor) {
                case "1":

                    do {
                        System.out.println("Jaki produkt chcesz dodać? ");
                        System.out.println("1- Komputer ");
                        System.out.println("2- Dron");
                        wyborDodanie = scanner.next();

                        switch (wyborDodanie) {
                            case "1":
                            System.out.print("Podaj nazwe komputera: ");
                            String nazwa = scanner.next();
                            System.out.print("Podaj markę komputera: ");
                            String marka = scanner.next();
                            System.out.print("Podaj ilość ramu: ");
                            int ram = scanner.nextInt();
                            System.out.print("Podaj cenę komputera: ");
                            BigDecimal cena = scanner.nextBigDecimal();
                            scanner.nextLine();
//                        if (id == 0) { // zamiast generatoraID
//                        System.out.print("Podaj ID komputera: ");
//                            id = scanner.nextLong();
//                        } else
//                            id++;
                            Komputer komputer = new Komputer(nazwa, cena, marka, ram);
                            sklep.dodaj(komputer);

                            break;
                            case "2":
                                System.out.print("Podaj nazwe drona: ");
                                nazwa = scanner.next();
                                System.out.print("Podaj markę drona: ");
                                marka = scanner.next();
                                System.out.print("Podaj zasięg drona: ");
                                double zasieg = scanner.nextDouble();
                                System.out.println("Czy dron ma kamerę? T/N");
                                String czyMa = scanner.next();
                                boolean czyMaKamere;
                                if (czyMa.equalsIgnoreCase("T")){
                                    czyMaKamere = true;
                                } else {
                                    czyMaKamere = false;
                                }
                                System.out.print("Podaj cenę drona: ");
                                cena = scanner.nextBigDecimal();
                                scanner.nextLine();

                                Dron dron = new Dron(nazwa, cena, zasieg, czyMaKamere);
                                sklep.dodaj(dron);

                                break;
                        }
                        System.out.println("Chcesz dodać kolejny produkt? T/N");
                        wyborDodanie = scanner.next();
                    } while (wyborDodanie.equalsIgnoreCase("T"));

                    break;
                case "2":
                        do {
                            System.out.print("Podaj numer id komputera, który chcesz usunąć: ");
                            long id = scanner.nextLong();
                            sklep.usun(id);

                            System.out.println("Chcesz usunąć kolejny komputer? T/N");
                            wyborDodanie = scanner.next();
                        } while (wyborDodanie.equalsIgnoreCase("T"));

                    break;
                case "3":
                        sklep.wyswietl();

                    break;
                case "4":
                    sklep.wyswietlPosortowaneCenowo();

                    break;
                    case "5":
                    sklep.wyswietlPosortowanePoNazwie();

                    break;

                case "q":
                case "Q":                           // Jeśli dwa case po soboie to albo albo
                    System.out.println("Koniec");
                    // zapis do pliku
                    try {
                        pliki.zapisz(sklep);
                    } catch (Exception e) {
                        System.out.println("Blad zapisu do pliku");
                        e.printStackTrace();
                    }
                    break;
                case "l":
                case "L":
                    System.out.println("1- dodaj komputer");
                    System.out.println("2- usun komputer");
                    System.out.println("3- wyswietl liste komputerow");
                    System.out.println("q- wyjdz");

                    break;
                default:
                    System.out.println("Podałeś bledna opcje, sprobuj jeszcze raz");
            }
        } while (!wybor.equalsIgnoreCase("q"));
    }
}
