package xyz.phanta.kpsi

import xyz.phanta.kpsi.Binding.Companion.createBinding

internal open class Piece<R : Binding>(val name: String) {

    class Factory<R : Binding>(
        private val name: String,
        private val resultType: ResultType<R>
    ) : () -> R {
        override fun invoke(): R = createBinding(resultType, Piece(name))
    }

    class Trick(
        private val name: String,
        private val body: SpellBody
    ) : () -> None {
        override fun invoke(): None = body.trick(Piece(name))
    }

    open val bindings: Set<ParamBinding<*>>
        get() = setOf()

}

internal class Piece1<A : Wildcard, R : Binding>(
    name: String,
    private val a: ParamBinding<A>
) : Piece<R>(name) {

    class Factory<A : Wildcard, R : Binding>(
        private val name: String,
        private val resultType: ResultType<R>,
        private val pA: Param<A>
    ) : (A?) -> R {
        override fun invoke(a: A?): R = createBinding(resultType, Piece1(name, ParamBinding(a, pA)))
    }

    class Trick<A : Wildcard>(
        private val name: String,
        private val body: SpellBody,
        private val pA: Param<A>
    ) : (A?) -> None {
        override fun invoke(a: A?): None = body.trick(Piece1(name, ParamBinding(a, pA)))
    }

    override val bindings: Set<ParamBinding<*>>
        get() = setOf(a)

}

internal class Piece2<A : Wildcard, B : Wildcard, R : Binding>(
    name: String,
    private val a: ParamBinding<A>,
    private val b: ParamBinding<B>
) : Piece<R>(name) {

    class Factory<A : Wildcard, B : Wildcard, R : Binding>(
        private val name: String,
        private val resultType: ResultType<R>,
        private val pA: Param<A>,
        private val pB: Param<B>
    ) : (A?, B?) -> R {
        override fun invoke(a: A?, b: B?): R =
            createBinding(resultType, Piece2(name, ParamBinding(a, pA), ParamBinding(b, pB)))
    }

    class Trick<A : Wildcard, B : Wildcard>(
        private val name: String,
        private val body: SpellBody,
        private val pA: Param<A>,
        private val pB: Param<B>
    ) : (A?, B?) -> None {
        override fun invoke(a: A?, b: B?): None = body.trick(Piece2(name, ParamBinding(a, pA), ParamBinding(b, pB)))
    }

    override val bindings: Set<ParamBinding<*>>
        get() = setOf(a, b)

}

internal class Piece3<A : Wildcard, B : Wildcard, C : Wildcard, R : Binding>(
    name: String,
    private val a: ParamBinding<A>,
    private val b: ParamBinding<B>,
    private val c: ParamBinding<C>
) : Piece<R>(name) {

    class Factory<A : Wildcard, B : Wildcard, C : Wildcard, R : Binding>(
        private val name: String,
        private val resultType: ResultType<R>,
        private val pA: Param<A>,
        private val pB: Param<B>,
        private val pC: Param<C>
    ) : (A?, B?, C?) -> R {
        override fun invoke(a: A?, b: B?, c: C?): R =
            createBinding(resultType, Piece3(name, ParamBinding(a, pA), ParamBinding(b, pB), ParamBinding(c, pC)))
    }

    class Trick<A : Wildcard, B : Wildcard, C : Wildcard>(
        private val name: String,
        private val body: SpellBody,
        private val pA: Param<A>,
        private val pB: Param<B>,
        private val pC: Param<C>
    ) : (A?, B?, C?) -> None {
        override fun invoke(a: A?, b: B?, c: C?): None =
            body.trick(Piece3(name, ParamBinding(a, pA), ParamBinding(b, pB), ParamBinding(c, pC)))
    }

    override val bindings: Set<ParamBinding<*>>
        get() = setOf(a, b, c)

}

internal class Piece4<A : Wildcard, B : Wildcard, C : Wildcard, D : Wildcard, R : Binding>(
    name: String,
    private val a: ParamBinding<A>,
    private val b: ParamBinding<B>,
    private val c: ParamBinding<C>,
    private val d: ParamBinding<D>
) : Piece<R>(name) {

    class Factory<A : Wildcard, B : Wildcard, C : Wildcard, D : Wildcard, R : Binding>(
        private val name: String,
        private val resultType: ResultType<R>,
        private val pA: Param<A>,
        private val pB: Param<B>,
        private val pC: Param<C>,
        private val pD: Param<D>
    ) : (A?, B?, C?, D?) -> R {
        override fun invoke(a: A?, b: B?, c: C?, d: D?): R =
            createBinding(
                resultType,
                Piece4(name, ParamBinding(a, pA), ParamBinding(b, pB), ParamBinding(c, pC), ParamBinding(d, pD))
            )
    }

    class Trick<A : Wildcard, B : Wildcard, C : Wildcard, D : Wildcard>(
        private val name: String,
        private val body: SpellBody,
        private val pA: Param<A>,
        private val pB: Param<B>,
        private val pC: Param<C>,
        private val pD: Param<D>
    ) : (A?, B?, C?, D?) -> None {
        override fun invoke(a: A?, b: B?, c: C?, d: D?): None =
            body.trick(Piece4(name, ParamBinding(a, pA), ParamBinding(b, pB), ParamBinding(c, pC), ParamBinding(d, pD)))
    }

    override val bindings: Set<ParamBinding<*>>
        get() = setOf(a, b, c, d)

}
