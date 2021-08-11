// Use one hashmap to record all checkin customer. 
// Once a customer checked out, use another hashmap
// to store all station-to-station time where the value is
// a pair(time sum, the number of records).

class UndergroundSystem {

    private HashMap<Pair<String, String>, Pair<Integer, Integer>> record;
    private HashMap<Integer, Pair<String, Integer>> in;

    public UndergroundSystem() {
        this.record = new HashMap<>();
        this.in = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.in.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> customer = this.in.get(id);
        Pair<String, String> stations = new Pair(customer.getKey(), stationName);

        int diff = t - customer.getValue();

        Pair<Integer, Integer> time = new Pair(diff, 1);
        if (this.record.containsKey(stations)) {
            time = this.record.get(stations);
            int count = time.getValue();
            int sum = time.getKey();
            time = new Pair(sum + diff, count + 1);
        }

        this.record.put(stations, time);
    }

    public double getAverageTime(String startStation, String endStation) {
        double sum = 0.0;
        Pair<String, String> stations = new Pair(startStation, endStation);

        if (this.record.containsKey(stations)) {
            Pair<Integer, Integer> time = this.record.get(stations);
            sum = (double) time.getKey() / time.getValue();
        }
        return sum;
    }
}
