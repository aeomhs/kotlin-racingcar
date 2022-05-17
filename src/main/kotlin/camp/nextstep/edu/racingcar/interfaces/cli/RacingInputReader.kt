package camp.nextstep.edu.racingcar.interfaces.cli

import camp.nextstep.edu.racingcar.interfaces.RacingInputs

object RacingInputReader {

    fun readRacingInputs(): RacingInputs {
        return RacingInputs(readCarNames(), readMoveCount())
    }

    private fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return requireNotNull(readLine()?.split(","))
    }

    private fun readMoveCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return requireNotNull(readLine()?.toInt())
    }
}
