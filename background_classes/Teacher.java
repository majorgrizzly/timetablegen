package Time_Table;

import java.util.ArrayList;

public class Teacher {

    private String name;
    private String sub[];
    private ArrayList<Teacher_Day>days=new ArrayList<>(5);
    private int[]range;

    Teacher(String n, String s[],int []r){
        name=n;
        sub=s;
        range=r;
        for(int i=1;i<=5;i++)
        	days.add(new Teacher_Day(i,name));
    }
    
    public ArrayList<Teacher_Day>getDays(){
    	return days;
    }
    
    public boolean isInRange(int g) {
    	for(int i=0;i<range.length;i++) {
    		if(g==range[i])
    			return true;
    	}
    	return false;
    }
    
    public String getName() {
        return name;
    }

    public String getSub(int i) {
        return sub[i];
    }

    public String[] getSubj(){
        return sub;
    }

    public int subjectNumber(String s){
        for(int i=0;i<sub.length;i++){
            if(sub[i]==s)
                return (i+1);
        }
        return 0;
    }

    public void reset(){
        for(int i=0;i<5;i++)
            days.get(i).reset();
    }
}

