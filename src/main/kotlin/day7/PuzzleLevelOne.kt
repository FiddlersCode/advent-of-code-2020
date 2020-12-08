package day7

import java.io.File

class PuzzleLevelOne(private val parser: Parser = Parser()) {

    fun solve(inputFileName: String, bag: Bag,  level: Int): Int {
        val lines = readFileLines(inputFileName)
        val parsedLogLines: List<Rule> = parser.parseLogLines(lines)
        val allOuterBags = getAllOuterBagsForBag(parsedLogLines, bag)
        return allOuterBags.size
    }

    fun getOuterBagsForBag(rules: List<Rule>, bag: Bag): List<Bag> {
        return rules.filter { rule: Rule -> rule.innerBags.contains(bag) }.map { it.outerBag }
    }

    fun getAllOuterBagsForBag(rules: List<Rule>, bag: Bag): List<Bag> {
      val allBags = getOuterBagsForBag(rules, bag).toMutableList()
        for (i in 0..1000) {
            val currentOuterBags = allBags.map { getOuterBagsForBag(rules, it) }.flatten()
            currentOuterBags.forEach {
                if (!allBags.contains(it)) { allBags.add(it) }
            }
        }
        return allBags.distinct().sortedBy { it.modifier }
    }

    private fun readInputFile(filePath: String): List<String> = File(filePath).readLines()

    private fun readFileLines(inputFileName: String): List<String> {
        val file = ClassLoader.getSystemClassLoader().getResource(inputFileName).file
        return readInputFile(file)
    }
}
