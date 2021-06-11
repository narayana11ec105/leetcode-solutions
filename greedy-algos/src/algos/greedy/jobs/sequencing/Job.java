package algos.greedy.jobs.sequencing;

public class Job {
	
	private char id;
	private int profit;
	private int deadline;
	
	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}

	public char getId() {
		return id;
	}

	public int getProfit() {
		return profit;
	}

	public int getDeadline() {
		return deadline;
	}
	
	
	
}
