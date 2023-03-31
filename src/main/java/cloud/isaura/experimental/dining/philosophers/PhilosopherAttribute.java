package cloud.isaura.experimental.dining.philosophers;

public record PhilosopherAttribute(Long eatTime, Long thinkTime, Long cycles, DiningPhilosopherMonitor diningPhilosopherMonitor, Integer index)
{
}
