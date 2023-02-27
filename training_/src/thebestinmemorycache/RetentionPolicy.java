package thebestinmemorycache;

interface RetentionPolicy {
    boolean shouldRemove(CacheItem item, long currentTime);
}
