package com.zafin.plugin.extensionmethods

import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.RowLayout
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.FillLayout

class SWTLayoutExtensions {
	
	def static newGridLayout() {
		new GridLayout
	}
		
	def static newGridLayout(int numColumns, boolean makeColumnsEqualWidth) {
		new GridLayout(numColumns, makeColumnsEqualWidth)
	}
	
	def static newRowLayout() {
		new RowLayout
	}
	
	def static newFillLayout() {
		new FillLayout
	}
	
	def static newGridData() {
		new GridData(SWT::FILL, SWT::BEGINNING, true, false)
	}
	
	def static newGridData(int style) {
		new GridData(style)
	}
}