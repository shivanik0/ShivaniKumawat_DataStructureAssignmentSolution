package floors.assembly;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ConstructionOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int noOfFloors,dayNo,floorSize,floor;

		System.out.print("Enter the total number of floors in the building:");
		noOfFloors=scanner.nextInt();

		Queue<Integer> queue1=new LinkedList<Integer>();
		Queue<Integer> queue2=new LinkedList<Integer>();

		//Insert floors to Queue
		for (int i=1;i<=noOfFloors;) {
			System.out.println("Enter the floor size given on Day:"+i);
			floorSize=scanner.nextInt();
			if (floorSize>0 && floorSize<=noOfFloors && !queue1.contains(floorSize)) {
				queue1.add(floorSize);
				i++;
			}
			else
				System.out.println("Enter valid floor number!");			
		}

		//Construction order of floors
		System.out.println("\nThe order of construction is as follows:");			

		floor=noOfFloors;
		dayNo=0;
		while(queue1.size()!=0) {
			dayNo++;
			System.out.println();
			System.out.println("Day: "+dayNo);
			if (floor==queue1.peek()) {
				queue1.remove();
				System.out.print(floor+" ");
				floor=floor-1;
				while(queue2.size()!=0 && queue2.contains(floor)) {
					System.out.print(floor+" ");
					floor=floor-1;
				}
			}
			else {
				queue2.add(queue1.remove());
			}
		}
		scanner.close();
	}	
}
