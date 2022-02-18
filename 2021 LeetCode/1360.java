// 1360. Number of Days Between Two Dates

class Solution {

    public int daysBetweenDates(String date1, String date2) {
        int[] d1 = getDate(date1);
        int[] d2 = getDate(date2);

        if (d1[0] == d2[0] && d1[1] == d2[1])
            return (int) Math.abs(d1[2] - d2[2]);
        else if (d1[0] > d2[0] || d1[0] == d2[0] && d1[1] > d2[1])
            return getDaysBetween(d2, d1);

        return getDaysBetween(d1, d2);
    }

    private int getDaysBetween(int[] d1, int[] d2) {
        int totalDays = 0;
        for (int y = d1[0] + 1; y < d2[0]; y++)
            totalDays += isLeapYear(y) ? 366 : 365;

        int daysInYear1 = getDaysInYear(d1[1], d1[2], isLeapYear(d1[0]));
        int daysInYear2 = getDaysInYear(d2[1], d2[2], isLeapYear(d2[0]));

        int dayDiff = 0;
        if (d1[0] == d2[0])
            dayDiff = daysInYear2 - daysInYear1;
        else // if (daysInYear1 > daysInYear2)
            dayDiff = daysInYear2 + (isLeapYear(d1[0]) ? 366 : 365) - daysInYear1;

        // System.out.println(daysInYear1 + " " + daysInYear2);
        // System.out.println(dayDiff);

        return totalDays + dayDiff;
    }

    private int[] getDate(String s) {
        String[] d = s.split("-");
        int[] date = new int[3];

        date[0] = Integer.parseInt(d[0]);
        date[1] = Integer.parseInt(d[1]);
        date[2] = Integer.parseInt(d[2]);
        return date;
    }

    private int getDaysInYear(int month, int day, boolean isLeap) {
        int days = 0;
        for (int i = 1; i < month; i++)
            days += getDaysInMonth(i, isLeap);
        return days + day;
    }

    private int getDaysInMonth(int month, boolean isLeap) {
        int days = 30;
        if (month == 2)
            days -= isLeap ? 1 : 2;
        else if (month <= 7)
            days += month % 2;
        else
            days -= month % 2 - 1;

        return days;
    }

    // leap year is exactly divisible by 4
    // but not divisible by 100
    // but divisible by 400

    // Must be divisible by 4 and not divisible by 100, or divisible by 400
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
