package Week_02;

import java.util.*;

/**
 * @author chengtong
 * @date 2020/7/28 21:24
 * not solved yet date
 */
public class GroupAnagramsSolution {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();


        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // 如果足够长 这一步消耗很大
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsTwo(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
//        int[] keys = new int[26];

        for (String str : strs) {
            char[] keys = new char[26];
            for (char c : str.toCharArray()) {
                int pos = c - 'a';
                keys[pos] += 1;
            }
            String key = String.valueOf(keys);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }



    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagramsMath(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<>(32);

        for (String str : strs) {
            int key = 1;

            for (char c : str.toCharArray()) {
                int pos = c - 'a';
                key *= primes[pos];
            }

            if(!map.containsKey(key)) map.put(key,new ArrayList<>());

            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagramsSolution solution = new GroupAnagramsSolution();
//        List<List<String>> lists = solution.groupAnagrams(strings);
        List<List<String>> lists2 = solution.groupAnagramsTwo(strings);
    }

}
