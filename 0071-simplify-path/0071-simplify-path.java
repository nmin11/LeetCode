class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            else if (part.equals("..")) {
                if (stack.isEmpty()) continue;
                else stack.pop();
            } else stack.push(part);
        }

        if (stack.isEmpty()) return "/";

        List<String> list = new ArrayList<>(stack);
        Collections.reverse(list);
        return "/" + String.join("/", list);
    }
}