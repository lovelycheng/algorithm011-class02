package Week_02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengtong
 * @date 2020/7/26 06:13
 */
public class AnagramSolution {

    public boolean isAnagram(String s, String t) {

        if(s.equals(t)){
            return true;
        }
        if(s.isEmpty() || t.isEmpty()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map1 = new HashMap<>();

        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                int integer = map.get(c)+1;
                map.put(c,integer);
            }else {
                map.put(c,1);
            }
        }

        for(Character c:t.toCharArray()){
            if(map1.containsKey(c)){
                int integer = map1.get(c)+1;
                map1.put(c,integer);
            }else {
                map1.put(c,1);
            }
        }
        for(Map.Entry entry : map.entrySet()){
            if(!entry.getValue().equals(map1.get(entry.getKey()))){
                return false;
            }
        }
        return true;
    }

}
