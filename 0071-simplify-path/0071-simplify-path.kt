class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        val parts = path.split("/")

        for (part in parts) {
            when {
                part == "" || part == "." -> continue
                part == ".." -> {
                    if (stack.isNotEmpty()) stack.removeLast()
                }
                else -> stack.addLast(part)
            }
        }

        if (stack.isEmpty()) return "/"

        return "/" + stack.joinToString("/")
    }
}