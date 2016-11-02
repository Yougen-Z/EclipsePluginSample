package zafinplugintest

import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite

class DescriptionWizardPage extends AbstractArtifactWizardPage {
	new() {
		super("New Model", "Create a model artifact", "model type")
	}

	override void createControl(Composite parent) {
		var container = new Composite(parent, SWT.NULL)
		var layout = new GridLayout(2, false)
		layout.marginWidth = 0
		container.setLayout(layout)
		addDescriptionControl(container)
		setControl(container)
		setPageComplete(true)
	}

}
