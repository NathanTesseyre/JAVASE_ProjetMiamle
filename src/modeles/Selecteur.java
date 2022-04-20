/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeles;

import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author nathan
 */
public class Selecteur extends JComboBox {

    private JTextArea printedEvent;
    private HashMap<LocalDate, Event> allEvents;

    public Selecteur() {
        super();
    }

    public Selecteur(HashMap<LocalDate, Event> tab, JTextArea affichage) {
        super();
        printedEvent = affichage;
        this.allEvents = tab;
        init();
    }

    private void init() {
        for (Map.Entry mapentry : allEvents.entrySet()) {
            this.addItem(mapentry.getKey());
        }
        this.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                this.printedEvent.setText(allEvents.get(this.getSelectedItem()).consoleFormat());
            }
        });
    }

}
