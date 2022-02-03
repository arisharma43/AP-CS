import java.io.*;
import java.util.*;

public class Main {

  /**
   * Sorts the given array in ascending order.
   * DO NOT MODIFY THIS METHOD SIGNATURE.
   * @param array The array to be sorted.
   */
  private static void sort(String[] array) {
    // YOUR CODE WILL GO HERE.
    // for(int i=0; i<array.length-1; i++) {
		// 	int minIndex = i;
		// 	for(int j = i+1; j<array.length; j++) {
		// 		if(array[minIndex].compareTo(array[j])>0) {
		// 			minIndex = j;
          
		// 		}
		// 	}
			
    //   if(minIndex!=i){
    //     String temp = array[i];
    //     array[i] = array[minIndex];
		// 	  array[minIndex] = temp;
    //     //minCount++;
    //   }
			
		//   }
    for(int i=1; i<array.length; i++) {
			int j=i;
			String temp = array[i];
			while(j>0&&temp.compareTo(array[j-1])<0) {
				array[j] = array[j-1];
				j--;
				
			}
			array[j] = temp;
		}
    
        
  }


  /**
   * Reads an entire file into an array of Strings, where each element
   * represents a new line in the file. Assumes the file's first line is an
   * integer indicating the number of following lines.
   * @param filename The filename of the file to read.
   * @return An array of strings read from the file.
   * @throws IOException If the file doesn't exist or an error occurs during the
   *     reading.
   */
  private static String[] load(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String[] lines = new String[Integer.parseInt(reader.readLine())];
    for (int i = 0; i < lines.length; i++) {
      lines[i] = reader.readLine();
    }
    return lines;
  }


  public static void main(String[] args) throws IOException {
    String[] prefixes = {"small", "medium", "large"};
    String[] suffixes = {"ascending.txt", "descending.txt", "random.txt"};
    for (String prefix : prefixes) {
      for (String suffix : suffixes) {
        String filename = prefix + "_" + suffix;
        String[] array = load(filename);
        long start, end;

        System.out.println("Sorting " + filename + " with " + array.length + " words");

        String[] copy = Arrays.copyOf(array, array.length);
        start = System.currentTimeMillis();
        Arrays.sort(copy);
        end = System.currentTimeMillis();
        System.out.println("\tArrays.sort() took:\t" + (end - start) + " ms");

        start = System.currentTimeMillis();
        sort(array);
        end = System.currentTimeMillis();
        if (Arrays.equals(array, copy)) {
          System.out.println("\tYour sort method took:\t" + (end - start) + " ms");
        } else {
          System.err.println("\tYour sort does not properly sort the array in ascending order!");
        }

        System.out.println();
      }
    }
  }
}
