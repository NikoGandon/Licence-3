package com.example.TD3.Utils.IP;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class IpListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Attribut ajoute : " + event.getName() + " : " + event.getValue());
        checkSession(event);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Attribut supprime : " + event.getName() + " : " + event.getValue());
        checkSession(event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Attribut remplace : " + event.getName() + " : " + event.getValue());
        checkSession(event);
    }

    private void checkSession(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        if ("adresseIP".equals(attributeName) || "userAgent".equals(attributeName)) {
            HttpSession session = event.getSession();
            session.invalidate();
            System.out.println("Session invalide.");
        }
    }

}
