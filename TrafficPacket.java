public class TrafficPacket implements Comparable<TrafficPacket> {

    int userId;
    int bandwidth;
    int priority;   // 1 = High, 2 = Medium, 3 = Low
    int duration;   // Time units the packet occupies bandwidth

    TrafficPacket(int userId, int bandwidth, int priority, int duration) {
        this.userId = userId;
        this.bandwidth = bandwidth;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public int compareTo(TrafficPacket other) {
        return Integer.compare(this.priority, other.priority);
    }
}
