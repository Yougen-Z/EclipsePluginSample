package com.zafin.plugin.extensionmethods;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;

@SuppressWarnings("all")
public class SWTLayoutExtensions {
  public static GridLayout newGridLayout() {
    return new GridLayout();
  }
  
  public static GridLayout newGridLayout(final int numColumns, final boolean makeColumnsEqualWidth) {
    GridLayout _xblockexpression = null;
    {
      GridLayout layout = new GridLayout(numColumns, makeColumnsEqualWidth);
      layout.marginWidth = 0;
      layout.marginHeight = 0;
      _xblockexpression = layout;
    }
    return _xblockexpression;
  }
  
  public static GridData newGridData() {
    return new GridData(SWT.FILL, SWT.BEGINNING, true, false);
  }
  
  public static GridData newGridData(final int style) {
    return new GridData(style);
  }
  
  public static RowLayout newRowLayout() {
    RowLayout _xblockexpression = null;
    {
      RowLayout layout = new RowLayout();
      layout.marginWidth = 0;
      layout.marginHeight = 0;
      _xblockexpression = layout;
    }
    return _xblockexpression;
  }
}
