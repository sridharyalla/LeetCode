package org.sridhar.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

    PriorityQueue<Integer> secondHalf = null;
    PriorityQueue<Integer> firstHalf = null;

    public FindMedianFromDataStream295() {
        secondHalf = new PriorityQueue<>();
        firstHalf = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(firstHalf.isEmpty()){
            firstHalf.add(num);
            return;
        }
        if(num > firstHalf.peek())
            secondHalf.add(num);
        else
            firstHalf.add(num);

        if(firstHalf.size() > secondHalf.size() +1)
            secondHalf.add(firstHalf.poll());

        if(secondHalf.size() > firstHalf.size())
            firstHalf.add(secondHalf.poll());
    }

    public double findMedian() {
        if((firstHalf.size() + secondHalf.size())% 2 == 0)
            return  (double) (firstHalf.peek() + secondHalf.peek())/2.0;
        else
            return firstHalf.peek();
    }

    // addNum(1)
    //addNum(2)
    //findMedian() -> 1.5
    //addNum(3)
    //findMedian() -> 2
    public static void main(String[] args) {
        FindMedianFromDataStream295 p = new FindMedianFromDataStream295();

        p.addNum(1);
        p.addNum(2);
        System.out.println(p.findMedian());
        p.addNum(3);
        System.out.println(p.findMedian());
    }
}
