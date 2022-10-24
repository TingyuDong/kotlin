fun main() {
    val solution = Solution()
    println(solution.knightProbability(3, 2, 0, 0))
}

class Solution {
    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        val possibleDirection = arrayOf(
                arrayOf(-1, 2),
                arrayOf(1, 2),
                arrayOf(2, 1),
                arrayOf(2, -1),
                arrayOf(1, -2),
                arrayOf(-1, -2),
                arrayOf(-2, -1),
                arrayOf(-2, 1)
        )
        val currentMatrix = Array(k + 1) { Array(n) { DoubleArray(n) { 0.0 } } }

        for (step in 0..k) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (step == 0) {
                        currentMatrix[step][i][j] = 1.0
                    } else {
                        for (move in possibleDirection.indices) {
                            val nextI = i + possibleDirection[move][0]
                            val nextJ = j + possibleDirection[move][1]
                            if (nextI in 0 until n && nextJ in 0 until n) {
                                currentMatrix[step][i][j] += currentMatrix[step - 1][nextI][nextJ] / 8
                            }
                        }
                    }
                }
            }
        }
        return currentMatrix[k][row][column]
    }
}

