class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        retrospect(s, 0, 0, "", result);
        return result;
    }

    private void retrospect(String s, int num, int index, String ip, List<String> result) {
        if (num == 3) {
            if (index < s.length() && s.length() - index <= 3) {
                String childIp = validIPField(s.substring(index));
                if (childIp != null) {
                    result.add(ip + "." + childIp);
                    return;
                }
            }
        } else if (index < s.length()){
            // if s.charAt(index) == '0', then should begin next iteration
            if (s.charAt(index) == '0') {
                if (num == 0) {
                    retrospect(s, num + 1, index + 1, "" + 0, result);
                } else {
                    retrospect(s, num + 1, index + 1, ip + "." + 0, result);
                }
            } else {
                for (int i = index + 1; i <= index + 4 && i < s.length(); i++) {
                    String ipField = validIPField(s.substring(index, i));
                    if (ipField == null) {
                        break;
                    } else {
                        if (num == 0) {
                            retrospect(s, num + 1, i, ipField, result);
                        } else {
                            retrospect(s, num + 1, i, ip + "." + ipField, result);
                        }

                    }
                }
            }
        }
    }

    private String validIPField(String s) {
        int len = s.length();
        int ipField = Integer.parseInt(s);
        if (ipField < 0 || ipField > 255) {
            return null;
        }
        String ipFieldStr = String.valueOf(ipField);
        if (ipFieldStr.length() < len) {
            return null;
        }
        return ipFieldStr;
    }
}
