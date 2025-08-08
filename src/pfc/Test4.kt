package pfc

/*
5. Checksum Aggregator
In a distributed network system, data packets with unique identifiers and checksum values are sent between nodes to maintain communication and data integrity. Develop a function to aggregate the checksum values for all possible pairs of packets within the network.
For any two distinct packets with identifiers i and j, the checksum is calculated as C(i, j) = i mod j + j mod i.
Calculate the sum of C(i, j) for all pairs (1 sis n) and (1 ≤j s n), where n is the total number of packets in the network. Return the result modulo (10° + 7).
Example
Given n = 3, calculate the checksum for all the pairs of packets (i, j) where (1 ≤ is n) and (1 ≤ j≤ n)
• C(1, 1) = 1 mod 1 + 1 mod 1 = 0 + 0 = 0
• C(1, 2) = 1 mod 2 + 2 mod 1 = 1 + 0 = 1
• C(1,3) = 1 mod 3 + 3 mod 1 = 1 + 0 = 1
• C(2, 1) = 2 mod 1 + 1 mod 2 = 0 + 1 = 1
• C(2, 2) = 2 mod 2 + 2 mod 2 = 0 + 0 = 0
• C(2, 3) = 2 mod 3 + 3 mod 2 = 2 + 1 = 3
• C(3, 1) = 3 mod 1 + 1 mod 3 = 0 + 1 = 1
• C(3, 2) = 3 mod 2 + 2 mod 3 = 1 + 2 = 3
• C(3, 3) = 3 mod 3 + 3 mod 3 = 0 + 0 = 0
The aggregated checksum is 0 + 1 + 1 + 1 + 0 + 3 + 1 + 3 + 0 = 10 mod (10° +7) = 10.

Function Description
Complete the function computeChecksumAggregation in the editor below.

Function Parameters:
int n: the total number of packets in the network

Returns
int the aggregated checksum

Constraints
• 1 ≤ n ≤ 10^6

Explanation
Given n = 2,
Calculating all the checksum between each pair of packets:
• C(1, 1) = 1 mod 1 + 1 mod 1 = 0 + 0 = 0
• C(1, 2) = 1 mod 2 + 2 mod 1 = 1 + 0 = 1
• C(2, 1) = 2 mod 1 + 1 mod 2 = 0 + 1 = 1
• C(2, 2) = 2 mod 2 + 2 mod 2 = 0 + 0 = 0
The sum of the checksums is 0 + 1 + 1 + 0 = 2 mod (10^9+7) = 2.

Explanation
Given n = 4,
Calculating all the checksum between each pair of packets :
• C(1, 1) = 1 mod 1 + 1 mod 1 = 0 + 0 = 0
• C(1, 2) = 1 mod 2 + 2 mod 1 = 1 + 0 = 1
• C(1, 3) = 1 mod 3 + 3 mod 1 = 1 + 0 = 1
• C(1, 4) = 1 mod 4 + 4 mod 1 = 1 + 0 = 1
• C(2, 1) = 2 mod 1 + 1 mod 2 = 0 + 1 = 1
• C(2, 2) = 2 mod 2 + 2 mod 2 = 0 + 0 = 0
• C(2, 3) = 2 mod 3 + 3 mod 2 = 2 + 1 = 3
• C(2, 4) = 2 mod 4 + 4 mod 2 = 2 + 0 = 2
• C(3, 1) = 3 mod 1 + 1 mod 3 = 0 + 1 = 1
• C(3, 2) = 3 mod 2 + 2 mod 3 = 1 + 2 = 3
• C(3, 3) = 3 mod 3 + 3 mod 3 = 0 + 0 = 0
• C(3, 4) = 3 mod 4 + 4 mod 3 = 3 + 1 = 4
• C(4, 1) = 4 mod 1 + 1 mod 4 = 0 + 1 = 1
• C(4, 2) = 4 mod 2 + 2 mod 4 = 0 + 2 = 2
• C(4, 3) = 4 mod 3 + 3 mod 4 = 1 + 3 = 4
• C(4, 4) = 4 mod 4 + 4 mod 4 = 0 + 0 = 0
The sum of the checksums = 24 mod (10°+7) = 24.

* */
import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*



/*
 * Complete the 'computeChecksumAggregation' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.
 */

fun computeChecksumAggregation(n: Int): Int {
    val MOD = 1_000_000_007L
    var total = 0L

    for (i in 1..n) {
        var j = 1
        while (j <= n) {
            val div = n / j
            val next = n / div + 1
            val count = (next - j).toLong()

            val r = j + count - 1
            // j부터 r까지의 값 중에서 j % i 합 구하기
            val modSum = ((div.toLong() % i) * i % MOD * count % MOD)

            total = (total + modSum) % MOD
            j = next
        }
    }

    return ((2 * total) % MOD).toInt()

}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val result = computeChecksumAggregation(n)

    println(result)
}


