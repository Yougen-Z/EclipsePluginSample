package zafinplugintest;

import com.zafin.plugin.extensionmethods.SWTLayoutExtensions;
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions;
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
    Composite child = SWTWidgetExtensions.addChildComposite(parent);
    GridLayout _newGridLayout = SWTLayoutExtensions.newGridLayout(2, false);
    child.setLayout(_newGridLayout);
    this.addDescriptionControl(child);
    this.setControl(child);
    this.setPageComplete(true);
  }
  
  @Override
  public void displayResult() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Description: ");
    StyledText _wizardDescription = this.getWizardDescription();
    String _text = _wizardDescription.getText();
    _builder.append(_text, "");
    System.out.println(_builder);
  }
}
