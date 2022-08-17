// Time Complexity : O(N)
// Where N is number of elements in an array
// Space Complexity : O(N)
// Where N is number of elements in a hashmap
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
The bruteforce approach would be checking all possibilites and finding whether number of zeros and ones
are equal. However, in bruteforce solution we do have reptition of possbilities which we have computed earlier.
To store those computation, we are using hashmap.

Running sum pattern (a + b = k), suppose assume that the number of 0 elements is a and number of 1 elements is k
So, b would be zero. (a + 0 = k) => (a = k). The number of elements of 0's and 1's should be equal.
 */


class Solution {
    public int findMaxLength(int[] nums) {

        if(nums==null || nums.length<=1) return 0;

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int total = 0;
        int max = 0;
        hashmap.put(total, -1);

        for(int i=0;i<nums.length;i++){

            if(nums[i]==0){
                total -= 1;
            }
            else{
                total += 1;
            }

            if(hashmap.containsKey(total)){
                int prevIndex = hashmap.get(total);
                max = Math.max(max, i - prevIndex);
            }
            else{
                hashmap.put(total, i);
            }
        }

        return max;
    }
}