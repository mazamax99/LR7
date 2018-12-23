import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class swingGUI {
    private JTable jTabPeople;

    public swingGUI() {
        List<Student> students = new ArrayList<>();
        tableModel model = new tableModel(students);
        jTabPeople = new JTable(model);
        JLabel textLabel=new JLabel("ФИО");
        JLabel groupLabel=new JLabel("Группа");
        JLabel markLabel=new JLabel("Средний бал");
        JTextField textName=new JTextField();
        JTextField textGroup=new JTextField();
        JTextField textMark=new JTextField();
        JCheckBox chName= new JCheckBox("ФИО");
        chName.setSelected(true);
        chName.addActionListener(e -> {
            TableColumn col1 = jTabPeople.getColumnModel().getColumn(0);
            if (!chName.isSelected()) {
                col1.setMaxWidth(0);
            }
            if(chName.isSelected()){
                col1.setMaxWidth(200);
                col1.setWidth(200);
                col1.setPreferredWidth(200);
                col1.setMaxWidth(200);
            }
        });

        JCheckBox chGroup= new JCheckBox("Группа");
        chGroup.setSelected(true);
        chGroup.addActionListener(e -> {
            TableColumn col2 = jTabPeople.getColumnModel().getColumn(1);
            if (!chGroup.isSelected()) {
                col2.setMaxWidth(0);
            }
            if(chGroup.isSelected()){
                col2.setMaxWidth(200);
                col2.setWidth(200);
                col2.setPreferredWidth(200);
                col2.setMaxWidth(200);
            }
        });
        JCheckBox chMark= new JCheckBox("Средний");
        chMark.setSelected(true);
        chMark.addActionListener(e -> {
            TableColumn col3 = jTabPeople.getColumnModel().getColumn(2);
            if (!chMark.isSelected()) {
                col3.setMaxWidth(0);
            }
            if(chMark.isSelected()){
                col3.setMaxWidth(200);
                col3.setWidth(200);
                col3.setPreferredWidth(200);
                col3.setMaxWidth(200);
            }
        });
        JFrame jfrm = new JFrame("Студенты");
        GridLayout layout = new GridLayout(4, 4, -1, -1);
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(1000, 170);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton addData = new JButton("Добавить");
        addData.addActionListener(event -> {
            students.add(new Student(textName.getText(), textGroup.getText(), Integer.parseInt(textMark.getText())));
            jTabPeople.updateUI();});
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(500, 200));

        JPanel cmpn=new JPanel(layout);
        cmpn.add(textLabel);
        cmpn.add(textName);
        cmpn.add(chName);
        cmpn.add(groupLabel);
        cmpn.add(textGroup);
        cmpn.add(chGroup);
        cmpn.add(markLabel);;
        cmpn.add(textMark);
        cmpn.add(chMark);


        jfrm.getContentPane().add(jscrlp);
        jfrm.add(cmpn);
        jfrm.add(addData);
        jfrm.pack();
        jfrm.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new swingGUI());
    }
}