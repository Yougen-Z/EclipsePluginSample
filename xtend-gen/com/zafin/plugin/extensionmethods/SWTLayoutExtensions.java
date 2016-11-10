package com.zafin.plugin.extensionmethods;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

@SuppressWarnings("all")
public class SWTLayoutExtensions {
  public static GridLayout newGridLayout() {
    return new GridLayout();
  }
  
  public static FillLayout newFillLayout() {
    return new FillLayout();
  }
  
  public static GridData newGridData() {
    return new GridData();
  }
  
  public static GridData newGridData(final int style) {
    return new GridData(style);
  }
}
