/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mergesort;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Đàm Quang Chiến
 */
public class NewClass {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");

        Date startDate = dateFormat.parse("2023-05-08");
        Date endDate = dateFormat.parse("2023-07-30");

        // Calculate the number of weeks between the start and end dates
        int numWeeks = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24 * 7));

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(startDate);

        java.util.Calendar calendar2 = java.util.Calendar.getInstance();

        calendar2.setTime(new Date());
        java.util.Date currentDate = calendar2.getTime();

        for (int i = 1; i <= numWeeks; i++) {
            SimpleDateFormat outputDateFormat = new java.text.SimpleDateFormat("dd MMMM");

            java.util.Date weekStartDate = calendar.getTime();
            String formattedStartDate = outputDateFormat.format(weekStartDate);

            calendar.add(java.util.Calendar.DAY_OF_YEAR, 6);
            java.util.Date weekEndDate = calendar.getTime();
            String formattedEndDate = outputDateFormat.format(weekEndDate);

            calendar.add(java.util.Calendar.DAY_OF_YEAR, 1);

            String start = dateFormat.format(weekStartDate);
            String end = dateFormat.format(weekEndDate);
            String current = dateFormat.format(currentDate);

//            System.out.println("Start: " + start);
//            System.out.println("End: " + end);
//            System.out.println("Current: " + current);
//
//            System.out.println("after start: " + (current.compareTo(start)));
//            System.out.println("before end: " + (current.compareTo(end)));
            if ((current.compareTo(start)) >= 0 && (current.compareTo(end) <= 0) ||(current.compareTo(end)) >= 0) {
                System.out.println("Start: " + start);
                System.out.println("End: " + end);
                System.out.println("Current: " + current);
                System.out.println();
            }
        }
    }

}
