package educative.TwoPointers;

public class StrCmpWthBksp {

    public static void main(String[] args) {
        String str1 = "xy#z";
        String str2 = "xzz#";

        boolean flag = stringCompare(str1, str2);
        System.out.println(flag);
    }

    private static boolean stringCompare(String str1, String str2) {
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        boolean flag = true;
        while (i >= 0 && j >= 0) {

            if (str1.charAt(i) == '#') {
                i = i - 2;
            } else if (str2.charAt(j) == '#') {
                j = j - 2;
            } else if (str1.charAt(i) == str2.charAt(j)) {
                i--;
                j--;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
