//Array of integers, find a cycle of largest sums  within the array. eg: either positive entire array, or between negative integers
//Realize sorting by using condition and manual method Сортування вручную
//A method, which accepts an n amount of int arrays. Return shared elements that exist in all arrays
//A method, which finds on which story an apartment is located based on it's number and building specifications
//Array of integers, find largest prime number. 2 scores
//array of strings, sort this array by the third character. 2 scores
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class examtask {
    public static boolean isPrime(int n){ //Self-explanatory
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;

        // Check if number is 2
        else if (n == 2)
            return true;

        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    //Function for outputting largest prime number in array
    public static void largestPrime(int ...a){
        int tempPrime = 0;
        for (int i = 0; i < a.length; i++) {
            if(isPrime(a[i])){
                if(tempPrime < a[i]) tempPrime = a[i];
            }
        }
        System.out.println(tempPrime);
    }
    //Sorting array of strings by their third character
    public static String[] thirdCharSort(String ...args){ //Variable arguments
        List<String> input = Arrays.asList(args); //Converting array of String to List
        Collections.sort(input, new Comparator<String>() { //
        @Override
        public int compare(String o1, String o2) {
            return Character.compare(o1.charAt(2), o2.charAt(2));
        }
    });
        String[] output = new String[input.size()];
        output = input.toArray(output);
        return output;
    }
    public static void main(String[] args) { //Main function
        String[] inArrStr = {
            "The","quick","brown","fox","jumped","over","the","lazy","do"
        };
        String[] arrStr = thirdCharSort(inArrStr);
        for (String string : arrStr) {
            System.out.println(string);
        }
        int[] intArr = {2,1,3,41,29,11,127};
        largestPrime(intArr);

    }
}
