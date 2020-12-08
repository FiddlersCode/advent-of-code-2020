package day7

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleLevelOneTest {
    private lateinit var puzzleLevelOne: PuzzleLevelOne

    @BeforeTest
    fun setUp() {
        puzzleLevelOne = PuzzleLevelOne()
    }

    @Test
    fun getOuterBagsForBagTest1() {
        val rule = listOf(
            Rule(
                outerBag = Bag(modifier = "dark", color = "olive"),
                innerBags = listOf(
                    Bag(modifier = "shiny", color = "gold"),
                    Bag(modifier = "vibrant", color = "plum")
                )
            ),
            Rule(
                outerBag = Bag(modifier = "faded", color = "blue"),
                innerBags = listOf(
                    Bag(modifier = "shiny", color = "gold"),
                    Bag(modifier = "vibrant", color = "plum")
                )
            )
        )

        val bag = Bag(
            modifier = "shiny",
            color = "gold"
        )
        val actual = puzzleLevelOne.getOuterBagsForBag(rule, bag)
        val expected = listOf(
            Bag(modifier = "dark", color = "olive"),
            Bag(modifier = "faded", color = "blue")
        )
        assertEquals(expected, actual)
    }

    @Test
    fun getAllOuterBagsForBagTest1() {
        val rule = listOf(
            Rule(
                outerBag = Bag(modifier = "bright", color = "white"),
                innerBags = listOf(
                    Bag(modifier = "dark", color = "olive"),
                    Bag(modifier = "vibrant", color = "plum")
                )
            ),
            Rule(
                outerBag = Bag(modifier = "dark", color = "olive"),
                innerBags = listOf(
                    Bag(modifier = "shiny", color = "gold"),
                    Bag(modifier = "vibrant", color = "plum")
                )
            ),
            Rule(
                outerBag = Bag(modifier = "faded", color = "blue"),
                innerBags = listOf(
                    Bag(modifier = "shiny", color = "gold"),
                    Bag(modifier = "vibrant", color = "plum")
                )
            )
        )

        val bag = Bag(modifier = "shiny", color = "gold")

        val actual = puzzleLevelOne.getAllOuterBagsForBag(rule, bag)
        val expected = listOf(
            Bag(modifier = "bright", color = "white"),
            Bag(modifier = "dark", color = "olive"),
            Bag(modifier = "faded", color = "blue")
        ).sortedBy { it.modifier }
        assertEquals(expected, actual)
    }

    @Test
    fun solveLevel1WithSmallInputTest() {
        val input = "day7/inputSmaller.log"
        val bag = Bag("muted", "yellow")
        val actual = puzzleLevelOne.solve(input, bag, 1)
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun solveTest() {
        val input = "day7/input.log"
        val bag = Bag("shiny", "gold")
        val actual = puzzleLevelOne.solve(input, bag,1)
        val expected = 205
        assertEquals(expected, actual)
    }
//
//    @Test
//    fun solveLevel2Test() {
//        val input = "day6/input.log"
//        val actual = puzzleLevelOne.solve(input, 2)
//        val expected = 3445
//        assertEquals(expected, actual)
//    }
}
