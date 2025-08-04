
package contests.Leetcode.contest_461;

public class TrionicArray {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(n < 3) return false; // Need at least 3 elements
        
        int i = 1;
        
        // Phase 1: Find increasing sequence
        while(i < n && nums[i] > nums[i-1]) {
            i++;
        }
        
        // If no increasing part or reached end, not trionic
        if(i == 1 || i == n) return false;
        
        // Phase 2: Find decreasing sequence
        while(i < n && nums[i] < nums[i-1]) {
            i++;
        }
        
        // If no decreasing part or reached end, not trionic
        if(i == n) return false;
        
        // Phase 3: Find increasing sequence again
        while(i < n && nums[i] > nums[i-1]) {
            i++;
        }
        
        // Should have processed all elements
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println(new TrionicArray().isTrionic(new int[] {1,3,5,4,2,6}));
    }
}
