package day6

data class GroupAnswers(
    val unsanitisedAnswers: String
) {
    val answers: String
    val numberOfAnswers: Int
    private val maxNumberOfUniqueAnswers = 26

    init {
        this.answers = removeDuplicateAnswers(unsanitisedAnswers)
        this.numberOfAnswers = this.answers.length
        require(this.numberOfAnswers <= maxNumberOfUniqueAnswers)
    }

    private fun removeDuplicateAnswers(answers: String): String {
        return answers.toList().distinct().joinToString("")
    }
}
