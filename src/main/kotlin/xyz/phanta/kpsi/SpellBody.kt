package xyz.phanta.kpsi

class SpellBody internal constructor(private val tricks: MutableSet<Piece<Binding>>) {

    internal fun trick(trick: Piece<Binding>): None {
        tricks.add(trick)
        return None
    }

    fun selectorCaster(): Entity = sCaster()
    private val sCaster = Piece.Factory(
        "Selector: Caster", ResultType.ENTITY
    )

    fun selectorFocalPoint(): Entity = sFocalPoint()
    private val sFocalPoint = Piece.Factory(
        "Selector: Focal Point", ResultType.ENTITY
    )

    fun selectorNearbyItems(position: Vector, radius: Numeral): EntityList = sNearbyItems(position, radius)
    private val sNearbyItems = Piece2.Factory(
        "Selector: Nearby Items", ResultType.LIST,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Radius", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun selectorNearbyLiving(position: Vector, radius: Numeral): EntityList = sNearbyLiving(position, radius)
    private val sNearbyLiving = Piece2.Factory(
        "Selector: Nearby Living", ResultType.LIST,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Radius", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun selectorNearbyEnemies(position: Vector, radius: Numeral): EntityList = sNearbyEnemies(position, radius)
    private val sNearbyEnemies = Piece2.Factory(
        "Selector: Nearby Enemies", ResultType.LIST,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Radius", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun selectorNearbyAnimals(position: Vector, radius: Numeral): EntityList = sNearbyAnimals(position, radius)
    private val sNearbyAnimals = Piece2.Factory(
        "Selector: Nearby Animals", ResultType.LIST,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Radius", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun selectorNearbyProjectiles(position: Vector, radius: Numeral): EntityList = sNearbyProjectiles(position, radius)
    private val sNearbyProjectiles = Piece2.Factory(
        "Selector: Nearby Projectiles", ResultType.LIST,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Radius", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun selectorNearbySmeltables(position: Vector, radius: Numeral): EntityList = sNearbySmeltables(position, radius)
    private val sNearbySmeltables = Piece2.Factory(
        "Selector: Nearby Smeltables", ResultType.LIST,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Radius", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun selectorLoopcastIndex(): Numeral = sLoopcastIndex()
    private val sLoopcastIndex = Piece.Factory(
        "Selector: Loopcast Index", ResultType.NUMBER
    )

    fun selectorBlockBroken(): Vector = sBlockBroken()
    private val sBlockBroken = Piece.Factory(
        "Selector: Block Broken", ResultType.VECTOR
    )

    fun selectorBlockSideBroken(): Vector = sBlockSideBroken()
    private val sBlockSideBroken = Piece.Factory(
        "Selector: Block Broken Side", ResultType.VECTOR
    )

    fun selectorAttackTarget(): Entity = sAttackTarget()
    private val sAttackTarget = Piece.Factory(
        "Selector: Attack Target", ResultType.ENTITY
    )

    fun selectorSneakStatus(): Numeral = sSneakStatus()
    private val sSneakStatus = Piece.Factory(
        "Selector: Sneak Status", ResultType.NUMBER
    )

    fun selectorTime(): Numeral = sTime()
    private val sTime = Piece.Factory(
        "Selector: Time", ResultType.NUMBER
    )

    fun selectorAttacker(): Entity = sAttacker()
    private val sAttacker = Piece.Factory(
        "Selector: Attacker", ResultType.ENTITY
    )

    fun selectorDamageTaken(): Numeral = sDamageTaken()
    private val sDamageTaken = Piece.Factory(
        "Selector: Damage Taken ", ResultType.NUMBER
    )

    fun selectorRulerVector(): Vector = sRulerVector()
    private val sRulerVector = Piece.Factory(
        "Selector: Ruler Vector ", ResultType.VECTOR
    )

    fun selectorItemPresence(slot: Numeral? = null): Numeral = sItemPresence(slot)
    private val sItemPresence = Piece1.Factory(
        "Selector: Item Presence", ResultType.NUMBER,
        Param("Slot", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun selectorBlockPresence(position: Vector): Numeral = sBlockPresence(position)
    private val sBlockPresence = Piece1.Factory(
        "Selector: Block Presence", ResultType.NUMBER,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun selectorSavedVector(number: Numeral): Vector = sSavedVector(number)
    private val sSavedVector = Piece1.Factory(
        "Selector: Saved Vector", ResultType.VECTOR,
        Param("Number", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun selectorEidosChangelog(number: Numeral): Vector = sEidosChangelog(number)
    private val sEidosChangelog = Piece1.Factory(
        "Selector: Eidos Changelog", ResultType.VECTOR,
        Param("Number", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorSum(numberA: Numeral, numberB: Numeral, numberC: Numeral? = null): Numeral =
        oSum(numberA, numberB, numberC)

    operator fun Numeral.plus(other: Numeral): Numeral = oSum(this, other, null)
    private val oSum = Piece3.Factory(
        "Operator: Sum", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number C", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorSubtract(numberA: Numeral, numberB: Numeral, numberC: Numeral? = null): Numeral =
        oSubtract(numberA, numberB, numberC)

    operator fun Numeral.minus(other: Numeral): Numeral = oSubtract(this, other, null)
    private val oSubtract = Piece3.Factory(
        "Operator: Subtract", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.RED),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number C", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorMultiply(numberA: Numeral, numberB: Numeral, numberC: Numeral? = null): Numeral =
        oMultiply(numberA, numberB, numberC)

    operator fun Numeral.times(other: Numeral): Numeral = oMultiply(this, other, null)
    private val oMultiply = Piece3.Factory(
        "Operator: Multiply", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number C", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorDivide(numberA: Numeral, numberB: Numeral): Numeral = oDivide(numberA, numberB)
    operator fun Numeral.div(other: Numeral): Numeral = oDivide(this, other)
    private val oDivide = Piece2.Factory(
        "Operator: Divide", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.RED),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorAbsolute(target: Numeral): Numeral = oAbsolute(target)
    fun Numeral.abs(): Numeral = oAbsolute(this)
    private val oAbsolute = Piece1.Factory(
        "Operator: Absolute", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorInverse(target: Numeral): Numeral = oInverse(target)
    fun Numeral.inverse(): Numeral = oInverse(this)
    private val oInverse = Piece1.Factory(
        "Operator: Inverse", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorModulus(numberA: Numeral, numberB: Numeral): Numeral = oModulus(numberA, numberB)
    operator fun Numeral.rem(other: Numeral): Numeral = oModulus(this, other)
    private val oModulus = Piece2.Factory(
        "Operator: Modulus", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.RED),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorRandom(target: Numeral): Numeral = oRandom(target)
    private val oRandom = Piece1.Factory(
        "Operator: Random", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorIntegerDivide(numberA: Numeral, numberB: Numeral): Numeral = oIntegerDivide(numberA, numberB)
    infix fun Numeral.intDivBy(other: Numeral): Numeral = oIntegerDivide(this, other)
    private val oIntegerDivide = Piece2.Factory(
        "Operator: Integer Divide", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.RED),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorSin(target: Numeral): Numeral = oSin(target)
    private val oSin = Piece1.Factory(
        "Operator: Sine", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorCos(target: Numeral): Numeral = oCos(target)
    private val oCos = Piece1.Factory(
        "Operator: Cosine", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorAsin(target: Numeral): Numeral = oAsin(target)
    private val oAsin = Piece1.Factory(
        "Operator: Arc Sine", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorAcos(target: Numeral): Numeral = oAcos(target)
    private val oAcos = Piece1.Factory(
        "Operator: Arc Cosine", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorMin(numberA: Numeral, numberB: Numeral, numberC: Numeral? = null): Numeral =
        oMin(numberA, numberB, numberC)
    private val oMin = Piece3.Factory(
        "Operator: Min", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number C", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorMax(numberA: Numeral, numberB: Numeral, numberC: Numeral? = null): Numeral =
        oMax(numberA, numberB, numberC)
    private val oMax = Piece3.Factory(
        "Operator: Max", ResultType.NUMBER,
        Param("Number A", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN),
        Param("Number C", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorSquare(number: Numeral): Numeral = oSquare(number)
    fun Numeral.sq(): Numeral = oSquare(this)
    private val oSquare = Piece1.Factory(
        "Operator: Square", ResultType.NUMBER,
        Param("Number", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorCube(number: Numeral): Numeral = oCube(number)
    fun Numeral.cubed(): Numeral = oCube(this)
    private val oCube = Piece1.Factory(
        "Operator: Cube", ResultType.NUMBER,
        Param("Number", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorPower(base: Numeral, power: Numeral): Numeral = oPower(base, power)
    fun Numeral.pow(power: Numeral): Numeral = oPower(this, power)
    private val oPower = Piece2.Factory(
        "Operator: Power", ResultType.NUMBER,
        Param("Base", ResultType.NUMBER, ParamCol.GREEN),
        Param("Power", ResultType.NUMBER, ParamCol.RED)
    )

    fun operatorSquareRoot(number: Numeral): Numeral = oSquareRoot(number)
    fun Numeral.sqrt(): Numeral = oSquareRoot(this)
    private val oSquareRoot = Piece1.Factory(
        "Operator: Square Root", ResultType.NUMBER,
        Param("Number", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorLog(target: Numeral, base: Numeral? = null): Numeral = oLog(target, base)
    private val oLog = Piece2.Factory(
        "Operator: Logarithm", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE),
        Param("Base", ResultType.NUMBER, ParamCol.RED)
    )

    fun operatorCeiling(number: Numeral): Numeral = oCeiling(number)
    fun Numeral.ceil(): Numeral = oCeiling(this)
    private val oCeiling = Piece1.Factory(
        "Operator: Ceiling", ResultType.NUMBER,
        Param("Number", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorFloor(number: Numeral): Numeral = oFloor(number)
    fun Numeral.floor(): Numeral = oFloor(this)
    private val oFloor = Piece1.Factory(
        "Operator: Floor", ResultType.NUMBER,
        Param("Number", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorRound(number: Numeral): Numeral = oRound(number)
    fun Numeral.round(): Numeral = oRound(this)
    private val oRound = Piece1.Factory(
        "Operator: Round", ResultType.NUMBER,
        Param("Number", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorEntityPosition(target: Entity): Vector = oEntityPosition(target)
    fun Entity.pos(): Vector = oEntityPosition(this)
    private val oEntityPosition = Piece1.Factory(
        "Operator: Entity Position", ResultType.VECTOR,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW)
    )

    fun operatorEntityLook(target: Entity): Vector = oEntityLook(target)
    fun Entity.look(): Vector = oEntityLook(this)
    private val oEntityLook = Piece1.Factory(
        "Operator: Entity Look", ResultType.VECTOR,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW)
    )

    fun operatorEntityMotion(target: Entity): Vector = oEntityMotion(target)
    fun Entity.vel(): Vector = oEntityMotion(this)
    private val oEntityMotion = Piece1.Factory(
        "Operator: Entity Motion", ResultType.VECTOR,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW)
    )

    fun operatorEntityAxialLook(target: Entity): Vector = oEntityAxialLook(target)
    fun Entity.axialLook(): Vector = oEntityAxialLook(this)
    private val oEntityAxialLook = Piece1.Factory(
        "Operator: Entity Axial Look", ResultType.VECTOR,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW)
    )

    fun operatorClosestToPoint(position: Vector, target: EntityList): Entity = oClosestToPoint(position, target)
    fun EntityList.closest(position: Vector): Entity = oClosestToPoint(position, this)
    private val oClosestToPoint = Piece2.Factory(
        "Operator: Closest to Point", ResultType.ENTITY,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Target", ResultType.LIST, ParamCol.YELLOW)
    )

    fun operatorRandomEntity(target: EntityList): Entity = oRandomEntity(target)
    fun EntityList.rand(): Entity = oRandomEntity(this)
    private val oRandomEntity = Piece1.Factory(
        "Operator: Random Entity", ResultType.ENTITY,
        Param("Target", ResultType.LIST, ParamCol.YELLOW)
    )

    fun operatorFocusedEntity(target: Entity): Entity = oFocusedEntity(target)
    fun Entity.focused(): Entity = oFocusedEntity(this)
    private val oFocusedEntity = Piece1.Factory(
        "Operator: Focused Entity", ResultType.ENTITY,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW)
    )

    fun operatorListAdd(target: Entity, list: EntityList): EntityList = oListAdd(target, list)
    operator fun EntityList.plus(entity: Entity): EntityList = oListAdd(entity, this)
    private val oListAdd = Piece2.Factory(
        "Operator: Add To List", ResultType.LIST,
        Param("Target", ResultType.ENTITY, ParamCol.BLUE),
        Param("List", ResultType.LIST, ParamCol.YELLOW)
    )

    fun operatorListRemove(target: Entity, list: EntityList): EntityList = oListRemove(target, list)
    fun EntityList.minus(entity: Entity): EntityList = oListRemove(entity, this)
    private val oListRemove = Piece2.Factory(
        "Operator: Remove From List", ResultType.LIST,
        Param("Target", ResultType.ENTITY, ParamCol.BLUE),
        Param("List", ResultType.LIST, ParamCol.YELLOW)
    )

    fun operatorVectorRaycast(position: Vector, ray: Vector, max: Numeral? = null): Vector =
        oVectorRaycast(position, ray, max)
    fun Entity.raycast(max: Numeral? = null): Vector = oVectorRaycast(pos(), look(), max)
    private val oVectorRaycast = Piece3.Factory(
        "Operator: Vector Raycast", ResultType.VECTOR,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Ray", ResultType.VECTOR, ParamCol.GREEN),
        Param("Max", ResultType.NUMBER, ParamCol.PURPLE)
    )

    fun operatorVectorSum(vectorA: Vector, vectorB: Vector, vectorC: Vector? = null): Vector =
        oVectorSum(vectorA, vectorB, vectorC)
    operator fun Vector.plus(other: Vector): Vector = oVectorSum(this, other, null)
    private val oVectorSum = Piece3.Factory(
        "Operator: Vector Sum", ResultType.VECTOR,
        Param("Vector A", ResultType.VECTOR, ParamCol.GREEN),
        Param("Vector B", ResultType.VECTOR, ParamCol.GREEN),
        Param("Vector C", ResultType.VECTOR, ParamCol.GREEN)
    )

    fun operatorVectorSubtract(vectorA: Vector, vectorB: Vector, vectorC: Vector? = null): Vector =
        oVectorSubtract(vectorA, vectorB, vectorC)
    operator fun Vector.minus(other: Vector): Vector = oVectorSubtract(this, other, null)
    private val oVectorSubtract = Piece3.Factory(
        "Operator: Vector Subtract", ResultType.VECTOR,
        Param("Vector A", ResultType.VECTOR, ParamCol.RED),
        Param("Vector B", ResultType.VECTOR, ParamCol.GREEN),
        Param("Vector C", ResultType.VECTOR, ParamCol.GREEN)
    )

    fun operatorVectorMultiply(vectorA: Vector, numberB: Numeral): Vector = oVectorMultiply(vectorA, numberB)
    operator fun Vector.times(other: Numeral): Vector = oVectorMultiply(this, other)
    private val oVectorMultiply = Piece2.Factory(
        "Operator: Vector Multiply", ResultType.VECTOR,
        Param("Vector A", ResultType.VECTOR, ParamCol.RED),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorVectorDivide(vectorA: Vector, numberB: Numeral): Vector = oVectorDivide(vectorA, numberB)
    operator fun Vector.div(other: Numeral): Vector = oVectorDivide(this, other)
    private val oVectorDivide = Piece2.Factory(
        "Operator: Vector Divide", ResultType.VECTOR,
        Param("Vector A", ResultType.VECTOR, ParamCol.RED),
        Param("Number B", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun operatorVectorCrossProduct(vectorA: Vector, vectorB: Vector): Vector = oVectorCrossProduct(vectorA, vectorB)
    infix fun Vector.cross(other: Vector): Vector = oVectorCrossProduct(this, other)
    private val oVectorCrossProduct = Piece2.Factory(
        "Operator: Vector Cross Product", ResultType.VECTOR,
        Param("Vector A", ResultType.VECTOR, ParamCol.RED),
        Param("Vector B", ResultType.VECTOR, ParamCol.GREEN)
    )

    fun operatorVectorNormalize(target: Vector): Vector = oVectorNormalize(target)
    fun Vector.norm(): Vector = oVectorNormalize(this)
    private val oVectorNormalize = Piece1.Factory(
        "Operator: Vector Normalize", ResultType.VECTOR,
        Param("Target", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun operatorVectorNegate(target: Vector): Vector = oVectorNegate(target)
    operator fun Vector.unaryMinus(): Vector = oVectorNegate(this)
    private val oVectorNegate = Piece1.Factory(
        "Operator: Vector Negate", ResultType.VECTOR,
        Param("Target", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun operatorVectorMagnitude(target: Vector): Numeral = oVectorMagnitude(target)
    fun Vector.magn(): Numeral = oVectorMagnitude(this)
    private val oVectorMagnitude = Piece1.Factory(
        "Operator: Vector Magnitude", ResultType.NUMBER,
        Param("Target", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun operatorVectorConstruct(x: Numeral? = null, y: Numeral? = null, z: Numeral? = null): Vector =
        oVectorConstruct(x, y, z)
    private val oVectorConstruct = Piece3.Factory(
        "Operator: Vector Construct", ResultType.VECTOR,
        Param("X", ResultType.NUMBER, ParamCol.RED),
        Param("Y", ResultType.NUMBER, ParamCol.GREEN),
        Param("Z", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun operatorVectorExtractX(target: Vector): Numeral = oVectorExtractX(target)
    fun Vector.x(): Numeral = oVectorExtractX(this)
    private val oVectorExtractX = Piece1.Factory(
        "Operator: Vector Extract X", ResultType.NUMBER,
        Param("Target", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun operatorVectorExtractY(target: Vector): Numeral = oVectorExtractY(target)
    fun Vector.y(): Numeral = oVectorExtractY(this)
    private val oVectorExtractY = Piece1.Factory(
        "Operator: Vector Extract Y", ResultType.NUMBER,
        Param("Target", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun operatorVectorExtractZ(target: Vector): Numeral = oVectorExtractZ(target)
    fun Vector.z(): Numeral = oVectorExtractX(this)
    private val oVectorExtractZ = Piece1.Factory(
        "Operator: Vector Extract Z", ResultType.NUMBER,
        Param("Target", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun operatorVectorRaycastAxis(position: Vector, ray: Vector, max: Numeral? = null): Vector =
        oVectorRaycastAxis(position, ray, max)
    private val oVectorRaycastAxis = Piece3.Factory(
        "Operator: Vector Axis Raycast", ResultType.VECTOR,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Ray", ResultType.VECTOR, ParamCol.GREEN),
        Param("Max", ResultType.NUMBER, ParamCol.PURPLE)
    )

    fun operatorVectorProject(vectorA: Vector, vectorB: Vector): Vector = oVectorProject(vectorA, vectorB)
    fun Vector.proj(onto: Vector): Vector = oVectorProject(this, onto)
    private val oVectorProject = Piece2.Factory(
        "Operator: Vector Project", ResultType.VECTOR,
        Param("Vector A", ResultType.VECTOR, ParamCol.RED),
        Param("Vector B", ResultType.VECTOR, ParamCol.GREEN)
    )

    fun operatorVectorDotProduct(vectorA: Vector, vectorB: Vector): Numeral = oVectorDotProduct(vectorA, vectorB)
    infix fun Vector.dot(other: Vector): Numeral = oVectorDotProduct(this, other)
    private val oVectorDotProduct = Piece2.Factory(
        "Operator: Vector Dot Product", ResultType.NUMBER,
        Param("Vector A", ResultType.VECTOR, ParamCol.RED),
        Param("Vector B", ResultType.VECTOR, ParamCol.GREEN)
    )

    fun constantNumber(value: Number): Numeral {
        return Numeral(Piece("Consant: $value"))
    }

    fun constantPi(): Numeral = cPi()
    private val cPi = Piece.Factory(
        "Constant: Pi", ResultType.NUMBER
    )

    fun constantE(): Numeral = cE()
    private val cE = Piece.Factory(
        "Constant: e", ResultType.NUMBER
    )

    fun constantWrapper(target: Numeral, constant: Numeral): Numeral = cWrapper(target, constant)
    fun Numeral.const(upperBound: Numeral): Numeral = cWrapper(this, upperBound)
    private val cWrapper = Piece2.Factory(
        "Constant: Wrapper", ResultType.NUMBER,
        Param("Target", ResultType.NUMBER, ParamCol.RED),
        Param("Constant", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun trickDebug(target: Wildcard, number: Numeral? = null): None = tDebug(target, number)
    fun Wildcard.debug(number: Numeral? = null): None = tDebug(this, number)
    private val tDebug = Piece2.Trick(
        "Trick: Debug", this,
        Param("Target", ResultType.ANY, ParamCol.BLUE),
        Param("Number", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickDelay(time: Numeral): None = tDelay(time)
    private val tDelay = Piece1.Trick(
        "Trick: Sleep", this,
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickDie(target: Numeral): None = tDie(target)
    private val tDie = Piece1.Trick(
        "Trick: Die", this,
        Param("Target", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickEvaluate(target: Wildcard): None = tEvaluate(target)
    fun Wildcard.eval(): None = tEvaluate(this)
    private val tEvaluate = Piece1.Trick(
        "Trick: Evaluate", this,
        Param("Target", ResultType.ANY, ParamCol.BLUE)
    )

    fun trickAddMotion(target: Entity, direction: Vector, speed: Numeral): None = tAddMotion(target, direction, speed)
    fun Entity.addMotion(direction: Vector, speed: Numeral): None = tAddMotion(this, direction, speed)
    private val tAddMotion = Piece3.Trick(
        "Trick: Add Motion", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Direction", ResultType.VECTOR, ParamCol.GREEN),
        Param("Speed", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickExplode(position: Vector, power: Numeral): None = tExplode(position, power)
    private val tExplode = Piece2.Trick(
        "Trick: Explode", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Power", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickBreakBlock(position: Vector): None = tBreakBlock(position)
    private val tBreakBlock = Piece1.Trick(
        "Trick: Break Block", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickBreakInSequence(position: Vector, target: Vector, max: Numeral): None =
        tBreakInSequence(position, target, max)

    private val tBreakInSequence = Piece3.Trick(
        "Trick: Break Block Sequence", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Target", ResultType.VECTOR, ParamCol.GREEN),
        Param("Max", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickPlaceBlock(position: Vector): None = tPlaceBlock(position)
    private val tPlaceBlock = Piece1.Trick(
        "Trick: Place Block", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickPlaceInSequence(position: Vector, target: Vector, max: Numeral): None =
        tPlaceInSequence(position, target, max)
    private val tPlaceInSequence = Piece3.Trick(
        "Trick: Place Block Sequence", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Target", ResultType.VECTOR, ParamCol.GREEN),
        Param("Max", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickInfusion(): None = tInfusion()
    private val tInfusion = Piece.Trick(
        "Trick: Infusion", this
    )

    fun trickBlink(target: Entity, distance: Numeral): None = tBlink(target, distance)
    fun Entity.blink(distance: Numeral): None = tBlink(this, distance)
    private val tBlink = Piece2.Trick(
        "Trick: Blink", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Distance", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickMassBlink(target: EntityList, distance: Numeral): None = tMassBlink(target, distance)
    fun EntityList.blink(distance: Numeral): None = tMassBlink(this, distance)
    private val tMassBlink = Piece2.Trick(
        "Trick: Mass Blink", this,
        Param("Target", ResultType.LIST, ParamCol.YELLOW),
        Param("Distance", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickMassAddMotion(target: EntityList, direction: Vector, speed: Numeral): None =
        tMassAddMotion(target, direction, speed)
    fun EntityList.addMotion(direction: Vector, speed: Numeral): None = tMassAddMotion(this, direction, speed)
    private val tMassAddMotion = Piece3.Trick(
        "Trick: Mass Add Motion", this,
        Param("Target", ResultType.LIST, ParamCol.YELLOW),
        Param("Direction", ResultType.VECTOR, ParamCol.GREEN),
        Param("Speed", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickMassExodus(target: EntityList, position: Vector, speed: Numeral): None =
        tMassExodus(target, position, speed)
    fun EntityList.exodus(position: Vector, speed: Numeral): None = tMassExodus(this, position, speed)
    private val tMassExodus = Piece3.Trick(
        "Trick: Mass Exodus", this,
        Param("Target", ResultType.LIST, ParamCol.YELLOW),
        Param("Position", ResultType.VECTOR, ParamCol.GREEN),
        Param("Speed", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickMoveBlock(position: Vector, target: Vector): None = tMoveBlock(position, target)
    private val tMoveBlock = Piece2.Trick(
        "Trick: Move Block", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Target", ResultType.VECTOR, ParamCol.GREEN)
    )

    fun trickCollapseBlock(position: Vector): None = tCollapseBlock(position)
    private val tCollapseBlock = Piece1.Trick(
        "Trick: Collapse Block", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickSmite(position: Vector): None = tSmite(position)
    private val tSmite = Piece1.Trick(
        "Trick: Smite", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickBlaze(position: Vector): None = tBlaze(position)
    private val tBlaze = Piece1.Trick(
        "Trick: Blaze", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickTorrent(position: Vector): None = tTorrent(position)
    private val tTorrent = Piece1.Trick(
        "Trick: Torrent", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickOvergrow(position: Vector): None = tOvergrow(position)
    private val tOvergrow = Piece1.Trick(
        "Trick: Overgrow", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickGreaterInfusion(): None = tGreaterInfusion()
    private val tGreaterInfusion = Piece.Trick(
        "Trick: Greater Infusion", this
    )

    fun trickEbonyIvory(): None = tEbonyIvory()
    private val tEbonyIvory = Piece.Trick(
        "Trick: Ebony And Ivory", this
    )

    fun trickSpeed(target: Entity, power: Numeral, time: Numeral): None = tSpeed(target, power, time)
    fun Entity.applySpeed(power: Numeral, time: Numeral): None = tSpeed(this, power, time)
    private val tSpeed = Piece3.Trick(
        "Trick: Speed", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickHaste(target: Entity, power: Numeral, time: Numeral): None = tHaste(target, power, time)
    fun Entity.applyHaste(power: Numeral, time: Numeral): None = tHaste(this, power, time)
    private val tHaste = Piece3.Trick(
        "Trick: Haste", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickStrength(target: Entity, power: Numeral, time: Numeral): None = tStrength(target, power, time)
    fun Entity.applyStrength(power: Numeral, time: Numeral): None = tStrength(this, power, time)
    private val tStrength = Piece3.Trick(
        "Trick: Strength", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickJumpBoost(target: Entity, power: Numeral, time: Numeral): None = tJumpBoost(target, power, time)
    fun Entity.applyJumpBoost(power: Numeral, time: Numeral): None = tJumpBoost(this, power, time)
    private val tJumpBoost = Piece3.Trick(
        "Trick: Jump Boost", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickWaterBreathing(target: Entity, time: Numeral): None = tWaterBreathing(target, time)
    fun Entity.applyWaterBreathing(time: Numeral): None = tWaterBreathing(this, time)
    private val tWaterBreathing = Piece2.Trick(
        "Trick: Water Breathing", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickFireResistance(target: Entity, time: Numeral): None = tFireResistance(target, time)
    fun Entity.applyFireResist(time: Numeral): None = tFireResistance(this, time)
    private val tFireResistance = Piece2.Trick(
        "Trick: Fire Resistance", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickInvisibility(target: Entity, time: Numeral): None = tInvisibility(target, time)
    fun Entity.applyInvis(time: Numeral): None = tInvisibility(this, time)
    private val tInvisibility = Piece2.Trick(
        "Trick: Invisibility", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickRegeneration(target: Entity, power: Numeral, time: Numeral): None = tRegeneration(target, power, time)
    fun Entity.applyRegen(power: Numeral, time: Numeral): None = tRegeneration(this, power, time)
    private val tRegeneration = Piece3.Trick(
        "Trick: Regeneration", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickResistance(target: Entity, power: Numeral, time: Numeral): None = tResistance(target, power, time)
    fun Entity.applyResistance(power: Numeral, time: Numeral): None = tResistance(this, power, time)
    private val tResistance = Piece3.Trick(
        "Trick: Resistance", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickSlowness(target: Entity, power: Numeral, time: Numeral): None = tSlowness(target, power, time)
    fun Entity.applySlow(power: Numeral, time: Numeral): None = tSlowness(this, power, time)
    private val tSlowness = Piece3.Trick(
        "Trick: Slowness", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickWeakness(target: Entity, power: Numeral, time: Numeral): None = tWeakness(target, power, time)
    fun Entity.applyWeakness(power: Numeral, time: Numeral): None = tWeakness(this, power, time)
    private val tWeakness = Piece3.Trick(
        "Trick: Weakness", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickWither(target: Entity, power: Numeral, time: Numeral): None = tWither(target, power, time)
    fun Entity.applyWither(power: Numeral, time: Numeral): None = tWither(this, power, time)
    private val tWither = Piece3.Trick(
        "Trick: Wither", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Power", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.BLUE)
    )

    fun trickIgnite(target: Entity, time: Numeral): None = tIgnite(target, time)
    fun Entity.ignite(time: Numeral): None = tIgnite(this, time)
    private val tIgnite = Piece2.Trick(
        "Trick: Ignite", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW),
        Param("Time", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickEidosAnchor(time: Numeral): None = tEidosAnchor(time)
    private val tEidosAnchor = Piece1.Trick(
        "Trick: Eidos Anchor", this,
        Param("Time", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickEidosReversal(time: Numeral): None = tEidosReversal(time)
    private val tEidosReversal = Piece1.Trick(
        "Trick: Eidos Reversal", this,
        Param("Time", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickSmeltBlock(position: Vector): None = tSmeltBlock(position)
    private val tSmeltBlock = Piece1.Trick(
        "Trick: Smelt Block", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE)
    )

    fun trickSmeltItem(target: Entity): None = tSmeltItem(target)
    fun Entity.smelt(): None = tSmeltItem(this)
    private val tSmeltItem = Piece1.Trick(
        "Trick: Smelt Item", this,
        Param("Target", ResultType.ENTITY, ParamCol.YELLOW)
    )

    fun trickConjureBlock(position: Vector, time: Numeral? = null): None = tConjureBlock(position, time)
    private val tConjureBlock = Piece2.Trick(
        "Trick: Conjure Block", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Time", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickConjureLight(position: Vector, time: Numeral? = null): None = tConjureLight(position, time)
    private val tConjureLight = Piece2.Trick(
        "Trick: Conjure Light", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Time", ResultType.NUMBER, ParamCol.RED)
    )

    fun trickConjureBlockSequence(position: Vector, target: Vector, max: Numeral, time: Numeral? = null): None =
        tConjureBlockSequence(position, target, max, time)
    private val tConjureBlockSequence = Piece4.Trick(
        "Trick: Conjure Block Sequence", this,
        Param("Position", ResultType.VECTOR, ParamCol.BLUE),
        Param("Target", ResultType.VECTOR, ParamCol.GREEN),
        Param("Max", ResultType.NUMBER, ParamCol.RED),
        Param("Time", ResultType.NUMBER, ParamCol.PURPLE)
    )

    fun trickSwitchTargetSlot(position: Numeral? = null, shift: Numeral? = null): None =
        tSwitchTargetSlot(position, shift)
    private val tSwitchTargetSlot = Piece2.Trick(
        "Trick: Switch Focus Slot", this,
        Param("Position", ResultType.NUMBER, ParamCol.BLUE),
        Param("Shift", ResultType.NUMBER, ParamCol.GREEN)
    )

    fun trickSaveVector(number: Numeral, target: Vector): None = tSaveVector(number, target)
    private val tSaveVector = Piece2.Trick(
        "Trick: Save Vector", this,
        Param("Number", ResultType.NUMBER, ParamCol.BLUE),
        Param("Target", ResultType.VECTOR, ParamCol.RED)
    )

}
