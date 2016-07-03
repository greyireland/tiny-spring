package us.codecraft.tinyioc.beans.io;

import java.net.URL;

/**
 * @author yihua.huang@dianping.com
 */
public class ResourceLoader {

	//获取资源 
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
