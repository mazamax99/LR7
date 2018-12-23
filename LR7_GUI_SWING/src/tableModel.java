import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class tableModel extends AbstractTableModel{
    private List<Student> students = new ArrayList<>();
    private Set<TableModelListener> listeners = new HashSet<>();

    public tableModel(List<Student> students) {
        super();
        this.students = students;
    }
    public void addStudent(String name, String group, int mark){
        students.add(new Student(name, group, mark));
        //fireTableDataChanged();
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return students.get(r).getName();
            case 1:
                return students.get(r).getGroup();
            case 2:
                return students.get(r).getMark();
            default:
                return "";
        }
    }
    @Override
    public String getColumnName(int c) {
        String result = "";
        switch (c) {
            case 0:
                result = "ФИО";
                break;
            case 1:
                result = "Группа";
                break;
            case 2:
                result = "Средний бал";
                break;
        }
        return result;
    }
}
