import java.util.*;

public class mergesort_np03cs4a220210 {
    public static void getInput(ArrayList<Integer> al) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the number for index " + i);
            al.add(scanner.nextInt());
        }
        System.out.println("Unsorted array: ");
        System.out.println(al);
    }

    public static void getOutput(ArrayList<Integer> al) {
        System.out.println("Sorted Array: ");
        System.out.print("[");
        for (int i = 0; i < al.size(); i++) {
            if (i == al.size() - 1) {
                System.out.print(al.get(i));
            } else {
                System.out.print(al.get(i) + ", ");
            }
        }
        System.out.print("]");
    }

    public static void merge(ArrayList<Integer> al, int beg, int mid, int end) {
        int beginning = beg;
        int middleIndex = mid + 1;
        int ending = end;

        while (beginning <= middleIndex && middleIndex <= ending) {
            if (al.get(beginning) > (al.get(middleIndex))) {
                al.add(beginning, al.remove(middleIndex));
                beginning++;
                middleIndex++;
            } else if (Objects.equals(al.get(beginning), al.get(middleIndex))) {
                al.add(beginning, al.remove(middleIndex));
                beginning++;
                middleIndex++;
            } else {
                beginning++;
            }
        }
    }

    public static void sort(ArrayList<Integer> al, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            sort(al, beg, mid);
            sort(al, mid + 1, end);
            merge(al, beg, mid, end);
        }
    }

    public static void main(String[] args) {
        mergesort_np03cs4a220210 ob = new mergesort_np03cs4a220210();
        ArrayList<Integer> al = new ArrayList<>();
        ob.getInput(al);
        ob.sort(al, 0, al.size() - 1);
        ob.getOutput(al);
    }
}