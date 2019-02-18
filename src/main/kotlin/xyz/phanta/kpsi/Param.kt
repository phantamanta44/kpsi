package xyz.phanta.kpsi

class Param<T : Wildcard>(val name: String, val type: ResultType<T>, val col: ParamCol)

internal class ParamBinding<T : Wildcard>(val binding: T?, val param: Param<T>)

enum class ParamCol(val colour: String) {

    RED("#D22A2A"), GREEN("#3ED22A"), BLUE("#2A55D2"), PURPLE("752AD2"),
    CYAN("2AD0D2"), YELLOW("D2CC2A"), GREY("767676")

}
