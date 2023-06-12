package theNationOfDelivery;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Step3 {
    public String[] solution(String[] productInfo, String[] dailyProductSales) {

        String[] answer = {};

        Map<String, String> productMap = Stream.of(productInfo)
                .map(info -> info.split(","))
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> arr[1] + "," + arr[2]
                ));

        answer = Stream.of(dailyProductSales)
                .map(sale -> sale.split(","))
                .filter(arr -> arr.length == 3)
                .map(arr -> {
                    String date = arr[0];
                    String productId = arr[1];
                    String saleQuantity = arr[2];

                    String productDetails = productMap.get(productId);
                    if (productDetails != null) {
                        String[] productInfoArr = productDetails.split(",");
                        String productName = productInfoArr[0];
                        int unitPrice = Integer.parseInt(productInfoArr[1]);

                        int totalSales = Integer.parseInt(saleQuantity) * unitPrice;
                        return date + "," + productId + "," + productName + "," + totalSales;
                    } else {
                        return "error";
                    }
                })
                .toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {
        Step3 solution = new Step3();

        // 상품정보
        String[] productInfo = {
                "123456789,유기농쌀 4kg,50000",
                "234578882,배달이캐릭터숟가락,3000"
        };

        // 일별 판매량 정보
        String[] dailyProductSales = {
                "20220810,123456789,5",
                "20220810,234578882,30",
                "20220811,123456789,7"
        };

        // 결과 출력
        String[] result = solution.solution(productInfo, dailyProductSales);
        System.out.println(Arrays.toString(result));
    }
}
