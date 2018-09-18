// add: O(nlogn), get: O(1)
class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> nums;
    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
        Collections.sort(nums);
    }
    
    public double findMedian() {
        int size = nums.size();
        if (size % 2 != 0) {
            // odd
            return nums.get(size / 2);
        } else {
            // even
            double ans = (nums.get(size / 2 - 1) + nums.get(size / 2)) / 2.0;
            return ans;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// add: O(logn) , get: O(1)
class MedianFinder {

    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }
};