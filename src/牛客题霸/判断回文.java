package 牛客题霸;

/**
 * Created by xieli on 2021/3/24.
 */
public class 判断回文 {

    public boolean judge(String str) {
        boolean flag = true;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
