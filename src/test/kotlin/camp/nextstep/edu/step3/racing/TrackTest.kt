package camp.nextstep.edu.step3.racing

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class TrackTest {

    @DisplayName("자동차가 달린 흔적을 남길 수 있다.")
    @Test
    fun markCarTrace() {
        val track = Track(3)
        val beforeTraces = track.traces()
        assertFalse(beforeTraces.next())
        assertFalse(beforeTraces.next())
        assertFalse(beforeTraces.next())

        track.markTrace()
        track.markTrace()

        val afterTraces = track.traces()
        assertTrue(afterTraces.next())
        assertTrue(afterTraces.next())
        assertFalse(afterTraces.next())
    }

    @DisplayName("트랙 길이를 넘어서 흔적을 남길 수 없다.")
    @Test
    fun cannotMarkCarTraceOverTrack() {
        val track = Track(3)

        track.markTrace()
        track.markTrace()
        track.markTrace()

        assertThrows<IllegalStateException> {
            track.markTrace()
        }
    }
}
