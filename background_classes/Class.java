package Time_Table;

import java.util.ArrayList;

public class Class {

	private Grade grade;
    private char division;
    private ArrayList<Class_Day>days=new ArrayList<>(5);
    private ArrayList<String>teachers=new ArrayList<>();
    private ArrayList<Integer>subs=new ArrayList<>();

    Class(Grade g,char d){
    	grade=g;
    	division=d;
        for(int i=1;i<=5;i++)
        	days.add(new Class_Day(i,grade,division));
        for(int i=0;i<grade.getSubjectsList().size();i++)
			teachers.add("");
        for(int i=0;i<grade.getSubjectsList().size();i++)
        	subs.add(0);
    }
    
    public ArrayList<Class_Day>getDays(){
    	return days;
    }

    public Grade getGrade() {
    	return grade;
    }
   
    public char getDivision() {
    	return division;
    }

    public ArrayList<Integer> getSubs(){
    	return subs;
	}
    
    public void addToSubject(String s){
    	for(int i=0;i<grade.getSubjectsList().size();i++){
    		if(s.equals(grade.getSubjectsList().get(i)))
    			subs.set(i,subs.get(i)+1);
		}
	}

	public int getSubInt(String s){
		for(int i=0;i<grade.getSubjectsList().size();i++) {
			if(s.equals(grade.getSubjectsList().get(i)))
				return subs.get(i);
		}
		return -1;
	}

	public boolean isWeeklySubjectLimitReached(String s) {
    	int count=0;
    	for(int i=0;i<5;i++) {
    		for(int j=0;j<grade.getSubjectsList().size();j++) {
    			if(grade.getSubjectsList().get(j).equals(s))
    				count+=days.get(i).getSub().get(j);
    		}
    	}
    	for(int i=0;i<grade.getSubjectsList().size();i++) {
    		if(grade.getSubjectsList().get(i).equals(s)) {
    			if(grade.getSubjectLimit().get(i) <= count)
    				return true;
    		}
    	}
    	return false;
    }

	public boolean isLowerSubjectLimitReached() {
		for(int k=0;k<grade.getSubjectsList().size();k++) {
			String s = grade.getSubjectsList().get(k);
			int count = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < grade.getSubjectsList().size(); j++) {
					if (grade.getSubjectsList().get(j).equals(s))
						count += days.get(i).getSub().get(j);
				}
			}
			for (int i = 0; i < grade.getSubjectsList().size(); i++) {
				if (grade.getSubjectsList().get(i).equals(s)) {
					if (grade.getLowerLimit().get(i) >= count)
						return false;
				}
			}
		}
		return true;
	}

	public ArrayList<String> getTeachers() {
		return teachers;
	}

	public boolean isTeacherAssigned(String t){
		for(int i=0;i<teachers.size();i++){
			if(t.equals(teachers.get(i))){
				return true;
			}
		}
		return false;
	}

	public void assignSubjectTeacher(String s, String t){
    	for(int i=0;i<grade.getSubjectsList().size();i++){
    		if(s.equals(grade.getSubjectsList().get(i))){
    			teachers.set(i,t);
			}
		}
	}

	public boolean isSubjectAssigned(String s){
    	for(int i=0;i<grade.getSubjectsList().size();i++){
    		if(s.equals(grade.getSubjectsList().get(i)))
    			if(!teachers.get(i).equals(""))
    				return true;
		}
    	return false;
	}

	public String getSubjectTeacher(String s){
		for(int i=0;i<grade.getSubjectsList().size();i++) {
			if (s.equals(grade.getSubjectsList().get(i)))
				return teachers.get(i);
		}
		return "";
	}

	public void reset(){
		for(int i=0;i<5;i++)
			days.get(i).reset();
		for(int i=0;i<teachers.size();i++)
			teachers.set(i,"");
		for(int i=0;i<subs.size();i++)
			subs.set(i,0);
    }
}
