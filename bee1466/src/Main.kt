import java.util.Scanner


/*
* beecrowd | 1466
Percurso em Árvore por Nível
Por Neilor Tonin, URI  Brasil

Timelimit: 2
Em uma árvore binária, o percurso por nível é um percurso denominado breadth first search (BFS) ou em português, busca em largura, a qual seria não-recursiva por natureza. Este percurso utiliza uma fila ao invés de pilha para armazenar os próximos 2 nodos que devem ser pesquisados (filho à esquerda e à direita). Esta é a razão pela qual você deve percorrer os nodos na ordem FIFO ao invés da ordem LIFO, obtendo desta forma a recursão.

Portanto nossa tarefa aqui, após algumas operações de inserção sobre uma árvore binária de busca (pesquisa), é imprimir o percurso por nível sobre estes nodos. Por exemplo, uma entrada com a sequência de valores inteiros: 8 3 10 14 6 4 13 7 1 resultará na seguinte árvore:



Com a saída de uma listagem por nível: 8 3 10 1 6 14 4 7 13.

Entrada
A entrada contém vários casos de teste. A primeira linha da entrada contém um inteiro C (C ≤ 1000), indicando o número de casos de teste que virão a seguir. Cada caso de teste é composto por 2 linhas. A primeira linha contém um inteiro N (1 ≤ N ≤ 500) que indica a quantidade de números que deve compor cada árvore e a segunda linha contém N inteiros distintos e não negativos, separados por um espaço em branco.

Saída
Para cada caso de teste de entrada você deverá imprimir a mensagem "Case n:", onde n indica o número do caso de teste seguido por uma linha contendo a listagem por nível dos nodos da árvore, conforme o exemplo abaixo.

Obs: Não deve haver espaço em branco após o último item de cada linha e há uma linha em branco após cada caso de teste, inclusive após o último. A árvore resultante não terá nodos repetidos e também não terá mais do que 500 níveis.
* */

data class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
)

class BinarySearchTree {
    var root: Node? = null

    // Classe interna para o nó
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(current: Node?, value: Int): Node {
        if (current == null) {
            return Node(value)
        }

        if (value < current.value) {
            current.left = insertRec(current.left, value)
        } else if (value > current.value) {
            current.right = insertRec(current.right, value)
        }
        // Se for igual, não fazemos nada (não permite duplicatas neste exemplo)

        return current
    }
}


fun main() {
    val scanner = Scanner(System.`in`)
    val testCasesNumber = scanner.nextInt() //Lê o número de casos de teste.
    for (i in 0 until testCasesNumber) {
        val treeSize = scanner.nextInt()
        val tree = BinarySearchTree()

        //Read the input array:
        for (j in 0 until treeSize) {
            val value = scanner.nextInt()
            tree.insert(value)
        }
        println("Case ${i + 1}:")
        printByLevel(tree)
    }

}


fun printByLevel(tree: BinarySearchTree) {
    val queue = ArrayDeque<Node>()
    queue.add(tree.root!!)
    val sb = StringBuilder()
    while (queue.isNotEmpty()) {
        //Remove the first queue element
        val current = queue.removeFirst()
        sb.append(current.value).append(" ")
        //Add child if exist
        current.left?.let { queue.add(it) }
        current.right?.let { queue.add(it) }
    }
    sb.deleteAt(sb.length - 1)
    println("$sb\n")
}
