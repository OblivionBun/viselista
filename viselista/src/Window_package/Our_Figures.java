package Window_package;
import java.awt.*;
public class Our_Figures {
    private Color color;
    private int type;
    private String text;
    Our_Figures(Color color, int type, String text){
        this.color = color;
        this.text = text;
        this.type = type;
    }
    public void paint_our_figures(Graphics g){
        g.getColor(color);
        g.fill

    }
}
