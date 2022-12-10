/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sorting;

import java.util.ArrayList;

/**
 *
 * @author JEFFREY ACKAH AND Keil Barracliffe
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Sort testing = new Sort();
        for (int i = 10000; i <= 100000; i += 10000) {
            ArrayList<Integer> list = testing.fillRandom(i, 100000);
            long start = System.currentTimeMillis();
            testing.selectionSort(list);
            long end = System.currentTimeMillis();
            System.out.println(i + "values" + (end - start) + " mi");
        }
    }

}
