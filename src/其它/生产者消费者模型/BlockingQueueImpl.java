package 其它.生产者消费者模型;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xieli on 2021/3/14.
 */

//wait 和 notify
public class BlockingQueueImpl {

    public static void main(String[] args) {

        Resource3 resource = new Resource3();

        // 生产者线程
        ProducerThread3 p = new ProducerThread3(resource);

        // 消费者线程
        ConsumerThread3 c1 = new ConsumerThread3(resource);
        ConsumerThread3 c2 = new ConsumerThread3(resource);
        ConsumerThread3 c3 = new ConsumerThread3(resource);

        p.start();
        c1.start();
        c2.start();
        c3.start();
    }

}


/**
 * 公共资源类
 */
class Resource3 {

    private BlockingQueue<Integer> resourceQueue = new LinkedBlockingQueue<>(10);

    /**
     * 从资源池中取走资源
     */
    public void remove() {
        try {
            resourceQueue.take();
            System.out.println("消费者" + Thread.currentThread().getName() +
                    "消费一份资源, " + "当前线程池有 " + resourceQueue.size() + " 份资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 向资源池中添加资源
     */
    public void add() {
        try {
            resourceQueue.put(1);
            System.out.println(Thread.currentThread().getName() + "生产一份资源, 当前线程池有 "
                    + resourceQueue.size() + " 份资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


/**
 * 消费者线程
 */
class ConsumerThread3 extends Thread {

    private Resource3 resource;

    public ConsumerThread3(Resource3 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            resource.remove();
        }
    }
}


/**
 * 生产者线程
 */
class ProducerThread3 extends Thread {

    private Resource3 resource;

    public ProducerThread3(Resource3 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        //不断地生产资源
        while (true) {

            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            resource.add();
        }
    }
}