package zafinplugintest

import org.eclipse.swt.widgets.Composite
import com.zafin.plugin.extensionmethods.SWTLayoutExtensions
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions

class DescriptionWizardPage extends AbstractArtifactWizardPage {
	new() {
		super("New Model", "Create a model artifact", "model type")
	}

	override void createControl(Composite parent) {
		var child = SWTWidgetExtensions.addChildComposite(parent)
		child.layout = SWTLayoutExtensions.newGridLayout(2, false)
		addDescriptionControl(child)
		control = child
		pageComplete = true
	}
	
	override void displayResult() {
		System.out.println('''Description: «wizardDescription.text»''')
	}
}
