package zafinplugintest;

import zafinplugintest.AbstractNewArtifactCreationWizard;
import zafinplugintest.DescriptionWizardPage;
import zafinplugintest.ModelWizardPage;

@SuppressWarnings("all")
public class NewModelWizard extends AbstractNewArtifactCreationWizard {
  private ModelWizardPage modelWizardPage = new ModelWizardPage();
  
  private DescriptionWizardPage descriptionWizardPage = new DescriptionWizardPage();
  
  @Override
  public String getWindowTitle() {
    return "New Model Creation Wizard";
  }
  
  @Override
  public void addPages() {
    super.addPages();
    this.addPage(this.modelWizardPage);
    this.addPage(this.descriptionWizardPage);
  }
  
  @Override
  public boolean performFinish() {
    boolean _xblockexpression = false;
    {
      this.modelWizardPage.displayResult();
      this.descriptionWizardPage.displayResult();
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
