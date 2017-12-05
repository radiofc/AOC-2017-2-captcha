package com.radiofc;

import org.apache.log4j.Logger;

import java.util.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(InputFileReader.class);
/*
Part 1:

For example, given the following spreadsheet:

5 1 9 5
7 5 3
2 4 6 8

The first row's largest and smallest
values are 9 and 1, and their
difference is 8.

The second row's largest and smallest
values are 7 and 3, and their difference
is 4.

The third row's difference is 6.

In this example, the spreadsheet's
checksum would be 8 + 4 + 6 = 18.

Part 2:

given the following spreadsheet:

5 9 2 8
9 4 7 3
3 8 6 5

In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
In the second row, the two numbers are 9 and 3; the result is 3.
In the third row, the result is 2.
In this example, the sum of the results would be 4 + 3 + 2 = 9.

*/


    public static void main(String args[])
    {
        int checksum = 0;
        int checksum2 = 0;

        List<String> spreadsheet = InputFileReader.readFile("C:\\Users\\eshamcc\\Dropbox\\git\\AOC-2017-2-captcha\\src\\main\\resources\\input.txt");

        for (String row : spreadsheet) {
            checksum += diffLargeSmall(row);
            checksum2 += evenDivision(row);
        }

        LOGGER.info("Part1 checksum: "+ checksum);

        LOGGER.info("Part2 checksum: "+ checksum2);

    }



    private static void printer(String s) {
        System.out.println(s);
    }


    private static int evenDivision(String input) {
        StringTokenizer st1 = new StringTokenizer(input);
        List<Integer> rowValues = new ArrayList<>();
        for (int i = 1; st1.hasMoreTokens(); i++) {
            String theToken = st1.nextToken().toString();
            rowValues.add(Integer.parseInt(theToken));
        }

        int[] arr = new int[rowValues.size()];

        for(int i = 0; i < rowValues.size(); i++) {
            if (rowValues.get(i) != null) {
                arr[i] = rowValues.get(i);
            }
        }

        int firstNum = 0;
        int secondNum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int x = 0; x < arr.length; x++) {
                if (i != x) {
                    if (arr[i] % arr[x] == 0) {
                        firstNum = arr[i];
                        secondNum = arr[x];
                    }
                }
            }
        }

        if (secondNum > firstNum) {
            return secondNum / firstNum;
        } else {
            return firstNum / secondNum;
        }
    }

    private static int diffLargeSmall(String input) {
        StringTokenizer st1 = new StringTokenizer(input);
        int smallNum = 0;
        int largeNum = 0;

        for (int i = 1; st1.hasMoreTokens(); i++) {
            String theToken = st1.nextToken().toString();
            int z = Integer.parseInt(theToken);

            if (i == 1) {
                smallNum = z;
                largeNum = z;
            } else {
                if (z < smallNum) {
                    smallNum = z;
                }
                if (z > largeNum) {
                    largeNum = z;
                }
            }

        }

        int diff = largeNum - smallNum;
        return diff;
    }
}

