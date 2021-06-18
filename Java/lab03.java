import java.util.ArrayList;
import java.util.Scanner;
class Professor{
    //Default fields
    String fname;
    String mname;
    String lname;
    ArrayList<Course> courses;

    public Professor(String fname, String mname, String lname){
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        courses = new ArrayList<Course>();
    }

    @Override
    public String toString() {
    return (fname + " " + mname + " " + lname);
    }
    void printCourses(){ //Print courses method
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i).toString());
        }
    }
}
class Course{
    String name;
    int year;
    ArrayList<Course.Lesson> lessons;
    Course.Group group;

    public Course(String name, int year){
        this.name = name;
        this.year = year;
        lessons = new ArrayList<Course.Lesson>();
    }

    @Override
    public String toString() {
        return year + " " + name + " " + sumHours() + " hours";
    }

    float sumHours(){ //Sum course hours method
        return (int)Math.floor((double)(lessons.size() * 8/6));
    }

    //ANCHOR ---------------- INNER CLASS LESSON ----------------

    class Lesson {
        String type;
        ArrayList<Boolean> attendance;
        ArrayList<Integer> grades;
        Course.Group aGroup = group;
        public Lesson(String type){
            this.type = type;
            attendance = new ArrayList<Boolean>();
            grades = new ArrayList<Integer>();
            for (int i = 0; i < aGroup.students.size(); i++) {
                attendance.add(false);
                grades.add(0);
            }
        }
        void PrintLesson(){ //Print Lesson Details Method
            System.out.println("Lesson type: " + type);
            for (int i = 0; i < attendance.size(); i++) {
                System.out.printf("%-3s",i);
                System.out.printf("%-50s",aGroup.students.get(i).toString());
                System.out.println(" " + grades.get(i) + " " + attendance.get(i));
            }
        }
        void sortedPrint(){
            int[] sGrades = grades.stream().mapToInt(i -> i).toArray();
            int n = sGrades.length;
            int[] order = new int[n];
            for (int k = 0; k < order.length; k++) {
                order[k] = k;
            }
             //Reverse bubble sort
            for(int i=0; i < n; i++)
                for(int j=1; j < (n-i); j++)
                    if(sGrades[j-1] < sGrades[j])
                    {
                        int temp = sGrades[j-1];
                        sGrades[j-1] = sGrades[j];
                        sGrades[j] = temp;

                        int temp2 = order[j-1];
                        order[j-1] = order[j];
                        order[j] = temp2;
                    }
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("|");System.out.printf("%-2s","I"); System.out.print("|");
            System.out.printf("%-50s","ID, First Middle Last Names");
            System.out.printf("%-5s","Grade ");System.out.printf("%-15s %n","Attendance");
            System.out.println("-----------------------------------------------------------------------");
            for (int i = 0; i < sGrades.length; i++) {
                System.out.print("|");System.out.printf("%-2s",order[i]); System.out.print("|");
                System.out.printf("%-52s",aGroup.students.get(order[i]).toString());
                System.out.printf("%-6s",sGrades[i]);System.out.printf("%-15s %n",attendance.get(order[i]));
            }
        }
    }

    //ANCHOR ---------------- GROUP & STUDENT INNER CLASSES ----------------

    class Group{
        int id;
        ArrayList<Group.Student> students;

        public Group(int id){
            this.id = id;
            students = new ArrayList<Group.Student>();
        }

        void printStudents(){ //Print all students in group
            System.out.print("|");System.out.printf("%-2s","I"); System.out.print("|");
            System.out.printf("%-50s","ID, First Middle Last Names");
            System.out.printf("%-5s %n","Grade Sum ");
            System.out.println("-----------------------------------------------------------------------");
            for (int i = 0; i < students.size(); i++) {
                System.out.print("|");System.out.printf("%-2s",i);System.out.print("|");
                System.out.printf("%-52s",students.get(i).toString());
                System.out.printf("%-6s %n",students.get(i).sumGrade());
            }
        }
        void printRating(){
            int arrSum[] = new int[group.students.size()];
            int n = arrSum.length;
            for (int i = 0; i < group.students.size(); i++) {
                System.out.println(students.get(i) + " " + students.get(i).sumGrade());
                arrSum[i] = group.students.get(i).sumGrade(); 
            }
            int order[] = new int[group.students.size()];
            for (int k = 0; k < order.length; k++) {
                order[k] = k;
            }
             //Reverse bubble sort
            for(int i=0; i < n; i++)
                for(int j=1; j < (n-i); j++)
                    if(arrSum[j-1] < arrSum[j])
                    {
                        int temp = arrSum[j-1];
                        arrSum[j-1] = arrSum[j];
                        arrSum[j] = temp;

                        int temp2 = order[j-1];
                        order[j-1] = order[j];
                        order[j] = temp2;
                    }
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("|");System.out.printf("%-2s","I"); System.out.print("|");
            System.out.printf("%-50s","ID, First Middle Last Names");
            System.out.printf("%-5s %n","Grade Sum ");
            System.out.println("-----------------------------------------------------------------------");
            for (int i = 0; i < arrSum.length; i++) {
                System.out.print("|");System.out.printf("%-2s",order[i]); System.out.print("|");
                System.out.printf("%-52s",group.students.get(order[i]).toString());
                System.out.printf("%-6s %n",arrSum[i]);
            }
        }
        class Student{
            int id;
            String fname;
            String mname;
            String lname;

