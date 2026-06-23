class KthLargest {
    PriorityQueue<Integer> pq;
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
