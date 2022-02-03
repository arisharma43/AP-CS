import java.util.*;
class Main {
  //public static int[] testArr = new int[10];
  // public static void generateRandomArr(){
  //   for(int i=0; i<10; i++){
  //     testArr[i] = (int)(Math.random()*19+1);
  //   }
  // }
  public static void main(String[] args) {
    int[] array1 = new int[10];
    int[] array2 = new int[10];
    int[] array3 = new int[10];
    int[] array4 = new int[10];
    int[] testArr3 = {7, 13, 1, 17, 20, 8, 12, 19, 2, 10};
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    ArrayList<Integer> list3 = new ArrayList<Integer>();
    ArrayList<Integer> list4 = new ArrayList<Integer>();
    for(int i=0; i<10; i++){
      array1[i] = (int)(Math.random()*19+1);
      array2[i] = (int)(Math.random()*19+1);
      array3[i] = (int)(Math.random()*19+1);
      array4[i] = (int)(Math.random()*19+1);
      list1.add(i, (int)(Math.random()*19+1));
      list2.add(i, (int)(Math.random()*19+1));
      list3.add(i, (int)(Math.random()*19+1));
      list4.add(i, (int)(Math.random()*19+1));
    }
    //int[] testArr2 = testArr1;
    
    System.out.println("TESTING bubbleSort() with 4 different sets of random number from 1-20");
    bubbleSort(array1,true);
    // // // System.out.println("array1 asc  " + Arrays.toString(array1));
    bubbleSort(array2,false);
    // // // System.out.println("array2 desc " + Arrays.toString(array2));
    // // // System.out.println("list1       " + list1);
    bubbleSort(list1,true);
    // // // System.out.println("list1 asc   " + list1);
    // // // System.out.println("list2       " + list2);
    bubbleSort(list2,false);
    // // // System.out.println("list2 desc  " + list2);

    System.out.println("\nTESTING selectionSort() with 4 different sets of random number from 1-20");
    //int[] testArr3 = testArr2;
    selectionSort(array2,true);
    // // System.out.println("array3 asc     " + Arrays.toString(array3));
    selectionSort(array4,false);
    // // // System.out.println("array4 desc    " + Arrays.toString(array4));
    // // // System.out.println("list3          " + list3);
    selectionSort(list3,true);
    // // // System.out.println("list3 asc      " + list3);
    // // // System.out.println("list4          " + list4);
    selectionSort(list4,false);
    // // System.out.println("list4 desc     " + list4);


    System.out.println("\nTESTING bubbleSelectionSort()");

    bubbleSelectionSort(testArr3, true);
    
    for(int i=1; i<=10; i++){
      System.out.println("Test " + i + " with 10 random numbers from 1 - 20");
      int[] testArr = new int[10];
      int[] testArr1 = new int[10];
      int[] testArr2 = new int[10];
    for(int j=0; j<10; j++){
      testArr[j] = (int)(Math.random()*19+1);
      testArr1[j] = (int)(Math.random()*19+1);
      testArr2[j] = (int)(Math.random()*19+1);
    }
      //generateRandomArr();
      int[] tempBubble = testArr;
      int[] tempSelection = testArr1;
      int[] tempBubbleSelection = testArr2;
      bubbleSort(tempBubble);
      selectionSort(tempSelection);
      bubbleSelectionSort(tempBubbleSelection);
    }
  }

