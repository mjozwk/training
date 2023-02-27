package thebestinmemorycache;

class CacheItem {
    private Object value;
    private long insertionTime;

    public CacheItem(Object value, long insertionTime) {
        this.value = value;
        this.insertionTime = insertionTime;
    }

    public Object getValue() {
        return value;
    }

    public long getInsertionTime() {
        return insertionTime;
    }
}