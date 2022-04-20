package miamle;

import modeles.Event;
import modeles.Participant;
import enumerations.Dish;
import java.time.LocalDate;

/**
 *
 * @author Herbert
 */
public class Miamle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Créer un événement
        Event anniv = new Event();
        LocalDate d = LocalDate.of(2022, 9, 10);
        anniv.setDate(d);

        // Créer 2 participants : herbert et alf
        Participant herbert = new Participant("Caffarel", "Herbert");
        Participant alf = new Participant("Danlta", "Alphonse");

        // Ajouter les plats amenés par ces deux personnes à leur liste de plats
        herbert.addDish(Dish.ENTREE, 2);
        herbert.addDish(Dish.PLAT, 2);
        herbert.addDish(Dish.DESSERT, 2);
        herbert.addDish(Dish.BOISSON, 2);
        herbert.setNbPersons(2);

        alf.addDish(Dish.ENTREE, 5);
        alf.addDish(Dish.PLAT, 5);
        alf.addDish(Dish.DESSERT, 3);
        alf.setNbPersons(3);
        alf.setComment("Gourmands");

        // Ajouter ces deux personnes à l'événement
        anniv.addParticipant(alf);
        anniv.addParticipant(herbert);
        anniv.addParticipant(new Participant());

        // Afficher l'événement
        System.out.println(anniv.consoleFormat());

        // Sauvegarder l'événement en texte
        anniv.saveToText("anniv.txt");

        // Récupérer l'événement en texte dans un autre objet
        Event e = Event.loadFromText("anniv.txt");
        // On l'affiche pour voir si c'est la même chose que anniv
        System.out.println("L'événement chargé depuis le fichier texte : ");
        System.out.println(e.consoleFormat());

        // Sauvegarder l'événement en binaire
        anniv.saveToBin("anniv.bin");

        // Restaurer l'anniversaire dans un autre objet
        Event newEvent = Event.loadFromBin("anniv.bin");
        // On l'affiche pour voir si c'est la même chose que anniv
        System.out.println("L'événement chargé depuis le fichier binaire : ");
        System.out.println(newEvent.consoleFormat());
    }

}
