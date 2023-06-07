package wrappers;

public class ClassForTest {
    public static void main(String[] args) {
        String money = "Вы получили очень очень много денег, а именно 1234 тысячи долларов";
        int result = Integer.parseInt(money.split("\\s")[8]);
        System.out.println(result);
    }



}
