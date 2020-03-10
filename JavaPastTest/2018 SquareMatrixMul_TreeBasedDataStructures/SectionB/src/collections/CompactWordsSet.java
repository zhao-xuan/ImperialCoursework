package collections;

import collections.exceptions.InvalidWordException;
import java.util.List;

public interface CompactWordsSet {

  static void checkIfWordIsValid(String word) throws InvalidWordException {
    if (word != null && word.length() > 0) {
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
          throw new InvalidWordException("Invalid literals appear");
        }
      }
    } else {
      throw new InvalidWordException("Word is either null or empty");
    }
  }

  boolean add(String word) throws InvalidWordException;

  boolean remove(String word) throws InvalidWordException;

  boolean contains(String word) throws InvalidWordException;

  int size();

  List<String> uniqueWordsInAlphabeticOrder();

}
