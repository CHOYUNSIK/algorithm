package imweb;

public class Step1 {
    public static int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(n);
            long num = Long.parseLong(sb.toString());
            if (num % k == 0) {
                answer = sb.length() / Integer.toString(n).length();
                break;
            }
            if (sb.length() > Integer.toString(n).length() * k) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Step1 solution = new Step1();

        int n1 = 22;
        int k1 = 9;
        int result1 = solution.solution(n1, k1);
        System.out.println("n = " + n1 + ", k = " + k1 + " -> Result: " + result1);

        int n2 = 25;
        int k2 = 15;
        int result2 = solution.solution(n2, k2);
        System.out.println("n = " + n2 + ", k = " + k2 + " -> Result: " + result2);
    }
}
