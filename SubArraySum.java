// Time Complexity : O(N)
// Where N is number of elements in an array
// Space Complexity : O(N)
// Where N is number of elements in the hashmap
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* The bruteforce approach would be checking all possibilites and taking sum of these two values and checking
whether it is equal to K. The time complexity of this solution would be O(N power 2). When we are checking all the
possibilities, some the possibilites are repeated, we can optimize these repeations by holding the result
at any datastructure. As we might have duplicates in the array, the array elements which are equal to K would
be repeated. So, to store the count of the repeated elements, we are going with hashmap.

We are using Running Sum pattern (a + b = k) => (a - k = b). For every element we would add to "a" and reduce
it by "k", we will check whether this result exists in the hashmap. If not we would add "a" to hashmap.

To simplify, we can assume that we are having multiple pointers.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int result  = 0;
        int rSum = 0;

        hashmap.put(rSum,1);

        for(int i=0;i<nums.length;i++){
            rSum += nums[i];

            if(hashmap.containsKey(rSum - k)){
                result += hashmap.get(rSum - k);
            }

            if(!hashmap.containsKey(rSum)){
                hashmap.put(rSum, 0);
            }
            hashmap.put(rSum, hashmap.get(rSum)+1);
        }

        return result;
    }
}


