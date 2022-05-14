package camp.nextstep.edu.racingcar

import camp.nextstep.edu.racingcar.interfaces.CommandLineInterface
import camp.nextstep.edu.racingcar.racing.Car
import camp.nextstep.edu.racingcar.racing.Racing

fun main() {
    val cli = CommandLineInterface()

    val carNames = cli.readCarNames()
    val moveCount = cli.readMoveCount()

    val participants = carNames.mapIndexed { i, name -> Car(i, name) }
    val racing = Racing.new(participants, moveCount)

    racing.start()
    val carTracks = racing.result()

    for (i in 0 until moveCount) {
        for ((car, track) in carTracks) {
            cli.draw(car, track, i)
        }
        cli.drawBlank()
    }

    cli.drawWinner(racing.winners().toList())
}
