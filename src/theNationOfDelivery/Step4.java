package theNationOfDelivery;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Step4 {
    public String solution(String pathVariableUrl) {

        String answer = "";

        String pattern = "/payment/([0-9]{1,9})/([a-zA-Z]{1,10})";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(pathVariableUrl);

        if (matcher.matches()) {
            String paymentId = matcher.group(1);
            String paymentMethod = matcher.group(2);
            answer = "/payment/" + paymentMethod + "?paymentId=" + paymentId;
        } else {
            answer = "error";
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "/payment/1234/cancel",
                "/payment/1234",
                "/payment/a1234/cancel",
                "/payment/1234567890/cancel",
                "/payment/1234/5678"
        };

        Step4 solution = new Step4();

        for (String input : inputs) {
            String result = solution.solution(input);
            System.out.println("Input: " + input);
            System.out.println("Result: " + result);
            System.out.println();
        }
    }
}
