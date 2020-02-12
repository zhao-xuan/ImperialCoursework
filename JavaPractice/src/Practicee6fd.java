import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface BitSet {
    void add(int x);
    void remove(int x);
    boolean contains(int x);
    void intersectWith(BitSet s);
    int maxStorableValue();
}

class BitSet8 implements BitSet {
    byte bitset;

    public BitSet8() {
        this.bitset = 0;
    }

    @Override
    public void add(int x) {
        if (inRange(x))
            bitset |= 1 << x;
        else
            System.out.println("Overflow!");
    }

    @Override
    public void remove(int x) {
        if (inRange(x))
            bitset &= (~(1 << x));
        else
            System.out.println("Overflow!");
    }

    @Override
    public boolean contains(int x) {
        if (inRange(x))
            return ((1 << x) & bitset) != 0;
        else
            System.out.println("Overflow!");
            return false;
    }

    @Override
    public void intersectWith(BitSet s) {
        if (s instanceof BitSet8)
            bitset &= ((byte) ((BitSet8) s).getBitSet());
        else
            for (int x = 0; inRange(x); x++) {
                if (!(contains(x) && s.contains(x))) {
                    remove(x);
                }
            }
    }

    @Override
    public int maxStorableValue() {
        return Byte.SIZE;
    }

    public Number getBitSet() {
        return (byte) this.bitset;
    }

    private boolean inRange(int x) {
        //Including 0, thereby x has to be smaller or equal to max - 1
        return x >= 0 && x <= maxStorableValue() - 1;
    }  

    public String toString() {
        return Byte.toString(bitset);
    }
}

class BitSet64 implements BitSet {
    long bitset;

    public BitSet64() {
        this.bitset = 0;
    }

    @Override
    public void add(int x) {
        if (inRange(x))
            bitset |= 1 << x;
        else
            System.out.println("Overflow!");
    }

    @Override
    public void remove(int x) {
        if (inRange(x))
            bitset &= (~(1 << x));
        else
            System.out.println("Overflow!");
    }

    @Override
    public boolean contains(int x) {
        if (inRange(x))
            return ((1 << x) & bitset) != 0;
        else
            System.out.println("Overflow!");
            return false;
    }

    @Override
    public void intersectWith(BitSet s) {
        if (s instanceof BitSet64)
            bitset &= ((long) ((BitSet64) s).getBitSet());
        else
            for (int x = 0; inRange(x); x++) {
                if (!(contains(x) && s.contains(x))) {
                    remove(x);
                }
            }
    }

    @Override
    public int maxStorableValue() {
        return Long.SIZE;
    }

    public Number getBitSet() {
        return (byte) this.bitset;
    }

    private boolean inRange(int x) {
        //Including 0, thereby x has to be smaller or equal to max - 1
        return x >= 0 && x <= maxStorableValue() - 1;
    }

    public String toString() {
        return Long.toString(bitset);
    }
}

class BitSetArray implements BitSet {
    long[] bitset;
    int size;

    public BitSetArray(int size) {
        this.size = size;
        this.bitset = new long[size / 64];
        Arrays.fill(this.bitset, (long) 0);
    }

    @Override
    public void add(int x) {
        if (inRange(x))
            bitset[x / 64] |= 1 << (x % 64);
        else
            System.out.println("Overflow!");
    }

    @Override
    public void remove(int x) {
        if (inRange(x))
            bitset[x / 64] &= ~(1 << (x % 64));
        else
            System.out.println("Overflow!");
    }

    @Override
    public boolean contains(int x) {
        if (inRange(x))
            return ((1 << (x % 64)) & bitset[x / 64]) != 0;
        else
            System.out.println("Overflow!");
            return false;
    }

    @Override
    public void intersectWith(BitSet s) {
        if (s instanceof BitSetArray) {
            int len = Math.min(((BitSetArray) s).getBitSet().length, this.bitset.length);
            for (int a = 0; a < len; a++) {
                bitset[a] &= ((byte) ((BitSetArray) s).getBitSet()[a]);
            }
        } else {
            for (int x = 0; inRange(x); x++) {
                if (!(contains(x) && s.contains(x))) {
                    remove(x);
                }
            }
        }
    }

    @Override
    public int maxStorableValue() {
        return this.size;
    }

    public long[] getBitSet() {
        return (long[]) this.bitset;
    }

    private boolean inRange(int x) {
        //Including 0, thereby x has to be smaller or equal to max - 1
        return x >= 0 && x <= maxStorableValue() - 1;
    }
}

public class Practicee6fd {
    public static void main(String[] args) {
        BitSet8 bs8 = new BitSet8();
        BitSet64 bs64 = new BitSet64();
        BitSetArray bsa = new BitSetArray(1024);
        bs8.add(1);
        bs8.add(3);
        bs8.add(4);
        bs8.add(7);
        bs64.add(3);
        bs64.add(7);
        bs64.add(13);
        bs64.add(18);
        bs8.intersectWith(bs64);
        /*System.out.println(bs8.contains(1));
        System.out.println(bs8.contains(3));
        System.out.println(bs8.contains(4));
        System.out.println(bs8.contains(7));
        System.out.println(bs8.contains(13));*/
        bsa.add(724);
        bsa.add(123);
        bsa.add(64);
        bsa.add(821);
        System.out.println(bsa.contains(123));
    }
}