package zafinplugintest

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import static extension com.zafin.plugin.extensionmethods.SWTWidgetExtensions.*
import static extension com.zafin.plugin.extensionmethods.SWTLayoutExtensions.*

class ModelWizardPage extends AbstractArtifactWizardPage {
	var Combo modelType
	var package Group modifiers

	new() {
		super(Messages.ModelWizardPage_WizardName_Model, Messages.ModelWizardPage_Description,
			Messages.ModelWizardPage_)
	}

	override protected void addCustomControls(Composite parent) {
		parent.addModelTypeControl
		parent.addModifiersControl
		parent.addParentModelControl
	}

	def private void addModelTypeControl(Composite parent) {
		parent.addLabel(Messages.ModelWizardPage_Type, SWT.NONE)
		var String[] items = #[Messages.ModelWizardPage_ModelType_Model, 
								Messages.ModelWizardPage_ModelType_Component,
								Messages.ModelWizardPage_ModelType_Enum]
		modelType = parent.addCombo(items,SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
		modelType.layoutData = newGridData
	}

	def private void addModifiersControl(Composite parent) {
		parent.addLabel("Modifier", SWT.NONE)
		modifiers = parent.addGroup(SWT.NULL)
		modifiers.layout = 3.newGridLayout(true)
		modifiers.layoutData = newGridData
		modifiers.addButton("Model", SWT::RADIO)
		modifiers.addButton("Enum", SWT::RADIO)
		modifiers.addButton("Component", SWT::RADIO)
		modifiers.pack()
	}

	override void displayResult() {
		super.displayResult()
		System.out.println('''Modifier: «modifiers.text»''')
		System.out.println('''Model Type: «modelType.text»''')
		System.out.println('''Parent Model: «parentModel.text»''')
	}

}
