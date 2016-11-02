package com.zafin.plugin.extensionmethods

import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Group

class SWTWidgetExtensions {
	
	def static addChildComposite(Composite parent) {
		new Composite(parent, SWT.NONE)
	}
	
	def static addChildComposite(Composite parent, int style) {
		new Composite(parent, style)
	}
	
	def static addLabel(Composite parent, int style) {
		new Label(parent, style)
	}
	
	def static addLabel(Composite parent, String defaultText, int style) {
		var label = new Label(parent, style)
		label.text = defaultText
		label
	}
	
	def static addText(Composite parent, int style) {
		var text = new Text(parent, style)
		text
	}
	
	def static addText(Composite parent, String defaultText, int style) {
		var text = new Text(parent, style)
		text.text = defaultText
		text
	}
	
	def static addButton(Composite parent, String defaultText, int style) {
		var button = new Button(parent, style)
		button.text = defaultText
		button
	}
	
	def static addStyledText(Composite parent, int style) {
		var text = new StyledText(parent, style)
		text
	}
	
	def static addStyledText(Composite parent, String defaultText, int style) {
		var text = new StyledText(parent, style)
		text.text = defaultText
		text
	}
	
	def static addCombo(Composite parent, int style) {
		var combo = new Combo(parent, style)
		combo.enabled = true
		combo
	}
	
	def static addCombo(Composite parent, String[] items, int style) {
		var combo = addCombo(parent, style)
		combo.items = items
		combo
	}
	
	def static addGroup(Composite parent, int style) {
		new Group(parent, style)
	}
}
