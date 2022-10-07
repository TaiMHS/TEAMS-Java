//Note to Mr. Perdomo
/*I modified part of the save and load codes to match the naming of the object
 * 
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TEAMS {
    static ArrayList<Teacher> Teachers;
    static ArrayList<Student> Students;
    static ArrayList<Course> Courses;
    static Scanner term;

    public TEAMS(ArrayList<Student> s,ArrayList<Teacher> t,ArrayList<Course> c){
        term = new Scanner(System.in);
        Students = s;
        Teachers = t;
        Courses = c;
    }

    public static ArrayList<Student> Students(){
        return Students;
    }

    public static ArrayList<Teacher> Teachers(){
        return Teachers;
    }

    public static ArrayList<Course> Courses(){
        return Courses;
    }

    public String listTeacher(){
        String tempstring = "";
        for(int i = 0;i < Teachers.size();i++){
            tempstring += (i+1)+": "+Teachers.get(i)+"\n";
        }
        return tempstring;
    }

    public String listStudent(){
        String tempstring = "";
        for(int i = 0;i < Students.size();i++){
            tempstring += (i+1)+": "+Students.get(i)+"\n";
        }
        return tempstring;
    }

    public String listCourses(){
        String tempstring = "";
        for(int i = 0;i < Courses.size();i++){
            tempstring += (i+1)+": "+Courses.get(i)+"\n";
        }
        return tempstring;
    }

    public void Option1(){
        System.out.print("Student Name: ");
        String stuname = term.nextLine();
        System.out.println("Student Grade: ");
        int stugrade = term.nextInt();
        Students().add(new Student(stuname,stugrade));
        System.out.print("Action Completed\n");
    }

    public void Option2(){
        System.out.print("Teacher Name: ");
        String teachname = term.nextLine();
        System.out.println("Teacher's Years of Experience: ");
        int teachexp = term.nextInt();
        Teachers().add(new Teacher(teachname,teachexp));
        System.out.print("Action Completed\n");
    }

    public void Option3(){
        if(Teachers().size() > 0){
            System.out.print("Course Name: ");
            term.nextLine();
            String coursename = term.nextLine();
            System.out.print(this.listTeacher());
            System.out.println("Select Teacher: ");
            int teacherindex = term.nextInt()-1;
            Courses().add(new Course(coursename,Teachers().get(teacherindex)));
            System.out.println("Action Completed\n");
            }
            else{
                System.out.println("Unavailable\n");
            }
    }

    public void Option4(){
        if(Students().size() > 0){
            System.out.print(this.listStudent());
            System.out.println("Select Student: ");
            int studentindex = term.nextInt()-1;
            System.out.println(
                "1: Edit Name\n"+
                "2: Edit Grade\n"+
                "3: Add Courses\n"+
                "4: Remove Courses\n"+
                "5: Edit Courses\n"+
                "Pick an Option: ");
                int StuOption = term.nextInt()-1;
                if(StuOption == 0){/*Edits student name */
                    System.out.println("Enter Name: ");
                    term.nextLine();
                    String nameedit = term.nextLine();
                    Students().get(studentindex).setName(nameedit);
                }
                else if(StuOption == 1){/*Edits student grade */
                    System.out.println("Enter Grade: ");
                    term.nextLine();
                    int gradeedit = term.nextInt();
                    Students().get(studentindex).setGrade(gradeedit);
                }
                else if(StuOption == 2){/*Adds course to student */
                    if(Courses().size() > 0){
                    System.out.println(this.listCourses());
                    System.out.println("Select Course: ");
                    int courseindex = term.nextInt()-1;
                    Course clonedCourse = Courses().get(courseindex).clone();
                    Students().get(studentindex).addCourse(clonedCourse);
                    System.out.println("Action Completed\n");
                    }
                    else{
                        System.out.println("Unavailable\n");
                    }
                }
                else if(StuOption == 3){/*Removes course from student */
                    if(Students().get(studentindex).getCourseSize() > 0){
                        System.out.println(Students().get(studentindex).listCourses());
                        System.out.println("Select Course: ");
                        int courseindex = term.nextInt()-1;
                        Students().get(studentindex).removeCourse(courseindex);
                        System.out.println("Action Completed\n");
                        }
                        else{
                            System.out.println("Unavailable\n");
                        }
                }
                else if(StuOption == 4){/* Edits Courses of student */
                    if(Students().get(studentindex).getCourseSize() > 0){
                        System.out.println(Students().get(studentindex).listCourses());
                        System.out.println("Select Course: ");
                        int courseindex = term.nextInt()-1;
                        Course Tempcourse = Students().get(studentindex).getCourse(courseindex);
                        System.out.println("1: Edit Grade");
                        System.out.println("Select Option: ");
                        int courseoption = term.nextInt()-1;
                        if(courseoption == 0){
                        System.out.println("New Grade: ");
                        int editgrade = term.nextInt();
                        Tempcourse.setGrade(editgrade);
                        System.out.println("Action Completed\n");
                        }
                    }
                    else{
                        System.out.println("Unavailable\n");
                    }
                    
                }
            }
            else{
                System.out.println("Unavailable\n");
            }
    }

    public void Option6(){
        if(Students().size() > 0){
            System.out.println("Enter name: ");
            term.nextLine();
            String search = term.nextLine();
            String tempname = "";
            String tempstring = "";
            for(int i = 0;i < Students().size();i++){
                tempname = Students().get(i).getName();
                if(tempname.contains(search)){
                    tempstring += Students().get(i)+"\n";
                }
            }
            System.out.println(tempstring);
            System.out.println("Action Completed\n");
        }
        else{
            System.out.println("Unavailable\n");
        }
    }

    public void Option7(){
        System.out.println("Exiting Menu...");
        System.out.println("Goodbye!");
        term.close();       
    }

    public static void main(String args[]){
        /*save code? */
        try{
            Students =(ArrayList<Student>)loadData("Students");

        }catch(Exception e){
            Students = new ArrayList<>();
        }
        try{
            Teachers =(ArrayList<Teacher>)loadData("Teachers");
        }catch(Exception e){
            Teachers = new ArrayList<>();
        }
        try{
            Courses =(ArrayList<Course>)loadData("Courses");
        }catch(Exception e){
            Courses = new ArrayList<>();
        }

        TEAMS MagnoliaIsd = new TEAMS(Students, Teachers, Courses);



        boolean menu = true;

        Scanner term = new Scanner(System.in);

        while(menu){
            System.out.print(
                "1: Add Student\n"+
                "2: Add Teacher\n"+
                "3: Add Course\n"+
                "4: Edit Student\n"+
                "5: List Students\n"+
                "6: List Courses\n"+
                "7: Search for Student\n"+
                "8: Exit\n"+
                "Pick an option: "
            );
            int Option = term.nextInt()-1;

            if(Option == 0){ /*Adds a new student WIP */
                MagnoliaIsd.Option1();
            }
            else if(Option == 1){/*Adds a new teacher WIP */
                MagnoliaIsd.Option2();
            }
            else if(Option == 2){/*Adds a new course WIP */
                MagnoliaIsd.Option3();
            }
            else if(Option == 3){/*Edits student's profile */
                MagnoliaIsd.Option4();
            }
            else if(Option == 4){/*Lists the students in TEAMS */
                System.out.print(MagnoliaIsd.listStudent());
            }
            else if(Option == 5){/*Lists the courses in TEAMS */
                System.out.print(MagnoliaIsd.listCourses()+"\n");
            }
            else if(Option == 6){/*Searches the students in TEAMS by name */
                MagnoliaIsd.Option6();
            }
            else if(Option == 7){/*Exits menu */
                try{

                    saveData();
                        
                }catch(Exception e){}
                MagnoliaIsd.Option7();
                menu = false;
                term.close();
            }

        }
    }

    public static void saveData()throws Exception{
        FileOutputStream f1 = new FileOutputStream("Students");
        ObjectOutputStream os = new ObjectOutputStream(f1);
        os.writeObject(Students);
        os.close();
        f1.close();

        FileOutputStream f2 = new FileOutputStream("Courses");
        os = new ObjectOutputStream(f2);
        os.writeObject(Courses);
        os.close();
        f2.close();

        FileOutputStream f3 = new FileOutputStream("Teachers");
        os = new ObjectOutputStream(f3);
        os.writeObject(Teachers);
        os.close();
        f3.close();
    }

    public static Object loadData(String name) throws Exception{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new  ObjectInputStream(fis);   
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}
