import java.util.*

/**
 * Constrói o Suffix Array usando Prefix Doubling em O(n log^2 n).
 */
fun buildSuffixArray(text: String): IntArray {
    val n = text.length
    if (n == 0) return IntArray(0)

    // Ranks iniciais são simplesmente os valores ASCII/Unicode de cada letra.
    var rank = IntArray(n) { text[it].code }

    // Usamos Array (boxed) em vez de IntArray para podermos usar sortWith nativo.
    val sa = Array(n) { it }

    var k = 1
    // Loop de potências de 2
    while (k < n) {
        val currentK = k

        // Ordena com base no par (rank[i], rank[i + k])
        sa.sortWith { i, j ->
            if (rank[i] != rank[j]) {
                rank[i].compareTo(rank[j])
            } else {
                val rankIK = if (i + currentK < n) rank[i + currentK] else -1
                val rankJK = if (j + currentK < n) rank[j + currentK] else -1
                rankIK.compareTo(rankJK)
            }
        }

        // Recalcula os ranks com base na nova ordenação
        val tempRank = IntArray(n)
        tempRank[sa[0]] = 0 // O menor sufixo sempre ganha o rank 0

        for (i in 1 until n) {
            val prev = sa[i - 1]
            val curr = sa[i]

            val rankPrev = rank[prev]
            val rankCurr = rank[curr]
            val nextRankPrev = if (prev + k < n) rank[prev + k] else -1
            val nextRankCurr = if (curr + k < n) rank[curr + k] else -1

            // Se os pares forem idênticos, recebem o mesmo rank.
            // Se divergirem, o atual recebe rank maior.
            if (rankPrev == rankCurr && nextRankPrev == nextRankCurr) {
                tempRank[curr] = tempRank[prev]
            } else {
                tempRank[curr] = tempRank[prev] + 1
            }
        }
        rank = tempRank
        k *= 2
    }

    // Converte de volta para IntArray primitivo para performance e baixo uso de memória
    return sa.toIntArray()
}

/**
 * Constrói o LCP Array usando o Algoritmo de Kasai em O(n).
 */
fun buildLCPArray(text: String, suffixArray: IntArray): IntArray {
    val n = text.length
    val lcp = IntArray(n)

    // Rank array (Inverse Suffix Array)
    val rank = IntArray(n)
    for (i in 0 until n) {
        rank[suffixArray[i]] = i
    }

    var h = 0
    for (i in 0 until n) {
        val rankIndex = rank[i]

        if (rankIndex > 0) {
            val j = suffixArray[rankIndex - 1]
            while (i + h < n && j + h < n && text[i + h] == text[j + h]) {
                h++
            }
            lcp[rankIndex] = h
            if (h > 0) h--
        }
    }
    return lcp
}

// 1. Criamos uma Data Class para encapsular o resultado com clareza
data class KasaiResult(
    val lcp: IntArray,
    val rank: IntArray
)

/**
 * Constrói o LCP Array e retorna junto com o Rank Array.
 */
fun buildLCPAndRank(text: String, suffixArray: IntArray): KasaiResult {
    val n = text.length

    // O array LCP final
    val lcp = IntArray(n)

    // O array Rank (Inverse Suffix Array)
    val rank = IntArray(n)
    for (i in 0 until n) {
        rank[suffixArray[i]] = i
    }

    var h = 0
    for (i in 0 until n) {
        val rankIndex = rank[i]

        if (rankIndex > 0) {
            val j = suffixArray[rankIndex - 1]
            while (i + h < n && j + h < n && text[i + h] == text[j + h]) {
                h++
            }
            lcp[rankIndex] = h
            if (h > 0) h--
        }
    }

    // 2. Retornamos a instância da Data Class
    return KasaiResult(lcp = lcp, rank = rank)
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    do {
        val line = scanner.nextLine()
        var countLetters = 0
        var aux: Int = 0
        for (char in line) {
            if (char != '?') {
                countLetters++
            } else {
                println("Count: $countLetters")
                aux = countLetters
            }
        }
    } while (scanner.hasNextLine())
}