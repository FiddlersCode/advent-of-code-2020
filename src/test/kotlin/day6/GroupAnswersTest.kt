package day6

import org.junit.Test
import kotlin.test.assertEquals

class GroupAnswersTest {
    @Test
    fun createGroup1() {
        val input = "abc"

        val groupAnswers = GroupAnswersLevel1(input)
        val actual = groupAnswers.answers

        val expected = "abc"
        assertEquals(expected, actual)
        assertEquals(3, groupAnswers.numberOfAnswers)
    }

    @Test
    fun createGroup2() {
        val input = "abccccccccc"

        val groupAnswers = GroupAnswersLevel1(input)
        val actual = groupAnswers.answers

        val expected = "abc"
        assertEquals(expected, actual)
        assertEquals(3, groupAnswers.numberOfAnswers)
    }
}

class SingleGroupAnswersTest {
    @Test
    fun getAllPersonsAnsweredTest1() {
        val input = mutableListOf(
            PersonAnswers(
                listOf(
                    PersonAnswer("d"),
                    PersonAnswer("e"),
                    PersonAnswer("h")
                )
            ),
            PersonAnswers(
                listOf(
                    PersonAnswer("d"),
                    PersonAnswer("h"),
                    PersonAnswer("f")
                )
            )
        )
        val groupAnswers = SingleGroupAnswers(input)
        val actual = groupAnswers.questionsAnsweredByAll
        val expected = setOf(
            "d",
            "h"
        )
        assertEquals(expected, actual)
    }

    @Test
    fun getAllPersonsAnsweredTest2() {
        val input = mutableListOf(
            PersonAnswers(
                listOf(
                    PersonAnswer("d"),
                    PersonAnswer("e"),
                    PersonAnswer("h")
                )
            ),
            PersonAnswers(
                listOf(
                    PersonAnswer("d"),
                    PersonAnswer("h"),
                    PersonAnswer("f")
                )
            ),
            PersonAnswers(
                listOf(
                    PersonAnswer("x"),
                    PersonAnswer("h"),
                    PersonAnswer("f")
                )
            )
        )
        val groupAnswers = SingleGroupAnswers(input)
        val actual = groupAnswers.questionsAnsweredByAll
        val expected = setOf(
            "h"
        )
        assertEquals(expected, actual)
    }
}