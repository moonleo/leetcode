class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "/";
        }
        String[] arr = path.split("/");
        LinkedList<String> list = new LinkedList<String>();
        for(String s:arr) {
            if("..".equals(s)) {
                if(list.size() != 0)
                    list.pollLast();
            }else if(s.trim().equals("")||s.equals(".")) {
                //do nothing
            } else {
                list.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String s: list) {
            sb.append(s).append("/");
        }
        String result = sb.toString();
        if(result.length() == 1) {
            return result;
        } else {
            return result.substring(0, result.length() - 1);
        }
    }
}
