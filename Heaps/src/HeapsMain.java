import java.util.InputMismatchException;
import java.util.Scanner;

public class HeapsMain{	
	
	private static int[] heapNodes;
	private static boolean maxHeap = false;
	private static boolean minHeap = false;	
	private static final int maxSize = 1000;
	
	public static void main(String[] args){
				
		Heaps heap;
		
		while(true){
			
			try{
				
				heap = new Heaps(maxSize);
	
				Scanner keyIn = new Scanner(System.in);
				
				System.out.println("\n\t--------------- H E A P S ---------------");
				System.out.print("\t	Start with [0/n]: ");
				int startNum = keyIn.nextInt();
				keyIn.nextLine();
				
				if(startNum > 0){
												
					System.out.println("\n\tEnter array elements: ");				
					
					heapNodes = new int[startNum + 1];
					
					for(int i = 1; i <= startNum; i++){
						
						System.out.printf("\tElement %d: ", i);
						heapNodes[i] = keyIn.nextInt();
											
					}													
				}
	
				keyIn.nextLine();
				
				System.out.printf("\n\tInput accepted. Size of n set to %d.\n", startNum);				
				System.out.print("\n\tChoose heap order [ma(x) / mi(n)]: ");
				String h = keyIn.nextLine();
				
				if(h.length() > 1 || (!h.equals("x") && !h.equals("n"))){
					throw new InputMismatchException();
				}						
				
				if(h.equalsIgnoreCase("x")){
				
					System.out.println("\n\tMax-heap order selected.... Heapifying... done.");
					
					maxHeap = true;
					minHeap = false;
					
					heap.setOrder(maxHeap, minHeap);									
					
					for(int i = 1; i <= startNum; i++){
						heap.addToHeap(heapNodes[i]);
					}
					
				}
				
				if(h.equalsIgnoreCase("n")){
					
					System.out.println("\n\tMin-heap order selected.... Heapifying... done.");
					
					maxHeap = false;
					minHeap = true;
					
					heap.setOrder(maxHeap, minHeap);
					
					for(int i = 1; i <= startNum; i++){
						heap.addToHeap(heapNodes[i]);
					}
					
				}
												
				while(true){
					
					//show resulting heap
					System.out.println("\n\nResulting Heap:\n");
					heap.printHeap(heap.heapArray[1], 0, 1);
					System.out.println();
					
					
					try{
						
						System.out.print("\n\tChoose Operation [(D)elete / (I)nsert / (E)xit]: ");
						String s = keyIn.nextLine();
						
						if(s.length() > 1 || ((!s.equalsIgnoreCase("D") && !s.equalsIgnoreCase("I") && !s.equalsIgnoreCase("E")))){
							throw new InputMismatchException();
						}
						
						if(s.equalsIgnoreCase("D")){
							//call delete function;
							heap.delete();
							
						}
						
						if(s.equalsIgnoreCase("I")){
							
							System.out.print("\n\tInsert value to insert: ");
							int val = keyIn.nextInt();
							keyIn.nextLine();
							
							heap.addToHeap(val);																			
							
						}
						
						if(s.equalsIgnoreCase("E")){
							
							maxHeap = false;
							minHeap = false;
							heapNodes = null;
							heap.heapArray = null;
							
							break;
						}
					
					}catch(InputMismatchException e){
						System.out.println("\n\tInvalid input. Please try again.");
					}
				}
				
			}catch(InputMismatchException e){
				System.out.println("\n\tInvalid Input. Please try again.\n");
			}
			
		}
	}
}