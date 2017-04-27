
import javax.swing.*;
import java.awt.*;

public class MediaFrame extends JFrame{

    ItemForm panel;

    protected void frameInit () {
        super.frameInit();
        panel = new ItemForm();

        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();

        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
