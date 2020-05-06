package main.java.leetcode;
import java.util.*;
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
