package day7


data class Rule(
    val outerBag: Bag,
    val innerBags: List<Bag>
)

data class Bag(
    val modifier: String,
    val color: String
)

data class InnerBagData(
    val bag: Bag,
    val number: Int
)
