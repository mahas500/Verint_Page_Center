package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerintTest {


    public static List<Integer> getPages(int currentPage, int totalPagesOfResult, int maxRange)
    {
        int center;
        int start;
        int end = 0;

        List<Integer> listOfPages = new ArrayList<Integer>(totalPagesOfResult);

        if(totalPagesOfResult <= maxRange)
        {
            for(int i = 1; i <= totalPagesOfResult; i++)
            {
                listOfPages.add(i);
            }
        }

        else
        {
            center = maxRange/2 + 1;

            start = currentPage - center + 1;

            end = (maxRange%2 == 0) ? currentPage + center - 2 : currentPage + center - 1;

            if(start < 1)
            {
                start = 1;
                end = start + maxRange - 1;
            }
            else if(end > totalPagesOfResult)
            {
                end = totalPagesOfResult;
                start = totalPagesOfResult - maxRange + 1;
            }

            for(int i = start; i <= end; i++)
            {
                listOfPages.add(i);
            }

        }
        return listOfPages;
    }

    public static void main(String[] args) {

        boolean status = true;

        while(status)
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter total Pages");

            int totalPagesOfResult = (input.nextInt());

            System.out.println("Enter the maximum range");

            int maxRange = input.nextInt();

            if(totalPagesOfResult < 1 || maxRange < 1)
            {
                System.out.println("Only natural numbers are allowed");
            }
            else
            {
                for(int i = 1; i <= totalPagesOfResult; i++)
                {
                    System.out.println(getPages(i,totalPagesOfResult,maxRange));
                }
            }

            System.out.println("Do you want to enter more values ? ");
            System.out.println("Please press No to terminate or any other key to continue ");

            String str = input.next();

            if(str.equalsIgnoreCase("No"))
            {
                status = false;

            }

        }

    }
}
