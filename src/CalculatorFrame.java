import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

/**
 * Created by Cedi on 10.11.14.
 */
public class CalculatorFrame extends Frame implements ActionListener
{
    private final int BUTTON_PLUS = 0;
    private final int BUTTON_MINUS = 1;
    private final int BUTTON_MAL = 2;
    private final int BUTTON_GETEILT = 3;

    private final int LABEL_TITLE = 0;
    private final int LABEL_NUMBER1 = 1;
    private final int LABEL_NUMBER2 = 2;
    private final int LABEL_NUMBER3 = 3;

    private final int TEXTFIELD_NUMBER1 = 0;
    private final int TEXTFIELD_NUMBER2 = 1;

    private Button[] buttons = new Button[15];
    private Label[] labels = new Label[4];
    private TextField[] textFields = new TextField[2];

    /**
     * Calculator erstellen
     */
    public CalculatorFrame()
    {
        super("Calculator Frame");

        initalizeButtons();
        inizalizeLabels();
        initalizeTextFields();

        // Pannels erstellen
        Panel panelNorth = new Panel(new FlowLayout(FlowLayout.CENTER));
        add(panelNorth, BorderLayout.NORTH);

        Panel panelSouth = new Panel(new GridLayout(1, 4));
        add(panelSouth, BorderLayout.SOUTH);

        Panel panelCenter = new Panel(new GridLayout(3, 1));
        add(panelCenter, BorderLayout.CENTER);

        Panel panelCenterRow1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        panelCenter.add((panelCenterRow1));

        Panel panelCenterRow2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        panelCenter.add((panelCenterRow2));

        Panel panelCenterRow3 = new Panel(new FlowLayout(FlowLayout.LEFT));
        panelCenter.add((panelCenterRow3));

        // Buttons setzen
        panelSouth.add(buttons[BUTTON_MAL]);
        panelSouth.add(buttons[BUTTON_GETEILT]);
        panelSouth.add(buttons[BUTTON_PLUS]);
        panelSouth.add(buttons[BUTTON_MINUS]);

        // Zahlen
        panelCenterRow1.add(labels[LABEL_NUMBER1]);
        panelCenterRow1.add(textFields[TEXTFIELD_NUMBER1]);

        panelCenterRow2.add(labels[LABEL_NUMBER2]);
        panelCenterRow2.add(textFields[TEXTFIELD_NUMBER2]);

        panelCenterRow3.add(labels[LABEL_NUMBER3]);

        // Titel setzen
        panelNorth.add(labels[LABEL_TITLE]);
    }

    private void initalizeTextFields() {
        for(int idx = textFields.length -1; idx > -1; idx--)
        {
            switch(idx)
            {
                case TEXTFIELD_NUMBER1:
                    textFields[idx] = new TextField(20);
                    break;

                case TEXTFIELD_NUMBER2:
                    textFields[idx] = new TextField(20);
                    break;
            }
        }
    }

    private void inizalizeLabels() {
        for(int idx = labels.length -1; idx > -1; idx--)
        {
            switch(idx)
            {
                case LABEL_TITLE:
                    labels[idx] = new Label("Calculator");
                    labels[idx].setFont(new Font("Arial", Font.BOLD, 16));
                    break;

                case LABEL_NUMBER1:
                    labels[idx] = new Label("1. Zahl");
                    break;

                case LABEL_NUMBER2:
                    labels[idx] = new Label("2. Zahl");
                    break;

                case LABEL_NUMBER3:
                    labels[idx] = new Label("                  ");
                    break;
            }
        }
    }

    private void initalizeButtons() {
        // Buttons erstellen
        for(int idx = buttons.length -1; idx > -1; idx--)
        {
            switch(idx)
            {
                case BUTTON_GETEILT:
                    buttons[idx] = new Button("/");
                    break;

                case BUTTON_MAL:
                    buttons[idx] = new Button("*");
                    break;

                case BUTTON_MINUS:
                    buttons[idx] = new Button("-");
                    break;

                case BUTTON_PLUS:
                    buttons[idx] = new Button("+");
                    break;
            }

            if(buttons[idx] != null)
                buttons[idx].addActionListener(this);
        }
    }

    /**
     * Taschenrechner anzeigen
     */
    public void showCalculator()
    {
        setSize(500, 250);
        setVisible(true);
    }

    /**
     * Klicks auf Buttons abfangen
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            double result = 0;
            double zahl1 = Double.parseDouble(textFields[TEXTFIELD_NUMBER1].getText());
            double zahl2 = Double.parseDouble(textFields[TEXTFIELD_NUMBER2].getText());

            if (e.getSource() == buttons[BUTTON_PLUS]) {
                result = zahl1 + zahl2;
            }
            if (e.getSource() == buttons[BUTTON_MINUS]) {
                result = zahl1 - zahl2;
            }
            if (e.getSource() == buttons[BUTTON_MAL]) {
                result = zahl1 * zahl2;
            }
            if (e.getSource() == buttons[BUTTON_GETEILT]) {
                result = zahl1 / zahl2;
            }

            labels[LABEL_NUMBER3].setText("" + result);
        }
        catch(Exception ex)
        {
            labels[LABEL_NUMBER3].setText(ex.getMessage());
        }
    }
}
