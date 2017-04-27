
import javax.swing.*;

public class CatalogList extends JList<String> {

    DefaultListModel model = new DefaultListModel<>();

    public CatalogList() {
        //this.setBorder(BorderFactory.createTitledBorder("Catalog Items"));
        this.setModel(model);
    }

    public void addItem(String item) {
        model.addElement(item);
    }

    public void clear() {
        model = new DefaultListModel<>();
        this.setModel(model);
    }

    @Override
    public DefaultListModel getModel() {
        return model;
    }
}
