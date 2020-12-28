package flyweight.website;

import java.util.HashMap;

/**
 * @author jeymingwu
 * @date 2020/12/28 21:00
 */
public class WebsiteFactory {

    private HashMap<String, Website> webSiteHashMap = new HashMap<>();

    public Website getWebsiteCategory(String key) {
        if (!this.webSiteHashMap.containsKey(key)) {
            this.webSiteHashMap.put(key, new ConcreteWebsite(key));
        }
        return this.webSiteHashMap.get(key);
    }

    public int getWebsiteCount() {
        return this.webSiteHashMap.size();
    }
}
