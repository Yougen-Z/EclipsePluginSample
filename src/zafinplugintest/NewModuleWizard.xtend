package zafinplugintest

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage

class NewModuleWizard extends AbstractNewArtifactCreationWizard {
	WizardNewProjectCreationPage wizardNewProjectCreationPage

	new() {
		setWindowTitle("Create a New Module")
	}

	override void addPages() {
		super.addPages()
		wizardNewProjectCreationPage = new WizardNewProjectCreationPage("New Model")
		wizardNewProjectCreationPage.title = "Title here"
		wizardNewProjectCreationPage.description = "Description here"
		wizardNewProjectCreationPage.addPage
	}
}
