# Java Threads

A thread is a lightweight unit of execution within a process. Multithreading allows multiple tasks to run concurrently, improving performance and responsiveness.

---

## Main Thread

Every Java program starts with a single **main thread** created automatically by the JVM.

```java
class Demo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); // main
    }
}
```

All code runs sequentially on this thread unless new threads are explicitly created.

---

## Creating Threads

### 1. Extending `Thread`

Override `run()` and call `start()` to launch the thread.

```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running on: " + Thread.currentThread().getName());
    }
}

class Demo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start(); // do NOT call run() directly — that runs on the current thread
        t2.start();
    }
}
```

### 2. Implementing `Runnable` (Preferred)

Separates the task from the thread. Works even if your class already extends another class.

```java
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Running on: " + Thread.currentThread().getName());
    }
}

class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        Thread t2 = new Thread(new MyTask());
        t1.start();
        t2.start();
    }
}
```

### 3. Lambda (Java 8+)

For short tasks, pass a lambda directly — no need for a separate class.

```java
Thread t1 = new Thread(() -> System.out.println("Lambda thread running"));
t1.start();
```

---

## Thread Lifecycle

```
NEW → RUNNABLE → RUNNING → TERMINATED
                    ↕
                 WAITING / TIMED_WAITING / BLOCKED
```

| State | Description |
|---|---|
| `NEW` | Thread object created, `start()` not yet called |
| `RUNNABLE` | `start()` called, waiting for CPU time |
| `RUNNING` | Actively executing `run()` |
| `WAITING` | Waiting indefinitely for another thread (e.g. `join()`) |
| `TIMED_WAITING` | Waiting for a set duration (e.g. `sleep(ms)`) |
| `BLOCKED` | Waiting to acquire a lock (e.g. `synchronized` block) |
| `TERMINATED` | `run()` has completed |

---

## Useful Thread Methods

```java
Thread t = new Thread(() -> {});

t.setName("WorkerThread");
t.getName();                    // "WorkerThread"
t.start();                      // launch the thread
t.join();                       // wait for t to finish before proceeding
Thread.sleep(1000);             // pause current thread for 1 second (throws InterruptedException)
t.getPriority();                // 1 (MIN) to 10 (MAX), default is 5
t.setPriority(Thread.MAX_PRIORITY); // set to 10
t.isAlive();                    // true if thread has started and not yet terminated
```

> `Thread.sleep()` is a static method — it always pauses the **current** thread, not the object it's called on.

---

## Synchronization

When multiple threads access shared data simultaneously, **race conditions** can occur. Use `synchronized` to allow only one thread at a time into a critical section.

```java
class Counter {
    private int count = 0;

    public synchronized void increment() { // only one thread at a time
        count++;
    }

    public int getCount() { return count; }
}

class Demo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> { for (int i = 0; i < 1000; i++) counter.increment(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < 1000; i++) counter.increment(); });

        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println(counter.getCount()); // always 2000
    }
}
```

Without `synchronized`, the result would be unpredictable due to race conditions.

### Synchronized Block

For finer control, synchronize only the critical section rather than the whole method:

```java
public void increment() {
    synchronized (this) {
        count++;
    }
}
```

---

## `volatile` Keyword

Marks a variable as always read from **main memory**, not from a thread's local cache. Used for simple flags shared across threads.

```java
class Worker implements Runnable {
    private volatile boolean running = true;

    public void stop() { running = false; }

    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
        }
    }
}
```

> `volatile` ensures visibility but does **not** guarantee atomicity. Use `synchronized` or `AtomicInteger` for compound operations like `count++`.

---

## `ExecutorService` (Thread Pool)

Creating a new thread for every task is expensive. `ExecutorService` manages a **pool of reusable threads**.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService executor = Executors.newFixedThreadPool(3); // pool of 3 threads

for (int i = 1; i <= 5; i++) {
    int taskId = i;
    executor.submit(() -> {
        System.out.println("Task " + taskId + " on " + Thread.currentThread().getName());
    });
}

executor.shutdown(); // stop accepting new tasks, finish existing ones
```

| Factory Method | Description |
|---|---|
| `newFixedThreadPool(n)` | Fixed number of threads |
| `newSingleThreadExecutor()` | Single background thread |
| `newCachedThreadPool()` | Creates threads as needed, reuses idle ones |

---

## Thread vs Runnable

| Feature | `extends Thread` | `implements Runnable` |
|---|---|---|
| Multiple inheritance | ❌ Not possible | ✅ Possible |
| Separation of task & thread | ❌ Coupled | ✅ Decoupled |
| Reusability | Low | High |
| Preferred | ❌ | ✅ |

---

## Summary

| Concept | Key Point |
|---|---|
| Main thread | Default thread every Java program starts with |
| `extends Thread` | Simple but limits inheritance |
| `implements Runnable` | Preferred; decouples task from thread |
| Lambda thread | Concise syntax for short tasks (Java 8+) |
| Thread lifecycle | NEW → RUNNABLE → RUNNING → WAITING → TERMINATED |
| `synchronized` | Prevents race conditions on shared data |
| `volatile` | Ensures variable visibility across threads |
| `ExecutorService` | Manages thread pools for efficient task execution |
