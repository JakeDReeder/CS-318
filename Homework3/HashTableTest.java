// Jacob Reeder
// CS 318 - Homework 3

package Homework3;

import java.util.Scanner;

public class HashTableTest {
    
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter some lowercase characters to store as keys in the hash table ");
       System.out.println("(Their uppercase equivalents will be used as the corresponding values):");
       String charsToHash = scanner.nextLine();
       System.out.println();
       
       HashTable<Character,Character> ht = new HashTable<Character,Character>();

       for (int i = 0; i < charsToHash.length(); i++) {
           ht.put(charsToHash.charAt(i), charsToHash.toUpperCase().charAt(i));
       }
       
       System.out.println(ht);
       
       System.out.println("Testing retrieval:");
       for (int i = 0; i < charsToHash.length(); i++) {
           System.out.print(ht.get(charsToHash.charAt(i)));
       }
       System.out.println("\n");
       
       System.out.println("Now enter one or more lowercase character keys to delete from the hash table: ");
       String charsToDelete = scanner.nextLine();
       scanner.close();
       for (int i = 0; i < charsToDelete.length(); i++) {
           ht.delete(charsToDelete.charAt(i));
       }
       System.out.println();
       
       System.out.println("Testing retrieval after deletion:");
       for (int i = 0; i < charsToHash.length(); i++) {
           Character v = ht.get(charsToHash.charAt(i));
           System.out.print(v != null ? v : '-');
       }
   }
}
