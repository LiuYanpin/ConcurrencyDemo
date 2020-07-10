import java.util.concurrent.locks.StampedLock;

public class Point {
    private double x, y;
    private final StampedLock stampedLock = new StampedLock();

    void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
    double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
