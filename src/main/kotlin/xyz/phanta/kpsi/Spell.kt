package xyz.phanta.kpsi

private typealias Intermediate = MutableMap<Piece<*>, PieceNode>

fun spell(name: String? = null, body: SpellBody.() -> Unit): SpellGraph {
    val tricks = mutableSetOf<Piece<Binding>>()
    body(SpellBody(tricks))
    val nodes = mutableMapOf<Piece<*>, PieceNode>()
    tricks.forEach { traverse(nodes, it) }
    return SpellGraph(name, nodes.values.toSet())
}

private fun traverse(nodes: Intermediate, piece: Piece<out Binding>): PieceNode {
    var node = nodes[piece]
    if (node == null) {
        node = PieceNode(
            piece.name,
            piece.bindings
                .filter { it.binding != null }
                .map { edge(nodes, it.binding!!.source, it.param) }
                .toSet()
        )
        nodes[piece] = node
    }
    return node
}

private fun edge(nodes: Intermediate, source: Piece<out Wildcard>, param: Param<out Wildcard>): PieceEdge {
    return PieceEdge(traverse(nodes, source), param)
}
