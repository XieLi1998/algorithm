package 其它;

import java.text.DecimalFormat;

/**
 * Created by xieli on 2021/3/14.
 */
public class 除法保留小数 {

    public static void main(String[] args) {

//        DecimalFormat df = new DecimalFormat(".00");
//        String res = df.format((float) 7 / 3);
//        System.out.println(res);

//        int a = 7, b = 3;
        int a = 5, b = 2;
        float c = (float) (Math.round(a * 100 / b) / 100.0);
//        System.out.println(c);

        System.out.println(String.format("%.2f", c));
    }

}
