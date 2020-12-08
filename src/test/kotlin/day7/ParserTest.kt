package day7

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ParserTest {
    private lateinit var parser: Parser

    @BeforeTest
    fun setUp() {
        parser = Parser()
    }

    @Test
    fun extractOuterBagTest1() {
        val input = "dotted black"
        val actual = parser.extractOuterBag(input)
        val expected = Bag(
            modifier = "dotted",
            color = "black"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun extractOuterBagTest2() {
        val input = "light red"
        val actual = parser.extractOuterBag(input)
        val expected = Bag(
            modifier = "light",
            color = "red"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun extractOuterBagPropertiesTest1() {
        val input = "dotted black bags contain no other bags."
        val actual = parser.extractOuterBagProperties(input)
        val expected = "dotted black"
        assertEquals(expected, actual)
    }

    @Test
    fun extractOuterBagPropertiesTest2() {
        val input = "light red bags contain 1 bright white bag, 2 muted yellow bags."
        val actual = parser.extractOuterBagProperties(input)
        val expected = "light red"
        assertEquals(expected, actual)
    }

    @Test
    fun extractInnerBagsPropertiesTest1() {
        val input = "light red bags contain 1 bright white bag, 2 muted yellow bags."
        val actual = parser.extractInnerBagsProperties(input)
        val expected = listOf("1 bright white", "2 muted yellow")
        assertEquals(expected, actual)
    }

    @Test
    fun extractInnerBagsPropertiesTest2() {
        val input = "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags."
        val actual = parser.extractInnerBagsProperties(input)
        val expected = listOf("2 shiny gold", "9 faded blue")
        assertEquals(expected, actual)
    }

    @Test
    fun extractInnerBagsTes1() {
        val input = listOf("2 shiny gold", "9 faded blue")
        val actual = parser.extractInnerBags(input)
        val expected = listOf(
            Bag(
                modifier = "shiny",
                color = "gold"
            ),
            Bag(
                modifier = "faded",
                color = "blue"
            )
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLineTest1() {
        val input = "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags."

        val actual = parser.parseLogLine(input)
        val expected = Rule(
            outerBag = Bag(
                modifier = "muted",
                color = "yellow"
            ),
            innerBags = listOf(
                Bag(
                    modifier = "shiny",
                    color = "gold"
                ),
                Bag(
                    modifier = "faded",
                    color = "blue"

                )
            )
        )
        assertEquals(expected, actual)
    }

    @Test
    fun parseLogLinesTest1() {
        val input = listOf(
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
            "bright white bags contain 1 shiny gold bag.",
            "faded blue bags contain no other bags."
        )

        val actual = parser.parseLogLines(input)
        val expected = listOf(
            Rule(
                outerBag = Bag(modifier = "shiny", color = "gold"),
                innerBags = listOf(Bag(modifier = "dark", color = "olive"), Bag(modifier = "vibrant", color = "plum")
                )
            ),
            Rule(
                outerBag = Bag(modifier = "dark", color = "olive"),
                innerBags = listOf(Bag(modifier = "faded", color = "blue"), Bag(modifier = "dotted", color = "black")
                )
            ),
            Rule(
                outerBag = Bag(modifier = "bright", color = "white"),
                innerBags = listOf(Bag(modifier = "shiny", color = "gold")
                )
            ),
            Rule(
                outerBag = Bag(modifier = "faded", color = "blue"),
                innerBags = listOf()
            )
        )

        assertEquals(expected, actual)
    }
}
