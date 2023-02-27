package thebestinmemorycache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {
    private Map<Object, CacheItem> items;
    private RetentionPolicy retentionPolicy;

    public Cache(RetentionPolicy retentionPolicy) {
        this.items = new LinkedHashMap<>();
        this.retentionPolicy = retentionPolicy;
    }

    public void put(Object key, Object value) {
        long currentTime = System.currentTimeMillis();
        CacheItem item = new CacheItem(value, currentTime);
        items.put(key, item);
    }

    public Object get(Object key) {
        CacheItem item = items.get(key);
        if (item == null) {
            return null;
        }
        long currentTime = System.currentTimeMillis();
        if (retentionPolicy.shouldRemove(item, currentTime)) {
            items.remove(key);
            return null;
        }
        return item.getValue();
    }
}