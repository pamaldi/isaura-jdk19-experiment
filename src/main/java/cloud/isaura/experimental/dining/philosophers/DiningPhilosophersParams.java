package cloud.isaura.experimental.dining.philosophers;

public record DiningPhilosophersParams

        (
            PhilosopherType philosopherType,
            Integer numberOfPhilosophers,
            Long thinkingTime,
            Long eatTime

        )
{
}
