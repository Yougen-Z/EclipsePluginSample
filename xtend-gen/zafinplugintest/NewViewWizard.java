package zafinplugintest;

import zafinplugintest.AbstractNewArtifactCreationWizard;
import zafinplugintest.ViewWizardPage;

@SuppressWarnings("all")
public class NewViewWizard extends AbstractNewArtifactCreationWizard {
  @Override
  public String getWindowTitle() {
    return "New View Creation Wizard";
  }
  
  @Override
  public void addPages() {
    super.addPages();
    ViewWizardPage _viewWizardPage = new ViewWizardPage();
    this.addPage(_viewWizardPage);
  }
}
