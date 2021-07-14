package greedy;

import java.util.*;

/*
Input: Five Jobs with following deadlines and profits
JobID Deadline Profit
   a     2       100
   b     1       19
   c     2       27
   d     1       25
   e     3       15
Output: Following is maximum profit sequence of jobs:
       c, a, e

 Each job takes 1 unit to finish and deadline is the maximum time point until this time job has to be finished.

 https://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/
 */
public class JobSequencingusingDisjointSet {

    public static void main(String[] args) {
        List<Job> jobList = new ArrayList<>();

        jobList.add(new Job("a",2,100));
        jobList.add(new Job("b",1,19));
        jobList.add(new Job("c",2,27));
        jobList.add(new Job("d",1,25));
        jobList.add(new Job("e",3,15));
        solveJobProblem(jobList);


    }

    private static void solveJobProblem(List<Job> jobList){
        Collections.sort(jobList);
        int maxDeadline = maxDeadline(jobList);
        int[] solArr = new int[maxDeadline+1];
        for(int i = 0;i<solArr.length;i++)solArr[i]=i;

        for(Job job:jobList){
            int availableSlot = find(solArr,job.deadline);
            if(availableSlot>0){
                int a = find(solArr,availableSlot-1);
                solArr[availableSlot]=a;
                System.out.println(job.jobName+"-"+job.profit);
            }
        }


    }
    private static int find(int[] solArr , int deadLine){
        if(deadLine == solArr[deadLine]) return deadLine;
        return solArr[deadLine] = find(solArr,solArr[deadLine]);
    }

    private static int maxDeadline(List<Job> jobList){
        int max = 0;
        for(Job job:jobList){
            max = Integer.max(max,job.deadline);
        }
        return max;
    }


}
class Job implements Comparable<Job>{
    String jobName;

    @Override
    public int compareTo(Job o) {
        return o.profit-this.profit;
    }

    int deadline;
    int profit;

    public Job(String jobName, int deadline, int profit) {
        this.jobName = jobName;
        this.deadline = deadline;
        this.profit = profit;
    }
}
