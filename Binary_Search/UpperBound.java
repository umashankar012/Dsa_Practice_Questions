public static int upperBound(int []arr, int x, int n){
    int ans = n; //returning answer
    int low = 0;
    int high = n-1;

    while(low <= high) {
        int mid = low + (high - low)/2;

        if(arr[mid] > x) {
            ans = mid;
            high = mid-1;
        }
        else{
            low = mid + 1;
        }

    }
    return ans;
}

//T.C - O(logn)