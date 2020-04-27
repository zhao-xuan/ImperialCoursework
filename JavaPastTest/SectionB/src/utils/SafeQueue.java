package utils;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeQueue<E> implements Queue<E> {
  private volatile SafeLinkedListNode<E> head;
  private volatile SafeLinkedListNode<E> tail;
  private AtomicInteger size;

  public SafeQueue() {
    head = new SafeLinkedListNode<>();
    tail = head;
    size = new AtomicInteger(0);
  }

  @Override
  public void push(E element) {
    while (true) {
      SafeLinkedListNode<E> temp = tail;
      temp.lock();
      if (temp == tail) {
        SafeLinkedListNode<E> node = new SafeLinkedListNode<>(element);
        node.lock();
        tail.setNext(node);
        tail = node;
        size.incrementAndGet();
        node.unlock();
        temp.unlock();
        break;
      }
      temp.unlock();
    }
  }

  @Override
  public Optional<E> pop() {
    head.lock();
    SafeLinkedListNode<E> headNext = head.getNext();
    if (headNext == null) {
      head.unlock();
      return Optional.empty();
    }
    headNext.lock();
    head.setNext(headNext.getNext());
    if (headNext == tail) tail = head;
    size.decrementAndGet();
    headNext.unlock();
    head.unlock();
    return Optional.of(headNext.getData());
  }

  @Override
  public int size() {
    return size.get();
  }

  private static class SafeLinkedListNode<E> {
    private E data;
    private volatile SafeLinkedListNode<E> next;
    private Lock lock;

    public SafeLinkedListNode() {
      this(null);
    }

    public SafeLinkedListNode(E data) {
      this.data = data;
      next = null;
      lock = new ReentrantLock();
    }

    public E getData() {
      return data;
    }

    public void setData(E data) {
      this.data = data;
    }

    public SafeLinkedListNode<E> getNext() {
      return next;
    }

    public void setNext(SafeLinkedListNode<E> next) {
      this.next = next;
    }

    public void lock() {
      lock.lock();
    }

    public void unlock() {
      lock.unlock();
    }
  }
}
