package Time_Table;

import java.util.ArrayList;

public class Subject {

    private ArrayList<Teacher>teachers=new ArrayList<>();
    private boolean all;
    private String name;

    Subject(boolean common,String s){
        all=common; //If the subject is to be assigned to all classes at the same time
        name=s;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher t){
        teachers.add(t);
    }

    public boolean isAll() {
        return all;
    }

    public String getName(){
        return name;
    }
}
