package u001Usefull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.util.Arrays;

public class FastCheck {

    public static void main(String[] args) {
        bubbleSort();
    }

    private static void compareDates() {
        LocalDateTime time = LocalDateTime.now();
        YearMonth time1 = YearMonth.from(time);
        YearMonth bdate = YearMonth.of(2006, 10);
        YearMonth traDate = YearMonth.of(2006, 10);
        System.out.println(traDate.compareTo(bdate));
    }

    private static void roundResult() {
        LocalDateTime time = LocalDateTime.of(2026, 6, 1, 0, 0);
        LocalDateTime time2 = LocalDateTime.of(2027, 6, 1, 0, 0);
        LocalDateTime time3 = LocalDateTime.of(2029, 12, 1, 0, 0);

        Month m1 = time.getMonth();
        Month m2 = m1.plus(24);

        Period diff = Period.between(time.toLocalDate(), time2.toLocalDate());
        Period diff2 = Period.between(time.toLocalDate(), time3.toLocalDate());


        LocalDate localDate1 = time.toLocalDate();
        LocalDate localDate2 = localDate1.plus(diff2);
        int comp = localDate1.compareTo(localDate2);
        int year = 2026;
        int month = 6;

        int toIncrease = 12;

        System.out.println(toIncrease % 12);
    }

    private static int getSummOfHighest(int x, int y, int z) {
        int[] nums = {x, y, z};
        Arrays.sort(nums);
        return nums[1] + nums[2];
    }


    private static void bubbleSort() {
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(nums));
    }

}
