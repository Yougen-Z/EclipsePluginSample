package zafinplugintest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend2.lib.StringConcatenation;
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
  
  @Override
  public void displayResult() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Description: ");
    StyledText _description1 = this.getDescription1();
    String _text = _description1.getText();
    _builder.append(_text, "");
    System.out.println(_builder);
  }
}
