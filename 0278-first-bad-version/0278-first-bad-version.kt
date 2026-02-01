/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n

        while (left <= right) {
            val mid = left + (right - left) / 2

            when (isBadVersion(mid)) {
                true -> right = mid - 1
                false -> left = mid + 1
            }
        }

        return left
	}
}