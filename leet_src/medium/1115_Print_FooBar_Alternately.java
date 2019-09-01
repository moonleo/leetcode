import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    Lock lock = new ReentrantLock();
    Condition fooCon = lock.newCondition();
    Condition barCon = lock.newCondition();

    private boolean isFoo = true;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            while (!isFoo) {
                fooCon.await();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            isFoo = false;
            barCon.signalAll();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            while (isFoo) {
                barCon.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            isFoo = true;
            fooCon.signalAll();
            lock.unlock();
        }
    }
}
