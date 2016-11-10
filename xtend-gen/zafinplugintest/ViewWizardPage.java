package zafinplugintest;

import org.eclipse.swt.widgets.Composite;
import zafinplugintest.AbstractArtifactWizardPage;
import zafinplugintest.Messages;

@SuppressWarnings("all")
public class ViewWizardPage extends AbstractArtifactWizardPage {
  public ViewWizardPage() {
    super(
      Messages.ViewWizardPage_Name, 
      Messages.ViewWizardPage_Description);
  }
  
  @Override
  protected void addCustomControls(final Composite parent) {
    this.addDescriptionControl(parent);
  }
}
