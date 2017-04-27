import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CreateFunctionality extends Functionality implements ActionListener{

    public CreateFunctionality(CatalogList catalogList, List<JTextField> textField) {

        super(catalogList, textField);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        List<String> list = new ArrayList<>();
        DBManager manager = null;
        try {
            manager = new DBManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < getTextField().size(); i++) {
            list.add(getTextField().get(i).getText());
        }

        String huge = null;
        try {
            assert manager != null;
            huge = manager.insert(list);
        } catch (SQLException e) {
            huge = ">          " + e.getMessage();
        }

        String[] separated = huge.split(">");
        getCatalogList().clear();

        //getCatalogList().addItem("Cluster     |     District     |     Municip     |     Activity     |     Item     |     Total     |     Units");

        getCatalogList().addItem(huge);

    }

}
