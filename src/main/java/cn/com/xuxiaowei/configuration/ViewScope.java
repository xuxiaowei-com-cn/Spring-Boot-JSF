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
 * @since 0.0.1
 */
public class ViewScope implements Scope {

    @Override
    @SuppressWarnings("all")
    public Object get(String name, ObjectFactory<?> objectFactory) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Object object = objectFactory.getObject();
        if (facesContext != null) {
            UIViewRoot viewRoot = facesContext.getViewRoot();
            Map<String, Object> viewMap = viewRoot.getViewMap();
            if (viewMap.containsKey(name)) {
                return viewMap.get(name);
            } else {
                viewMap.put(name, object);
                return object;
            }
        } else {
            return object;
        }
    }

    @Override
    @SuppressWarnings("all")
    public Object remove(String name) {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = currentInstance.getViewRoot();
        Map<String, Object> viewMap = viewRoot.getViewMap();
        return viewMap.remove(name);
    }

    @Override
    @SuppressWarnings("all")
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    @SuppressWarnings("all")
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }

}
