class Solution:
    def accountsMerge(self, accounts: list[list[str]]) -> list[list[str]]:
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)

        parent = {}
        email_to_name = {}

        for account in accounts:
            name = account[0]
            first_email = account[1]
            for email in account[1:]:
                if email not in parent:
                    parent[email] = email
                email_to_name[email] = name
                union(first_email, email)

        groups = {}
        for email in parent:
            root = find(email)
            groups.setdefault(root, []).append(email)
        
        result = []
        for root, emails in groups.items():
            name = email_to_name[root]
            result.append([name] + sorted(emails))
        
        return result
        