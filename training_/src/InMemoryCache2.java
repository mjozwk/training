import java.util.HashMap;
import java.util.Map;

public class InMemoryCache2 {
    private final Map<String, CacheObject> cache;
    private int maxSize;
    private boolean useExpirationPolicy;
    private boolean useSizePolicy;

    public InMemoryCache2(int maxSize, boolean useExpirationPolicy, boolean useSizePolicy) {
        this.cache = new HashMap<>();
        this.maxSize = maxSize;
        this.useExpirationPolicy = useExpirationPolicy;
        this.useSizePolicy = useSizePolicy;
    }

    public void put(String key, Object value, long expirationInMilliseconds) {
        CacheObject cacheObject = new CacheObject(value, expirationInMilliseconds);
        cache.put(key, cacheObject);

        if (useSizePolicy && cache.size() > maxSize) {
            removeFirstInserted();
        }
    }

    public Object get(String key) {
        CacheObject cacheObject = cache.get(key);
        if (cacheObject == null) {
            return null;
        }

        if (useExpirationPolicy && cacheObject.isExpired()) {
            cache.remove(key);
            return null;
        }

        return cacheObject.getValue();
    }

    private void removeFirstInserted() {
        String firstInsertedKey = null;
        long earliestInsertTime = Long.MAX_VALUE;
        for (Map.Entry<String, CacheObject> entry : cache.entrySet()) {
            if (entry.getValue().getInsertTime() < earliestInsertTime) {
                earliestInsertTime = entry.getValue().getInsertTime();
                firstInsertedKey = entry.getKey();
            }
        }
        cache.remove(firstInsertedKey);
    }

    private class CacheObject {
        private Object value;
        private long expirationInMilliseconds;
        private long insertTime;

        public CacheObject(Object value, long expirationInMilliseconds) {
            this.value = value;
            this.expirationInMilliseconds = expirationInMilliseconds;
            this.insertTime = System.currentTimeMillis();
        }

        public Object getValue() {
            return value;
        }

        public long getInsertTime() {
            return insertTime;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - insertTime > expirationInMilliseconds;
        }
    }
}