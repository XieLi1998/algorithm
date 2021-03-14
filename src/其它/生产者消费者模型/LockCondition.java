package 其它.生产者消费者模型;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xieli on 2021/3/14.
 */

//wait 和 notify
public class LockCondition {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition produceCondition = lock.newCondition();
        Condition consumeCondition = lock.newCondition();
        Resource2 resource = new Resource2(lock, produceCondition, consumeCondition);

        // 生产者线程
        ProducerThread2 producer1 = new ProducerThread2(resource);

        // 消费者线程
        ConsumerThread2 consumer1 = new ConsumerThread2(resource);
        ConsumerThread2 consumer2 = new ConsumerThread2(resource);
        ConsumerThread2 consumer3 = new ConsumerThread2(resource);

        producer1.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

}


/**
 * 公共资源类
 */
class Resource2 {

    // 当前资源数量
    private int num = 0;
    // 资源池中允许存放的资源数目
    private int size = 10;

    private Lock lock;
    private Condition produceCondition;
    private Condition consumerCondition;

    public Resource2(Lock lock, Condition produceCondition, Condition consumerCondition) {
        this.lock = lock;
        this.produceCondition = produceCondition;
        this.consumerCondition = consumerCondition;
    }

    /**
     * 从资源池中取走资源
     */
    public void remove() {
        lock.lock();

        try {
            if (num > 0) {
                num--;
                System.out.println("消费者" + Thread.currentThread().getName() +
                        "消费一份资源, " + "当前线程池有 " + num + " 份资源");
                // 唤醒等待的生产者
                produceCondition.signalAll();
            } else {
                try {
                    // 如果没有资源，则消费者进入等待状态
                    consumerCondition.await();
                    System.out.println("消费者" + Thread.currentThread().getName() + "线程进入等待状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }

    }

    /**
     * 向资源池中添加资源
     */
    public void add() {
        lock.lock();
        try {
            if (num < size) {
                num++;
                System.out.println(Thread.currentThread().getName() + "生产一份资源, 当前线程池有 "
                        + num + " 份资源");
                // 唤醒等待的消费者
                consumerCondition.signalAll();
            } else {
                // 如果当前资源池中有 10 件资源
                try {
                    //生产者进入等待状态，并释放锁
                    produceCondition.await();
                    System.out.println(Thread.currentThread().getName() + "线程进入等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

}


/**
 * 消费者线程
 */
class ConsumerThread2 extends Thread {

    private Resource2 resource;

    public ConsumerThread2(Resource2 resource) {
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
class ProducerThread2 extends Thread {

    private Resource2 resource;

    public ProducerThread2(Resource2 resource) {
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