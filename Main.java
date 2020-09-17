package Time_Table;

import java.util.*;
import Time_Table.Data;

public class Main {

    static int c = 0;

    public static void main(String[] args) {
        Data.initialiseObjects();
        aVoid();
        for (int d = 0; d < 5; d++) {
            for (int i = 0; i < 7; i++)
                System.out.println(Data.getClassList().get(i).getDays().get(d));
        }

    }

    public static void aVoid(){
        for (int d = 0; d < 5; d++) {
            for (int i = 0; i < Data.getClassList().size(); i++) {
                for (int k = 0; k < 10; k++) {
                    while (!Data.getClassList().get(i).getDays().get(d).getIsOccupied(k)) {
                        if (!Data.getClassList().get(i).getDays().get(d).getIsOccupied(k)) {
                            int j=0;
                            for(int ra=0;ra<Data.getClassList().get(i).getGrade().getSubjectsList().size();ra++) {
                                //ra = (int) (Math.random() * Data.getClassList().get(i).getGrade().getSubjectsList().size());
                                String subject = Data.getClassList().get(i).getGrade().getSubjectsList().get(ra);
                                do {
                                    ArrayList<Integer>randomvals=new ArrayList<>();
                                    int random = (int) (Math.random() * Data.getSubject(subject).getTeachers().size());
                                    if(!isElementOf(randomvals,random)){
                                        randomvals.add(random);
                                        j = Data.getTeacherIndex(Data.getSubject(subject).getTeachers().get(random).getName());
                                    }
                                }while (Data.getClassList().get(i).getDays().get(d).isTeacherLimitReached(Data.getTeacherList().get(j).getName()) || Data.getTeacherList().get(j).getDays().get(d).getIsBusy(k));
                                assignPeriod(i, j, d, k, subject);
//                                System.out.println("ll");
                                int count = 0;
                                ArrayList<ArrayList<Integer>>dkvals=new ArrayList<>();
                                ArrayList<Integer>k1vals=new ArrayList<>();
                                ArrayList<Integer>dk=new ArrayList<>();
                                while (Data.getClassList().get(i).getSubInt(subject) < Data.getClassList().get(i).getGrade().getSubjectLL(subject)) {
                                    if(count<=100000){
                                        int d1 = (int) (Math.random() * Data.getClassList().get(i).getDays().size());
                                        int k1 = (int) (Math.random() * Data.getClassList().get(i).getDays().get(d).getSub().size());
                                        if(!isElementOf(dk,dkvals)){
                                            dk.add(d1);
                                            dk.add(k1);
                                            dkvals.add(dk);
                                            count++;
                                            assignPeriod(i, j, d1, k1, subject);
                                        }
                                    }
                                    else{
                                        c++;
                                        reset();
                                        aVoid();
                                    }
                                    dk.removeAll(dk);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void assignPeriod(int i, int j, int d, int k, String subject) {
        if (!Data.getTeacherList().get(j).getDays().get(d).getIsBusy(k)) {
//            System.out.println("get is busy");
            if (Data.getTeacherList().get(j).isInRange(Data.getClassList().get(i).getGrade().getGrade())) {
//                System.out.println("is in range");
                if (!Data.getClassList().get(i).getDays().get(d).isTeacherLimitReached(Data.getTeacherList().get(j).getName())) {
//                    System.out.println("is teacher limit reached");
                    if (!Data.getClassList().get(i).getDays().get(d).isSubjectLimitReached(subject)) {
//                        System.out.println("is subject limit reached");
                        if (Data.getClassList().get(i).getGrade().isInGradeSubject(subject)) {
//                            System.out.println("is in grade subject");
                            if (!Data.getClassList().get(i).isWeeklySubjectLimitReached(subject)) {
//                                System.out.println();
//                                co++;
//                                System.out.println(co+"is within weekly limit");
//                                System.out.println();
                                if (!Data.getSubject(subject).isAll()) {
                                    if (!Data.getClassList().get(i).isSubjectAssigned(subject)) {
                                        if(!Data.getClassList().get(i).isTeacherAssigned(Data.getTeacherList().get(j).getName())) {
                                            Data.getClassList().get(i).assignSubjectTeacher(subject, Data.getTeacherList().get(j).getName());
                                            Data.getTeacherList().get(j).getDays().get(d).setBusy(k);
                                            Data.getClassList().get(i).getDays().get(d).setIsOccupied(k);
                                            Data.getClassList().get(i).getDays().get(d).addTeacher(k, Data.getTeacherList().get(j).getName());
                                            Data.getTeacherList().get(j).getDays().get(d).addClass(k, Data.getClassList().get(i).getGrade().getGrade() + Data.getClassList().get(i).getDivision() + "");
                                            Data.getTeacherList().get(j).getDays().get(d).addOccupied();
                                            Data.getClassList().get(i).getDays().get(d).addSubject(k, subject);
                                            Data.getClassList().get(i).getDays().get(d).addToSubject(subject);
                                            Data.getTeacherList().get(j).getDays().get(d).addSubjectsTaught(k, subject);
                                            Data.getClassList().get(i).addToSubject(subject);
                                        }
                                    }
                                    else {
                                        j = Data.getTeacherIndex(Data.getClassList().get(i).getSubjectTeacher(subject));
                                        if (!Data.getTeacherList().get(j).getDays().get(d).getIsBusy(k)) {
                                            if (Data.getTeacherList().get(j).isInRange(Data.getClassList().get(i).getGrade().getGrade())) {
                                                if (!Data.getClassList().get(i).getDays().get(d).isTeacherLimitReached(Data.getTeacherList().get(j).getName())) {
                                                    Data.getTeacherList().get(j).getDays().get(d).setBusy(k);
                                                    Data.getClassList().get(i).getDays().get(d).setIsOccupied(k);
                                                    Data.getClassList().get(i).getDays().get(d).addTeacher(k, Data.getTeacherList().get(j).getName());
                                                    Data.getTeacherList().get(j).getDays().get(d).addClass(k, Data.getClassList().get(i).getGrade().getGrade() + Data.getClassList().get(i).getDivision() + "");
                                                    Data.getTeacherList().get(j).getDays().get(d).addOccupied();
                                                    Data.getClassList().get(i).getDays().get(d).addSubject(k, subject);
                                                    Data.getClassList().get(i).getDays().get(d).addToSubject(subject);
                                                    Data.getTeacherList().get(j).getDays().get(d).addSubjectsTaught(k, subject);
                                                    Data.getClassList().get(i).addToSubject(subject);

                                                }
                                            }
                                        }
                                    }
                                }
                                else {
                                    ArrayList<Class> classes = Data.getClasses(Data.getClassList().get(i).getGrade().getGrade());
                                    ArrayList<Teacher> teachers = Data.getSubject(subject).getTeachers();
                                    for (Class aClass : classes) {
                                        int g=0;
                                        ArrayList<Integer>tvals=new ArrayList<>();
                                        while (!aClass.getDays().get(d).getIsOccupied(k)) {
                                            g++;
                                            if (!aClass.getDays().get(d).getIsOccupied(k)) {
                                                int t = (int) (Math.random() * teachers.size());
                                                if(!isElementOf(tvals,t)){
                                                    tvals.add(t);
                                                    if (!teachers.get(t).getDays().get(d).getIsBusy(k)) {
//                                                        System.out.println("get is busy");
//                                                        System.out.println(teachers.size());
//                                                        System.out.println(tvals.size());
                                                        if (teachers.get(t).isInRange(aClass.getGrade().getGrade())) {
//                                                            System.out.println("is in range");
                                                            if (!aClass.getDays().get(d).isTeacherLimitReached(teachers.get(t).getName())) {
//                                                                System.out.println("teacher limit reached");
                                                                if (!aClass.getDays().get(d).isSubjectLimitReached(subject)) {
//                                                                    System.out.println("is subject limit reached");
                                                                    if (aClass.getGrade().isInGradeSubject(subject)) {
//                                                                        System.out.println("is in grade subject");
                                                                        if (!aClass.isWeeklySubjectLimitReached(subject)) {
//                                                                            System.out.println("weekly limit");
                                                                            if (!aClass.isSubjectAssigned(subject)) {
                                                                                if(!aClass.isTeacherAssigned(teachers.get(t).getName())){
                                                                                    aClass.assignSubjectTeacher(subject, teachers.get(t).getName());
                                                                                    teachers.get(t).getDays().get(d).setBusy(k);
                                                                                    aClass.getDays().get(d).setIsOccupied(k);
                                                                                    aClass.getDays().get(d).addTeacher(k, teachers.get(t).getName());
                                                                                    teachers.get(t).getDays().get(d).addClass(k, aClass.getGrade().getGrade() + aClass.getDivision() + "");
                                                                                    teachers.get(t).getDays().get(d).addOccupied();
                                                                                    aClass.getDays().get(d).addSubject(k, subject);
                                                                                    aClass.getDays().get(d).addToSubject(subject);
                                                                                    teachers.get(t).getDays().get(d).addSubjectsTaught(k, subject);
                                                                                    aClass.addToSubject(subject);
                                                                                }
                                                                            }
                                                                            else {
                                                                                j = Data.getTeacherIndex(aClass.getSubjectTeacher(subject));
                                                                                if (!Data.getTeacherList().get(j).getDays().get(d).getIsBusy(k)) {
                                                                                    if (Data.getTeacherList().get(j).isInRange(aClass.getGrade().getGrade())) {
                                                                                        if (!aClass.getDays().get(d).isTeacherLimitReached(Data.getTeacherList().get(j).getName())) {
                                                                                            Data.getTeacherList().get(j).getDays().get(d).setBusy(k);
                                                                                            aClass.getDays().get(d).setIsOccupied(k);
                                                                                            aClass.getDays().get(d).addTeacher(k, Data.getTeacherList().get(j).getName());
                                                                                            Data.getTeacherList().get(j).getDays().get(d).addClass(k, aClass.getGrade().getGrade() + aClass.getDivision() + "");
                                                                                            Data.getTeacherList().get(j).getDays().get(d).addOccupied();
                                                                                            aClass.getDays().get(d).addSubject(k, subject);
                                                                                            aClass.getDays().get(d).addToSubject(subject);
                                                                                            Data.getTeacherList().get(j).getDays().get(d).addSubjectsTaught(k, subject);
                                                                                            aClass.addToSubject(subject);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if(teachers.size()<=tvals.size()){
                                                while(!isComplete()){
                                                    c++;
                                                    try{
//                                                        for (int s = 0; s < 5; s++) {
//                                                            for (int b = 0; b < 7; b++)
//                                                                System.out.println(Data.getClassList().get(b).getDays().get(s));
//                                                        }
                                                        System.out.println("loop restarted "+c);
                                                        reset();
                                                        aVoid();
                                                    }
                                                    catch(StackOverflowError error){
                                                            System.exit(0);
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void reset() {
        for (int i = 0; i < Data.getTeacherList().size(); i++)
            Data.getTeacherList().get(i).reset();
        for (int i = 0; i < Data.getClassList().size(); i++)
            Data.getClassList().get(i).reset();
    }

    public static boolean isLowerLimitReached() {
        for (int i = 0; i < Data.getClassList().size(); i++)
            if (!Data.getClassList().get(i).isLowerSubjectLimitReached())
                return false;
        return true;
    }

    public static boolean isElementOf(ArrayList<Integer>a, int b){
        for(int i=0;i<a.size();i++){
            if(b==a.get(i))
                return true;
        }
        return false;
    }

    public static boolean isElementOf(ArrayList<Integer>b, ArrayList<ArrayList<Integer>>a){
        if(a.size()>0 && b.size()>0){
            for(int i=0;i<a.size();i++){
                if(b.get(0)==a.get(i).get(0)){
                    if(b.get(1)==a.get(i).get(1))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean isComplete(){
        for (int i = 0; i < Data.getClassList().size(); i++) {
//            for(int ra=0;ra<Data.getClassList().get(i).getGrade().getSubjectsList().size();ra++){
//                String subject = Data.getClassList().get(i).getGrade().getSubjectsList().get(ra);
//                if(Data.getClassList().get(i).getSubInt(subject) > Data.getClassList().get(i).getGrade().getSubjectLL(subject))
//                    return false;
//            }
            for(int j = 0;j < Data.getClassList().get(i).getDays().size();j++){
                for(int p=0;p<10;p++){
                    if(Data.getClassList().get(i).getDays().get(j).getIsOccupied(p)==false)
                        return false;
                }
            }
        }
        return true;
    }
}
