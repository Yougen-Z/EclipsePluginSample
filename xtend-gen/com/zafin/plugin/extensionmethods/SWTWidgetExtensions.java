package com.zafin.plugin.extensionmethods;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

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
    Label _xblockexpression = null;
    {
      Label newLabel = new Label(parent, style);
      newLabel.setText(label);
      _xblockexpression = newLabel;
    }
    return _xblockexpression;
  }
  
  public static Text addText(final Composite parent, final int style) {
    return new Text(parent, style);
  }
  
  public static Text addText(final Composite parent, final String defaultText, final int style) {
    Text _xblockexpression = null;
    {
      Text newText = new Text(parent, style);
      newText.setText(defaultText);
      _xblockexpression = newText;
    }
    return _xblockexpression;
  }
  
  public static Button addButton(final Composite parent, final int style) {
    return new Button(parent, style);
  }
  
  public static Button addButton(final Composite parent, final String defaultText, final int style) {
    Button _xblockexpression = null;
    {
      Button button = new Button(parent, style);
      button.setText(defaultText);
      _xblockexpression = button;
    }
    return _xblockexpression;
  }
  
  public static StyledText addStyledText(final Composite parent, final int style) {
    return new StyledText(parent, style);
  }
  
  public static StyledText addStyledText(final Composite parent, final String defaultText, final int style) {
    StyledText _xblockexpression = null;
    {
      StyledText text = new StyledText(parent, style);
      text.setText(defaultText);
      _xblockexpression = text;
    }
    return _xblockexpression;
  }
  
  public static Combo addCombo(final Composite parent, final int style) {
    return new Combo(parent, style);
  }
  
  public static Combo addCombo(final Composite parent, final String[] items, final int style) {
    Combo _xblockexpression = null;
    {
      Combo combo = SWTWidgetExtensions.addCombo(parent, style);
      combo.setItems(items);
      _xblockexpression = combo;
    }
    return _xblockexpression;
  }
  
  public static Group addGroup(final Composite parent, final int style) {
    return new Group(parent, style);
  }
}
