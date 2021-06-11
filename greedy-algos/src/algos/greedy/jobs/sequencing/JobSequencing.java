package algos.greedy.jobs.sequencing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencing {

	/*
	 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. 
	 * It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 
	 * 1. How to maximize total profit if only one job can be scheduled at a time
	 * Input: Four Jobs with following deadlines and profits
			JobID  Deadline  Profit
  			a      4        20   
  			b      1        10
  			c      1        40  
  			d      1        30
	 */
	public static void main(String[] args) {
		
		ArrayList<Job> jobs = new ArrayList<>();
		 
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));
        
        System.out.println("The job schedule sequence: ");
        char[] sequence = getScheduledJobSequence(jobs, 3);
        for (int i = 0; i < sequence.length; i++) {
			System.out.print(sequence[i] + "	");
		}
		
	}
	
	private static char[] getScheduledJobSequence(List<Job> jobs, int maxDeadline) {
		
		Collections.sort(jobs, (job1, job2) -> job2.getProfit() - job1.getProfit());
		
		char[] sequence = new char[maxDeadline];
		boolean[] filledSlots = new boolean[maxDeadline];
		
		for(int i=0; i < jobs.size(); i++) {
			int currentDeadline = jobs.get(i).getDeadline() - 1;
			
			if (!filledSlots[currentDeadline]) {
				filledSlots[currentDeadline] = true;
				sequence[currentDeadline] = jobs.get(i).getId();
			}else {
				for (int j = currentDeadline - 1; j >= 0; j--) {
					if (!filledSlots[j]) {
						filledSlots[j] = true;
						sequence[j] = jobs.get(i).getId();
						break;
					}
				}
			}
			
		}
		return sequence;
	}
	
}
