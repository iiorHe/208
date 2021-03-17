import java.util.Scanner;
public class lab01{
    //VARIANT 16
    //№5 Створіть метод, який дозволяє видаляти всі елементи в масиві int[] , які мають певне значення, 
    //наприклад дорівнюються 23. Масив без видалених елементів повинен повертатися, як результат роботи методу.
    //Function for removing a value from an array
    public static int[] RemoveArrNum(int[] arr, int num){
        int dcount = 0; //Counter for the numbers of numbers to delete
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                dcount++;
            }
        }
        int[] temparr = new int[arr.length - dcount]; //New array size of original - dcount
        int tempiter = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != num){
                temparr[tempiter] = arr[i];
                tempiter++;
            }
        }
        return temparr;
    }
    //№3 Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число. Метод повинен повертати новий масив.
    public static int[] ChangeArrElement(int[] arr){
        int[] temparr = new int[arr.length];
        int ploop = 1;
        for(int i = 0; i < arr.length; i++){
            temparr[i] = arr[i];
        }
        while(ploop == 1){
            System.out.println("Please enter which element to change: ");
            Scanner PosInput = new Scanner(System.in);
            int pos = PosInput.nextInt();
            System.out.println("Please enter number: ");
            Scanner NumInput = new Scanner(System.in);
            int num = NumInput.nextInt();
            temparr[pos]=num;
            System.out.println("Go again? 1 for YES, 0 for NO: ");
            Scanner LoopInput = new Scanner(System.in);
            ploop = LoopInput.nextInt();
            PosInput.close();
            NumInput.close();
            LoopInput.close();
        }
        return temparr;

    }
    //№27 Створіть метод, який приймає параметр int та конвертує його з десятичної у восьмирічну систему числення
    //та повертає у вигляді String. Приклад- приймає 9, повертає =011=
    //Manually creating the function for converting decimal values to octal
    public static String ToOctal(int decimal){
        int rem;
        String octal="";
        char[] octalchars= {'0','1','2','3','4','5','6','7'};
        while(decimal>0){
            rem=decimal%8;
            octal=octalchars[rem]+octal;
            decimal=decimal/8;
        }
        return octal;
    }
    //№1 Розробіть метод, який дозволяє знайти спільні елементи двох діапазонів цілих чисел, та вивести їх на екран.
    //Приклад - діапазон з 5 до 11 та діапазон з 18 до 9. Спільні елементи- 9,10,11
    //Function for printing out all shared integers between 2 sets of values
    public static void SharedNums(int a, int b, int c, int d){
        if(a > b){
            if(b < d){
                for(int i = a; i < d; i++){
                    System.out.println(i);
                }
            }
            else{
                    for(int i = a; i < c; i++){
                        System.out.println(i);
                    }
            }
        }
        else{
            if(b < d){
                for(int i = b; i < d; i++){
                    System.out.println(i);
                }
            }
            else{
                for(int i = b; i < c; i++){
                    System.out.println(i);
                }
            }
        }
    }
    //№22 Створіть метод, який рахує факторіал числа, використовуючи цикли. 
    //Потім створити ще одну реалізацію, яка використовує рекурсію для вирішення цієї задачі.
    //Linear factorial function
    public static int Lfactorial(int a){
        int limit = a;
        for(int i = 0; i < limit; i++){
            if(i>0){
            a *= i;
            }
        }
        return a;
    }
    //Recurvise factorial function
    public static int Rfactorial(int a){
        if(a <= 1){
            return a;
        }
        else{
            return a*Rfactorial(a-1);
        }
    }
    public static void main(String[] args){
        int num1 = 10;
        System.out.println("//////DECIMAL TO OCTAL//////");
        System.out.println(ToOctal(num1));
        System.out.println(Integer.toOctalString(num1)); //Using the built-in Integer.toOctalString() method of the Integer class
        System.out.println("//////REMOVE ELEMENTS FROM ARRAY//////");
        int[] array1 = {11,33,22,22,33,55,44};
        int[] array2 = RemoveArrNum(array1,11);
        for(int i : array2){
            System.out.println(i);
        }
        System.out.println("//////CHANGE ARRAY//////");
        int[] array3 = ChangeArrElement(array2);
        for(int i : array3){
            System.out.println(i);
        }
        System.out.println("//////PRINT NUM SEQUENCE//////");
        SharedNums(2, 3, 8, 9);
        System.out.println("//////FACTORIALS//////");
        System.out.println(Lfactorial(5));
        System.out.println(Rfactorial(5));
    }
}
