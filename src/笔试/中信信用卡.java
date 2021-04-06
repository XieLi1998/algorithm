package 笔试;

import java.util.*;

/**
 * Created by xieli on 2021/4/6.
 */
public class 中信信用卡 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int ans = 1;
        for (int num : nums) {
            ans *= num;
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = ans / nums[i];
        }

        return res;
    }

    // hello credit card
    // card eit hlo
    public String removeDup(String str) {
        String[] tmp = str.split(" ");

        int len = tmp.length;
        StringBuilder res = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            String string = tmp[i].toLowerCase();
            res.append(string);
        }

        StringBuilder ans = new StringBuilder();
        Set<Character> set = new HashSet<>();
        String str1 = res.toString();
        for (int i = 0; i < str1.length(); i++) {
            if (set.contains(str1.charAt(i)))
                continue;
            set.add(str1.charAt(i));
            ans.append(str1.charAt(i));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String string = "HjdakshOIUOU";
        String res = string.toLowerCase();
        System.out.println(res);
    }

    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ArrayList<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        Set<String> set = new HashSet<>();
        for (String s2 : strs) {
            char[] chars = s2.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (set.contains(key))
                continue;
            ArrayList<String> list = map.get(key);
            res.add(list);
            set.add(key);
        }

        return res;
    }

    public int calculateAdventureMinHp (String adventurePlayer) {
        return 0;
    }

}
