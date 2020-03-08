package concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import concurrency.expressions.Expr;
import concurrency.schedulers.Scheduler;

public class Executor {

	private ConcurrentProgram program;
	private Scheduler scheduler;

	public Executor(ConcurrentProgram program, Scheduler scheduler) {
		this.program = program;
		this.scheduler = scheduler;
	}

	/**
	 * Executes program with respect to scheduler
	 *
	 * @return the final state and history of execution
	 */
	public String execute() {
		List<Integer> history = new LinkedList<Integer>();
		boolean deadlockOccurred = false;
		Set<Integer> set = program.getEnabledThreadIds();

		while (!program.isTerminated()) {
			if (set.size() == 0) {
				deadlockOccurred = true;
				break;
			}
			int id = 0;
			try {
				id = scheduler.chooseThread(program);
			} catch (DeadlockException e) {
				e.printStackTrace();
			}
			program.step(id);
			history.add(id);
			set = program.getEnabledThreadIds();
		}

		StringBuilder result = new StringBuilder();
		result.append("Final state: " + program + "\n");
		result.append("History: " + history + "\n");
		result.append("Termination status: "
				+ (deadlockOccurred ? "deadlock" : "graceful") + "\n");
		return result.toString();
	}

	// An incorrect attempt at overriding the equals method
	// of Object

	public boolean equals(Executor o) {
		if (this == o) return true;
		return program.toString().equals(o.program.toString());
	}

	@Override
	public int hashCode() {
		return Objects.hash(program, scheduler);
	}
}
