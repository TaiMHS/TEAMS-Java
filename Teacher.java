//Believed to be done
import java.util.ArrayList;

public class Teacher {

    private String Name;
    private int YoExp;
    private ArrayList<Course> Classtaught;

    public Teacher(String N,int Y){

        Name = N;
        YoExp = Y;
    }

    public String getName(){
        return Name;
    }

    public void setName(String N){
        Name = N;
    }

    public int getEXP(){
        return YoExp;
    }
    
    public void setEXP(int Y){
        YoExp = Y;
    }

    public void addCourse(Course course){
        Classtaught.add(course);
    }

    public void removeCourse(int index){
        Classtaught.remove(index);
    }

    public String toString(){
        return "Teacher Name: "+Name+" Years of Experience: "+YoExp;
    }
    public static void main(String args[]){
        
    }
}
