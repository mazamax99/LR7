package sample;

public class Student {
    private String id;
    private String name;
    private String group;
    private int mark;

    public Student(String id, String group, int mark) {
        this.id=id;
        this.name = name;
        this.group = group;
        this.mark = mark;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
