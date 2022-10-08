//Believed to be done

//on top of student add the import java.io.Serializable; and import java.util.ArrayList;
/*There will be at least 3 classes: Teacher, Student, Courses. There may be a potential class called Menu for all the options. Lots of the methods in the other classes will probably be public to be accessed in the menu class' main
 * There is a clone method to be used in course class
 * 
 */


import java.util.ArrayList;


public class Student {
    private String name;
    private int Gradelevel;
    private ArrayList<Course> StuClasses;
    private double GPA; //didn't want to make local variables
    private String FavT;


    public Student(String N,int G){
        name = N;
        Gradelevel = G;
        StuClasses = new ArrayList<Course>();
        GPA = 0;
        FavT = "no one";
        
    }

    public String getName(){
        return name;
    }

    public void setName(String N){
        name = N;
    }

    public int getGrade(){
        return Gradelevel;
    }

    public void setGrade(int G){
        Gradelevel = G;
    }

    public double calculateGPA(){
        double classcount = 0;
        double gradecount = 0;
        for(int i = 0; i < StuClasses.size();i++){
            gradecount += StuClasses.get(i).getGrade();
            classcount++;
        }
        double average = (gradecount/classcount)-70;
        if(average <=0){
            average = 0;
        }
        GPA = (average/30)*4;
        return GPA;

    }

    public Course getBestClass(){
        int tempgrade = 0;
        Course tempclass = new Course("");
        for(int i = 0; i < StuClasses.size(); i++){
            //if the course grade > tempgrade, tempclass = the course and tempgrade = grade of class
            if(StuClasses.get(i).getGrade()> tempgrade){
                tempclass = StuClasses.get(i);
                tempgrade = StuClasses.get(i).getGrade();
            }
        }
        return tempclass;
    }

    public void addCourse(Course Coursename){
        StuClasses.add(Coursename);
    }

    public void removeCourse(int index){
        StuClasses.remove(index);
    }

    public String listCourses(){
        String tempstring = "";
        for(int i = 0;i < StuClasses.size();i++){
            tempstring += (i+1)+": "+StuClasses.get(i)+"\n";
        }
        return tempstring;
    }

    public int getCourseSize(){
        return StuClasses.size();
    }

    public Course getCourse(int courseindex){
        return StuClasses.get(courseindex);
    }

    public void setFavT(String favt){
        FavT = favt;

    }

    public String toString(){
        Course BestClass = this.getBestClass();
        String Coursestr = "";
        double GradePointAvg = this.calculateGPA();
    
        for(int i = 0; i < StuClasses.size();i++){
            Coursestr += StuClasses.get(i)+" Grade: "+StuClasses.get(i).getGrade()+" ";
        }
        
        return "\nName: "+name+"\nGrade: "+Gradelevel+"\nCourses: "+Coursestr+"\nGPA: "+GradePointAvg+"\nBest Class: "+BestClass+"\nFavorite Teacher: "+FavT+"\n";
        
    }

    public static void main(String args[]){
        
    }
}
