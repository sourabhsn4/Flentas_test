import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = sc.nextInt();	//no. of testcases				
		
		for(int i=1; i<=t; ++i) {
			int n = sc.nextInt();	//no. of villagers
			int sum = 0; 
			//LinkedList<Integer> departedVillagers = new LinkedList<Integer>();
			PriorityQueue<Integer> departedVillagers = new PriorityQueue<>(n);
			LinkedList<Integer> costs = new LinkedList<>();   
			
			for(int j=0; j<n ; ++j) {
				costs.add(sc.nextInt());
			}
			Collections.sort(costs); 	//sorts costs in ascending order
			
			while(!costs.isEmpty()) {
				int villager1 = 0;
				int villager2 = 0;
				if (departedVillagers.isEmpty()) {
					villager1 = costs.removeFirst();
					villager2 = costs.removeFirst();
					sum = sum + villager2;
				}else {
					if(costs.size() > 2) {
						if (costs.get(0) > costs.get(1) + costs.get(0) - departedVillagers.peek()) {
							villager2 = costs.remove(0);
							villager1 = costs.removeLast();
							sum = sum + villager2;
						}else {
							villager1 = costs.removeFirst();
							villager2 = costs.removeFirst();
							sum = sum + villager2;
						}
					}else
					{
						villager1 = costs.removeFirst();
						villager2 = costs.removeFirst();
						sum = sum + Math.max(villager1, villager2);						
					}
				}
				
				departedVillagers.add(villager1);
				departedVillagers.add(villager2);
				if (!costs.isEmpty()) {
					int returnPerson = departedVillagers.poll();
					//System.out.println("return person : "+ returnPerson);
					costs.addLast(returnPerson);
					sum = sum + returnPerson;			
					//System.out.println(sum);					
				}
			}
			System.out.println(sum);
		} 
	}
}
