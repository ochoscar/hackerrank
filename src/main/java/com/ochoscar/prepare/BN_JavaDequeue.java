package com.ochoscar.prepare;

import java.util.*;

/**
 * In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).
 *
 * Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:
 *
 * Deque deque = new LinkedList<>();
 * or
 * Deque deque = new ArrayDeque<>();
 * You can find more details about Deque here.
 *
 * In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .
 *
 * Note: Time limit is  second for this problem.
 *
 * Input Format
 *
 * The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.
 *
 * Constraints
 *
 *
 *
 *
 * The numbers in the array will range between .
 *
 * Output Format
 *
 * Print the maximum number of unique integers among all possible contiguous subarrays of size .
 *
 * Sample Input
 *
 * 6 3
 * 5 3 5 2 3 2
 * Sample Output
 *
 * 3
 * Explanation
 *
 * In the sample testcase, there are 4 subarrays of contiguous numbers.
 *
 *  - Has  unique numbers.
 *
 *  - Has  unique numbers.
 *
 *  - Has  unique numbers.
 *
 *  - Has  unique numbers.
 *
 * In these subarrays, there are  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .
 */
public class BN_JavaDequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
        }

        if(n < m) m = n;

        int max = Integer.MIN_VALUE;
        Set<Integer> nums = new HashSet<>();
        boolean firstTime = true;
        Integer firstNum = null; boolean needRemoveFisrtNum = true;
        for(int i = 0; i < n - m + 1; i++) {
            //nums.clear();
            int j = 0;

            if(firstTime) {
                for (; j < m; j++) {
                    Integer num = deque.pollFirst();
                    if(j == 0) firstNum = num;
                    else if(num.equals(firstNum)) needRemoveFisrtNum = false;
                    nums.add(num);
                    deque.addLast(num);
                    if (nums.size() + (m - j) < max) break;
                }
                firstTime = false;
            } else {
                if(needRemoveFisrtNum) nums.remove(firstNum);

                for (; j < m; j++) {
                    Integer num = deque.pollFirst();
                    if(j == m - 1) nums.add(num);
                    deque.addLast(num);
                    if (nums.size() + (m - j) < max) break;
                }
                needRemoveFisrtNum = true;
                nums.clear();
                firstTime = true;
            }
            if(nums.size() > max) max = nums.size();
            if(max == m) break;
            int k = 0;
            for(;k < j - 1; k++) {
                deque.addFirst(deque.pollLast());
            }
            deque.pollLast();
        }
        System.out.println(max);
    }

}
