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
 
    public HashTable(int capacity) {
 
       
       // INSERT CODE HERE //
       
    }
 
    private int hash(Key key) {
       return (key.hashCode() & 0x7fffffff) % arrayLength;
    }
    
    public String toString() { 
        String s = "";
        for (int i = 0; i < arrayLength; i++) {
            s += i + " : " + keys[i] + "/" + vals[i] + "\n";
        }
        return s;
    }
 
    public void put(Key key, Value val) {
        // insert or update the value associated with the given key 
        // in the array by hashing and handling any collisions
 
        
        // INSERT CODE HERE //
        
    }
 
    public Value get(Key key) {
        // get the value associated with a given key
       
        
        // INSERT CODE HERE //
        
    }
    
    public boolean contains(Key key) {
    
        
        // INSERT CODE HERE //
        
    }
 
    public void delete(Key key) {
        
        
        // INSERT CODE HERE //
        
    }
 
    private void resize(int capacity) {
        // resize the array to have the given capacity 
        // (requires a rehashing of all items).
        
        
        // INSERT CODE HERE //
        
    }
 }