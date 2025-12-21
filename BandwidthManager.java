public class BandwidthManager {
    int totalBandwidth;

    BandwidthManager(int totalBandwidth) {
        this.totalBandwidth = totalBandwidth;
    }

    void allocate(User user) {
        if (user.requestedBandwidth <= totalBandwidth) {
            totalBandwidth -= user.requestedBandwidth;
            System.out.println(
                "User " + user.userId +
                " allocated " + user.requestedBandwidth + " Mbps"
            );
        } else {
            System.out.println(
                "User " + user.userId +
                " rejected (Not enough bandwidth)"
            );
        }
    }
}
