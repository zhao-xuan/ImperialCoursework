package huffman;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanEncoder {

  final HuffmanNode root;
  final Map<String, String> word2bitsequence;

  private HuffmanEncoder(HuffmanNode root,
      Map<String, String> word2bitSequence) {
    this.root = root;
    this.word2bitsequence = word2bitSequence;
  }

  public static HuffmanEncoder buildEncoder(Map<String, Integer> wordCounts) {
    //TODO: complete the implementation of this method (Q1)

    if (wordCounts == null) {
      throw new HuffmanEncoderException("wordCounts cannot be null");
    }
    if (wordCounts.size() < 2) {
      throw new HuffmanEncoderException("This encoder requires at least two different words");
    }

    // fixing the order in which words will be processed: this determinize the execution and makes
    // tests reproducible.
    TreeMap<String, Integer> sortedWords = new TreeMap<String,Integer>(wordCounts);
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(sortedWords.size());

    queue.addAll(sortedWords.entrySet().stream()
            .map(e -> new HuffmanLeaf(e.getValue(), e.getKey()))
            .collect(Collectors.toList()));
    while (queue.size() > 1) {
      HuffmanNode n1 = queue.poll();
      HuffmanNode n2 = queue.poll();
      HuffmanInternalNode internalNode = new HuffmanInternalNode(n1, n2);
      queue.offer(internalNode);
    }

    //YOUR IMPLEMENTATION HERE...
    HuffmanNode root = queue.poll();
    Map<String, String> word2bitSequence = new HashMap<>();
    traverseTree(root, word2bitSequence, "");
    return new HuffmanEncoder(root, word2bitSequence);
  }

  private static void traverseTree(HuffmanNode node, Map<String, String> m, String bitseq) {
    if (node instanceof HuffmanLeaf) {
      m.put(((HuffmanLeaf) node).word, bitseq);
    } else {
      traverseTree(((HuffmanInternalNode) node).left, m, bitseq + "0");
      traverseTree(((HuffmanInternalNode) node).right, m, bitseq + "1");
    }
  }


  public String compress(List<String> text) {
    assert text != null && text.size() > 0;
    StringBuilder s = new StringBuilder();
    for (String str : text) {
      if (!word2bitsequence.keySet().contains(str)) {
        throw new HuffmanEncoderException();
      }
      s.append(word2bitsequence.get(str));
    }

    return s.toString();
  }


  public List<String> decompress(String compressedText) {
    assert compressedText != null && compressedText.length() > 0;
    List<String> decomposed = new ArrayList<>();
    HuffmanNode node = root;
    for (int i = 0; i < compressedText.length(); i++) {
      if (node instanceof HuffmanLeaf) {
        decomposed.add(((HuffmanLeaf) node).word);
        node = root;
      }
      if (compressedText.charAt(i) == '0') {
        node = ((HuffmanInternalNode) node).left;
      } else {
        node = ((HuffmanInternalNode) node).right;
      }
    }

    if (node instanceof HuffmanLeaf) {
      decomposed.add(((HuffmanLeaf) node).word);
    } else {
      throw new HuffmanEncoderException();
    }

    return decomposed;
  }

  // Below the classes representing the tree's nodes. There should be no need to modify them, but
  // feel free to do it if you see it fit

  private static abstract class HuffmanNode implements Comparable<HuffmanNode> {

    private final int count;

    public HuffmanNode(int count) {
      this.count = count;
    }

    @Override
    public int compareTo(HuffmanNode otherNode) {
      return count - otherNode.count;
    }
  }


  private static class HuffmanLeaf extends HuffmanNode {

    private final String word;

    public HuffmanLeaf(int frequency, String word) {
      super(frequency);
      this.word = word;
    }
  }


  private static class HuffmanInternalNode extends HuffmanNode {

    private final HuffmanNode left;
    private final HuffmanNode right;

    public HuffmanInternalNode(HuffmanNode left, HuffmanNode right) {
      super(left.count + right.count);
      this.left = left;
      this.right = right;
    }
  }
}
