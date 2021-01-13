//package cachepak.configs;
//
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//
//import static java.util.Arrays.asList;
//
//public class SimpleCache  implements CacheManagerCustomizer<ConcurrentMapCacheManager>  {
//
//    @Override
//    public void customize(ConcurrentMapCacheManager cacheManager) {
//        cacheManager.setCacheNames(asList("user", "summ"));
//    }
//}
