package wrappers;

public class ClassForTest {
    public static void main(String[] args) {
        String money = "�� �������� ����� ����� ����� �����, � ������ 1234 ������ ��������";
        int result = Integer.parseInt(money.split("\\s")[8]);
        System.out.println(result);
    }



}
