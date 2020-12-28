package flyweight.website;

/**
 * @author jeymingwu
 * @date 2020/12/28 21:03
 */
public class Main {

    public static void main(String[] args) {
        WebsiteFactory websiteFactory = new WebsiteFactory();

        Website fx = websiteFactory.getWebsiteCategory("产品展示");
        fx.use();
        fx.use(new User("Tony"));

        Website fy = websiteFactory.getWebsiteCategory("产品展示");
        fy.use();
        fx.use(new User("Jenny"));

        Website fz = websiteFactory.getWebsiteCategory("产品展示");
        fz.use();
        fx.use(new User("Tom"));

        Website fa = websiteFactory.getWebsiteCategory("blog");
        fa.use();
        fx.use(new User("Jane"));

        Website fb = websiteFactory.getWebsiteCategory("blog");
        fb.use();
        fx.use(new User("May"));

        Website fc = websiteFactory.getWebsiteCategory("blog");
        fc.use();
        fx.use(new User("Petty"));

        System.out.println("网站分类总数：" + websiteFactory.getWebsiteCount());
    }
}
