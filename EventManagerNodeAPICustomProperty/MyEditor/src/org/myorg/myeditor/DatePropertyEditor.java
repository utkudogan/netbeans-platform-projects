/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.myorg.myeditor;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.openide.explorer.propertysheet.ExPropertyEditor;
import org.openide.explorer.propertysheet.InplaceEditor;
import org.openide.explorer.propertysheet.PropertyEnv;
import org.openide.explorer.propertysheet.PropertyModel;
import org.openide.nodes.PropertyEditorRegistration;

/**
 *
 * @author bites
 */
@PropertyEditorRegistration(targetType = ZonedDateTime.class)
public class DatePropertyEditor extends PropertyEditorSupport implements ExPropertyEditor, InplaceEditor.Factory {

    @Override
    public String getAsText() {
        ZonedDateTime d = (ZonedDateTime) getValue();
        if (d == null) {
            return "No Date Set";
        }
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(d);
    }

    @Override
    public void setAsText(String s) {
        try {
            setValue(ZonedDateTime.parse(s));
        } catch (DateTimeParseException ex) {
            IllegalArgumentException iae = new IllegalArgumentException("Could not parse date");
            throw iae;
        }
    }

    @Override
    public void attachEnv(PropertyEnv env) {
        env.registerInplaceEditorFactory(this);
    }

    private InplaceEditor ed = null;

    @Override
    public InplaceEditor getInplaceEditor() {
        if (ed == null) {
            ed = new Inplace();
        }
        return ed;
    }

    private static class Inplace implements InplaceEditor {

        private final DateTimePicker picker = new DateTimePicker();
        private PropertyEditor editor = null;

        @Override
        public void connect(PropertyEditor propertyEditor, PropertyEnv env) {
            editor = propertyEditor;
            reset();
        }

        @Override
        public JComponent getComponent() {
            return picker;
        }

        @Override
        public void clear() {
            //avoid memory leaks:
            editor = null;
            model = null;
        }

        @Override
        public Object getValue() {
            LocalDateTime d = picker.getDateTimePermissive();
            ZonedDateTime zdt = d.atZone(ZoneId.systemDefault());
            return zdt;
        }

        @Override
        public void setValue(Object object) {
            ZonedDateTime zdt = (ZonedDateTime) object;
            if (zdt != null) {
                picker.setDateTimePermissive(zdt.toLocalDateTime());
            }
        }

        @Override
        public boolean supportsTextEntry() {
            return true;
        }

        @Override
        public void reset() {
            ZonedDateTime zdt = (ZonedDateTime) editor.getValue();
            if (zdt != null) {
                picker.setDateTimePermissive(zdt.toLocalDateTime());
            }
        }

        @Override
        public KeyStroke[] getKeyStrokes() {
            return new KeyStroke[0];
        }

        @Override
        public PropertyEditor getPropertyEditor() {
            return editor;
        }

        @Override
        public PropertyModel getPropertyModel() {
            return model;
        }

        private PropertyModel model;

        @Override
        public void setPropertyModel(PropertyModel propertyModel) {
            this.model = propertyModel;
        }

        @Override
        public boolean isKnownComponent(Component component) {
            return component == picker || picker.isAncestorOf(component);
        }

        @Override
        public void addActionListener(ActionListener actionListener) {
            //do nothing - not needed for this component
        }

        @Override
        public void removeActionListener(ActionListener actionListener) {
            //do nothing - not needed for this component
        }
    }
}
