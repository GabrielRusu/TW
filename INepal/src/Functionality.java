import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Functionality {
    private CatalogList catalogList;
    private List<JTextField> textField = new ArrayList<>();

    public Functionality(CatalogList catalogList, List<JTextField> textField) {
        this.catalogList = catalogList;
        this.textField = textField;
    }

    public CatalogList getCatalogList() {
        return catalogList;
    }

    public List<JTextField> getTextField() {
        return textField;
    }

}
