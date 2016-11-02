package zafinplugintest

class NewViewWizard extends AbstractNewArtifactCreationWizard {

	override String getWindowTitle() {
		return "New View Creation Wizard"
	}

	override void addPages() {
		super.addPages()
		addPage(new ViewWizardPage())
	}
}
