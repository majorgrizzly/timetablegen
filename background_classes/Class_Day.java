package Time_Table;

import java.util.ArrayList;

public class Class_Day extends Days{
	
	private ArrayList<String>teacher=new ArrayList<>(10);
	private Grade grade;
	private ArrayList<Integer>sub=new ArrayList<>();
	private char division;
    private boolean[] isOccupied;
	
	Class_Day(int i,Grade grade,char division){
		super(i);
        isOccupied=new boolean[]{false,false,false,false,false,false,false,false,false,false};
        this.grade=grade;
        this.division=division;
        for(int j=0;j<10;j++)
            teacher.add("");
        for(int j=0;j<grade.getSubjectsList().size();j++)
        	sub.add(0);
	}

	public ArrayList<Integer> getSub(){
		return sub;
	}
	
    public void addToSubject(String s){
        for(int i=0;i<grade.getSubjectsList().size();i++) {
        	if(s.equals(grade.getSubjectsList().get(i)))
        		sub.set(i, sub.get(i)+1);
        }
    }
    
    public boolean isTeacherLimitReached(String n) {
        int count=0;
    	for(int i=0;i<teacher.size();i++) {
    		if(teacher.get(i).equals(n))
    			count++;
    	}
    	if(count>=2)
    		return true;
    	else
    		return false;
    }
    
    public boolean isSubjectLimitReached(String s) {
    	for(int i=0;i<grade.getSubjectsList().size();i++) {
        	if(s.equals(grade.getSubjectsList().get(i))){
        		if(sub.get(i)>=2)
        			return true;
        	}
        }
    	return false;
    }

    public void addSubject(int i,String s){
	    subjects.set(i,s);
    }

    public boolean getIsOccupied(int i) {
    	return isOccupied[i];
    }

    public void setIsOccupied(int i) {
        isOccupied[i]=true;
    }

    public void addTeacher(int i,String s){
	    teacher.set(i,s);
    }
    
    public Grade getGrade() {
    	return grade;
    }
	
    @Override
    public String toString() {
        String s=grade.getGrade()+" "+division+" "+name+":\n";
        for(int i=0;i<subjects.size();i++)
            s+="Period "+(i+1)+"\t:\t"+subjects.get(i)+"\tTeacher:\t"+teacher.get(i)+"\n";
        return s;
    }

    public void reset(){
        for(int j=0;j<10;j++)
            teacher.set(j,"");
        for(int j=0;j<grade.getSubjectsList().size();j++)
            sub.set(j,0);
        for(int j=0;j<isOccupied.length;j++)
            isOccupied[j]=false;
        for(int j=0;j<10;j++)
            subjects.set(j,"");
    }
}
