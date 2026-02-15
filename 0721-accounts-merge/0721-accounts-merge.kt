class Solution {
    private val parent = mutableMapOf<String, String>()
    private val emailToName = mutableMapOf<String, String>()
    private val groups = mutableMapOf<String, MutableList<String>>()

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        for (account in accounts) {
            val name = account[0]

            for (i in 1 until account.size) {
                val email = account[i]
                parent.putIfAbsent(email, email)
                emailToName[email] = name

                if (i > 1) union(account[1], email)
            }
        }

        for (email in parent.keys) {
            val root = find(email)
            groups.getOrPut(root) { mutableListOf() }.add(email)
        }

        return groups.map { (root, emails) ->
            emails.sort()
            mutableListOf(emailToName[root]!!).apply {
                addAll(emails)
            }
        }
    }

    private fun find(x: String): String {
        if (parent[x] == x) return x
        val root = find(parent[x]!!)
        parent[x] = root
        return root
    }

    private fun union(x: String, y: String) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            parent[rootY] = rootX
        }
    }
}