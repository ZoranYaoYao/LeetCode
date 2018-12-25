package com.zoran.leetcode.medium4;

/**
 * 验证IP地址
 * https://leetcode-cn.com/submissions/detail/10841327/
 *
 * [Solution]
 * https://blog.csdn.net/qq_36387730/article/details/82501742
 *
 * 对IPV4 IPV6的字符解析判断
 */
public class Test191 {
    public static void main(String[] args) {
        Test191 test191 = new Test191();
        String ip = "2001:0db8:85a3:033:0:8A2E:0370:7334";
        String res = test191.validIPAddress(ip);
        System.out.println(res);
    }

    /**
     * "20EE:FGb8:85a3:0:0:8A2E:0370:7334"
     */
    public String validIPAddress(String IP) {
        //判断条件验证
        if (IP.endsWith(":") || IP.endsWith(".")) return "Neither";

        if (IP.contains(".")) {
            String[] strs = IP.split("\\.");
            if (strs.length != 4) return "Neither";
            for (String item : strs) {
                if (item.startsWith("0")) return "Neither";
                try {
                    int num = Integer.parseInt(item);
                    if (num > 255) return "Neither";
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            String[] strs = IP.split("\\:");
            if (strs.length != 8) return "Neither";
            for (String item : strs) {
                if (item == null) return "Neither";
                if (item.length() > 4) return "Neither";
            }
        }
        return "IPv6";
    }

}

class Nice_Test191 {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() <= 0) return "Neither";
        if (isIPV4(IP)) return "IPv4";
        if (isIPV6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPV6(String IP) {
        if (IP.charAt(IP.length()-1) == ':') return false;
        String[] num = IP.toLowerCase().split("\\:"); //Nice_Core 统一转换成小写进行16进制处理
        if (num.length != 8) return false;
        for (String val : num) {
            if (val.length() <= 0 || val.length()>4) return false;
            for (int i=0; i<val.length(); i++) {
                char c = val.charAt(i);
                if (c < '0' || (c>'9' && c<'a') || c>'f') return false; //Core,16进制只包含0-9 a-f
            }
        }
        return true;
    }

    private boolean isIPV4(String IP) {
        if (IP.charAt(IP.length()-1) == '.') return false;
        String[] num = IP.split("\\.");
        if (num.length != 4) return false;

        for (String val : num) {
            if ("".equals(val) || val.length() > 3 || (val.length()>1 && val.charAt(0) == '0')) return false;
            for (int i=0; i<val.length(); i++) {
                if (!(val.charAt(i) >= '0' && val.charAt(i) <= '9')) return false;
            }
            if (Integer.parseInt(val) > 255) return false;
        }
        return true;
    }
}






































