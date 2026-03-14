class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalGas = 0
        var totalCost = 0
        var tank = 0
        var start = 0

        for (i in gas.indices) {
            totalGas += gas[i]
            totalCost += cost[i]
            tank += gas[i] - cost[i]

            if (tank < 0) {
                start = i + 1
                tank = 0;
            }
        }

        return if (totalGas < totalCost) -1 else start
    }
}