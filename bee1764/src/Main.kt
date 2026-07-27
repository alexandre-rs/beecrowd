import java.util.Scanner

data class Edge(val u: Int, val v: Int, val weight: Int)


class UnionFind(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 0 }

    // Find the representative with Path compression
    fun find(i: Int): Int {
        if (parent[i] != i) {
            parent[i] = find(parent[i])
        }
        return parent[i]
    }

    //Joins two sets by rank
    fun union(i: Int, j: Int): Boolean {
        val rootI = find(i)
        val rootJ = find(j)
        if (rootI == rootJ) {
            return false //Vertices i and j are already in the same set (It would form a circle)
        }
        if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ
        } else if (rank[rootI] > rank[rootJ]) {
            parent[rootJ] = rootI
        } else {
            parent[rootI] = rootJ
            rank[rootJ]++
        }
        return true
    }
}
//MST = Minimum Spanning Tree
fun kruskalMST(numberOfVertices: Int, edges: List<Edge>): List<Edge> {
    val mst = mutableListOf<Edge>() //Here the MST is an edge list
    val uf = UnionFind(numberOfVertices) //Cria e inicializa um objeto do tipo union find que contém os arrays parent e rank
    val sortedEdges = edges.sortedBy { it.weight } //Sort the edge list by weight

    //Loop de construção da MST
    for (edge in sortedEdges) { //Para cada aresta na lista ordenada de arestas ...
        if (uf.union(edge.u, edge.v)) {
            mst.add(edge)
        }
    }
    return mst
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var m = scanner.nextInt() //number of vertices
    var n = scanner.nextInt() //number of edges
    while (n != 0 && m != 0) {
        val edges = mutableListOf<Edge>()
        for (e in 0 until n) {
            //ler x, y e z
            val x: Int = scanner.nextInt()
            val y: Int = scanner.nextInt()
            val z: Int = scanner.nextInt()
            edges.add(Edge(x, y, z))
        }
        val result = kruskalMST(m, edges)
        println("${result.sumOf { it.weight }}")
        m = scanner.nextInt()
        n = scanner.nextInt()
    }
}