package zafinplugintest

class NewModelWizard extends AbstractNewArtifactCreationWizard {
	var modelWizardPage = new ModelWizardPage()
	var descriptionWizardPage = new DescriptionWizardPage()

	override String getWindowTitle() {
		"New Model Creation Wizard"
	}

	override void addPages() {
		super.addPages()
		modelWizardPage.addPage
		descriptionWizardPage.addPage
	}
	
	override boolean performFinish() {
		modelWizardPage.displayResult
		descriptionWizardPage.displayResult
		true
	}
}
