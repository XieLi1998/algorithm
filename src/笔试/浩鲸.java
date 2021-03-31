package 笔试;

/**
 * Created by xieli on 2021/3/31.
 */
public class 浩鲸 {

    public static void main(String[] args) {
        String str = "chkjkjchdjashkjdch2";
        replace(str);
    }

    public static void replace(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'h') {
                count++;
//                sb.append("ch1");
                sb.append('c');
                sb.append('h');
                sb.append('1');
                continue;
            }
            sb.append(str.charAt(i));
        }

        sb.append(str.charAt(str.length() - 1));
        str = sb.toString();
        System.out.println(str);
        System.out.println(count);
    }

}
