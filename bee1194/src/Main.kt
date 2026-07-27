import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // Verifica se há entrada
    if (scanner.hasNext()) {
        // Lê o número de casos de teste
        val c = scanner.nextInt()

        for (i in 0 until c) {
            // Lê N (número de nodos), embora não precisemos usá-lo estritamente na lógica recursiva
            // pois podemos usar o tamanho das strings, mas precisamos consumir o token.
            val n = scanner.nextInt()

            val preOrder = scanner.next()
            val inOrder = scanner.next()

            // Reseta o índice global da string prefixa para cada caso de teste
            solverIndex = 0

            solvePostOrder(preOrder, inOrder, 0, n - 1)
            println() // Quebra de linha ao final de cada caso de teste
        }
    }
}

// Variável global para rastrear o caractere atual na string Prefixa
var solverIndex = 0

/**
 * Função recursiva para imprimir o percurso Posfixo.
 * * @param preStr String do percurso Prefixo (completa)
 * @param inStr String do percurso Infixo (completa)
 * @param inStart Índice inicial do intervalo atual na string Infixa
 * @param inEnd Índice final do intervalo atual na string Infixa
 */
fun solvePostOrder(preStr: String, inStr: String, inStart: Int, inEnd: Int) {
    // Caso base: se o início ultrapassar o fim, o intervalo é inválido/vazio
    if (inStart > inEnd) return

    // 1. A raiz atual é o caractere apontado por solverIndex na string Prefixa
    val rootValue = preStr[solverIndex]
    solverIndex++

    // 2. Encontrar a posição da raiz na string Infixa
    // (Isso divide a árvore em subárvore esquerda e direita)
    val rootIndexInInOrder = inStr.indexOf(rootValue)

    // 3. Processar recursivamente a Subárvore Esquerda
    // (Vai do início atual até um antes da raiz)
    solvePostOrder(preStr, inStr, inStart, rootIndexInInOrder - 1)

    // 4. Processar recursivamente a Subárvore Direita
    // (Vai de um depois da raiz até o fim atual)
    solvePostOrder(preStr, inStr, rootIndexInInOrder + 1, inEnd)

    // 5. Imprimir a Raiz (Definição de Posfixa: Esq -> Dir -> Raiz)
    print(rootValue)
}