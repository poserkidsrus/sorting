/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author JEFFREY ACKAH AND Keil Barracliffe
 */
public class Sort {

    public ArrayList<Integer> fillRandom(int n, int bound) {
        Random rng = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(rng.nextInt(bound));
        }
        return list;
    }

    public void bubbleSort(ArrayList<Integer> numbers) {
        // Boolean to hold whether the list is sorted or not
        boolean sorted = false;

        //While loop to Keep looping until the list is sorted
        while (!sorted) {
            // Set the sorted Boolean to true
            // If we have to swap any items, this will be set to false
            sorted = true;

            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    //swap
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, temp);

                    // Since swap items, the list is not sorted
                    // Set to sort
                    sorted = false;
                }
            }
        }
    }

    public void shellSort(ArrayList<Integer> numbers) {
        // Start with a gap of half the size of the list
        int gap = numbers.size() / 2;

        // Continue until the gap is 1
        while (gap >= 1) {
            // Perform an insertion sort on the list, using the current gap size
            for (int i = gap; i < numbers.size(); i++) {
                int temp = numbers.get(i);
                int j = i;
                while (j >= gap && numbers.get(j - gap) > temp) {
                    numbers.set(j, numbers.get(j - gap));
                    j -= gap;
                }
                numbers.set(j, temp);
            }

            // Reduce the gap size by half
            gap /= 2;
        }
    }

    public  void selectionSort(ArrayList<Integer> numbers) {
        // Loop through the list of numbers
        for (int i = 0; i < numbers.size() - 1; i++) {
            // Set the current item as the minimum
            int min = numbers.get(i);
            int minIndex = i;

            // Loop through the remaining items in the list
            for (int j = i + 1; j < numbers.size(); j++) {
                // Check if the current item is less than the minimum
                if (numbers.get(j) < min) {
                    // If it is, update the minimum and minimum index
                    min = numbers.get(j);
                    minIndex = j;
                }
            }

            // Check if the minimum is not the current item
            if (minIndex != i) {
                // If it isn't, swap the current item with the minimum
                int temp = numbers.get(i);
                numbers.set(i, min);
                numbers.set(minIndex, temp);
            }
        }
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> numbers) {
        // Check if the list has more than one item
        if (numbers.size() > 1) {
            // If it does, split the list into two halves
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            int middle = numbers.size() / 2;
            for (int i = 0; i < middle; i++) {
                left.add(numbers.get(i));
            }
            for (int i = middle; i < numbers.size(); i++) {
                right.add(numbers.get(i));
            }

            // Recursively sort the two halves
            left = mergeSort(left);
            right = mergeSort(right);

            // Merge the two sorted halves and return the result
            return merge(left, right);
        } else {
            // If the list has only one item, return the list
            return numbers;
        }
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> finMerge = new ArrayList<>();
        int m = list1.size();
        int n = list2.size();
        int i = 0, K = 0;
        while (i < m && K < n) {
            if (list1.get(i) < list2.get(K)) {
                finMerge.add(list1.get(i));
                i++;
            } else if (list1.get(i) > list2.get(K)) {
                finMerge.add(list2.get(K));
                K++;
            } else {
                finMerge.add(list1.get(i));
                finMerge.add(list2.get(K));
                i++;
                K++;
            }
        }
        if (i == list1.size()) {
            while (K < list2.size()) {
                finMerge.add(list2.get(K));
                K++;
            }
        } else {
            while (i < list1.size()) {
                finMerge.add(list1.get(i));
                i++;
            }
        }
        return finMerge;
    }

    public void insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > current) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

    public void heapSort(ArrayList<Integer> list) {
        // Build the heap
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            heaping(list, list.size(), i);
        }

        // Extract elements from the heap one by one
        for (int i = list.size() - 1; i >= 0; i--) {
            // Move the current root (maximum value) to the end of the list
            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // Call heaping on the reduced heap
            heaping(list, i, 0);
        }
    }

    // Heapify the list
    public void heaping(ArrayList<Integer> list, int heapSize, int i) {
        int largest = i; // Initialize the largest value as the root
        int left = 2 * i + 1; // Index of the left child
        int right = 2 * i + 2; // Index of the right child

        // If the left child is larger than the root
        if (left < heapSize && list.get(left) > list.get(largest)) {
            largest = left;
        }

        // If the right child is larger than the root
        if (right < heapSize && list.get(right) > list.get(largest)) {
            largest = right;
        }

        // If the largest value is not the root, swap it with the root and heaping the sublist
        if (largest != i) {
            int temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            heaping(list, heapSize, largest);
        }
    }
}
