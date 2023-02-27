package thebestinmemorycache;

class TimeBasedRetentionPolicy implements RetentionPolicy {
    private long retentionPeriod;

    public TimeBasedRetentionPolicy(long retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
    }

    @Override
    public boolean shouldRemove(CacheItem item, long currentTime) {
        long elapsedTime = currentTime - item.getInsertionTime();
        return elapsedTime > retentionPeriod;
    }
}
