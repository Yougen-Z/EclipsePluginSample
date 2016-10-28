package zafinplugintest;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewModuleWizard extends AbstractNewArtifactCreationWizard {

	private WizardNewProjectCreationPage page_;

	public NewModuleWizard() {
		setWindowTitle("Create a New Module");
	}
	
	@Override
	public void addPages() {
		super.addPages();
		page_ = new WizardNewProjectCreationPage("New Model");
		page_.setTitle("Title here");
		page_.setDescription("Description here");
		addPage(page_);
	}


	@Override
	public boolean performFinish() {

		return true;
	}

}
