package Window_package;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Window_for_visilitsa extends JFrame {
    private JLabel label = new JLabel("Слово");
    private JTextField input = new JTextField("", 5);
    private JButton check_button = new JButton("Проверить");//
    private Container container = this.getContentPane();
    Our_Figures x;

    public Window_for_visilitsa() {
        super("Visilitsa");
        setBounds(100, 100, 250, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(input);
        check_button.addActionListener(new ButtonEventListener());
        container.add(check_button);
        container.add(label);
    }

    public void addOurFigures(Our_Figures x) {
        this.x = x;
    }

    /*@Override
    public void paint(Graphics g) {
        g.setColor(x.getcolor());
        g.fillRect(100, 100, 100, 20);
    }
*/

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText(input.getText());
            String message = "";
            message += "Working";
            message += "Text is" + label.getText();
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}