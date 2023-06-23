package tradlinx;


public class Step1 {
    public long[] solution(long n) {
        long[] answer = new long[2];

        long quotient = n / 7; // 주 단위로 나눈 몫
        long remainder = n % 7; // 나머지 일 수

        // 최솟값 계산
        if (remainder == 1) {
            answer[0] = quotient * 2;
            answer[1] = quotient * 2 + 1;
        } else if (remainder == 6) {
            answer[0] = quotient * 2 + 1;
            answer[1] = quotient * 2 + 2;
        } else {
            answer[0] = quotient * 2;
            answer[1] = quotient * 2 + Math.min(2, remainder);
        }

        return answer;
    }




    private long getHolidays(int startDay, long n) {
        long fullWeeks = n / 7;
        long remainingDays = n % 7;

        long holidays = fullWeeks * 2;

        if (remainingDays > 0) {
            if (startDay <= 6 && startDay + remainingDays >= 8) {
                holidays += 2;
            } else {
                holidays += 1;
            }
        }

        return holidays;
    }


    public static void main(String[] args) {
        Step1 solution = new Step1();
        long n1 = 6;
        long n2 = 7;
        long[] result1 = solution.solution(n1);
        long[] result2 = solution.solution(n2);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");
    }
}
