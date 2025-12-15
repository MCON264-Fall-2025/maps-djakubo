package hashmap_exercises;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * Example:
 * Input:  ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();
        for(String string: strs){

            //Convert string into canonical form
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            //if bucket does not exist create a new bucket
            if(!anagrams.containsKey(key)){
                List<String> list = new ArrayList<>();
                anagrams.put(key,list);
            }
            anagrams.get(key).add(string); //add string to bucket
        }
        return new ArrayList<>(anagrams.values());
    }
}

