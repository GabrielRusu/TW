import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadFunctionality extends Functionality implements ActionListener{
    JSpinner spinner;

    public ReadFunctionality(CatalogList catalogList, List<JTextField> textField, JSpinner spinner) {
        super(catalogList, textField);
        this.spinner = spinner;
    }

    public void actionPerformed (ActionEvent actionEvent) {
        List<String> list = new ArrayList<>();
        String page = spinner.getValue().toString();
        DBManager manager = null;
        try {
            manager = new DBManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < getTextField().size(); i++) {
            list.add(getTextField().get(i).getText());
        }

        String huge = null;
        try {
            assert manager != null;
            huge = manager.show(list, page);
        } catch (SQLException e) {
            huge = ">          " + e.getMessage();
        }

        String[] separated = huge.split(">");
        getCatalogList().clear();
        getCatalogList().addItem("Cluster     |     District     |     Municip     |     Activity     |     Item     |     Total     |     Units");

        for (int i = 0; i < separated.length; i++) {
            getCatalogList().addItem(separated[i]);
        }

    }
}
