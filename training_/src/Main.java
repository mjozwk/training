import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        InMemoryCache<String, String> cache = new InMemoryCache<>(1, TimeUnit.HOURS, 100);
        cache.put("hello", "world");
        String value = cache.get("hello"); // Returns "world"
    }
}