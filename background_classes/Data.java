package Time_Table;


import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    private static ArrayList<Teacher>teacherList=new ArrayList<>();
    private static ArrayList<Class>classList=new ArrayList<>();
    private static ArrayList<Subject> subjectList=new ArrayList<>();

    public static ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public static ArrayList<Class> getClassList() {
        return classList;
    }

    public static ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public static void main(String[] args) {
        initialiseObjects();
    }

    public static void initialiseObjects() {
        Subject math=new Subject(false,conv("Math"));
        Subject physics=new Subject(false,conv("Physics"));
        Subject mgh=new Subject(true,conv("MGH"));
        Subject english=new Subject(false,conv("English"));
        Subject geography=new Subject(false,conv("Geography"));
        Subject history=new Subject(false,conv("History"));
        Subject computers=new Subject(true,conv("Computers"));
        Subject ped=new Subject(true,conv("P. Ed"));
        Subject biology=new Subject(true,conv("Biology"));
        Subject chemistry=new Subject(true,conv("Chemistry"));
        subjectList.add(mgh);
        subjectList.add(ped);
        subjectList.add(math);
        subjectList.add(english);
        subjectList.add(geography);
        subjectList.add(history);
        subjectList.add(physics);
        subjectList.add(computers);
        subjectList.add(chemistry);
        subjectList.add(biology);
        for(int i=0;i<50;i++) {
        	int ra=0;
        	int ran=0;
        	int rand=0;
        	while(ra==ran || ra==rand || ran==rand || ra==0 || ran==0 || rand==0) {
        		ra=(int)(Math.random()*10);
        		ran=(int)(Math.random()*10);
                rand=(int)(Math.random()*10);
        	}
        	String s[]={subjectList.get(ra).getName(),subjectList.get(rand).getName(),subjectList.get(ran).getName()};
        	teacherList.add(new Teacher("Teacher "+(i+1),s,new int[] {10,2}));
        	for(int j=0;j<teacherList.get(i).getSubj().length;j++)
        	    addTeacher(teacherList.get(i),teacherList.get(i).getSubj()[j]);
        }
        for(int i=0;i<10;i++)
            teacherList.add(new Teacher("Teacher "+(50+i),new String[]{conv("MGH")},new int[]{10}));
        for(int i=50;i<60;i++)
            addTeacher(teacherList.get(i),conv("MGH"));
        ArrayList<String>sg1=new ArrayList<>();
        ArrayList<Integer>slg1=new ArrayList<>();
        ArrayList<Integer>llg1=new ArrayList<>();
        for(int i=0;i<subjectList.size();i++)
            sg1.add(subjectList.get(i).getName());
        slg1.add(1000);llg1.add(8);//Math
        slg1.add(1000);llg1.add(8);//English
        slg1.add(1000);llg1.add(4);//Geography
        slg1.add(1000);llg1.add(3);//History
        slg1.add(1000);llg1.add(5);//Physics
        slg1.add(1000);llg1.add(4);//Computers
        slg1.add(1000);llg1.add(6);//MGH
        slg1.add(1000);llg1.add(5);//Chemistry
        slg1.add(1000);llg1.add(4);//Biology
        slg1.add(1000);llg1.add(3);//Physical Education

//        slg1.add(8);llg1.add(8);//Math
//        slg1.add(8);llg1.add(8);//English
//        slg1.add(4);llg1.add(4);//Geography
//        slg1.add(3);llg1.add(3);//History
//        slg1.add(5);llg1.add(5);//Physics
//        slg1.add(4);llg1.add(4);//Computers
//        slg1.add(6);llg1.add(6);//MGH
//        slg1.add(5);llg1.add(5);//Chemistry
//        slg1.add(4);llg1.add(4);//Biology
//        slg1.add(3);llg1.add(3);//Physical Education
//        for(int i=0;i<10;i++)
//        	slg1.add(1000);
//        for(int i=0;i<10;i++)
//            llg1.add(0);
        Grade g1=new Grade(10,sg1,slg1,llg1);
        for(int i=0;i<7;i++) {
            classList.add(new Class(g1, (char) (65 + i)));
        }
        System.out.println(g1.getSubjectsList().size());
        System.out.println(g1.getSubjectLimit().size());
    }
    
    public static String conv(String s) {
    	s=s.trim();
        for(int i=0;i<(20-s.length());i++) {
    		s+=" ";
    	}
    	return s;
    }

    public static void addTeacher(Teacher t, String s){
        for(int i=0;i<subjectList.size();i++){
            if(s.equals(subjectList.get(i).getName()))
                subjectList.get(i).addTeacher(t);
        }
    }

    public static int getTeacherIndex(String t){
        for(int i=0;i<teacherList.size();i++){
            if(t.equals(teacherList.get(i).getName()))
                return i;
        }
        return -1;
    }

    public static Subject getSubject(String s){
        for(int i=0;i<subjectList.size();i++){
            if(s.equals(subjectList.get(i).getName()))
                return subjectList.get(i);
        }
        return null;
    }

    public static ArrayList<Class> getClasses(int g){
        ArrayList<Class> classes = new ArrayList<>();
        for(int i=0;i<classList.size();i++){
            if(classList.get(i).getGrade().getGrade()==g)
                classes.add(classList.get(i));
        }
        return classes;
    }
}

