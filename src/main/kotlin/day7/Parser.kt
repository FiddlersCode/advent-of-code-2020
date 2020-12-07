package day7

class Parser {
    fun parseLogLine(logLine: String): Rule {
        val outerBagProperties = extractOuterBagProperties(logLine)
        val outerBag = extractOuterBag(outerBagProperties)

        val innerBagsPropertes: List<String> = extractInnerBagsProperties(logLine)
        val innerBagData: List<InnerBagData> = extractInnerBags(innerBagsPropertes)
        return Rule(
            outerBag = outerBag,
            innerBags = innerBagData
        )
    }

    fun extractOuterBagProperties(logLine: String, delimiter: String = " bags"): String {
        return logLine.substringBefore(delimiter)
    }

    fun extractInnerBagsProperties(input: String, delimiter: String = "contain "): List<String> {
        val innerBags = input.substringAfter(delimiter, ".").split(",")
        return sanitiseInnerBagsProperties(innerBags)
    }

    fun extractOuterBag(outerBag: String): Bag {
        return Bag(
            modifier = outerBag.substringBefore(" "),
            color = outerBag.substringAfter(" ")
        )
    }

    fun extractInnerBags(innerBags: List<String>): List<InnerBagData> {
        val innerBagList = innerBags.map { it.split(" ") }
        return innerBagList.map {
            InnerBagData(
                bag = Bag(
                    modifier = it[1],
                    color = it[2]
                ),
                number = it[0].toInt()
            )
        }
    }

    private fun sanitiseInnerBagsProperties(
        innerBags: List<String>,
        regex: Regex = Regex("(bags|bag|\\.|,)")
    ): List<String> {
        return innerBags.map { regex.replace(it, "").trim() }
    }
}
