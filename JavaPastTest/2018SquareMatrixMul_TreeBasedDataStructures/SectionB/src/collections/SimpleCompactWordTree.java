package collections;

import collections.exceptions.InvalidWordException;
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TreeNode {
  private char c;
  private boolean isWord;
  private Map<Character, TreeNode> sublist;
  private Lock lock = new ReentrantLock();

  public TreeNode(char c, boolean isWord, Map<Character, TreeNode> sublist) {
    this.c = c;
    this.isWord = isWord;
    this.sublist = sublist;
  }

  public char getChar() {
    return c;
  }

  public boolean isWord() {
    return isWord;
  }

  public void setIsWord(boolean isWord) {
    this.isWord = isWord;
  }

  public Map<Character, TreeNode> getSublist() {
    return sublist;
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }
}

public class SimpleCompactWordTree implements CompactWordsSet {
  private int size;
  private TreeNode root;

  public SimpleCompactWordTree() {
    size = 0;
    root = new TreeNode(' ', false, new HashMap<>());
  }

  @Override
  public boolean add(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    TreeNode temp = root;
    temp.lock();
    try {
      for (int i = 0; i < word.length() - 1; i++) {
        char c = word.charAt(i);
        if (temp.getSublist().containsKey(c)) {
          temp.getSublist().get(c).lock();
          TreeNode temp2 = temp;
          temp = temp.getSublist().get(c);
          temp2.unlock();
        } else {
          TreeNode node = new TreeNode(c, false, new HashMap<>());
          node.lock();
          temp.getSublist().put(c, node);
          TreeNode temp2 = temp;
          temp = node;
          temp2.unlock();
        }
      }

      char lastChar = word.charAt(word.length() - 1);

      if (temp.getSublist().containsKey(lastChar)) {
        temp.getSublist().get(lastChar).lock();
        TreeNode temp2 = temp;
        temp = temp.getSublist().get(lastChar);
        temp2.unlock();
        if (temp.isWord()) {
          return false;
        } else {
          temp.setIsWord(true);
          size++;
          return true;
        }
      } else {
        TreeNode node = new TreeNode(lastChar, true, new HashMap<>());
        temp.getSublist().put(lastChar, node);
        size++;
        return true;
      }
    } finally {
      temp.unlock();
    }
  }

  @Override
  public boolean remove(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    TreeNode temp = root;
    temp.lock();
    try {
      for (int i = 0; i < word.length(); i++) {
        char tc = word.charAt(i);
        if (temp.getSublist().containsKey(tc) && i == word.length() - 1) {
          temp.getSublist().get(tc).lock();
          TreeNode temp2 = temp;
          temp = temp.getSublist().get(tc);
          temp2.unlock();
          if (temp.isWord()) {
            temp.setIsWord(false);
            size--;
            return true;
          } else {
            return false;
          }
        }
        if (temp.getSublist().keySet().contains(tc)) {
          temp.getSublist().get(tc).lock();
          TreeNode temp2 = temp;
          temp = temp.getSublist().get(tc);
          temp2.unlock();
        } else {
          return false;
        }
      }

      return false;
    } finally {
      temp.unlock();
    }
  }

  @Override
  public boolean contains(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    TreeNode temp = root;
    temp.lock();
    try {
      for (int i = 0; i < word.length(); i++) {
        char tc = word.charAt(i);
        if (temp.getSublist().keySet().contains(tc)) {
          temp.getSublist().get(tc).lock();
          TreeNode temp2 = temp;
          temp = temp.getSublist().get(tc);
          temp2.unlock();
        } else {
          return false;
        }
      }

      return temp.isWord();
    } finally {
      temp.unlock();
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<String> uniqueWordsInAlphabeticOrder() {
    return uniqueWordHelper(root, "");
  }

  private List<String> uniqueWordHelper(TreeNode node, String s) {
    List<String> list = new ArrayList<>();
    if (node.isWord()) {
      list.add(s);
    }
    for (char c : node.getSublist().keySet()) {
      list.addAll(uniqueWordHelper(node.getSublist().get(c), s + c));
    }

    return list;
  }
}
