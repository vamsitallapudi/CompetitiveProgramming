
package contests.Leetcode.contest_461;

public class TrionicArray {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i =1;
        if(n <3) return false;
        
        while(i< n && nums[i] > nums[i-1]) {
            i++;
        }
        if(i == 1 || i == n) return false;

        while(i<n && nums[i] < nums[i-1]) {
            i++;
        }
        if(i <= 2 || i==n) return false;
        while(i< n  && nums[i] > nums[i-1]) {
            i++;
        }
        if(i!=n) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new TrionicArray().isTrionic(new int[] {1,3,5,4,2,6}));
    }
}
