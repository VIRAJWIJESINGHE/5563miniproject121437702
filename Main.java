public class Main {

    // Method to allocate memory to processes based on the First Fit Algorithm
    static void allocateMemory(int[] memoryBlocks, int numBlocks, int[] processes, int numProcesses) {

       
        int[] allocation = new int[numProcesses];

        
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;  // -1 means no block is assigned
        }

        
        for (int i = 0; i < numProcesses; i++) {
            
            for (int j = 0; j < numBlocks; j++) {
                if (memoryBlocks[j] >= processes[i]) {
                   
                    allocation[i] = j;

                    
                    memoryBlocks[j] -= processes[i];

                    break; 
                }
            }
        }

        // Display the results
        System.out.println("\nProcess No.\tProcess Size\tBlock No.");
        for (int i = 0; i < numProcesses; i++) {
            System.out.print(" " + (i + 1) + "\t\t" + processes[i] + "\t\t");
            if (allocation[i] != -1) {
               
                System.out.print("Block " + (allocation[i] + 1));
            } else {
                
                System.out.print("Not Allocated");
            }
            System.out.println();
        }
    }

    // Main driver code
    public static void main(String[] args) {
        // Block sizes
        int[] memoryBlocks = {100,200, 300, 400, 500};
        
        // Process sizes
        int[] processes = {12, 347, 112, 7,321};
        
        // Number of blocks and processes
        int numBlocks = memoryBlocks.length;
        int numProcesses = processes.length;

        // Call the  method 
        allocateMemory(memoryBlocks, numBlocks, processes, numProcesses);
    }
}
