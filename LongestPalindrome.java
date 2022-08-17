// Time Complexity : O(N)
// Where N is number of elements in an array
// Space Complexity : O(N)
// Where N is number of elements in a hashmap
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
The Palindrome with even length will always have a character repated in multiples of 2 whereas if the
palindrome is in odd length then expect one character will have multiples of 2 repetitions.

When a character exists in the hashset, we will remove that character and add count as two. After traversing
to all elements, if the hashset has any elements, then it can be odd value. So we add by 1.
 */

class Solution {
    public int longestPalindrome(String s) {

        if(s.length()==1) return 1;

        HashSet<Character> hashset = new HashSet<>();
        char sChar = ' ';
        int count = 0;
        for(int i=0;i<s.length();i++){
            sChar = s.charAt(i);

            if(hashset.contains(sChar)) {
                hashset.remove(sChar);
                count+=2;
            }
            else{
                hashset.add(sChar);
            }
        }

        if(!hashset.isEmpty()){
            count+=1;
        }

        return count;
    }
}