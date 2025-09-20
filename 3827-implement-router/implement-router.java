import java.util.*;

class Router {
    private int memoryLimit;
    private Queue<int[]> fifo;
    private Set<String> packetSet;
    private Map<Integer, ArrayList<Integer>> destTimestamps;
    private Map<Integer, ArrayList<Integer>> destPrefix;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.fifo = new LinkedList<>();
        this.packetSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.destPrefix = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false;

        if (fifo.size() == memoryLimit) {
            int[] old = fifo.poll();
            String oldKey = old[0] + "#" + old[1] + "#" + old[2];
            packetSet.remove(oldKey);

            ArrayList<Integer> ts = destTimestamps.get(old[1]);
            ArrayList<Integer> pf = destPrefix.get(old[1]);
            int idx = Collections.binarySearch(ts, old[2]);
            ts.remove(idx);
            pf.remove(idx);
            for (int i = idx; i < pf.size(); i++) pf.set(i, pf.get(i) - 1);
        }

        fifo.offer(new int[]{source, destination, timestamp});
        packetSet.add(key);

        destTimestamps.putIfAbsent(destination, new ArrayList<>());
        destPrefix.putIfAbsent(destination, new ArrayList<>());
        ArrayList<Integer> ts = destTimestamps.get(destination);
        ArrayList<Integer> pf = destPrefix.get(destination);

        ts.add(timestamp);
        if (pf.isEmpty()) pf.add(1);
        else pf.add(pf.get(pf.size() - 1) + 1);

        return true;
    }

    public int[] forwardPacket() {
        if (fifo.isEmpty()) return new int[0];
        int[] pkt = fifo.poll();
        String key = pkt[0] + "#" + pkt[1] + "#" + pkt[2];
        packetSet.remove(key);

        ArrayList<Integer> ts = destTimestamps.get(pkt[1]);
        ArrayList<Integer> pf = destPrefix.get(pkt[1]);
        int idx = Collections.binarySearch(ts, pkt[2]);
        ts.remove(idx);
        pf.remove(idx);
        for (int i = idx; i < pf.size(); i++) pf.set(i, pf.get(i) - 1);

        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;
        ArrayList<Integer> ts = destTimestamps.get(destination);
        ArrayList<Integer> pf = destPrefix.get(destination);
        if (ts.isEmpty()) return 0;

        int l = lowerBound(ts, startTime);
        int r = upperBound(ts, endTime) - 1;
        if (l > r) return 0;

        int left = (l == 0 ? 0 : pf.get(l - 1));
        return pf.get(r) - left;
    }

    private int lowerBound(ArrayList<Integer> arr, int x) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int x) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) > x) r = m;
            else l = m + 1;
        }
        return l;
    }
}
