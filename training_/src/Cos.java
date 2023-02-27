public class Cos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int n = in.nextInt();
        int m = in.nextInt();

        // Initialize deque and set with the first M elements
        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
        }

        int maxUnique = set.size(); // Keep track of the maximum number of unique elements
        maxUnique = Math.max(maxUnique, set.size()); // Update the maximum with the first subarray

        // Slide the window through the array
        for (int i = m; i < n; i++) {
            int num = in.nextInt();

            // Remove the first element from the deque and the set, if it is present
            int first = deque.removeFirst();
            set.remove(first);

            // Add the new element to the deque and the set
            deque.add(num);
            set.add(num);

            // Update the maximum number of unique elements
            maxUnique = Math.max(maxUnique, set.size());
        }

        System.out.println(maxUnique);
    }
}
