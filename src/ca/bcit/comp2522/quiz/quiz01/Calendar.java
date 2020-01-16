package ca.bcit.comp2522.quiz.quiz01;

import java.util.ArrayList;

public class Calendar {

    private int theNumberOfDay;
    private ArrayList<String> theFirstDayOfMonth;

    public Calendar(int theNumberOfDay, int theFirstDayOfMonth) {
        this.theNumberOfDay = theNumberOfDay;
        this.theFirstDayOfMonth = new ArrayList<>();
        this.theFirstDayOfMonth.add("Sun");
        this.theFirstDayOfMonth.add("Mon");
        this.theFirstDayOfMonth.add("Tue");
        this.theFirstDayOfMonth.add("Wed");
        this.theFirstDayOfMonth.add("Thu");
        this.theFirstDayOfMonth.add("Fri");
        this.theFirstDayOfMonth.add("Sat");
        for (int i = 0; i < theFirstDayOfMonth; i++) {
            this.theFirstDayOfMonth.add("");
        }
        for (int i = 0; i < theNumberOfDay; i++) {
            this.theFirstDayOfMonth.add(Integer.toString(i + 1));
        }
    }

    @Override
    public String toString() {
        int countElementInLine = 0;
        for (String element : theFirstDayOfMonth) {
            countElementInLine++;
            if (countElementInLine == 7) {
                System.out.printf("%-6s\n", element);
                countElementInLine = 0;
            } else {
                System.out.printf("%-6s", element);
            }
        }
        return "";
    }


    public static void main(String[] args) {
        Calendar date1 = new Calendar(30, 0);
        date1.toString();
//        Calendar date2 = new Calendar(28, 5);
//        date2.toString();
    }
}