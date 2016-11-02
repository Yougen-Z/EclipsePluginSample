package com.zafin.plugin.extensionmethods

import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.RowLayout
import org.eclipse.swt.SWT

class SWTLayoutExtensions {
	def static newGridLayout() {
		new GridLayout
	}
	
	def static newGridLayout(int numColumns, boolean makeColumnsEqualWidth) {
		var layout = new GridLayout(numColumns, makeColumnsEqualWidth)
		layout.marginWidth = 0
		layout.marginHeight = 0
		layout
	}
	
	def static newGridData() {
		new GridData(SWT::FILL, SWT::BEGINNING, true, false)
	}
	
	def static newGridData(int style) {
		new GridData(style)
	}
	
	def static newRowLayout() {
		var layout = new RowLayout()
		layout.marginWidth = 0
		layout.marginHeight = 0
		layout
	}
}