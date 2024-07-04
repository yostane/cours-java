///usr/bin/env jbang "$0" "$@" ; exit $?

public class VirtualThreadDemo {

  public static void main(String... args) throws InterruptedException {
    Thread virtualThread = Thread.ofVirtual().start(() -> {
      System.out.println(Thread.currentThread());
    });

    Thread.ofVirtual().start(() -> {
      System.out.println(Thread.currentThread());
    });

    Thread osThread = Thread.ofPlatform().start(() -> {
      System.out.println(Thread.currentThread());
    });

    Thread.sleep(1000);
  }
}
