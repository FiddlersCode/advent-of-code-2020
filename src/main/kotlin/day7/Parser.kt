package day7

class Parser {
    fun parseLogLines(logLines: List<String>): List<Rule> {
        return logLines.map { parseLogLine(it) }
    }

    fun parseLogLine(logLine: String): Rule {
        val outerBagProperties = extractOuterBagProperties(logLine)
        val outerBag = extractOuterBag(outerBagProperties)

        val innerBagsPropertes: List<String> = extractInnerBagsProperties(logLine)
        val innerBags: List<Bag> = extractInnerBags(innerBagsPropertes).filterNotNull()
        return Rule(
            outerBag = outerBag,
            innerBags = innerBags
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

    fun extractInnerBags(innerBags: List<String>): List<Bag?> {
        val innerBagList = innerBags.map { it.split(" ") }
        return innerBagList.map {
            if (it.size > 2) {
                Bag(modifier = it[1], color = it[2])
            } else {
                null
            }
        }
    }

    private fun sanitiseInnerBagsProperties(
        innerBags: List<String>,
        regex: Regex = Regex("(bags|bag|\\.|,)")
    ): List<String> {
        return innerBags.map { regex.replace(it, "").trim() }
    }
}
