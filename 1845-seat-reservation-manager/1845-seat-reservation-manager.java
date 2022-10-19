class SeatManager {
    //mean heap to keep the elements ordered 
    PriorityQueue<Integer> unreservedSeats = new PriorityQueue<>();
    Set<Integer> reservedSeats = new HashSet<>(); // for constant lookup

    public SeatManager(int n) {
        
        for (int i = 1; i <= n; i++) {
            unreservedSeats.add(i);   // O(n log n)
        }
        
    }
    
    public int reserve() {
        
        int reserved = unreservedSeats.remove();
        reservedSeats.add(reserved);
        return reserved;
        
    }
    
    public void unreserve(int seatNumber) {
        if (reservedSeats.contains(seatNumber)) {
            reservedSeats.remove(seatNumber);
            unreservedSeats.add(seatNumber);
        }        
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */