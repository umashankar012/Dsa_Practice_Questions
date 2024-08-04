public static int findFloor(int []a, int n, int x) {
    int low = 0;
    int high = n-1;
    int ans = -1;

    while(low <= high) {
      int mid = low + (high - low)/2;

      if(a[mid] <= x){
        //may be answer
        ans = a[mid];
        //look in left part 
        low = mid + 1;
      }
      else{
        //look for the right part
        high = mid - 1;
      }
      
    }
    return ans;
  }

public static int findCeil(int []a, int n, int x) {
  int low = 0;
  int high = n-1;
  int ans = -1;

  while(low <= high) {
    int mid = low + (high - low)/2;
    if(a[mid] >= x){
      //may be answer
      ans = a[mid];
      //look for smaller index in left part
      high = mid - 1;
    }
    else{
      //look in the right part
      low = mid + 1;
    }
  }
  return ans;
}

  public static int[] getFloorAndCeil(int[] a, int n, int x) {
    int f = findFloor(a,n,x);
    int c = findCeil(a,n,x);

    return new int[]{f,c} ; 
  
  }


  //T.C -> O(log N)