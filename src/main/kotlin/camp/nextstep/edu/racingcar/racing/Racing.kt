package camp.nextstep.edu.racingcar.racing

class Racing private constructor(participants: List<Car>, private val moveCount: Int) {

    private var ended = false
    private var winners = setOf<Winner>()
    private val carEvents = linkedMapOf(*participants.map { car -> car to mutableListOf<CarRaceEvent>() }.toTypedArray())

    fun start() {
        repeat(moveCount) {
            for ((car, events) in carEvents) {
                events.add(car.race())
            }
        }

        ended = true
        winners = Winner.of(this)
    }

    fun carRacingEvents(): Map<Car, List<CarRaceEvent>> {
        check(ended) { "racing is not ended" }

        return carEvents
    }

    fun winners(): Set<Winner> {
        check(ended) { "racing is not ended" }

        return winners
    }

    companion object {
        fun new(participants: List<Car>, moveCount: Int): Racing {
            require(participants.isNotEmpty())
            require(moveCount > 0) { "최소 1회 이상 움직일 수 있어야 합니다." }
            return Racing(participants, moveCount)
        }
    }
}
