package zafinplugintest;

import com.zafin.plugin.extensionmethods.SWTLayoutExtensions;
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend2.lib.StringConcatenation;
import zafinplugintest.AbstractArtifactWizardPage;
import zafinplugintest.Messages;

@SuppressWarnings("all")
public class ModelWizardPage extends AbstractArtifactWizardPage {
  private Combo modelType;
  
  Group modifiers;
  
  public ModelWizardPage() {
    super(Messages.ModelWizardPage_WizardName_Model, Messages.ModelWizardPage_Description, 
      Messages.ModelWizardPage_);
  }
  
  @Override
  protected void addCustomControls(final Composite parent) {
    this.addModelTypeControl(parent);
    this.addModifiersControl(parent);
    this.addParentModelControl(parent);
  }
  
  private void addModelTypeControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, Messages.ModelWizardPage_Type, SWT.NONE);
    GridData _newGridData = SWTLayoutExtensions.newGridData();
    this.modelType.setLayoutData(_newGridData);
    String[] items = { Messages.ModelWizardPage_ModelType_Model, Messages.ModelWizardPage_ModelType_Component, Messages.ModelWizardPage_ModelType_Enum };
    Combo _addCombo = SWTWidgetExtensions.addCombo(parent, items, (SWT.DROP_DOWN | SWT.READ_ONLY));
    this.modelType = _addCombo;
  }
  
  private void addModifiersControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Modifier", SWT.NONE);
    Group _addGroup = SWTWidgetExtensions.addGroup(parent, SWT.NULL);
    this.modifiers = _addGroup;
    GridLayout _newGridLayout = SWTLayoutExtensions.newGridLayout(3, true);
    this.modifiers.setLayout(_newGridLayout);
    GridData _newGridData = SWTLayoutExtensions.newGridData();
    this.modifiers.setLayoutData(_newGridData);
    SWTWidgetExtensions.addButton(this.modifiers, "Model", SWT.RADIO);
    SWTWidgetExtensions.addButton(this.modifiers, "Enum", SWT.RADIO);
    SWTWidgetExtensions.addButton(this.modifiers, "Component", SWT.RADIO);
    this.modifiers.pack();
  }
  
  @Override
  public void displayResult() {
    super.displayResult();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Modifier: ");
    String _text = this.modifiers.getText();
    _builder.append(_text, "");
    System.out.println(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Model Type: ");
    String _text_1 = this.modelType.getText();
    _builder_1.append(_text_1, "");
    System.out.println(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Parent Model: ");
    Text _parentModel = this.getParentModel();
    String _text_2 = _parentModel.getText();
    _builder_2.append(_text_2, "");
    System.out.println(_builder_2);
  }
}
