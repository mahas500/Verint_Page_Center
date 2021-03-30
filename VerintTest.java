package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerintTest {


    public static List<Integer> getPages(int currentPage, int totalPagesOfResult, int maxRange) {

        int center;
        int start;
        int end = 0;

        List<Integer> listOfPages = new ArrayList<Integer>(totalPagesOfResult);

        if (totalPagesOfResult <= maxRange) {
            for (int i = 1; i <= totalPagesOfResult; i++) {
                listOfPages.add(i);
            }
        } else {
            center = maxRange / 2 + 1;

            start = currentPage - center + 1;

            end = (maxRange % 2 == 0) ? currentPage + center - 2 : currentPage + center - 1;

            if (start < 1) {
                start = 1;
                end = start + maxRange - 1;
            } else if (end > totalPagesOfResult) {
                end = totalPagesOfResult;
                start = totalPagesOfResult - maxRange + 1;
            }

            for (int i = start; i <= end; i++) {
                listOfPages.add(i);
            }

        }
        return listOfPages;
    }

    public static void main(String[] args) {

        boolean status = true;

        while(status) {

            Scanner input = new Scanner(System.in);

            System.out.println("Enter total Pages");

            int totalPagesOfResult = (input.nextInt());

            System.out.println("Enter the maximum range");

            int maxRange = input.nextInt();

            if (totalPagesOfResult < 1 || maxRange < 1) {

                System.out.println("Only positive integer values are allowed");

            } else {
                System.out.println("Do you wish to enter a specific page number or entire list ?");

                System.out.println("Please press 1 for specific page result or 2 to get the entire list");

                String strPref = input.next();

                if (strPref.equalsIgnoreCase("1")) {

                    System.out.println("Please enter your desired page number");

                    int currentPage = input.nextInt();

                    if(currentPage < 1 || currentPage > totalPagesOfResult)
                    {
                        System.out.println("Please enter a valid page number from 1 to total pages entered value");
                        currentPage = input.nextInt();
                        System.out.println(getPages(currentPage, totalPagesOfResult, maxRange));
                    }
                    else{

                        System.out.println(getPages(currentPage, totalPagesOfResult, maxRange));
                    }

                } else if (strPref.equalsIgnoreCase("2")) {

                    for (int i = 1; i <= totalPagesOfResult; i++) {

                        System.out.println(getPages(i, totalPagesOfResult, maxRange));
                    }
                } else {

                    System.out.println("Please enter a valid input ");

                    status = true;
                }

            }

            System.out.println("Do you want to enter more values ? ");

            System.out.println("Please press 0 to terminate or any other key to continue ");

            String str = input.next();

            if (str.equalsIgnoreCase("0")) {

                status = false;

            }

        }

    }
}
