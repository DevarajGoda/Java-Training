package timeAndSpaceComplexity;

import java.util.*;

public class CollectionComparisonInsertion {

	private static long getMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}

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
		long memoryBefor, memoryAfter;

		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();

		System.out.println("============ ArrayList Insertion Time and Space Complexity ===============");

		// Add Element to AyyayList
		for (double i = 0; i < 100010; i++) {
			arrayList.add(i);
		}

		// Calculate the time After adding to ArrayList
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		long arrayListTime = endTime - startTime;
		long arrayListSpace = memoryAfter - memoryBefor;

		System.out.println("ArrayList insertion time :" + arrayListTime + " nanoSecond");
		System.out.println("ArrayList memory usage :" + arrayListSpace + " bytes");
		System.out.println("");

		System.out.println("============ LinkedList Insertion Time and Space Complexity ===============");

		// Add Element to LinkedList
		for (double i = 0; i < 100010; i++) {
			linkedList.add(i);
		}

		// Calculate the time After adding to LinkedList
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		long linkedListTime = endTime - startTime;
		long linkedListSpace = memoryAfter - memoryBefor;

		System.out.println("LinkedList insertion time :" + linkedListTime + " nanoSecond");
		System.out.println("LinkedList memory usage :" + linkedListSpace + " bytes");
		System.out.println("");

		System.out.println("*********************** ArreyList vs LinkedList ************************");

		long differentTime;
		if (arrayListTime < linkedListTime) {
			differentTime = linkedListTime - arrayListTime;
			System.out
					.println("ArrayList adding time is smaller then LinkedList & Time different is : " + differentTime);
		} else {
			differentTime = arrayListTime - linkedListTime;
			System.out
					.println("LinkedList adding time is smaller then ArrayList & Time different is : " + differentTime);

		}
		System.out.println("**************************************************************************");
		System.out.println("");
		System.out.println("============== HashSet Insertion Time and Space Complexity ===============");
		for (double i = 0; i < 10000; i++) {
			hashSet.add(i);
		}

		// Calculate the time After adding to HashSet
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		long hashSetTime = endTime - startTime;
		long hashSetSpace = memoryAfter - memoryBefor;

		System.out.println("HashSet insertion time :" + hashSetTime + " nanoSecond");
		System.out.println("HashSet memory usage :" + hashSetSpace + " bytes");
		System.out.println("");

		System.out.println("============= TreeSet Insertion Time and Space Complexity ===================");
		for (double i = 0; i < 10000; i++) {
			treeSet.add(i);
		}

		// Calculate the time After adding to TreeSet
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		long treeSetTime = endTime - startTime;
		long treeSetSpace = memoryAfter - memoryBefor;

		System.out.println("TreeSet insertion time :" + treeSetTime + " nanoSecond");
		System.out.println("TreeSet memory usage :" + treeSetSpace + " bytes");
		System.out.println("");

		System.out.println("*********************** HashSet vs TreeSet ************************");
		long differentTime2;
		if (hashSetTime < treeSetTime) {
			differentTime2 = treeSetTime - hashSetTime;
			System.out.println("HashSet adding time is smaller then TreeSet & Time different is : " + differentTime2);
		} else {
			differentTime2 = hashSetTime - treeSetTime;
			System.out.println("TreeSet adding time is smaller then HashSet & Time different is : " + differentTime2);
		}

		System.out.println("**************************************************************************");
		System.out.println("");

		System.out.println("============= HashMap Insertion Time and Space Complexity ===================");
		for (long i = 0; i < 10000; i++) {
			hashMap.put(1l, "Dev");
		}

		// Calculate the time After adding to HashMap
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		long hashMapTime = endTime - startTime;
		long hashMapSpace = memoryAfter - memoryBefor;

		System.out.println("HashMap insertion time :" + hashMapTime + " nanoSecond");
		System.out.println("HashMap memory usage :" + hashMapSpace + " bytes");
		System.out.println("");

		System.out.println("============= TreeMap Insertion Time and Space Complexity ===================");
		for (long i = 0; i < 10000; i++) {
			treeMap.put(1l, "Dev");
		}

		// Calculate the time After adding to TreeMap
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		long treeMapTime = endTime - startTime;
		long treeMapSpace = memoryAfter - memoryBefor;

		System.out.println("TreeMap insertion time :" + treeMapTime + " nanoSecond");
		System.out.println("TreeMap memory usage :" + treeMapSpace + " bytes");
		System.out.println("");

		System.out.println("*********************** HashSet vs TreeSet ************************");
		long differentTime3;
		if (hashMapTime < treeMapTime) {
			differentTime3 = treeMapTime - hashMapTime;
			System.out.println("HashMap adding time is smaller then TreeMap & Time different is : " + differentTime3);
		} else {
			differentTime3 = hashMapTime - treeMapTime;
			System.out.println("TreeMap adding time is smaller then HashMap & Time different is : " + differentTime3);
		}

		System.out.println("**************************************************************************");
	}

}
