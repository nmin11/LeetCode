class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = ArrayDeque<Int>()

        for (asteroid in asteroids) {
            var isAlive = true

            while (stack.isNotEmpty() && stack.last() > 0 && asteroid < 0) {
                val top = stack.last()
                when {
                    top < -asteroid -> stack.removeLast()
                    top == -asteroid -> {
                        stack.removeLast()
                        isAlive = false
                        break
                    }
                    else -> {
                        isAlive = false
                        break
                    }
                }
            }

            if (isAlive) stack.addLast(asteroid)
        }

        return stack.toIntArray()
    }
}