package question;


import java.util.*;

/**
 * Created by siren0413 on 1/30/14.
 */
public class RestoreIPAddresses {
    public static ArrayList<String> restoreIpAddresses(String s) {
        if (s.isEmpty()) return new ArrayList<>();
        ArrayList<String> totalList = new ArrayList<>();
        ArrayList<String> subList = new ArrayList<>();
        restoreIpAddressesHelper(s, 0, 0, subList, totalList);
        return totalList;
    }

    private static void restoreIpAddressesHelper(String s, int n, int i, ArrayList<String> subList, ArrayList<String> totalList) {
        if (n == 4) {
            if (i >= s.length()) {
                StringBuilder sb = new StringBuilder();
                sb.append(subList.get(0) + ".");
                sb.append(subList.get(1) + ".");
                sb.append(subList.get(2) + ".");
                sb.append(subList.get(3));
                totalList.add(sb.toString());
            }
            return;
        }
        if (i > s.length() - 1) return;

        // one digit
        subList.add(s.substring(i, i + 1));
        restoreIpAddressesHelper(s, n + 1, i + 1, subList, totalList);
        subList.remove(subList.size() - 1);

        // two digits
        if (i + 2 <= s.length() && s.charAt(i) != '0') {
            subList.add(s.substring(i, i + 2));
            restoreIpAddressesHelper(s, n + 1, i + 2, subList, totalList);
            subList.remove(subList.size() - 1);
        }

        // two digits
        if (i + 3 <= s.length() && s.charAt(i) != '0' && Integer.valueOf(s.substring(i, i + 3)) <= 255) {
            subList.add(s.substring(i, i + 3));
            restoreIpAddressesHelper(s, n + 1, i + 3, subList, totalList);
            subList.remove(subList.size() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
