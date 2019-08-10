package mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class ConflictingAppointments {
	/*
	 * http://karmaandcoding.blogspot.com/2012/01/find-all-conflicting-appointments-from.html
	 * E5: 4 : 12
E3: 11 : 24
E1: 13 : 15
E2: 18 : 20
E4: 19: 27

Now take the end time of first Event (E5) ie 12 and check in the start time the first event whose start time is greater than 12, in the above example E1 - with start time 13 is the event.
Now we can safely say that all the events less than E1 and greater than E5 are conflicting with E5 - which is E3 in our case.
With the same above logic, E3 is conflicting with E1, E2 and E4.
Time complexity = O(nlogn) for sorting the events on start time + O(nlogn) for searching a all the conflicting events for a given event Ei (1 <= i <= n).
So total time complexity: O(nlogn)
	 * 
	 * Output of the below code:

Events sorted with start time:
5: 4:12
3: 11:24
1: 13:15
2: 18:20
4: 19:27
Conflicts are: 
1 <> 3 
2 <> 3 4 
3 <> 5 1 2 4 
4 <> 3 2 
5 <> 3 

	 * */
	class Event {
		 int id;
		 int start;
		 int end;
		  
		 public Event(int id, int s, int e) {
		  this.id = id;
		  this.start = s;
		  this.end = e;
		 }
		}
	public List<List<Integer>> findConflicts(List<Event> givenList){
		List<List<Integer>> result=new ArrayList<>();
		//Arrays.sort(events, new startEventComparator());
		  int len = givenList.size();
		   
		  for (int i = 0; i < len; i++) {
			  //for each index we seacrh for the next event start index such that current event end< start index of this event
			  //from there can say that all events between these 2 events conflict with this current event
			  
		 
			   int low = i + 1;
			   int high = len - 1;
			   int keyId = givenList.get(i).id;
			   int currEnd_tosearch = givenList.get(i).end;
			   //binary seacrh this in low to high
			   int index_of_startGreater_minus1=0;
			   while(low<=high) {
				   int mid=low+(high-low)/2;
				   if(givenList.get(mid).start<=currEnd_tosearch && givenList.get(mid+1).start>currEnd_tosearch) {
					   //we might find more greater starts before mid but mid also might be our boundary candidate
					   index_of_startGreater_minus1=mid;
					  break;
				   }
				   else if(givenList.get(mid).start<currEnd_tosearch){
					   //this is still less so we move low
					   low=mid+1;
				   }
				   else {
					   high=mid-1;
				   }
			   }
			   
			   
			   List<Integer> conflicting=new ArrayList<>();
			   //now we add all events from i+1 to index_of_startGreater_minus1
			   for(int m=i+1;m<index_of_startGreater_minus1;m++) {
				   //add all event ids into a list
				   
				   conflicting.add(givenList.get(m).id);
			   }
			   result.add(conflicting);
			   
		  }
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
