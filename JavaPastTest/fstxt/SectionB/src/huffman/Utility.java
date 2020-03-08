package huffman;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {

  private static class WordCountRunner implements Runnable {
    private Map<String, Integer> map;
    private List<String> words;
    private int NUM_OF_THREADS;
    private int threadNum;

    public WordCountRunner(Map<String, Integer> map, List<String> words, int NUM_OF_THREADS, int threadNum) {
      this.map = map;
      this.words = words;
      this.NUM_OF_THREADS = NUM_OF_THREADS;
      this.threadNum = threadNum;
    }

    @Override
    public void run() {
      for (int count = threadNum; count < words.size(); count += NUM_OF_THREADS) {
        String currWord = words.get(count);
        if (map.containsKey(currWord)) {
          map.put(currWord, map.get(currWord) + 1);
        } else {
          map.put(currWord, 1);
        }
      }
    }
  }

  public static List<String> getWords(String filePath) {
    List<String> words = null;
    try (Stream<String> linesStream = Files.lines(Paths.get(filePath))) {
      words = linesStream.flatMap(line -> Arrays.stream(line.split(" "))).map(word -> word.trim())
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return words;
  }

  public static String sequenceOfBitsAsNumber(String binaryEncoding) {
    final String binaryEncodingWithHeading1 =
        "1" + binaryEncoding; // Prepending 1 not to lose heading zeroes
    BigInteger result = new BigInteger(binaryEncodingWithHeading1, 2);
    return result.toString();
  }

  public static String numberAsSequenceOfBits(String numberRepresentation) {
    BigInteger number = new BigInteger(numberRepresentation);
    String binaryRepresentation = number.toString(2);
    return binaryRepresentation.substring(1); // Removing previously prepended 1
  }

  public static long totalLength(List<String> words) {
    long length = words.size() - 1; // White spaces
    length += words.stream().mapToLong(w -> w.length()).sum();
    return length;
  }

  public static Map<String, Integer> countWords(List<String> words) {
    if (words == null) {
      throw new NullPointerException();
    }

    int NUM_OF_THREADS = 3;
    Runnable[] runnables = new Runnable[NUM_OF_THREADS];
    Thread[] threads = new Thread[NUM_OF_THREADS];
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < NUM_OF_THREADS; i++) {
      runnables[i] = new WordCountRunner(map, words, NUM_OF_THREADS, i);
      threads[i] = new Thread(runnables[i]);
    }

    Arrays.stream(threads).forEach(i -> i.start());
    Arrays.stream(threads).forEach(i -> {
      try {
        i.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    return map;
    //return words.stream().collect(Collectors.toMap(Function.identity(), w -> 1, Integer::sum));
  }
}
