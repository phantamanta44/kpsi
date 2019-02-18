package xyz.phanta.kpsi

import org.graphstream.graph.Edge
import org.graphstream.graph.Node
import org.graphstream.graph.implementations.SingleGraph

class PieceNode(val name: String, val incoming: Set<PieceEdge>)

class PieceEdge(val source: PieceNode, val param: Param<*>)

class SpellGraph internal constructor(name: String?, val nodes: Set<PieceNode>) {

    val name: String = name ?: "Psi Spell"

    fun asGraphStream(): SingleGraph {
        val graph = SingleGraph(name, true, false)
        val gsNodes = nodes.associateWith { node ->
            graph.addNode<Node>(node.toString()).also {
                it.addAttribute("name", node.name)
                it.addAttribute("ui.label", node.name)
            }
        }
        nodes.forEach { node ->
            node.incoming.forEach {
                val edge = graph.addEdge<Edge>(it.toString(), gsNodes[it.source], gsNodes[node], true)
                edge.addAttribute("name", it.param.name)
                edge.addAttribute("type", it.param.type)
                edge.addAttribute("colour", it.param.col)
                edge.addAttribute("ui.label", "${it.param.name}: ${it.param.type.name}")
                edge.addAttribute("ui.style", "fill-color: ${it.param.col.colour};")
            }
        }
        return graph
    }

}
