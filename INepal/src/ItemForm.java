import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ItemForm extends JPanel {

    public ItemForm() {
        this.init();
    }

    private void init() {

        JLabel label1 = new JLabel("Cluster ID");
        this.add(label1, BorderLayout.NORTH);
        JTextField cluster = new JTextField("");
        cluster.setColumns(20);
        this.add(cluster, BorderLayout.NORTH);

        JLabel label2 = new JLabel("District ID");
        this.add(label2, BorderLayout.NORTH);
        JTextField district = new JTextField("");
        district.setColumns(20);
        this.add(district, BorderLayout.NORTH);

        JLabel label3 = new JLabel("Municipality ID");
        this.add(label3, BorderLayout.NORTH);
        JTextField municipality = new JTextField("");
        municipality.setColumns(18);
        this.add(municipality, BorderLayout.NORTH);

        JLabel label4 = new JLabel("Activity");
        this.add(label4, BorderLayout.NORTH);
        JTextField activity = new JTextField("");
        activity.setColumns(20);
        this.add(activity, BorderLayout.NORTH);

        JLabel label5 = new JLabel("Item");
        this.add(label5, BorderLayout.NORTH);
        JTextField item = new JTextField("");
        item.setColumns(22);
        this.add(item, BorderLayout.NORTH);

        JLabel label6 = new JLabel("Total NR");
        this.add(label6, BorderLayout.NORTH);
        JTextField total = new JTextField("");
        total.setColumns(22);
        this.add(total, BorderLayout.NORTH);

        JLabel label7 = new JLabel("Units");
        this.add(label7, BorderLayout.NORTH);
        JTextField units = new JTextField("");
        units.setColumns(20);
        this.add(units, BorderLayout.NORTH);

        JButton insert = new JButton("Insert");
        insert.setForeground(Color.yellow);
        insert.setBackground(Color.BLACK);
        this.add(insert, BorderLayout.CENTER);

        JButton select = new JButton("Select");
        select.setForeground(Color.yellow);
        select.setBackground(Color.BLACK);
        this.add(select, BorderLayout.CENTER);

        JButton update = new JButton("Update");
        update.setForeground(Color.yellow);
        update.setBackground(Color.BLACK);
        this.add(update, BorderLayout.CENTER);

        JButton delete = new JButton("Delete");
        delete.setForeground(Color.yellow);
        delete.setBackground(Color.BLACK);
        this.add(delete, BorderLayout.CENTER);

        JLabel label8 = new JLabel("Page");
        this.add(label8, BorderLayout.NORTH);
        /*JTextField filter = new JTextField("page");
        filter.setColumns(5);
        this.add(filter, BorderLayout.NORTH);*/

        JSpinner year = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        //Component mySpinnerEditor = year.getEditor();
        //JFormattedTextField spinnerStuff = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();
        //spinnerStuff.setColumns(3);
        this.add(year, BorderLayout.NORTH);

        JButton funct = new JButton("FUNCTION");
        funct.setForeground(Color.WHITE);
        funct.setBackground(Color.BLACK);
        this.add(funct, BorderLayout.CENTER);

        JButton funct2 = new JButton("FUNCTION2");
        funct2.setForeground(Color.WHITE);
        funct2.setBackground(Color.BLACK);
        this.add(funct2, BorderLayout.CENTER);

        JButton funct3 = new JButton("FUNCTION3");
        funct3.setForeground(Color.WHITE);
        funct3.setBackground(Color.BLACK);
        this.add(funct3, BorderLayout.CENTER);

////////////////////////////////////////////////////////////////////////////////
        CatalogList l = new CatalogList();

        JScrollPane scrollPane = new JScrollPane(l);
        Dimension d = l.getPreferredScrollableViewportSize();
        d.width = 500;
        d.height = 400;
        scrollPane.setPreferredSize(d);
        this.add(scrollPane, BorderLayout.CENTER);

        List<JTextField> listt = new ArrayList<>();

        listt.add(cluster);
        listt.add(district);
        listt.add(municipality);
        listt.add(activity);
        listt.add(item);
        listt.add(total);
        listt.add(units);

        ReadFunctionality readFunctionality = new ReadFunctionality(l, listt, year);
        select.addActionListener(readFunctionality);

        CreateFunctionality createFunctionality = new CreateFunctionality(l, listt);
        insert.addActionListener(createFunctionality);

        UpdateFunctionality updateFunctionality = new UpdateFunctionality(l, listt);
        update.addActionListener(updateFunctionality);

        DeleteFunctionality deleteFunctionality = new DeleteFunctionality(l, listt);
        delete.addActionListener(deleteFunctionality);

        FunctionFunctionality functionFunctionality = new FunctionFunctionality(l, listt);
        funct.addActionListener(functionFunctionality);

        Function2Functionality function2Functionality = new Function2Functionality(l, listt);
        funct2.addActionListener(function2Functionality);

        Function3Functionality function3Functionality = new Function3Functionality(l, listt);
        funct3.addActionListener(function3Functionality);

    }

}
