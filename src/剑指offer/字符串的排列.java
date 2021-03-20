package 剑指offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xieli on 2021/3/21.
 */
public class 字符串的排列 {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        String[] ans = res.toArray(new String[res.size()]);
        Arrays.sort(ans);
        return ans;
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));     // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i]))     // 重复，因此剪枝
                continue;

            set.add(c[i]);

            swap(i, x);      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);       // 开启固定第 x + 1 位字符
            swap(i, x);      // 恢复交换
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
