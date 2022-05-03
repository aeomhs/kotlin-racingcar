package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("엄현식", 10, nickname = "tim.aeom"),
            Person(name = "엄현식", age = 10, nickname = "tim.aeom")
        )
        assertThat(people[0].name).isEqualTo("엄현식")
        assertThat(people[1].name).isEqualTo("엄현식")
    }

    @Test
    fun `널 타입`() {
        val person = Person("엄현식", 10, null)
        assertThat(person.nickname).isNull()
    }
}
