package utils;

import java.util.Optional;

public class UnsafeQueue<E> implements Queue<E> {
  private UnsafeLinkedListNode<E> head;
  private UnsafeLinkedListNode<E> tail;
  private int size;

  public UnsafeQueue() {
    this.head = new UnsafeLinkedListNode<E>();
    this.tail = head;
    size = 0;
  }

  @Override
  public void push(E element) {
    UnsafeLinkedListNode<E> node = new UnsafeLinkedListNode<>(element);
    tail.setNext(node);
    tail = node;
    size++;
  }

  @Override
  public Optional<E> pop() {
    UnsafeLinkedListNode<E> node = head.getNext();
    if (node == null) {
      return Optional.empty();
    }
    head.setNext(node.getNext());
    size--;
    return Optional.of(node.getData());
  }

  @Override
  public int size() {
    return size;
  }

  private static class UnsafeLinkedListNode<E> {
    private E data;
    private UnsafeLinkedListNode<E> next;
    public UnsafeLinkedListNode() {
      this(null);
    }

    public UnsafeLinkedListNode(E data) {
      this.data = data;
      next = null;
    }

    public E getData() {
      return data;
    }

    public void setData(E data) {
      this.data = data;
    }

    public UnsafeLinkedListNode<E> getNext() {
      return next;
    }

    public void setNext(UnsafeLinkedListNode<E> next) {
      this.next = next;
    }
  }
}
