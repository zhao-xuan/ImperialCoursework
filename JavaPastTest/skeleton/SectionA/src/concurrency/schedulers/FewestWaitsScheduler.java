package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;
import concurrency.statements.WaitStmt;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FewestWaitsScheduler implements Scheduler {

    @Override
    public int chooseThread(ConcurrentProgram program) throws DeadlockException {
        Set<Integer> enabled = program.getEnabledThreadIds();
        if (enabled.size() == 0) {
            throw new DeadlockException();
        }
        Map<Integer, Long> map = enabled.stream()
                .collect(Collectors.toMap(x -> x, i -> program.remainingStatements(i).stream()
                                                                .filter(t -> t instanceof WaitStmt)
                                                                .count()));
        int id = map.entrySet().stream()
                .min(Comparator.comparing(Map.Entry<Integer, Long>::getValue).thenComparing(Map.Entry::getKey))
                .get().getKey();
        return id;
    }
}
