package Time_Table;

import java.util.ArrayList;

public class Teacher_Day extends Days{
	
	private ArrayList<String>classTaught=new ArrayList<String>(10);
	private int classes;
    private boolean [] isBusy;
    private String tname;
    
    Teacher_Day(int i, String name){
    	super(i);
    	classes=0;
        isBusy= new boolean[]{false, false, false, false, false, false, false, false, false, false};
        tname=name;
        for(int j=0;j<10;j++)
            classTaught.add("");
    }
    
    public boolean getIsBusy(int i){
        if(classes>7){
            return true;
        }
        return isBusy[i];
    }
    
    public int getClasses() {
        return classes;
    }

    public ArrayList<String> getClassTaught() {
        return classTaught;
    }
    
    public void addClass(int i,String s){
        classTaught.set(i,s);
    }

    public void addSubjectsTaught(int i,String s){
        subjects.set(i,s);
    }
    
    public void setBusy(int i) {
        isBusy[i] = true;
    }
    
    public void addOccupied(){
        classes++;
    }
    
    public String toString() {
    	String s=name+","+tname+":";
        for(int i=0;i<classTaught.size();i++)
            s+="Period "+(i+1)+": "+classTaught.get(i)+" - "+subjects.get(i)+"\n";
        return s;
    }

    public void reset(){
        for(int j=0;j<10;j++)
            classTaught.set(j,"");
        for(int j=0;j<isBusy.length;j++)
            isBusy[j]=false;
        for(int j=0;j<10;j++)
            subjects.set(j,"");
        classes = 0;
    }
}

