package topK_Elements;

public class ConnectRopes {
//https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
	
	// The main function that returns the 
    // minimum cost to connect n ropes of 
    // lengths stored in len[0..n-1] 
    static int minCost(int len[], int n) 
    { 
        int cost = 0; // Initialize result 
  
        // Create a min heap of capacity equal 
        // to n and put all ropes in it 
        MinHeap minHeap = new MinHeap(len, n); 
  
        // Iterate while size of heap doesn't become 1 
        while (!minHeap.isSizeOne()) { 
            // Extract two minimum length ropes from min heap 
            int min = minHeap.extractMin(); 
            int sec_min = minHeap.extractMin(); 
  
            cost += (min + sec_min); // Update total cost 
  
            // Insert a new rope in min heap with length equal to sum 
            // of two extracted minimum lengths 
            minHeap.insertKey(min + sec_min); 
        } 
  
        // Finally return total minimum 
        // cost for connecting all ropes 
        return cost; 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
