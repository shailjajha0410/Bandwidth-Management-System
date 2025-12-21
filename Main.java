import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Priority Queue for traffic scheduling
        PriorityQueue<TrafficPacket> queue = new PriorityQueue<>();

        int totalBandwidth = 100;   // Total available bandwidth
        int currentTime = 0;        // ⬅️ TIME STARTS HERE
        int choice;

        do {
            System.out.println("\n--- Bandwidth Management System ---");
            System.out.println("1. Add Traffic Request");
            System.out.println("2. Process Traffic");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    System.out.print("Enter Bandwidth Required (Mbps): ");
                    int bw = sc.nextInt();

                    System.out.print("Enter Priority (1-High, 2-Medium, 3-Low): ");
                    int priority = sc.nextInt();

                    System.out.print("Enter Duration (time units): ");
                    int duration = sc.nextInt();

                    queue.add(new TrafficPacket(userId, bw, priority, duration));
                    System.out.println("Traffic request added successfully.");
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No traffic to process.");
                        break;
                    }

                    TrafficPacket p = queue.poll();

                    if (p.bandwidth <= totalBandwidth) {
                        totalBandwidth -= p.bandwidth;

                        // ⬇️ TIME UPDATE HAPPENS HERE
                        currentTime += p.duration;

                        System.out.println("User " + p.userId +
                                " served with " + p.bandwidth + " Mbps");
                        System.out.println("Packet completed at time: " + currentTime);
                        System.out.println("Remaining bandwidth: " + totalBandwidth + " Mbps");
                    } else {
                        System.out.println("User " + p.userId +
                                " dropped due to insufficient bandwidth");
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
