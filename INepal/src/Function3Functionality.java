import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Function3Functionality extends Functionality  implements ActionListener {
    public Function3Functionality(CatalogList catalogList, List<JTextField> textField) {
        super(catalogList, textField);
    }

    public void actionPerformed (ActionEvent actionEvent) {
        DBManager manager = null;
        try {
            manager = new DBManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String huge = null;
        try {
            assert manager != null;
            huge = manager.showFunction3();
        } catch (SQLException e) {
            huge = ">          " + e.getMessage();
        }

        String[] separated = huge.split("<");
        getCatalogList().clear();
        //getCatalogList().addItem("Cluster     |     District     |     Municip     |     Activity     |     Item     |     Total     |     Units");

        for (int i = 0; i < separated.length; i++) {
            getCatalogList().addItem(separated[i]);
        }
        getCatalogList().addItem(huge);

    }

}
