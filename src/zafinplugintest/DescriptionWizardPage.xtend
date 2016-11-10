package zafinplugintest

import org.eclipse.swt.widgets.Composite
import static extension com.zafin.plugin.extensionmethods.SWTLayoutExtensions.*
import static extension com.zafin.plugin.extensionmethods.SWTWidgetExtensions.*

class DescriptionWizardPage extends AbstractArtifactWizardPage {
	new() {
		super("New Model", "Create a model artifact")
	}

	override void createControl(Composite parent) {
		
		control = parent.addChildComposite => [
			layout = newGridLayout => [
				numColumns = 2
				makeColumnsEqualWidth = false
			]
			
			addDescriptionControl
		]
		pageComplete = true
	}
	
	override void displayResult() {
		System.out.println('''Description: «wizardDescription.text»''')
	}
}
