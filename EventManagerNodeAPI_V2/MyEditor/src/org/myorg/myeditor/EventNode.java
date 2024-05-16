/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.myorg.myeditor;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.time.ZonedDateTime;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.myorg.myapi.Event;
import org.openide.ErrorManager;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.ImageUtilities;
import org.openide.util.WeakListeners;
import org.openide.util.actions.Presenter;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author bites
 */
public class EventNode extends AbstractNode implements java.beans.PropertyChangeListener {

    public EventNode(Event obj) {
        super(Children.create(new EventChildFactory(), true), Lookups.singleton(obj));
        setDisplayName("Event " + obj.getIndex());
        obj.addPropertyChangeListener(WeakListeners.propertyChange(this, obj));
    }

    public EventNode() {
        super(Children.create(new EventChildFactory(), true));
        setDisplayName("Root");
    }

    @Override
    public String getHtmlDisplayName() {
        /*
        Event obj = getLookup().lookup(Event.class);
        if ((obj != null) && (obj.getIndex() % 2 != 0)) {
            return "<font color='0000FF'>Event " + obj.getIndex() + "</font>";
        } else {
            return null;
        }
         */

 /*
        Event obj = getLookup().lookup(Event.class);
        if (obj != null) {
            return "<font color='#0000FF'>Event " + obj.getIndex() + "</font>"
                    + " <font color='AAAAAA'><i>" + obj.getDate() + "</i></font>";
        } else {
            return null;
        }
         */
        Event obj = getLookup().lookup(Event.class);
        if (obj != null) {
            return "<font color='!textText'>Event " + obj.getIndex() + "</font>"
                    + " <font color='!controlShadow'><i>" + obj.getDate() + "</i></font>";
        } else {
            return null;
        }
    }

    @Override
    public Image getIcon(int type) {
        return ImageUtilities.loadImage("org/myorg/myeditor/nodesapi2_icon.png");
    }

    @Override
    public Image getOpenedIcon(int type) {
        return getIcon(type);
    }

    @Override
    public Action[] getActions(boolean popup) {
        return new Action[]{new MyAction(), new MyAction2()};
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("date".equals(evt.getPropertyName())) {
            this.fireDisplayNameChange(null, getDisplayName());
        }
    }

    private class MyAction extends AbstractAction {

        public MyAction() {
            putValue(NAME, "Do Something");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Event obj = getLookup().lookup(Event.class);
            JOptionPane.showMessageDialog(null, "Hello from " + obj);
        }
    }

    private class MyAction2 extends AbstractAction implements Presenter.Popup {

        public MyAction2() {
            putValue(NAME, "Do Something");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Event obj = getLookup().lookup(Event.class);
            JOptionPane.showMessageDialog(null, "Hello from " + obj);
        }

        @Override
        public JMenuItem getPopupPresenter() {
            JMenu result = new JMenu("Submenu");  //remember JMenu is a subclass of JMenuItem
            result.add(new JMenuItem(this));
            result.add(new JMenuItem(this));
            return result;
        }
    }

    @Override
    protected Sheet createSheet() {
        /* 
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        Event obj = getLookup().lookup(Event.class);

        try {
            Property indexProp = new PropertySupport.Reflection(obj, Integer.class, "getIndex", null);
            Property dateProp = new PropertySupport.Reflection(obj, String.class, "getDateAsString", "setDateFromString");

            indexProp.setName("index");
            dateProp.setName("date");

            set.put(indexProp);
            set.put(dateProp);
        } catch (NoSuchMethodException ex) {
            ErrorManager.getDefault();
        }

        sheet.put(set);
        return sheet;
         */

        //Propertylerde gruplama yapar
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        Sheet.Set set2 = Sheet.createPropertiesSet();
        set2.setDisplayName("Other");
        set2.setName("other");
        final Event obj = getLookup().lookup(Event.class);
        if (obj != null) {
            try {
                Property indexProp = new PropertySupport.Reflection(obj, Integer.class, "getIndex", null);
                Property dateProp = new PropertySupport.Reflection(obj, String.class, "getDateAsString", "setDateFromString");
                indexProp.setName("index");
                dateProp.setName("date");

                set.put(indexProp);
                set2.put(dateProp);
                set2.setValue("tabName", "Other Tab");
            } catch (NoSuchMethodException ex) {
                ErrorManager.getDefault();
            }
        }

        sheet.put(set);
        sheet.put(set2);
        return sheet;
    }
}
