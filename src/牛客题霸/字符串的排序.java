package 牛客题霸;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by xieli on 2021/3/21.
 */
public class 字符串的排序 {

    ArrayList<String> res = new ArrayList<>();
    char[] c;

    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        Collections.sort(res);
        return res;
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
