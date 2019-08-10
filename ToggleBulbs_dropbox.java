package binaryIndexTreesFenwick;

public class ToggleBulbs_dropbox {
	
	//https://www.geeksforgeeks.org/binary-indexed-tree-range-updates-point-queries/
	//same as above queires in binary index trees
	//https://careercup.com/question?id=5668664122540032
	//Question: given n light bulbs, write 2 methods:
	//On(i) to check if light bulb is on/off
	//toggle(x,y) to toggle all light bulbs in the range-->time should be O(logn)
	
	//Binary Indexed Tree(Fenwick Tree) code from Topcoder's Tutorials
/*
 * When we need to toggle range (s,e), we could add 1 to cell s, and -1 to cell e+1. 
Now, every time that we wanna know about the state of a i-th cell, we need to know whether the cumulative sum from 1 to i is even or odd. 

For having an efficient updatable cummulative sum array, we could use Binary Index Tree. 
So updating and reading the state of a cell would be O(logN) 
 * */
	 int maxn=100000;
	int cumulative_sum_binaryIndexTree[]=new int[maxn];
	/* Function to construct fenwick tree  
    from given array.*/
    void constructBITree(int arr[], int n) 
    { 
        // Initialize BITree[] as 0 
        for(int i=1; i<=n; i++) 
        	cumulative_sum_binaryIndexTree[i] = 0; 
      
        // Store the actual values in BITree[] 
        // using update() 
        for(int i = 0; i < n; i++) 
            updateBIT( i, arr[i]); 
    } 
    
    
	int read(int idx){
	    int ans = 0;
	    //until we reach the topmost root which is 0, keep collecting values at each parent nodes 
	    while (idx > 0){
	        ans += cumulative_sum_binaryIndexTree[idx];
	        //used to get index of parent node so that we keep going up until we get to node idx=0 which is the parent
	        idx -= (idx & -idx);
	    }
	    return ans;
	}

	void updateBIT(int idx ,int val){
	    while (idx <= maxn){
	    	cumulative_sum_binaryIndexTree[idx] += val;
	    	//used to get the next generation of nodes that we need to update beacuse of this current change
	        idx += (idx & -idx);
	    }
	}



	boolean isOn(int i)
	{
		//every time that we want to know the state of a i th cell,
		//we need to know whether the cumulative sum from 1 to i is even or odd. 
		return read(i)%2==1;
	}

	void toggle(int start,int end)
	{
		//When we need to toggle range (s,e), we could add 1 to cell s, and add -1 to cell e+1. 
		//as adding 1 to start will flow onto start to maxn
		//then we add -1 from end+1 to maxn as we don't want 1 to be added to cell from end+1 to maxn
		//we want 1 to be added to start to end only
		update(start,1);
		update(end+1,-1);
	}



	int main()
	{

		int Q=0,x=1,y=3;
		char ch='T';
//		cin >> Q;//queries
		while (Q-->0){
			//cin >> ch;
			if (ch=='T'){
				//cin >> x >> y;//1-based indexed;
				toggle(x,y);
			}
			else{
				//cin >> x;
				//cout << isOn(x) << endl;

			}

		}

		return 0;
	}
}
