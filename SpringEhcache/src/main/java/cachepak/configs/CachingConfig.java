//package cachepak.configs;
//
//import net.sf.ehcache.config.CacheConfiguration;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableCaching
//public class CachingConfig {
//
//    @Bean
//    public net.sf.ehcache.CacheManager  ehCacheManager() {
//        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
//        config.addCache(cacheConfigDefaultTimeout("summ", 1));
//        return net.sf.ehcache.CacheManager.newInstance(config);
//    }
//
//    private CacheConfiguration cacheConfigDefaultTimeout(String cacheName, Integer maxEntries) {
//        return cacheConfig(cacheName, maxEntries, 1, 1);
//    }
//
//    private CacheConfiguration cacheConfig(String name,
//                                           int maxEntries,
//                                           Integer timeToIdleSeconds,
//                                           Integer timeToLiveSeconds
//    ) {
//        CacheConfiguration config = new CacheConfiguration(name, maxEntries);
//        config.eternal(false)
//                .memoryStoreEvictionPolicy("some sting")
//                .timeToIdleSeconds(timeToIdleSeconds)
//                .timeToLiveSeconds(timeToLiveSeconds)
//                .transactionalMode(CacheConfiguration.TransactionalMode.OFF);
//        return config;
//    }
//}
