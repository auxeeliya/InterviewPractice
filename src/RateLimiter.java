import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RateLimiter {
    private final Map<String, Long> requestTimestamps = new ConcurrentHashMap<>();
    private final int maxRequests;
    private final long windowDurationMillis;

    public RateLimiter(int maxRequests, long windowDuration, TimeUnit timeUnit) {
        this.maxRequests = maxRequests;
        this.windowDurationMillis = timeUnit.toMillis(windowDuration);
    }

    public synchronized boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        long windowStart = currentTime - windowDurationMillis;

        // Remove expired timestamps
        requestTimestamps.entrySet().removeIf(entry -> entry.getValue() < windowStart);

        // Check if number of requests exceeds the limit
        System.out.println("requestTimestamps.size() " + requestTimestamps.size());
        if (requestTimestamps.size() >= maxRequests) {
        	
            return false;
        }

        // Record the current request timestamp
        System.out.println("clientId, currentTime " + clientId+" -" +currentTime);
        requestTimestamps.put(clientId, currentTime);
        return true;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(1, 1, TimeUnit.SECONDS);

        // Test the rate limiter with multiple requests from the same client
        String clientId = "client1";
        for (int i = 0; i < 5; i++) {
            boolean allowed = rateLimiter.allowRequest(clientId);
            System.out.println("Request from " + clientId + " allowed: " + allowed);
            try {
                Thread.sleep(900); // Simulate time between requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
