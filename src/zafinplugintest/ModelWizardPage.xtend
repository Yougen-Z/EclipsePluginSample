package zafinplugintest

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Group
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions
import com.zafin.plugin.extensionmethods.SWTLayoutExtensions

class ModelWizardPage extends AbstractArtifactWizardPage {
	var Combo modelType
	var package Group modifiers

	new() {
		super(Messages.ModelWizardPage_WizardName_Model, Messages.ModelWizardPage_Description,
			Messages.ModelWizardPage_)
	}

	override protected void addCustomControls(Composite parent) {
		addModelTypeControl(parent)
		addModifiersControl(parent)
		addParentModelControl(parent)
	}

	def private void addModelTypeControl(Composite parent) {
		SWTWidgetExtensions.addLabel(parent, Messages.ModelWizardPage_Type, SWT.NONE)
		modelType.setLayoutData(SWTLayoutExtensions.newGridData)
		var String[] items = #[Messages.ModelWizardPage_ModelType_Model, 
								Messages.ModelWizardPage_ModelType_Component,
								Messages.ModelWizardPage_ModelType_Enum]
		modelType = SWTWidgetExtensions.addCombo(parent, items, SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
	}

	def private void addModifiersControl(Composite parent) {
		SWTWidgetExtensions.addLabel(parent, "Modifier", SWT.NONE)
		modifiers = SWTWidgetExtensions.addGroup(parent, SWT.NULL)
		modifiers.layout = SWTLayoutExtensions.newGridLayout(3, true)
		modifiers.layoutData = SWTLayoutExtensions.newGridData
		SWTWidgetExtensions.addButton(modifiers, "Model", SWT::RADIO)
		SWTWidgetExtensions.addButton(modifiers, "Enum", SWT::RADIO)
		SWTWidgetExtensions.addButton(modifiers, "Component", SWT::RADIO)
		modifiers.pack()
	}

	override void displayResult() {
		super.displayResult()
		System.out.println('''Modifier: «modifiers.text»''')
		System.out.println('''Model Type: «modelType.text»''')
		System.out.println('''Parent Model: «parentModel.text»''')
	}

}
