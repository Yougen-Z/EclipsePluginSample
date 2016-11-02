package zafinplugintest;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import zafinplugintest.AbstractNewArtifactCreationWizard;

@SuppressWarnings("all")
public class NewModuleWizard extends AbstractNewArtifactCreationWizard {
  private WizardNewProjectCreationPage wizardNewProjectCreationPage;
  
  public NewModuleWizard() {
    this.setWindowTitle("Create a New Module");
  }
  
  @Override
  public void addPages() {
    super.addPages();
    WizardNewProjectCreationPage _wizardNewProjectCreationPage = new WizardNewProjectCreationPage("New Model");
    this.wizardNewProjectCreationPage = _wizardNewProjectCreationPage;
    this.wizardNewProjectCreationPage.setTitle("Title here");
    this.wizardNewProjectCreationPage.setDescription("Description here");
    this.addPage(this.wizardNewProjectCreationPage);
  }
}