  public static void bubbleSort(int[] array){
    System.out.println("bubble sort " + Arrays.toString(array));
    int swapCount = 0;
    for (int i = 0; i < array.length-1; i++)
            for (int j = 0; j < array.length-i-1; j++)
                if (array[j] > array[j+1])
                {
                    
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapCount++;
                }

        //System.out.println(Arrays.toString(array));
        System.out.println(" " + swapCount + " bubbles");
  }
  public static void bubbleSort(int[] array, boolean ascending){
    System.out.println("bubble sort (array)" + Arrays.toString(array));
    System.out.println(Arrays.toString(array));
    int swapCount = 0;
    if(ascending){
      for (int i = 0; i < array.length-1; i++)
            for (int j = 0; j < array.length-i-1; j++)
                if (array[j] > array[j+1])
                {
                    
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapCount++;
                }
    }else{
      for (int i = 0; i < array.length-1; i++)
            for (int j = 0; j < array.length-i-1; j++)
                if (array[j] < array[j+1])
                {
                    
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapCount++;
                }
    }
    

        System.out.println("sorted (asc=" + ascending + ") " + Arrays.toString(array));
        System.out.println(" " + swapCount + " bubbles");
  }
  public static void bubbleSort(ArrayList<Integer> array, boolean ascending){
    System.out.println("bubble sort (ArrayList)" + (array));
    int swapCount = 0;
    if(ascending){
      for (int i = 0; i < array.size()-1; i++)
            for (int j = 0; j < array.size()-i-1; j++)
                if (array.get(j) > array.get(j+1))
                {
                    
                    int temp = array.get(j);
                    array.set(j,array.get(j+1));
                    array.set(j+1, temp);
                    swapCount++;
                }
    }else{
      for (int i = 0; i < array.size()-1; i++)
            for (int j = 0; j < array.size()-i-1; j++)
                if (array.get(j) < array.get(j+1))
                {
                    
                    int temp = array.get(j);
                    array.set(j,array.get(j+1));
                    array.set(j+1, temp);
                    swapCount++;
                }
    }
    

        System.out.println("sorted (asc=" + ascending + ") " + Arrays.toString(array.toArray()));
        System.out.println(" " + swapCount + " bubbles");
  }

  // public static void bubbleSort(int[] array, boolean asc) {
  //       System.out.println("bubble sort " + Arrays.toString(array));
  //       int swapCount = 0;
        
        
  //       // * * * * * * * * * * * * * 
  //       //  Your Code Goes Here
  //       //    Use swapCount to count the number of swaps that occur
  //       // * * * * * * * * * * * * * 

  //       for (int i = 0; i < array.length-1; i++)
  //           for (int j = 0; j < array.length-i-1; j++)
  //               if (arr[j] > arr[j+1])
  //               {
                    
  //                   int temp = arr[j];
  //                   arr[j] = arr[j+1];
  //                   arr[j+1] = temp;
  //                   swapCount++;
  //               }

  //       System.out.println("sorted (asc=" + asc + ") " + Arrays.toString(array));
  //       System.out.println(" " + swapCount + " bubbles");

  //   }

  public static void selectionSort(ArrayList<Integer> list){
    System.out.println("selection sort (ArrayList)" + Arrays.toString(list.toArray()));
    int minCount = 0;

    for(int i=0; i<list.size()-1; i++) {
			int minIndex = i;
			for(int j = i+1; j<list.size(); j++) {
				if(list.get(minIndex)<list.get(j)) {
					minIndex = j;
          minCount++;
				}
			}
      if(minIndex!=i){
        int temp = list.get(i);
			  list.set(i, list.get(minIndex));
			  list.set(minIndex,temp);
      }
			
		}
    System.out.println(Arrays.toString(list.toArray()));
    System.out.println(" " + minCount + " moves");
  }


