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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import zafinplugintest.AbstractArtifactWizardPage;
import zafinplugintest.Messages;

@SuppressWarnings("all")
public class ModelWizardPage extends AbstractArtifactWizardPage {
  private Combo modelType;
  
  Group modifiers;
  
  public ModelWizardPage() {
    super(Messages.ModelWizardPage_WizardName_Model, Messages.ModelWizardPage_Description);
  }
  
  @Override
  protected void addCustomControls(final Composite parent) {
    final Procedure1<Composite> _function = (Composite it) -> {
      this.addModelTypeControl(it);
      this.addModifiersControl(it);
      this.addParentModelControl(it);
    };
    ObjectExtensions.<Composite>operator_doubleArrow(parent, _function);
  }
  
  private void addModelTypeControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, Messages.ModelWizardPage_Type, SWT.NONE);
    String[] items = { Messages.ModelWizardPage_ModelType_Model, Messages.ModelWizardPage_ModelType_Component, Messages.ModelWizardPage_ModelType_Enum };
    Combo _addCombo = SWTWidgetExtensions.addCombo(parent, items, (SWT.DROP_DOWN | SWT.READ_ONLY));
    this.modelType = _addCombo;
    GridData _newGridData = SWTLayoutExtensions.newGridData();
    this.modelType.setLayoutData(_newGridData);
  }
  
  private void addModifiersControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Modifier", SWT.NONE);
    Group _addGroup = SWTWidgetExtensions.addGroup(parent, SWT.NULL);
    this.modifiers = _addGroup;
    GridLayout _newGridLayout = SWTLayoutExtensions.newGridLayout();
    final Procedure1<GridLayout> _function = (GridLayout it) -> {
      it.numColumns = 3;
      it.makeColumnsEqualWidth = true;
    };
    GridLayout _doubleArrow = ObjectExtensions.<GridLayout>operator_doubleArrow(_newGridLayout, _function);
    this.modifiers.setLayout(_doubleArrow);
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
