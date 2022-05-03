package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonKoTest: StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("엄현식", 10, nickname = "tim.aeom"),



            Person(
                name = "엄현식", age = 10, nickname = "tim.aeom")



        )
        people.forAll {
            it.name shouldBe "엄현식"
            it.age shouldBe 10
            it.nickname shouldBe "tim.aeom"
        }
    }

    "널 타입" {
        val person = Person("엄현식", 10, null)
        person.nickname shouldBe null
    }
})