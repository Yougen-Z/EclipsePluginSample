package zafinplugintest

import org.eclipse.swt.widgets.Composite

class ViewWizardPage extends AbstractArtifactWizardPage {
	new() {
		super(Messages.ViewWizardPage_Name, Messages.ViewWizardPage_Description, Messages.ViewWizardPage_Type)
	}

	override protected void addCustomControls(Composite container) {
		addDescriptionControl(container)
	}
}
