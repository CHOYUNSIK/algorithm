package hecto;


public class Step3 {

    public String addStrings(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int tempSum = digitA + digitB + carry;
            carry = tempSum / 10;
            sum.insert(0, tempSum % 10);

            i--;
            j--;
        }

        if (carry > 0) {
            sum.insert(0, carry);
        }

        return sum.toString();
    }

    public static void main(String[] args) {
        Step3 solution = new Step3();
        String a1 = "1234";
        String b1 = "5678";
        System.out.println(solution.addStrings(a1, b1)); // 출력 결과: 6912

        String a2 = "1111";
        String b2 = "8889";
        System.out.println(solution.addStrings(a2, b2)); // 출력 결과: 10000
    }
}
