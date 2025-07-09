class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val letters = mutableListOf<String>()
        val digits = mutableListOf<String>()
        
        for (log in logs) {
            if (Character.isDigit(log.split(" ")[1][0])) {
                digits.add(log)
            } else {
                letters.add(log)
            }
        }

        letters.sortWith(Comparator { s1: String, s2: String ->
            val s1x = s1.split(" ", limit = 2)
            val s2x = s2.split(" ", limit = 2)

            val compared = s1x[1].compareTo(s2x[1])
            if (compared == 0) {
                s1x[0].compareTo(s2x[0])
            } else {
                compared
            }
        })

        letters.addAll(digits)

        return letters.toTypedArray()
    }
}