package zafinplugintest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import zafinplugintest.AbstractArtifactWizardPage;

@SuppressWarnings("all")
public class DescriptionWizardPage extends AbstractArtifactWizardPage {
  public DescriptionWizardPage() {
    super("New Model", "Create a model artifact", "model type");
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    GridLayout layout = new GridLayout(2, false);
    layout.marginWidth = 0;
    container.setLayout(layout);
    this.addDescriptionControl(container);
    this.setControl(container);
    this.setPageComplete(true);
  }
}
