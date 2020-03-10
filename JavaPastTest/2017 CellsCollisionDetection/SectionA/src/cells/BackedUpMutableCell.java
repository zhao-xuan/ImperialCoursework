package cells;

import java.util.*;

public class BackedUpMutableCell<T> extends MutableCell<T> implements BackedUpCell<T> {
    private enum Mode {
        BOUNDED, UNBOUNDED
    }
    Stack<T> history;
    Mode mode;
    int limit;

    public BackedUpMutableCell() {
        value = null;
        history = new Stack<>();
        mode = Mode.UNBOUNDED;
    }

    public BackedUpMutableCell(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException();
        }
        value = null;
        this.limit = limit;
        mode = Mode.BOUNDED;
        history = new Stack<>();
    }

    @Override
    public void set(T value) {
        if (isSet()) {
            history.push(this.value);
            if (mode == Mode.BOUNDED && history.size() > limit) {
                history.pop();
            }
        }
        this.value = value;
    }

    @Override
    public boolean hasBackup() {
        return !history.isEmpty();
    }

    @Override
    public void revertToPrevious() {
        if (history.isEmpty()) {
            throw new UnsupportedOperationException();
        }
        value = history.pop();
    }
}
