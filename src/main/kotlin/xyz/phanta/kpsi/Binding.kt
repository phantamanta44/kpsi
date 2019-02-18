package xyz.phanta.kpsi

interface Binding {

    companion object {

        @Suppress("UNCHECKED_CAST")
        internal fun <T : Binding> createBinding(type: ResultType<T>, source: Piece<T>): T = when (type) {
            ResultType.ANY -> Wildcard(source as Piece<Wildcard>)
            ResultType.NUMBER -> Numeral(source as Piece<Numeral>)
            ResultType.VECTOR -> Vector(source as Piece<Vector>)
            ResultType.ENTITY -> Entity(source as Piece<Entity>)
            ResultType.LIST -> EntityList(source as Piece<EntityList>)
        } as T

    }

}

object None : Binding

open class Wildcard internal constructor(internal val source: Piece<out Wildcard>) : Binding

class Numeral internal constructor(source: Piece<out Numeral>) : Wildcard(source)

class Vector internal constructor(source: Piece<out Vector>) : Wildcard(source)

class Entity internal constructor(source: Piece<out Entity>) : Wildcard(source)

class EntityList internal constructor(source: Piece<out EntityList>) : Wildcard(source)

sealed class ResultType<T : Binding>(val name: String) {

    object ANY : ResultType<Wildcard>("Any")

    object NUMBER : ResultType<Numeral>("Number")

    object VECTOR : ResultType<Vector>("Vector")

    object ENTITY : ResultType<Entity>("Entity")

    object LIST : ResultType<EntityList>("Entity List")

}
