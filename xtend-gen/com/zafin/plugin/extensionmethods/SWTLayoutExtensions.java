package com.zafin.plugin.extensionmethods;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;

@SuppressWarnings("all")
public class SWTLayoutExtensions {
  public static GridLayout newGridLayout() {
    return new GridLayout();
  }
  
  public static GridLayout newGridLayout(final int numColumns, final boolean makeColumnsEqualWidth) {
    return new GridLayout(numColumns, makeColumnsEqualWidth);
  }
  
  public static RowLayout newRowLayout() {
    return new RowLayout();
  }
  
  public static FillLayout newFillLayout() {
    return new FillLayout();
  }
  
  public static GridData newGridData() {
    return new GridData(SWT.FILL, SWT.BEGINNING, true, false);
  }
  
  public static GridData newGridData(final int style) {
    return new GridData(style);
  }
}
