package zafinplugintest;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewModuleWizard extends AbstractNewArtifactCreationWizard {

	private WizardNewProjectCreationPage wizardNewProjectCreationPage;

	public NewModuleWizard() {
		setWindowTitle("Create a New Module");
	}
	
	@Override
	public void addPages() {
		super.addPages();
		wizardNewProjectCreationPage = new WizardNewProjectCreationPage("New Model");
		wizardNewProjectCreationPage.setTitle("Title here");
		wizardNewProjectCreationPage.setDescription("Description here");
		addPage(wizardNewProjectCreationPage);
	}


	@Override
	public boolean performFinish() {

		return true;
	}

}
