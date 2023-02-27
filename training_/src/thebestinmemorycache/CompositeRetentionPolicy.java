package thebestinmemorycache;

interface CompositeRetentionPolicy extends RetentionPolicy {
    void addRetentionPolicy(RetentionPolicy policy);
}
