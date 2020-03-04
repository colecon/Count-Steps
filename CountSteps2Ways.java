//Cole Constantino | 2 iterative and recursive way to count how many 
//ways you can go up n steps with runtimes
public class CountSteps2Ways{
  
  //dynaSoln - O(N)
  public static int dynamSolution(int n){
    int[] arr = new int[n+1];
    arr[0] = 1;
    arr[1] = 1;
    for(int i = 2; i <= n; i++){
      arr[i] = arr[i-1] + arr[i-2];
    }
    return arr[n];
  }

  //recurseSoln - worst: O(n^2)
  public static int recurseSolution(int n){
    return helper(1,1,2,n);
  }
  
  public static int helper(int twoAgo, int oneAgo, int curr, int count){
    //first 2 values are already accounted for so stop when count == 2
    if(count == 2) return curr;
    return helper(oneAgo, curr, oneAgo + curr, count = count -1);
  }
  
  //Main method setup
  public static void main(String[] args){
    
    long start1 = System.currentTimeMillis();
    System.out.println(dynamSolution(20));
    long stop1 = System.currentTimeMillis();
    System.out.println("Iterative Solution RunTime: " + (stop1 - start1) + " ms\n");
    
    long start2 = System.currentTimeMillis();
    System.out.println(recurseSolution(20));
    long stop2 = System.currentTimeMillis();
    System.out.println("Rescursive Solution RunTime: " + (stop2 - start2) + " ms");
  }
}