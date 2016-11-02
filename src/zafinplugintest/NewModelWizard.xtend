package zafinplugintest

class NewModelWizard extends AbstractNewArtifactCreationWizard {
	var ModelWizardPage = new ModelWizardPage()

	override String getWindowTitle() {
		"New Model Creation Wizard"
	}

	override void addPages() {
		super.addPages()
		ModelWizardPage.addPage
		new DescriptionWizardPage().addPage
	}
	
	override boolean performFinish() {
		ModelWizardPage.displayResult
		true
	}
}
