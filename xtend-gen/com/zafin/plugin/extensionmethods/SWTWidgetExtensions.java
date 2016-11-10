package com.zafin.plugin.extensionmethods;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SWTWidgetExtensions {
  public static Composite addChildComposite(final Composite parent) {
    return new Composite(parent, SWT.NONE);
  }
  
  public static Composite addChildComposite(final Composite parent, final int style) {
    return new Composite(parent, style);
  }
  
  public static Label addLabel(final Composite parent, final int style) {
    return new Label(parent, style);
  }
  
  public static Label addLabel(final Composite parent, final String label, final int style) {
    Label _label = new Label(parent, style);
    final Procedure1<Label> _function = (Label it) -> {
      it.setText(label);
    };
    return ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
  
  public static Text addText(final Composite parent, final int style) {
    return new Text(parent, style);
  }
  
  public static Text addText(final Composite parent, final String defaultText, final int style) {
    Text _text = new Text(parent, style);
    final Procedure1<Text> _function = (Text it) -> {
      it.setText(defaultText);
    };
    return ObjectExtensions.<Text>operator_doubleArrow(_text, _function);
  }
  
  public static Button addButton(final Composite parent, final int style) {
    return new Button(parent, style);
  }
  
  public static Button addButton(final Composite parent, final String defaultText, final int style) {
    Button _button = new Button(parent, style);
    final Procedure1<Button> _function = (Button it) -> {
      it.setText(defaultText);
    };
    return ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  public static StyledText addStyledText(final Composite parent, final int style) {
    return new StyledText(parent, style);
  }
  
  public static StyledText addStyledText(final Composite parent, final String defaultText, final int style) {
    StyledText _styledText = new StyledText(parent, style);
    final Procedure1<StyledText> _function = (StyledText it) -> {
      it.setText(defaultText);
    };
    return ObjectExtensions.<StyledText>operator_doubleArrow(_styledText, _function);
  }
  
  public static Combo addCombo(final Composite parent, final int style) {
    return new Combo(parent, style);
  }
  
  public static Combo addCombo(final Composite parent, final String[] items, final int style) {
    Combo _addCombo = SWTWidgetExtensions.addCombo(parent, style);
    final Procedure1<Combo> _function = (Combo it) -> {
      it.setItems(items);
    };
    return ObjectExtensions.<Combo>operator_doubleArrow(_addCombo, _function);
  }
  
  public static Group addGroup(final Composite parent, final int style) {
    return new Group(parent, style);
  }
}
