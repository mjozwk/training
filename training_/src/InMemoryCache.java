import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InMemoryCache<K, V> {
    private final Map<K, V> cache;
    private final long retentionTime;
    private final TimeUnit timeUnit;
    private final int maxSize;

    public InMemoryCache(long retentionTime, TimeUnit timeUnit, int maxSize) {
        this.cache = new HashMap<>();
        this.retentionTime = retentionTime;
        this.timeUnit = timeUnit;
        this.maxSize = maxSize;
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        // Remove the oldest entry if the cache is full
        if (cache.size() >= maxSize) {
            K oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        // Add the new entry
        cache.put(key, value);

        // Schedule the entry to be removed after the retention time has passed
        if (retentionTime > 0) {
            Thread removalThread = new Thread(() -> {
                try {
                    timeUnit.sleep(retentionTime);
                } catch (InterruptedException e) {
                    // Do nothing
                }
                cache.remove(key);
            });
            removalThread.start();
        }
    }
}
