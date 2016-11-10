package zafinplugintest

import org.eclipse.swt.widgets.Composite

class ViewWizardPage extends AbstractArtifactWizardPage {
	new() {
		super(
			Messages.ViewWizardPage_Name,
			Messages.ViewWizardPage_Description
		)
	}

	override protected void addCustomControls(Composite parent) {
		parent.addDescriptionControl
	}
}
