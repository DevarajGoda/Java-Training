package timeAndSpaceComplexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionComparisonRemove {

	public static void main(String[] args) {

		// ArrayList and LinkedList deceleration
		List<Double> arrayList = new ArrayList<>();
		List<Double> linkedList = new LinkedList<>();

		// HashSet and TreeSet deceleration
		Set<Double> hashSet = new HashSet<>();
		Set<Double> treeSet = new TreeSet<>();

		// HashMap and TreeMap deceleration
		Map<Long, String> hashMap = new HashMap<>();
		Map<Long, String> treeMap = new TreeMap<>();

		// time deceleration
		long startTime, endTime;
		startTime = System.nanoTime();

		System.out.println("============ ArrayList Remove Time Complexity ===============");

		//adding
		for (double i = 0; i < 10000; i++) {
			arrayList.add(i);
		}
		
		// Removing one Element to AyyayList
		arrayList.remove(100);

		// Calculate the time After adding from ArrayList
		endTime = System.nanoTime();
		long arrayListTime = endTime - startTime;

		System.out.println("ArrayList removing time :" + arrayListTime + " nanoSecond");
		System.out.println("");

		System.out.println("============ LinkedList Remove Time Complexity ===============");

		//adding
		for (double i = 0; i < 10000; i++) {
			linkedList.add(i);
		}
		
		// Removing Element to LinkedList
		linkedList.remove(100);

		// Calculate the time After removing from LinkedList
		endTime = System.nanoTime();
		long linkedListTime = endTime - startTime;

		System.out.println("LinkedList removing time :" + linkedListTime + " nanoSecond");
		System.out.println("");

		System.out.println("*********************** ArreyList vs LinkedList Removing ************************");

		long differentTime;
		if (arrayListTime < linkedListTime) {
			differentTime = linkedListTime - arrayListTime;
			System.out.println(
					"ArrayList removing time is smaller then LinkedList & Time different is : " + differentTime);
		} else {
			differentTime = arrayListTime - linkedListTime;
			System.out.println(
					"LinkedList removing time is smaller then ArrayList & Time different is : " + differentTime);

		}
		System.out.println("**************************************************************************");
		System.out.println("");

		System.out.println("============== HashSet Removing Time Complexity ===============");

	
		for (double i = 0; i < 100010; i++) {
			hashSet.add(i);
		}
		
	 // Removing from HashSet
		hashSet.remove(100);

		// Calculate the time After removing from HashSet
		endTime = System.nanoTime();
		long hashSetTime = endTime - startTime;

		System.out.println("HashSet removing time :" + hashSetTime + " nanoSecond");
		System.out.println("");

		System.out.println("============= TreeSet Removing Time Complexity ===================");

		//adding
		for (double i = 0; i < 100010; i++) {
			treeSet.add(i);
		}
		
	   // Removing from HashSet
		treeMap.remove(100);

		// Calculate the time After removing from TreeSet
		endTime = System.nanoTime();
		long treeSetTime = endTime - startTime;

		System.out.println("TreeSet removing time :" + treeSetTime + " nanoSecond");
		System.out.println("");

		System.out.println("*********************** HashSet vs TreeSet ************************");
		long differentTime2;

		if (hashSetTime < treeSetTime) {
			differentTime2 = treeSetTime - hashSetTime;
			System.out.println("HashSet removing time is smaller then TreeSet & Time different is : " + differentTime2);
		} else {
			differentTime2 = hashSetTime - treeSetTime;
			System.out.println("TreeSet removing time is smaller then HashSet & Time different is : " + differentTime2);
		}

		System.out.println("**************************************************************************");
		System.out.println("");

		System.out.println("============= HashMap Removing Time Complexity ===================");
		
		//adding
		for (long i = 0; i < 10000; i++) {
			hashMap.put(1l, "dev");
		}
		
		// removing from HashMap
		hashMap.remove(100l);

		// Calculate the time After adding to HashMap
		endTime = System.nanoTime();
		long hashMapTime = endTime - startTime;

		System.out.println("HashMap Removing time :" + hashMapTime + " nanoSecond");
		System.out.println("");

		System.out.println("============= TreeMap Removing Time and Space Complexity ===================");

		for (long i = 0; i < 10000; i++) {
			treeMap.put(1l, "Dev");
		}
		
		// removing from treeMap
		treeMap.remove(100l);

		// Calculate the time After adding to TreeMap
		endTime = System.nanoTime();
		long treeMapTime = endTime - startTime;

		System.out.println("TreeMap removing time :" + treeMapTime + " nanoSecond");
		System.out.println("");

		System.out.println("*********************** HashSet vs TreeSet ************************");
		long differentTime3;
		if (hashMapTime < treeMapTime) {
			differentTime3 = treeMapTime - hashMapTime;
			System.out.println("HashMap removing time is smaller then TreeMap & Time different is : " + differentTime3);
		} else {
			differentTime3 = hashMapTime - treeMapTime;
			System.out.println("TreeMap removing time is smaller then HashMap & Time different is : " + differentTime3);
		}

		System.out.println("**************************************************************************");
	}

}
