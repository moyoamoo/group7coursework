package com.napier.sem;

public class Utils {

    /*
     * Print the contents of an array
     *
     * @param prompt Prints a prompt
     * @param arr An array
     */
    public void displayArray(String prompt, String[] arr){
        System.out.println(prompt);
        for (int i = 0; i < arr.length; i++){
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }

    /*
     * Print a single element from an array
     *
     * @param arr An Array
     * @param index Array Index
     */
    public String displayElement(String[] arr, int index){
        return arr[index];
    }
}
