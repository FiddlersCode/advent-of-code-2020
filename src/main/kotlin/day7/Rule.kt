package day7


data class Rule(
    val outerBag: Bag,
    val innerBags: List<InnerBagData>
)

data class Bag(
    val modifier: String,
    val color: String
)

data class InnerBagData(
    val bag: Bag,
    val number: Int
)
