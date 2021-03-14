package 其它;

/**
 * Created by xieli on 2021/3/14.
 */
public class InnerClassTest {

    private int aNum = 1;

    public static void main(String[] args) {
        new InnerClassTest().a();
    }

    private void a() {
        new InnerClass().innerMethod();
        new StaticInnerClass().innerMethod();
    }

    void b() {

    }

    private void c() {

    }

    public void d(){

    }

    private class InnerClass {
        private void innerMethod() {
            c();
            aNum = 2;
        }
    }

    static class StaticInnerClass {
        private void innerMethod() {
//            d();
        }
    }


}
