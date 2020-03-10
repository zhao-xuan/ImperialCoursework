package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;

import java.util.Set;

public class RoundRobinScheduler implements Scheduler {
    private boolean firstTimeExec;
    private int lastThreadId;

    public RoundRobinScheduler() {
        this.firstTimeExec = true;
    }

    @Override
    public int chooseThread(ConcurrentProgram program) throws DeadlockException {
        Set<Integer> enabled = program.getEnabledThreadIds();
        if (enabled.size() == 0) {
            throw new DeadlockException();
        }
        if (firstTimeExec) {
            firstTimeExec = false;
            //We can directly use get() below since the program is guaranteed to have at least one enabled thread
            lastThreadId = enabled.stream().min(Integer::compareTo).get();
            return lastThreadId;
        } else {
            lastThreadId =  enabled.stream()
                                .filter(i -> i.compareTo(lastThreadId) > 0)
                                .min(Integer::compareTo)
                                .orElse(enabled.stream().min(Integer::compareTo).get());
            return lastThreadId;
        }
    }
}
