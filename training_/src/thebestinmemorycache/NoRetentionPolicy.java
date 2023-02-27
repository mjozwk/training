package thebestinmemorycache;

class NoRetentionPolicy implements RetentionPolicy {
    @Override
    public boolean shouldRemove(CacheItem item, long currentTime) {
        return false;
    }
}
