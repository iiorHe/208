import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.*;
class temp
{
	public static int[] FindDuplicates(int[] ...a) //varargs for array types
	{
        //Collapsing int array of all array arguments
        int[] fullarr = Stream.of(a)//Streaming the sequence of values from array "a"
        .flatMapToInt(IntStream::of)//returns an IntStream consisting of the results
        //of replacing each element of this stream with the contents of a mapped stream
        .toArray();//Coverting all elements of Stream to an array
        //Hashsets don't allow for duplicate values, so we create 2 of them:
        //1 for all the ordinary values of the input array,
        //2 for storing duplicate numbers. Since it's also a HashSet, if we have values which repeat more than twice
        //they don't get stored.
        HashSet<Integer> hCheckSet = new HashSet<>();
        HashSet<Integer> hTargetSet = new HashSet<>();
        for (Integer intvalue : fullarr) {
         if(!hCheckSet.add(intvalue)) {
            hTargetSet.add(intvalue);
         }
        }
        
        //Streaming values from Hashset of duplicates, mapping them as integers, and returning them as an array
        int[] result = hTargetSet.stream().mapToInt(Number::intValue).toArray();
        Arrays.sort(result);
        return result;
	}

	public static void main(String args[])
	{
		int[] a = new int[100];
        int[] b = new int[100];
        int[] c = new int[100];
        int[] d = new int[100];
        int[] e = new int[100];
        for (int i = 0; i <  a.length; i++) {
            a[i] = (int)(Math.random() * 1000);
        }
        for (int i = 0; i <  b.length; i++) {
            b[i] = (int)(Math.random() * 1000);
        }
        for (int i = 0; i <  c.length; i++) {
            c[i] = (int)(Math.random() * 1000);
        }
        for (int i = 0; i <  d.length; i++) {
            d[i] = (int)(Math.random() * 1000);
        }
        for (int i = 0; i <  e.length; i++) {
            e[i] = (int)(Math.random() * 1000);
        }
        int[] res = FindDuplicates(a,b,c,d,e);
        System.out.println(res.hashCode());
        // System.out.println("Duplicate values are:");
        // for(int i = 0; i < res.length; i++){
        //     System.out.println(res[i]);
        // }
    };
}

