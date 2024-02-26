package Homework3;

public class HashTable<Key, Value> {
    private int size;              // how many key/value pairs are stored
    private int arrayLength;       // size of the array (and consequently, the mod)
    private Key[] keys;
    private Value[] vals;
    private boolean[] tombstones;  // true if element at this index has been deleted, false otherwise

    public HashTable() {
        this(1);  // chains to the other constructor with 1 specified as capacity.
    }

    // NOTE: Whenever I initialized keys and vals, java didn't like it and suggested I add this supressed warning.
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        arrayLength = 1;
        while (arrayLength < capacity) {
            arrayLength *= 2; // Ensure array length is a power of 2
        }
        keys = (Key[]) new Object[arrayLength];
        vals = (Value[]) new Object[arrayLength];
        tombstones = new boolean[arrayLength];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % arrayLength;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arrayLength; i++) {
            s.append(i).append(" : ").append(keys[i]).append("/").append(vals[i]).append("\n");
        }
        return s.toString();
    }

    // method takes a key and value and adds to the hash table.
    public void put(Key key, Value val) {
        if (size >= arrayLength / 2) resize(2 * arrayLength); // Double array size if 50% full
        int i = hash(key);
        int startingIndex = i;
        int probe = 1;
        // Quadratic probing
        while (keys[i] != null && !keys[i].equals(key)) {
            i = (startingIndex + probe * probe) % arrayLength;
            probe++;
        }
        keys[i] = key;
        vals[i] = val;
        tombstones[i] = false;
        size++;
    }

    // method gets a value using a key as a parameter.
    public Value get(Key key) {
        int i = hash(key);
        int startingIndex = i;
        int probe = 1;
        //Quadratic probing.
        while (keys[i] != null) {
            if (keys[i].equals(key)) return vals[i];
            i = (startingIndex + probe * probe) % arrayLength;
            probe++;
        }
        return null;
    }
    // returns true if key is in table
    public boolean contains(Key key) {
        return get(key) != null;
    }

    //deletes a key from the table. 
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        int startingIndex = i;
        int probe = 1;
        //quadratic probing
        while (!key.equals(keys[i])) {
            i = (startingIndex + probe * probe) % arrayLength;
            probe++;
        }
        keys[i] = null;
        vals[i] = null;
        tombstones[i] = true;
        size--;
        // Rehash to update tombstones
        while (keys[i] != null) {
            Key rehashKey = keys[i];
            Value rehashValue = vals[i];
            keys[i] = null;
            vals[i] = null;
            tombstones[i] = true;
            size--;
            put(rehashKey, rehashValue);
            i = (i + 1) % arrayLength;
        }
        if (size > 0 && size <= arrayLength / 4) resize(arrayLength / 2); // Halve array size if 25% full or less
    }

    //resizes table using a new capacity.
    private void resize(int capacity) {
        HashTable<Key, Value> temp = new HashTable<>(capacity);
        for (int i = 0; i < arrayLength; i++) {
            if (keys[i] != null && !tombstones[i]) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        arrayLength = temp.arrayLength;
        tombstones = temp.tombstones;
    }
}