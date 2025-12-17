package projet.voyagevoyage;

import projet.voyagevoyage.classes.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Destination dest = new Destination(1, "bengladesh", "Bordeaux City");
        Vol vol = new Vol(1, "InchallaSaVol", LocalDate.now(), LocalDate.now().plusDays(37), 800);
        Hotel hotel = new Hotel(1, "Hotel Ynoved", "23 rue du omg jsui dans la sauce pour la poo", 1400);

        Voyage voyage = new Voyage(1, "Vroum Vroum", "Séjour complet", dest, vol, hotel);
        Client client = new Client(1, "Abdel", "Matteo", "john@exemple.com");

        Reservation res = new Reservation(1, client, voyage, LocalDate.now(), 22);

        System.out.println("Prix voyage : " + voyage.calculerPrixTotal());
        System.out.println("Prix réservation : " + res.calculerPrixTotal());
    }
}
