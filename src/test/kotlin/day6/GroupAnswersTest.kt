package day6

import org.junit.Test
import kotlin.test.assertEquals

class GroupAnswersTest {
    @Test
    fun createGroup1() {
        val input = "abc"

        val groupAnswers = GroupAnswers(input)
        val actual = groupAnswers.answers

        val expected = "abc"
        assertEquals(expected, actual)
        assertEquals(3, groupAnswers.numberOfAnswers)
    }

    @Test
    fun createGroup2() {
        val input = "abccccccccc"

        val groupAnswers = GroupAnswers(input)
        val actual = groupAnswers.answers

        val expected = "abc"
        assertEquals(expected, actual)
        assertEquals(3, groupAnswers.numberOfAnswers)
    }
}