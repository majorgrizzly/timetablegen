package Time_Table;

import java.util.ArrayList;

public class Grade {

	private int grade;
	private ArrayList<String>subjectsList=new ArrayList<>();
	private ArrayList<Integer>subjectLimit=new ArrayList<>();
	private ArrayList<Integer>lowerLimit=new ArrayList<>();

	Grade(int g,ArrayList<String>subject,ArrayList<Integer>subjectLimitList,ArrayList<Integer>lowerLimitList){
		grade=g;
		subjectsList.addAll(subject);
		subjectLimit.addAll(subjectLimitList);
		lowerLimit.addAll(lowerLimitList);
	}
	
	public boolean isInGradeSubject(String s) {
		for(int i=0;i<subjectsList.size();i++) {
			if(s.equals(subjectsList.get(i)))
				return true;
		}
		return false;
	}
	
	public ArrayList<String> getSubjectsList(){
		return subjectsList;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public ArrayList<Integer> getSubjectLimit(){
		return subjectLimit;
	}

	public ArrayList<Integer> getLowerLimit() {
		return lowerLimit;
	}

	public int getSubjectLL(String s){
		for(int i=0;i<subjectsList.size();i++){
			if(s.equals(subjectsList.get(i)))
				return lowerLimit.get(i);
		}
		return -1;
	}
}
