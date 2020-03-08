package arithgram;

/**
 * 大数加法
 */
public class BigNumAdd {
    public static void main(String[] args) {
        String a = "123451111111111111111111111111111111";
        String b = "11111";
        System.out.println(add(a, b));
    }

    public static String add(String a, String b) {
        int ai = 0;// a的倒数第ai位
        int bi = 0;// b的倒数第bi位
        int carry = 0;// 进位数
        String result = "";
        while (ai < a.length() || bi < b.length() || carry > 0) {
            int addend = ai < a.length() ? a.charAt(a.length() - ai++ - 1) - '0' : 0;
            int summand = bi < b.length() ? b.charAt(b.length() - bi++ - 1) - '0' : 0;
            result = (addend + summand + carry) % 10 + result;
            carry = (addend + summand + carry) / 10;
        }
        return result;
    }
}
