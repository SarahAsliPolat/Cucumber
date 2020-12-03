package Utilities;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CacheStorage {
    private static Map<String, String> contextCache = new HashMap<>();


    public static String getContextCache(String key) {
        if(StringUtils.isBlank(key)) {
            return key;
        }

        return contextCache.get(key);
    }

    public static void setContextCache(String key, String value) {
        contextCache.put(key, value);
    }

}