            public Student(int id, String fname, String mname, String lname){
                this.id = id;
                this.fname = fname;
                this.mname = mname;
                this.lname = lname;
            }

            @Override
            public String toString() {
            return (id + " " + fname + " " + mname + " " + lname);
            }

            void printStats(){ //Print Group Stats Method
                for (int i = 0; i < lessons.size(); i++) {
                    for (int j = 0; j < lessons.get(i).aGroup.students.size(); j++) {
                        if(lessons.get(i).aGroup.students.get(j).id == id){
                            System.out.printf("%-3s",i);
                            System.out.printf("%-50s",lessons.get(i).aGroup.students.get(j).toString());
                            System.out.println(" " + lessons.get(i).grades.get(j) + " " + lessons.get(i).attendance.get(j));

                        }
                    }
                }
                System.out.println("Grade sum: " + sumGrade());
            }
            int sumGrade(){ //Sum Grade Method
                int sum = 0;
                for (int i = 0; i < lessons.size(); i++) {
                    for (int j = 0; j < lessons.get(i).aGroup.students.size(); j++) {
                        if(lessons.get(i).aGroup.students.get(j).id == id){
                            sum = sum + lessons.get(i).grades.get(j);
                        }
                    }
                }
                return sum;
            }
        }
    }
    void listLessons(){ //Print list of Lessons Method
        for (int i = 0; i < lessons.size(); i++) { //Formatted printing for available lessons
            System.out.printf("%-3s",i);
            System.out.printf("%-7s",group.id);
            System.out.printf("%-15s %n",lessons.get(i).type);
        }
    }
}

