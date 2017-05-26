public class Heaps{
	
	private static boolean maxHeap = false;
	private static boolean minHeap = false;
	
	private final int maxSize;
	private int currentSize = 1;
	public Node[] heapArray; 
	
	public Heaps(int max){
		
		maxSize = max;
		heapArray = new Node[maxSize];
		
	}
	
	public void addToHeap(int val){
		
		heapArray[currentSize++] = new Node(val);		
		percolationUp();
		
	}	
	
	public void printHeap(Node root, int level, int k){
		
		try{
			root.getData();
		}catch(NullPointerException e){
			return;
		}
	    
	    	    
	    int right = 2 * k + 1;
	    int left = 2 * k;
	    
	    printHeap(heapArray[right], level+1, right);
	    
	    if(level != 0){
	        for(int i = 0; i < level-1; i++)
	            System.out.print("|\t");
	        	
	        	if(heapArray[left] == null && heapArray[right] == null)
	        		System.out.println("|------[" + root.getData() + "]");	
	        	else
	        		System.out.println("|------[" + root.getData() + "]");
	    }else
	    	System.out.println("[" + root.getData() + "]");
	   
	    printHeap(heapArray[left], level+1, left);
	}
	
	public Node delete(){
		
		Node root = heapArray[1];
		heapArray[1] = heapArray[currentSize-1];
		heapArray[--currentSize] = null;				
		percolationDown(1);
		
		return root;		
	}
	
	public void percolationDown(int index){
		
		int largerChild;
		int smallerChild;
		Node top = heapArray[index];      
		
		while(index < currentSize/2){
			
         int leftChild = 2 * index;
         int rightChild = leftChild + 1;                                            
                     
         if(rightChild < currentSize){
        	
        	 if(heapArray[leftChild].getData() < heapArray[rightChild].getData()){
        	 
        		 largerChild = rightChild;
        		 smallerChild = leftChild;
         	
        	 }else{            
        		 largerChild = leftChild;            
        		 smallerChild = rightChild;
        	 }        	 
		}else{			
			 largerChild = leftChild;            
    		 smallerChild = leftChild;			
		}
         
         if(maxHeap){        	         	         	 
        	 if( top.getData() >= heapArray[largerChild].getData())
        		 break;
        	         	 
        	 heapArray[index] = heapArray[largerChild];
             index = largerChild;           
         }
         
         if(minHeap){
        	  
        	 if( top.getData() <= heapArray[smallerChild].getData())
        		 break;
        	 
        	 heapArray[index] = heapArray[smallerChild];
             index = smallerChild;                   	 
         }                 
         
		} 
      
		heapArray[index] = top;  
		
      } 	
	
	private void percolationUp(){					
		
		if(currentSize-1 > 1){
			
			int k = currentSize-1;
			int parent = k / 2;					
					
			while(parent > 0){
				
				if(maxHeap){
					
					if(heapArray[parent].getData() > heapArray[k].getData())													
						break;										
				}
				
				if(minHeap){
				
					if(heapArray[parent].getData() < heapArray[k].getData())
						break;
				}
				
				int temp = heapArray[parent].getData();				
				heapArray[parent].setData(heapArray[k].getData());
				heapArray[k].setData(temp);
				
				
				k = parent;
				parent = k / 2;
			}
		}
		
	}

	
	public void setOrder(boolean max, boolean min){
		
		maxHeap = max;
		minHeap = min;
		
	}
}