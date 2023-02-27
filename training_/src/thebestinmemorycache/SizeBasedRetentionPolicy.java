package thebestinmemorycache;

import java.util.Iterator;
import java.util.Map;

class SizeBasedRetentionPolicy implements RetentionPolicy {
    private Map<Object, CacheItem> items;
    private int maxSize;

    public SizeBasedRetentionPolicy(Map<Object, CacheItem> items, int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean shouldRemove(CacheItem item, long currentTime) {
        if (items.size() > maxSize) {
            // Usun pierwszy dodany element
            Iterator<Map.Entry<Object, CacheItem>> iterator = items.entrySet().iterator();
            iterator.next();
            iterator.remove();
            return true;
        }
        return false;
    }
}

