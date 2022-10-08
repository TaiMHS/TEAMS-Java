import java.io.Serializable;


public class Course implements Serializable, Cloneable {

    //Subject (course), teacher, and grade should be imported already
    private String current;
    private String coursename;
    private int Grade;
    private Teacher teacher;
    

    
    public Course clone() {
        try {
           return (Course) super.clone();
        } 
        catch (Exception e) {
            
        }
        return null;
    }

    // This constructor is meant for temporary use in Student.java, do not remove
    public Course(String Course_Name){
        coursename = Course_Name;
        current = "";
        Grade = 0;
        teacher = new Teacher("", 0);
    }

    public Course(String Course_Name, Teacher Course_Teacher){
        coursename = Course_Name;
        current = "";
        Grade = 0;
        teacher = Course_Teacher;
    }

    public Course(String Course_Name, String Class_Taken, int Student_Grade, Teacher Teacher){
        coursename = Course_Name;
        current = Class_Taken;
        Grade = Student_Grade;
        teacher = Teacher;
    }

    public int getGrade(){
        return Grade;
    }

    public void setGrade(int New_Grade){
        Grade = New_Grade;
    }

    public String getCurrent(){
        return current;
    }

    public void setCurrent(String Current){
        current = Current;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void setTeacher(Teacher New_Teacher){
        teacher = New_Teacher;
    }

    public String toString(){
        
        return coursename+" by "+teacher+" Grade: "+Grade;
    }

}