// Given information about N petrol pumps (say arr[]) that are present in a circular path. 
// The information consists of the distance of the next petrol pump from the current 
// one (in arr[i][1]) and the amount of petrol stored in that petrol pump (in arr[i][0]). 
// Consider a truck with infinite capacity that consumes 1 unit of petrol to travel 1 unit distance. 
// The task is to find the index of the first starting point such that the truck can visit all the petrol 
// pumps and come back to that starting point.

// Input: arr[] = {{4, 6}, {6, 5}, {7, 3}, {4, 5}}. 
// Output: 1
// Explanation: If started from 1st index then a circular tour can be covered

// Input: arr[] {{6, 4}, {3, 6}, {7, 3}}
// Output: 2


import java.util.*;
class CircularTour {

static class petrolPump {

	int petrol;
	int distance;

	petrolPump(int a, int b) {
	this.petrol = a;
	this.distance = b;
	}
};

static int printTour(petrolPump p[], int n) {

	int start = 0, deficit = 0;
	int capacity = 0;
	for (int i = 0; i < n; i++) {
	capacity += p[i].petrol - p[i].distance;
	if (capacity < 0) {
		start = i + 1;
		deficit += capacity;
		capacity = 0;
	}
	}
	return (capacity + deficit >= 0) ? start : -1;
}

public static void main(String[] args) {
	petrolPump arr[] = { new petrolPump(6, 4), new petrolPump(3, 6), new petrolPump(7, 3) };

	int n = arr.length;
	int start = printTour(arr, n);

	if (start == -1)
	System.out.print("No solution");
	else
	System.out.print("Start = " + start);

}
}

