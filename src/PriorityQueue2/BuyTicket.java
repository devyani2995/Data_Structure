/*
 * You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. 
 * Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).
The tickets are sold in the following manner -
1. The first person (pi) in the queue requests for the ticket.
2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without 
    giving him the ticket.
3. Otherwise, give him the ticket (and don't make him stand in queue again).
Giving a ticket to a person takes exactly 1 second and it takes no time for removing and adding a person to the queue.
 And you can assume that no new person joins the queue.
Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). 
Find and return the time it will take until you get the ticket.
 */

package PriorityQueue2;
import java.util.*;
public class BuyTicket {
	public static int buyTicket(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
       Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            queue.add(i);
            pq.add(input[i]);
        }
        int time=0;
        while (!queue.isEmpty()){
            if (input[queue.peek()] < pq.peek())
            {
                queue.add(queue.poll());
            }
            else
            {
                int idx = queue.poll();
                pq.remove();
                time++;
                if (idx == k)
                {
                    break;
                }
            }
        }
        return time;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,9,4};
		int k=2;
		System.out.println(buyTicket(arr,k));
	}

}
