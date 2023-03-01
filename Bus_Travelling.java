import java.util.Scanner;
import java.util.*;
class BusTravelling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of cities");
        int cities = sc.nextInt();
        System.out.println("Enter routes of buses and cost");
        int buses[][] = new int[cities][3];
        // buses array will be defined in this way -- {{city1 , city2 , cost of travel
        // from city 1 to city2 }}
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < 3; j++) {
                buses[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter Source");
        int src = sc.nextInt();
        System.out.println("Enter destination");
        int dst = sc.nextInt();
        System.out.println("Enter no. of stops");
        int stop = sc.nextInt();
        System.out.println(
            "The Least cost of travelling is " + "  " + findPath(cities, buses, src, dst, stop));
    }
    public static int findPath(int n, int[][] buses, int src, int dst, int k) {
        int prev[] = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[src] = 0;
        int cur[] = new int[n];
        for (int j = 0; j < n; j++) {
            cur[j] = prev[j];
        }
        for (int e[]: buses) {
            int u = e[0], v = e[1], wt = e[2];
            if (prev[u] != Integer.MAX_VALUE && prev[u] + wt < cur[v]) {
                cur[v] = prev[u] + wt;
            }
        }
        for (int j = 0; j < n; j++) {
            prev[j] = cur[j];
        }
        return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
    }
}

