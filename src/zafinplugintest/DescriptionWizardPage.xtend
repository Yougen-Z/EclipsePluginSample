package zafinplugintest

import org.eclipse.swt.widgets.Composite
import static extension com.zafin.plugin.extensionmethods.SWTLayoutExtensions.*
import static extension com.zafin.plugin.extensionmethods.SWTWidgetExtensions.*

class DescriptionWizardPage extends AbstractArtifactWizardPage {
	new() {
		super("New Model", "Create a model artifact", "model type")
	}

	override void createControl(Composite parent) {
		var child = parent.addChildComposite
		child.layout = 2.newGridLayout(false)
		child.addDescriptionControl
		control = child
		pageComplete = true
	}
	
	override void displayResult() {
		System.out.println('''Description: «wizardDescription.text»''')
	}
}
