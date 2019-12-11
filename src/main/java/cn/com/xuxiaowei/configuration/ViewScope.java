package cn.com.xuxiaowei.configuration;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * 视图
 *
 * @author xuxiaowei
 */
public class ViewScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = currentInstance.getViewRoot();
        Map<String, Object> viewMap = viewRoot.getViewMap();
        if (viewMap.containsKey(name)) {
            return viewMap.get(name);
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = currentInstance.getViewRoot();
        Map<String, Object> viewMap = viewRoot.getViewMap();
        return viewMap.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
