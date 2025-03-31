import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CourseDBStructure implements CourseDBStructureInterface and functions as a hash table.
 */
public class CourseDBStructure implements CourseDBStructureInterface {
    private ArrayList<LinkedList<CourseDBElement>> hashTable;
    private int tableSize;

    /**
     * Constructor that takes estimated number of courses and calculates table size using 4k+3 prime logic.
     */
    public CourseDBStructure(int n) {
        int estimatedSize = (int)(n / 1.5);
        this.tableSize = getNext4kPlus3Prime(estimatedSize);
        initTable();
    }

    /**
     * Constructor for testing, takes size directly.
     */
    public CourseDBStructure(String testing, int size) {
        this.tableSize = size;
        initTable();
    }

    private void initTable() {
        hashTable = new ArrayList<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            hashTable.add(null);
        }
    }

    private int getNext4kPlus3Prime(int start) {
        int k = start / 4;
        while (true) {
            int candidate = 4 * k + 3;
            if (isPrime(candidate)) return candidate;
            k++;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public void add(CourseDBElement element) {
        int index = Math.abs(element.hashCode()) % tableSize;
        LinkedList<CourseDBElement> bucket = hashTable.get(index);

        if (bucket == null) {
            bucket = new LinkedList<>();
            bucket.add(element);
            hashTable.set(index, bucket);
        } else {
            boolean updated = false;
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i).getCRN() == element.getCRN()) {
                    bucket.set(i, element);
                    updated = true;
                    break;
                }
            }
            if (!updated) bucket.add(element);
        }
    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = Math.abs(Integer.toString(crn).hashCode()) % tableSize;
        LinkedList<CourseDBElement> bucket = hashTable.get(index);

        if (bucket != null) {
            for (CourseDBElement e : bucket) {
                if (e.getCRN() == crn) return e;
            }
        }
        throw new IOException("CRN " + crn + " not found");
    }

    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> result = new ArrayList<>();
        for (LinkedList<CourseDBElement> bucket : hashTable) {
            if (bucket != null) {
                for (CourseDBElement e : bucket) {
                    result.add("\n" + e.toString());
                }
            }
        }
        return result;
    }

    @Override
    public int getTableSize() {
        return tableSize;
    }
}
