class Solution {
    private Map<String, String> parent;
    private Map<String, String> emailToName;
    private Map<String, List<String>> groups;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new HashMap<>();
        emailToName = new HashMap<>();
        groups = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);

                if (i > 1) {
                    union(account.get(1), email);
                }
            }
        }

        for (String email : parent.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root));
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }

    private String find(String x) {
        if (parent.get(x).equals(x)) return x;
        String root = find(parent.get(x));
        parent.put(x, root);
        return root;
    }

    private void union(String x, String y) {
        String rootX = find(x);
        String rootY = find(y);

        if (rootX != rootY) {
            parent.put(rootY, rootX);
        }
    }
}