package zafinplugintest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
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
  protected void addCustomControls(final Composite container) {
    this.addModelTypeControl(container);
    this.addModifiersControl(container);
    this.addParentModelControl(container);
  }
  
  private void addModelTypeControl(final Composite container) {
    Label _label = new Label(container, SWT.NONE);
    _label.setText(Messages.ModelWizardPage_Type);
    Combo _combo = new Combo(container, (SWT.DROP_DOWN | SWT.READ_ONLY));
    this.modelType = _combo;
    GridData _gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
    this.modelType.setLayoutData(_gridData);
    String[] items = { Messages.ModelWizardPage_ModelType_Model, Messages.ModelWizardPage_ModelType_Component, Messages.ModelWizardPage_ModelType_Enum };
    this.modelType.setItems(items);
    this.modelType.setEnabled(true);
  }
  
  private void addModifiersControl(final Composite container) {
    Label _label = new Label(container, SWT.NONE);
    _label.setText("Modifier:");
    GridLayout layout = new GridLayout(3, true);
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    Group _group = new Group(container, SWT.NULL);
    this.modifiers = _group;
    this.modifiers.setLayout(layout);
    GridData _gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
    this.modifiers.setLayoutData(_gridData);
    Button m1 = new Button(this.modifiers, SWT.RADIO);
    m1.setText("Model");
    Button m2 = new Button(this.modifiers, SWT.RADIO);
    m2.setText("Enum");
    Button m3 = new Button(this.modifiers, SWT.RADIO);
    m3.setText("Component");
    this.modifiers.pack();
  }
  
  @Override
  public void displayResult() {
    super.displayResult();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Model Type: ");
    String _text = this.modelType.getText();
    _builder.append(_text, "");
    System.out.println(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Modifier: ");
    String _text_1 = this.modifiers.getText();
    _builder_1.append(_text_1, "");
    System.out.println(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("Model Type");
    String _text_2 = this.modelType.getText();
    _builder_2.append(_text_2, "");
    System.out.println(_builder_2);
  }
}
