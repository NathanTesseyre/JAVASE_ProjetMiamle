package modeles;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author nathan
 */
public class App extends JFrame {

    private Selecteur selector;
    private JPanel currentEventPanel;
    private JTextArea currentEventContent;

    public App() {
        this(new HashMap<LocalDate, Event>(), "Miamle");
    }

    public App(HashMap<LocalDate, Event> e, String title) {
        super(title);
        this.currentEventPanel = new JPanel();
        Map.Entry<LocalDate, Event> entry = e.entrySet().iterator().next();
        currentEventContent = new JTextArea(entry.getValue().consoleFormat());
        this.selector = new Selecteur(e, currentEventContent);
        this.currentEventContent.setEditable(false);
        this.currentEventPanel.add(currentEventContent);
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.add(this.selector, BorderLayout.NORTH);
        this.add(this.currentEventPanel, BorderLayout.CENTER);
        //this.pack();
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
