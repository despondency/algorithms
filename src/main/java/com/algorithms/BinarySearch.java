package com.algorithms;

public class BinarySearch {

	private int A[];
	public BinarySearch(int A[]){
		this.A = A;
	}
	public int equalBound(int n){
		int hi = A.length; int lo = 0;
		while ( hi >= lo ){
			int mid = lo + ((hi-lo)/2);
			if (A[mid] == n){
				return mid;
			}
			else if(A[mid] < n){
				lo = mid + 1;
			}
			else if (A[mid] > n){
				hi = mid - 1;
			}
		}
		return -1; // does not exist
	}

	//returns first element bigger than the searched element if its not found
	// if there is no bigger element it returns array.length + 1 indx out of the array
	public int lowerBound(int n){
		int hi = A.length; int lo = 0;
		while ( hi > lo ){
			int mid = lo + ((hi-lo)/2);
			if(A[mid] >= n){
				hi = mid;
			}
			else{
				lo = mid + 1;
			}
		}
		return lo;
	}
	// returns first bigger element than the one that is being searched for
	// if there is no bigger element it returns array.length + 1 indx out of the array
	public int upperBound(int n){
		int hi = A.length; int lo = 0;
		while ( hi > lo ){
			int mid = lo + ((hi-lo)/2);
			if(A[mid] <= n){
				lo = mid + 1;
			}else{
				hi = mid;
			}
		}
		return lo;
	}
}