public class Lab03{
    public static void main(String[] args) {

        //ANCHOR ---------------- DECLARING DATA ----------------
        Professor prof1 = new Professor("Yuriy", "Oleksiyovych", "Nezdoliy");
        Professor prof2 = new Professor("Jordan", "Samuel", "Peterson");
        Course oopCourse = new Course("Object-Oriented Programming", 2021);
        oopCourse.group = oopCourse.new Group(208);
        oopCourse.group.students.add(oopCourse.group.new Student(1910801, "Yuriy", "Sergiyovych", "Afonin"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910802, "Bogdan", "Anatoliyovych", "Bankov"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910803, "Ilya", "Viktorovych", "Belevyat"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910804, "Yevheniy", "Valeriyovych", "Biba"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910805, "Daniyil", "Kostyantynovych", "Bilosvit"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910806, "Dmitro", "Pavlovych", "Horodov"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910807, "Volodymyr", "Igorovych", "Demiraki"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910808, "Maxim", "Andriyovich", "Deriy"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910809, "Vitaliy", "Ivanovych", "Dyminskiy"));
        oopCourse.group.students.add(oopCourse.group.new Student(1910810, "Vladislav", "Vitaliyovych", "Dobrinov"));

        Course philCourse = new Course("Philosophy", 2020);
        philCourse.group = philCourse.new Group(225);
        philCourse.group.students.add(philCourse.group.new Student(1722501, "Adam", "Collin", "Abrams"));
        philCourse.group.students.add(philCourse.group.new Student(1722502, "Joshua", "Michael", "Kennedy"));
        philCourse.group.students.add(philCourse.group.new Student(1722503, "Taylor", "Reagan", "Booker"));
        philCourse.group.students.add(philCourse.group.new Student(1722504, "Maurice", "Finley", "Hudson"));
        philCourse.group.students.add(philCourse.group.new Student(1722505, "Hayden", "Elliot", "Whitaker"));
        philCourse.lessons.add(philCourse.new Lesson("Lecture"));


        oopCourse.lessons.add( oopCourse.new Lesson("Lecture")); //ANCHOR ---------------- PRINT LESSON ----------------
        oopCourse.lessons.get(0).grades.set(0, 5);
        oopCourse.lessons.get(0).grades.set(1, 8);
        oopCourse.lessons.get(0).grades.set(2, 3);
        oopCourse.lessons.get(0).grades.set(3, 9);
        oopCourse.lessons.get(0).grades.set(4, 7);
        oopCourse.lessons.get(0).grades.set(5, 5);
        oopCourse.lessons.get(0).grades.set(6, 5);
        oopCourse.lessons.get(0).grades.set(7, 2);
        oopCourse.lessons.get(0).grades.set(8, 1);
        oopCourse.lessons.get(0).grades.set(9, 10);
        oopCourse.lessons.add( oopCourse.new Lesson("Practical")); //ANCHOR ---------------- PRINT LESSON ----------------
        oopCourse.lessons.get(1).grades.set(0, 5);
        oopCourse.lessons.get(1).grades.set(1, 8);
        oopCourse.lessons.get(1).grades.set(2, 3);
        oopCourse.lessons.get(1).grades.set(3, 9);
        oopCourse.lessons.get(1).grades.set(4, 7);
        oopCourse.lessons.get(1).grades.set(5, 5);
        oopCourse.lessons.get(1).grades.set(6, 5);
        oopCourse.lessons.get(1).grades.set(7, 2);
        oopCourse.lessons.get(1).grades.set(8, 1);
        oopCourse.lessons.get(1).grades.set(9, 10);

        prof1.courses.add(oopCourse);
        prof2.courses.add(philCourse);

        //ANCHOR ---------------- PROGRAM LOOP ----------------
        ArrayList<Professor> profs = new ArrayList<Professor>();
        profs.add(prof1);
        profs.add(prof2);
        boolean mLoop;
        boolean inLoop1;
        boolean inLoop2;
        boolean outLoop;
        Scanner userInput = new Scanner(System.in);
        do{
            outLoop = true;
            System.out.println("|||| Petro Mohyla Black Sea National University Grading System ||||");
            System.out.println("Available profiles:");
            for (int i = 0; i < profs.size(); i++) {
                System.out.println(i + " " + profs.get(i).toString());
            }
            System.out.println("Enter profile:");
            int login = userInput.nextInt();
            System.out.println("Logged in as: " + profs.get(login).toString());
            System.out.println("Available courses:");
            for (int i = 0; i < profs.get(login).courses.size(); i++) {
                System.out.println(i + " " + profs.get(login).courses.get(i).toString());
            }
            System.out.println("Enter course:");
            int cSelection = userInput.nextInt();
            do{
                mLoop = true;
                System.out.println("1: Print info\t2: Modify values\t3: Add Lesson\t4: Quit");
                switch(userInput.nextInt()){
                    case 1:
                        do{
                            inLoop1 = true;
                            System.out.println("1: Course\t2: Group\t3: Student\t4: Lesson\t5: Back");
                            switch(userInput.nextInt()){
                                case 1:
                                    System.out.println(profs.get(login).courses.get(cSelection));
                                    profs.get(login).courses.get(cSelection).listLessons();
                                break;
                                case 2:
                                    System.out.println("1: Indexed Group Stats\t2: Sorted Group Stats");
                                    switch(userInput.nextInt()){
                                        case 1:
                                            profs.get(login).courses.get(cSelection).group.printStudents();
                                            break;
                                        case 2:
                                            profs.get(login).courses.get(cSelection).group.printRating();
                                            break;
                                    }
                                break;
                                case 3:
                                    System.out.println("Enter Student Index:");
                                    profs.get(login).courses.get(cSelection).group.students.get(userInput.nextInt()).printStats();
                                break;
                                case 4:
                                    System.out.println("1: Indexed Lesson Stats\t2: Sorted Lesson Stats");
                                        switch(userInput.nextInt()){
                                            case 1:
                                                System.out.println("Enter Lesson index:");
                                                profs.get(login).courses.get(cSelection).lessons.get(userInput.nextInt()).PrintLesson();
                                            break;
                                            case 2:
                                                System.out.println("Enter Lesson index:");
                                                profs.get(login).courses.get(cSelection).lessons.get(userInput.nextInt()).sortedPrint();
                                            break;
                                        }
                                    break;
                                case 5:
                                    inLoop1 = false;
                            }
                            
                        }while(inLoop1 != false);
                        break;
                    case 2:
                        do{
                            inLoop2 = true;
                            profs.get(login).courses.get(cSelection).listLessons();
                            System.out.println("Select a lesson: ");
                            int selection = userInput.nextInt();
                            profs.get(login).courses.get(cSelection).lessons.get(selection).PrintLesson();
                            System.out.println("Select index to modify");
                            int selectiontwo = userInput.nextInt();
                            System.out.println("Type in grade value:");
                            int inputgrade = userInput.nextInt();
                            System.out.println("... now input attendance:");
                            boolean inputattendance = userInput.nextBoolean();
                            profs.get(login).courses.get(cSelection).lessons.get(selection).grades.set(selectiontwo, inputgrade);
                            profs.get(login).courses.get(cSelection).lessons.get(selection).attendance.set(selectiontwo, inputattendance);
                            System.out.println("Type false if you'd like to stop");
                            boolean confirmExit = userInput.nextBoolean();
                            if(confirmExit == false) break;
                        }while(inLoop2 != false);
                        break;
                    case 3:
                        System.out.println("1: Lecture\t2: Practical");
                        switch(userInput.nextInt()){
                            case 1:
                                profs.get(login).courses.get(cSelection).lessons.add(profs.get(login).courses.get(cSelection).new Lesson("Lecture"));
                                break;
                            case 2:
                                profs.get(login).courses.get(cSelection).lessons.add(profs.get(login).courses.get(cSelection).new Lesson("Practical"));
                                break;
                        }
                        break;
                    case 4:
                    mLoop = false;
                }
            }while(mLoop != false);
            System.out.println("Would you like to continue? Type false to quit out, true to change profiles");
            boolean confirmLogOut = userInput.nextBoolean();
            if(confirmLogOut == false) outLoop = false;;
        }while(outLoop != false);
        userInput.close();
    }
}
