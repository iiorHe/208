import java.lang.Math;
public class lab02 {
    //Variant 16: 34,38,50,31,36
    //№34 Створіть метод, який приймає параметр - значення перерахування для місяця, а повертає кількість днів в місяці. Лютий завжди 28
    public static int MonthCount(String month){
        switch (month) {
            case "January": case "March": case "May": case "July": case "August": case "October": case "December":
                return 31;
            case "February":
                return 28;
            case "April": case "June": case "September": case "November":
                return 30;
            default:
                System.out.println("Error! Incorrect month");
                return -1;
        }
    }
    /*№31 Створіть метод який дозволяє фільтрувати елементи будь якого масиву int та виводити ці елементи на консоль.
    Умови фільтрації повинні передаватися в метод як параметр. Використовуйте функціональні інтерфейси та анонимні класи.*/
    public static void ArrayFilter(int[] arr, Filter filter){
        for (int i : arr) {
            if(filter.condition(i)){
                System.out.println(i);
            }
        }
    }
 
    /*№36 Створіть метод, який дозволяє сортувати масив Студентів у відповідності до критерію сортування(за віком, за прізвищем та інше). 
    Масив та критерій сортування  передаються як критерії методу. Сортування реалізувати методом =бульбашки=*/
        public static void ObjFilter(Student[] arr, String field){
		int n = arr.length;
        switch(field){ //Switch case for field selection
            case "age":
            for (int i = 0; i < n-1; i++) 
                for (int j = 0; j < n-i-1; j++) //Comparison to previous element
                    //Integer swap
                    if (arr[j].age > arr[j+1].age) 
                    { 
                        int temp = arr[j].age; 
                        arr[j].age = arr[j+1].age; 
                        arr[j+1].age = temp; 
                    }
            for (int i = 0; i < arr.length; i++){
                System.out.println(arr[i].age);
            }
            break;
            case "fname":
            for (int j = 0; j < arr.length; j++) {
                for (int i = j + 1; i < arr.length; i++) {
                    //Adjacent string comparison using compareTo() method
                    if (arr[i].fname.compareTo(arr[j].fname) < 0) {
                        String temp = arr[j].fname;
                        arr[j].fname = arr[i].fname;
                        arr[i].fname = temp;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++){
                System.out.println(arr[i].fname);
            }
            break;
            case "group":
            for (int i = 0; i < n-1; i++) 
                for (int j = 0; j < n-i-1; j++) //Comparison to previous element
                    //Integer swap
                    if (arr[j].group > arr[j+1].group) 
                    { 
                        int temp = arr[j].group; 
                        arr[j].group = arr[j+1].group; 
                        arr[j+1].group = temp; 
                    }
            for (int i = 0; i < arr.length; i++){
                System.out.println(arr[i].group);
            }
        }

    }

    public static void main(String[] args){
        System.out.println("//////MONTH COUNT//////");
        System.out.println(MonthCount("lel"));
        System.out.println("//////ARRAY FILTER//////");
        int[] testarr = {5,22,67,43,11,9,1};
        ArrayFilter(testarr,new Filter(){
            @Override
            public boolean condition(int val) {
                return val > 10;
            }
        } );
        System.out.println("////////////");
        Student[] obj = new Student[4] ;
        obj[0] = new Student(19,"Dima",108);
        obj[1] = new Student(20,"Yurii",208);
        obj[2] = new Student(18,"Alla",109);
        obj[3] = new Student(21,"Volodimir",308);
        ObjFilter(obj,"fname");
    }
}
//Student class for sorting method
class Student{
    public int age;
    public String fname;
    public int group;
    public Student(int age, String fname, int group){
        this.age = age;
        this.fname = fname;
        this.group = group;
    }

}

interface Filter {
    boolean condition(int val);
}
