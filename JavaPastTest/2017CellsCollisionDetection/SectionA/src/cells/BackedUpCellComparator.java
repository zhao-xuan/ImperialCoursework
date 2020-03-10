package cells;

import java.nio.file.StandardWatchEventKinds;
import java.util.Comparator;
import java.util.Stack;

public class BackedUpCellComparator<U> implements Comparator<BackedUpCell<U>> {
    Comparator<U> valueComparator;

    public BackedUpCellComparator(Comparator<U> valueComparatoromparator) {
        this.valueComparator = valueComparatoromparator;
    }

    @Override
    public int compare(BackedUpCell<U> first, BackedUpCell<U> second) {
        if (!first.isSet() && !second.isSet()) {
            return 0;
        } else if (!first.isSet()) {
            return -1;
        } else if (!second.isSet()) {
            return 1;
        } else {
            int valueCompare;
            valueCompare = valueComparator.compare(first.get(), second.get());
            if (valueCompare != 0) {
                return valueCompare;
            }
            Stack<U> firstHistory = new Stack<>();
            Stack<U> secondHistory = new Stack<>();
            try {
                while(first.hasBackup() && second.hasBackup()) {
                    first.revertToPrevious();
                    second.revertToPrevious();
                    valueCompare = valueComparator.compare(first.get(), second.get());
                    if (valueCompare != 0) {
                        return valueCompare;
                    }
                    firstHistory.push(first.get());
                    secondHistory.push(second.get());
                }
            } finally {
                while (first.hasBackup()) {
                    first.revertToPrevious();
                    firstHistory.push(first.get());
                }
                while(!firstHistory.empty()) {
                    first.set(firstHistory.pop());
                }
                while (second.hasBackup()) {
                    second.revertToPrevious();
                    secondHistory.push(second.get());
                }
                while (!secondHistory.empty()) {
                    second.set(secondHistory.pop());
                }
            }

            return 0;
        }
    }
}