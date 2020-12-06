package day6

data class GroupAnswersLevel1(
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

data class SingleGroupAnswers(
    val personAnswers: MutableList<PersonAnswers>
) {
    var questionsAnsweredByAll: Set<String> = setOf()

    fun findAllPersonsAnswered(personAnswers: MutableList<PersonAnswers>) {
        val numberOfPeople = personAnswers.size
        val answers: List<PersonAnswer> = personAnswers.flatMap { it.answer }
        val associated = answers.groupingBy {  it.answer }.eachCount()
        questionsAnsweredByAll = associated.filter { it.value == numberOfPeople }.keys
    }
}

data class PersonAnswers(
    val answer: List<PersonAnswer>
)

data class PersonAnswer(
    val answer: String
) {
    init {
        require(answer.length == 1)
    }
}