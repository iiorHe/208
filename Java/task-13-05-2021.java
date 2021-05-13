public class task3 {
    //Method takes a n amoung of string, return string with most vowels
    public static void MostVowel(String ...input){
        int max = 0;
        int counter = 0;
        int maxindex = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                if(input[i].charAt(j) == 'a' || input[i].charAt(j) == 'e' || input[i].charAt(j) == 'i' || input[i].charAt(j) == 'o' || input[i].charAt(j) == 'u'){
                    counter++;
                }
            }
            if(max < counter){
                max = counter;
                maxindex = i;
            }
            counter = 0;
        }
        System.out.println("Max value of vowels is: " + max + " at " + maxindex);
    }
    public static void main(String[] args){
        String str1 = "aeiou";
        String str2 = "abcd";
        String str3 = "bcde";
        String[] arrstr = {"what","nope","exceptionally"};
        MostVowel(arrstr);
        MostVowel(str1,str2,str3);
    }
}
