package main.java.leetcode;
import java.util.*;

/**
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
 *
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
 *
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
 */
public class KillProcess {
	public List < Integer > killProcess(List < Integer > pid, List < Integer > ppid, int kill) {
		Map<Integer,List<Integer>> map=new HashMap<>();
		for(int i=0;i<ppid.size();i++) {
			if(ppid.get(i)>0) {
				List<Integer> list=map.getOrDefault(ppid.get(i), new ArrayList<>());
				list.add(pid.get(i));
				map.put(ppid.get(i), list);
			}
		}
		List<Integer> result=new ArrayList<>();
		Queue<Integer> queue=new LinkedList<>();
		queue.add(kill);
		while(!queue.isEmpty()) {
			int p=queue.poll();
			result.add(p);
			if(map.containsKey(p)) {
				for(int i:map.get(p)) {
					queue.add(i);
				}
			}
		}
		return result;
	}


}