  public static void selectionSort(int[] array){
    System.out.print("selection sort " + Arrays.toString(array));
    int minCount = 0;
    
      for(int i=0; i<array.length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j<array.length; j++) {
				if(array[minIndex]>array[j]) {
					minIndex = j;
          
				}
			}
			
      if(minIndex!=i){
        int temp = array[i];
        array[i] = array[minIndex];
			  array[minIndex] = temp;
        minCount++;
      }
			
		  }
      //System.out.println("sorted (asc=" + ascending + ") " + Arrays.toString(array));
      System.out.println(" " + minCount + " moves");
    }
    
    
  

  public static void selectionSort(int[] array, boolean ascending){
    System.out.println("selection sort (array)" + Arrays.toString(array));
    int minCount = 0;
    if(ascending){
      for(int i=0; i<array.length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j<array.length; j++) {
				if(array[minIndex]>array[j]) {
					minIndex = j;
          
				}
			}
			
      if(minIndex!=i){
        int temp = array[i];
        array[i] = array[minIndex];
			  array[minIndex] = temp;
        minCount++;
      }
			
		  }
    }else{
      for(int i=0; i<array.length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j<array.length; j++) {
				if(array[minIndex]<array[j]) {
					minIndex = j;
          
				}
			}
			if(minIndex!=i){
        int temp = array[i];
        array[i] = array[minIndex];
			  array[minIndex] = temp;
        minCount++;
      }
		  }
    }
    System.out.println("sorted (asc=" + ascending + ") " + Arrays.toString(array));
    System.out.println(" " + minCount + " moves");
    
  }

  public static void selectionSort(ArrayList<Integer> list, boolean ascending){
    System.out.println("selection sort (ArrayList)" + Arrays.toString(list.toArray()));
    int minCount = 0;
    if(ascending){
      for(int i=0; i<list.size()-1; i++) {
			int minIndex = i;
			for(int j = i+1; j<list.size(); j++) {
				if(list.get(minIndex)>list.get(j)) {
					minIndex = j;
          minCount++;
				}
			}
      if(minIndex!=i){
        int temp = list.get(i);
			  list.set(i, list.get(minIndex));
			  list.set(minIndex,temp);
      }
			
		}
    }else{
      for(int i=0; i<list.size()-1; i++) {
			int minIndex = i;
			for(int j = i+1; j<list.size(); j++) {
				if(list.get(minIndex)<list.get(j)) {
					minIndex = j;
          minCount++;
				}
			}
			if(minIndex!=i){
        int temp = list.get(i);
			  list.set(i, list.get(minIndex));
			  list.set(minIndex,temp);
      }
    }
    
    System.out.println(Arrays.toString(list.toArray()));
    System.out.println(" " + minCount + " moves");
  }
  

  }

  public static void bubbleSelectionSort(int[] array){
    
    System.out.print("bubbleSelection sort " + Arrays.toString(array));
    int swapCount = 0;
    int minCount = 0;
    //System.out.println(Arrays.toString(array));
    for (int i = 0; i < array.length-1; i++){
          int minIndex = i;
            for (int j = i; j < array.length-1; j++){
                
                if (array[j] > array[j+1])
                {
                    
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapCount++;
                }
                if(array[minIndex]>array[j]) {
					        minIndex = j;
                }
            }
            if(minIndex!=i){
              int temp = array[i];
              array[i] = array[minIndex];
			        array[minIndex] = temp;
              minCount++;
            }
            
            // System.out.println(Arrays.toString(array)); 
    }
    System.out.println(" " + swapCount + " bubbles" + " & " + minCount + " moves");
    System.out.println("sorted " + Arrays.toString(array));
    
  }

  public static void bubbleSelectionSort(int[] array, boolean ascending){
    System.out.println("Testing bubbleSelectionSort on this array " + Arrays.toString(array));
    System.out.print("bubbleSelection sort " + Arrays.toString(array));
    int swapCount = 0;
    int minCount = 0;
    //System.out.println(Arrays.toString(array));
    for (int i = 0; i < array.length-1; i++){
          int minIndex = i;
            for (int j = i; j < array.length-1; j++){
                
                if (array[j] > array[j+1])
                {
                    
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapCount++;
                }
                if(array[minIndex]>array[j]) {
					        minIndex = j;
                }
            }
            if(minIndex!=i){
              int temp = array[i];
              array[i] = array[minIndex];
			        array[minIndex] = temp;
              minCount++;
            }
            
            // System.out.println(Arrays.toString(array)); 
    }
    System.out.println(" " + swapCount + " bubbles" + " & " + minCount + " moves");
    System.out.println("sorted " + Arrays.toString(array));
    
  }
  
}

