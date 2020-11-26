import java.util.Arrays;
import java.util.HashSet;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 联想
 * Date: 2020-11-15
 * Time: 21:28
 */
public class PaiXu {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a+"."+b);
    }
    static void operate(StringBuffer x,StringBuffer y) {
        x.append(y);
        y = x;
    }
    public static void main21(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i)+"")){
                result.append(str1.charAt(i));
            }

        }
        System.out.println(result);

    }

}
class Solution {
    //颜色交换012，让0全部在前面，1全部在0后面，2全部在1后面，
    public void sortColors(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(i,index,nums);
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(i,index,nums);
                index++;
            }
        }
    }
    public void swap(int i,int index,int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}


class Solution14 {
    //leetcode853车队问题
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || position.length ==0) return 0;

        int[] temp = new int[target];
        for(int i=0;i<position.length;i++){
            temp[position[i]] = speed[i];
        }
        double[] time = new double[position.length];
        Arrays.sort(position);
        for(int i=0;i<time.length;i++){
            int n = position.length -1-i;
            time[i] = (target-position[n])/(1.0*temp[position[n]]);
        }
        int ans = 1;
        for(int i=0;i<time.length-1;i++){
            if(time[i]>=time[i+1]){
                time[i+1] = time[i];
            }else{
                ans++;
            }
        }
        return ans;
    }
}
