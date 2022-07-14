public class test {

    public static void main(String[] args) {
        String test = "2020-12-01 00:00:00";


        System.out.println(test.replaceAll("-", "").substring(0, 8));


        String ttt = "2020-12-03";

        String test2 = "tb_tran_cardpg_" + ttt.replaceAll("-", "").substring(2, 6);

        System.out.println(test2);

    }

}
