package cells;

import java.util.Comparator;

public class BackedUpCellComparator<U> implements Comparator<BackedUpCell<U>> {
    Comparator<U> valueComparator;

    public BackedUpCellComparator(Comparator<U> valueComparatoromparator) {
        this.valueComparator = valueComparatoromparator;
    }

    @Override
    public int compare(BackedUpCell<U> uBackedUpCell, BackedUpCell<U> t1) {
        if (!uBackedUpCell.isSet() && !t1.isSet()) {
            return 0;
        } else if (!uBackedUpCell.isSet()) {
            return -1;
        } else if (!t1.isSet()) {
            return 1;
        } else {
            return
        }
    }
}
