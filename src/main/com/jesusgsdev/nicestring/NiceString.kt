package jesusgsdev.nicestring

fun String.isNice(): Boolean {
    val vowels = listOf('a','e','i','o','u')

    val doesNotContainsBuBaBe = !this.contains("bu")
            && !this.contains("ba")
            && !this.contains("be")

    val containsAtLeastThreeVowels = this.filter { it -> vowels.contains(it) }.count() >= 3

    var containsADoubleLetterFollowingEachOther = false
    this.forEachIndexed { index, element ->
        if(index != 0){
            if(this.get(index - 1) == element) {
                containsADoubleLetterFollowingEachOther = true
            }
        }
    }

    return listOf(doesNotContainsBuBaBe, containsAtLeastThreeVowels, containsADoubleLetterFollowingEachOther)
            .filter { it }
            .count() >= 2
}