package Utilities;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class CacheStorage {
    private static Map<String, String> contextCache = new HashMap<>();
    private static HashMap<String, Map<String, String>> cacheParamMap = new HashMap<>();
    private static HashMap<String, Response> responseHashMap = new HashMap<>();

    public static Map<String, String> getCacheParam(String key) {
        return cacheParamMap.get(key);
    }

    public static void setCacheParam(String key, Map<String, String> paramsMap) {
        cacheParamMap.put(key, paramsMap);
    }
    public static void setResponse(String key, Response response)
    {
        responseHashMap.put(key, response);
    }

    public static Response getResponse(String key) {

        return responseHashMap.get(key);
    }

    public static String getCache(String key) {
        return contextCache.get(key);
    }

    public static void setCache(String key, String value) {
        contextCache.put(key, value);
    }

}
