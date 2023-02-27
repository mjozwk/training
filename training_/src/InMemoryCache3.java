import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryCache3<K, V> {
    private final ConcurrentHashMap<K, V> cache;
    private final ScheduledExecutorService expirationExecutor;
    private final long expirationTimeMillis;
    private final int maxCacheSize;

    public InMemoryCache3(long expirationTimeMillis, int maxCacheSize) {
        this.cache = new ConcurrentHashMap<>();
        this.expirationExecutor = Executors.newScheduledThreadPool(1);
        this.expirationTimeMillis = expirationTimeMillis;
        this.maxCacheSize = maxCacheSize;
    }

    public void put(K key, V value) {
        if (cache.size() == maxCacheSize) {
            // Remove the first inserted item if the cache is at max capacity
            cache.entrySet().iterator().remove();
        }
        cache.put(key, value);

        // Schedule the item for removal if an expiration time was specified
        if (expirationTimeMillis > 0) {
            expirationExecutor.schedule(() -> cache.remove(key), expirationTimeMillis, TimeUnit.MILLISECONDS);
        }
    }

    public V get(K key) {
        return cache.get(key);
    }
}




