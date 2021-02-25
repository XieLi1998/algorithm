package 其它;

/**
 * Created by xieli on 2021/2/24.
 */


/**
 * （一）懒汉式（线程不安全）
 */
//public class Singleton {
//
//    private static Singleton uniqueInstance;
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getUniqueInstance(){
//        if (uniqueInstance == null) {
//            uniqueInstance = new Singleton();
//        }
//        return uniqueInstance;
//    }
//
//}


/**
 * （二）饿汉式（线程安全）
 */
//public class Singleton {
//
//    private static Singleton uniqueInstance = new Singleton();
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getUniqueInstance(){
//        return uniqueInstance;
//    }
//}


/**
 * （三）懒汉式（线程安全）
 */
//public class Singleton {
//
//    private static Singleton uniqueInstance;
//
//    private Singleton() {
//
//    }
//
//    public static synchronized Singleton getUniqueInstance(){
//        if (uniqueInstance == null) {
//            uniqueInstance = new Singleton();
//        }
//        return uniqueInstance;
//    }
//
//}


/**
 * （四）双重检查锁实现（线程安全）
 */
//public class Singleton {
//
//    private volatile static Singleton uniqueInstance;
//
//    private Singleton(){
//
//    }
//
//    public static Singleton getUniqueInstance(){
//        if (uniqueInstance == null) {
//            synchronized (Singleton.class){
//                if (uniqueInstance == null) {
//                    uniqueInstance = new Singleton();
//                }
//            }
//        }
//        return uniqueInstance;
//    }
//
//}

/**
 * （五）静态内部类实现（线程安全）
 */
//public class Singleton {
//
//    private Singleton() {
//
//    }
//
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getUniqueInstance(){
//        return SingletonHolder.INSTANCE;
//    }
//
//}

/**
 * （五）静态内部类实现（线程安全）
 */
public enum Singleton {

    INSTANCE;

    public void doSomeThing(){

    }

}

