package zafinplugintest;

import com.zafin.plugin.extensionmethods.SWTLayoutExtensions;
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import zafinplugintest.AbstractArtifactWizardPage;

@SuppressWarnings("all")
public class DescriptionWizardPage extends AbstractArtifactWizardPage {
  public DescriptionWizardPage() {
    super("New Model", "Create a model artifact");
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite _addChildComposite = SWTWidgetExtensions.addChildComposite(parent);
    final Procedure1<Composite> _function = (Composite it) -> {
      GridLayout _newGridLayout = SWTLayoutExtensions.newGridLayout();
      final Procedure1<GridLayout> _function_1 = (GridLayout it_1) -> {
        it_1.numColumns = 2;
        it_1.makeColumnsEqualWidth = false;
      };
      GridLayout _doubleArrow = ObjectExtensions.<GridLayout>operator_doubleArrow(_newGridLayout, _function_1);
      it.setLayout(_doubleArrow);
      this.addDescriptionControl(it);
    };
    Composite _doubleArrow = ObjectExtensions.<Composite>operator_doubleArrow(_addChildComposite, _function);
    this.setControl(_doubleArrow);
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
