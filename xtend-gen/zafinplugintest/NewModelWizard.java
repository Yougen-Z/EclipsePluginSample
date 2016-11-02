package zafinplugintest;

import zafinplugintest.AbstractNewArtifactCreationWizard;
import zafinplugintest.DescriptionWizardPage;
import zafinplugintest.ModelWizardPage;

@SuppressWarnings("all")
public class NewModelWizard extends AbstractNewArtifactCreationWizard {
  private ModelWizardPage ModelWizardPage = new ModelWizardPage();
  
  @Override
  public String getWindowTitle() {
    return "New Model Creation Wizard";
  }
  
  @Override
  public void addPages() {
    super.addPages();
    this.addPage(this.ModelWizardPage);
    DescriptionWizardPage _descriptionWizardPage = new DescriptionWizardPage();
    this.addPage(_descriptionWizardPage);
  }
  
  @Override
  public boolean performFinish() {
    boolean _xblockexpression = false;
    {
      this.ModelWizardPage.displayResult();
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
