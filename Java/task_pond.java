public class task2 {
    public static void FindPond(int[] height){
        int res = 0;
        int firstborder = 0;
        int secondborder = 0;
        for (int searchwidth = 1; searchwidth < height.length; searchwidth++) {
            for (int i = 0; i < (height.length - searchwidth); i++) {
                firstborder = height[i];
                secondborder = height[i+searchwidth];
                if(firstborder >= secondborder){
                    if(res < secondborder * searchwidth){
                        res = secondborder * searchwidth;
                    }
                }
                else{
                    if(res < firstborder * searchwidth){
                        res = firstborder * searchwidth;
                    }
                }

            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int[] intarr = {9,4,2,1,1,1,1,1,1,1,1,1,6,2,7,11,1,9};
        FindPond(intarr);
    }
}
