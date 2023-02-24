package DreamShop.utill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
@Component
public class SessionUtill {
    private static SessionUtill sessionUtill = null;
    public static SessionUtill getInstance(){
        if (sessionUtill == null) {
            sessionUtill = new SessionUtill();
        }
        return sessionUtill;
    }
    public void putValue(HttpSession session , String key, Object value){
    	session.setAttribute(key, value);
    }
    public Object getValue(HttpSession session , String key){       
        return session.getAttribute(key);
    }
    public void removeValue(HttpSession session , String key){
    	session.removeAttribute(key);
    }
    public void putValue(HttpServletRequest Request , String key, Object value){
        Request.getSession().setAttribute(key, value);
    }
    public Object getValue(HttpServletRequest Request , String key){
        return Request.getSession().getAttribute(key);
    }
}
