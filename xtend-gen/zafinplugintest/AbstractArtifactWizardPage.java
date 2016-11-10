package zafinplugintest;

import com.zafin.plugin.extensionmethods.SWTLayoutExtensions;
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public abstract class AbstractArtifactWizardPage extends WizardPage {
  private Text modelName;
  
  private StyledText wizardDescription;
  
  private Combo namespace;
  
  private Text parentModel;
  
  public AbstractArtifactWizardPage(final String title, final String description) {
    super(title);
    this.setTitle(title);
    this.setDescription(description);
  }
  
  @Override
  public void createControl(final Composite parent) {
    final int nclo = 2;
    final int mwidth = 0;
    Composite _addChildComposite = SWTWidgetExtensions.addChildComposite(parent);
    final Procedure1<Composite> _function = (Composite it) -> {
      GridLayout _newGridLayout = SWTLayoutExtensions.newGridLayout();
      final Procedure1<GridLayout> _function_1 = (GridLayout it_1) -> {
        it_1.numColumns = nclo;
        it_1.makeColumnsEqualWidth = false;
        it_1.marginWidth = mwidth;
      };
      GridLayout _doubleArrow = ObjectExtensions.<GridLayout>operator_doubleArrow(_newGridLayout, _function_1);
      it.setLayout(_doubleArrow);
      this.addNamespaceControl(it);
      this.addNameControl(it);
      this.addCustomControls(it);
      this.createLine(it, nclo);
      this.addOpenInEditorCheckbox(it);
      this.setControl(it);
    };
    ObjectExtensions.<Composite>operator_doubleArrow(_addChildComposite, _function);
    this.setPageComplete(false);
  }
  
  private void addNamespaceControl(final Composite parent) {
    final List<String> items = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("C:/workspace/", "D:/workspace/", "E:/"));
    final Procedure1<Composite> _function = (Composite it) -> {
      SWTWidgetExtensions.addLabel(it, "Namespace", SWT.NONE);
      Combo _addCombo = SWTWidgetExtensions.addCombo(it, ((String[])Conversions.unwrapArray(items, String.class)), (SWT.DROP_DOWN | SWT.READ_ONLY));
      final Procedure1<Combo> _function_1 = (Combo it_1) -> {
        GridData _newGridData = SWTLayoutExtensions.newGridData();
        it_1.setLayoutData(_newGridData);
      };
      Combo _doubleArrow = ObjectExtensions.<Combo>operator_doubleArrow(_addCombo, _function_1);
      this.namespace = _doubleArrow;
    };
    ObjectExtensions.<Composite>operator_doubleArrow(parent, _function);
  }
  
  private void addNameControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Name", SWT.NONE);
    Text _addText = SWTWidgetExtensions.addText(parent, "", (SWT.BORDER | SWT.SINGLE));
    this.modelName = _addText;
    GridData _newGridData = SWTLayoutExtensions.newGridData(GridData.FILL_HORIZONTAL);
    this.modelName.setLayoutData(_newGridData);
    this.modelName.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(final KeyEvent e) {
      }
      
      @Override
      public void keyReleased(final KeyEvent e) {
        String _text = AbstractArtifactWizardPage.this.modelName.getText();
        boolean _isEmpty = _text.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          AbstractArtifactWizardPage.this.setPageComplete(true);
        }
      }
    });
  }
  
  protected void addCustomControls(final Composite parent) {
  }
  
  public void addDescriptionControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Description", SWT.NONE);
    StyledText _addStyledText = SWTWidgetExtensions.addStyledText(parent, 
      "Description for the model", 
      ((((SWT.MULTI | SWT.WRAP) | SWT.BORDER) | SWT.H_SCROLL) | SWT.V_SCROLL));
    this.wizardDescription = _addStyledText;
    GridData _newGridData = SWTLayoutExtensions.newGridData(GridData.FILL_BOTH);
    this.wizardDescription.setLayoutData(_newGridData);
  }
  
  public void addParentModelControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Parent Model", SWT.NONE);
    Composite _addChildComposite = SWTWidgetExtensions.addChildComposite(parent, SWT.FILL);
    final Procedure1<Composite> _function = (Composite it) -> {
      GridLayout _newGridLayout = SWTLayoutExtensions.newGridLayout();
      it.setLayout(_newGridLayout);
      GridData _newGridData = SWTLayoutExtensions.newGridData();
      it.setLayoutData(_newGridData);
      Text _addText = SWTWidgetExtensions.addText(it, SWT.NULL);
      this.parentModel = _addText;
      Button _addButton = SWTWidgetExtensions.addButton(it, "Browse...", SWT.PUSH);
      final Procedure1<Button> _function_1 = (Button it_1) -> {
        final Procedure1<Event> _function_2 = (Event event) -> {
          IWizardContainer _container = this.getContainer();
          Shell _shell = _container.getShell();
          DirectoryDialog directoryDialog = new DirectoryDialog(_shell);
          directoryDialog.setFilterPath("C:/zplatform-develop/ws");
          directoryDialog.setMessage("directory message here");
          String dir = directoryDialog.open();
          if ((dir != null)) {
            this.parentModel.setText(dir);
          }
        };
        it_1.addListener(SWT.Selection, ((Listener) new Listener() {
            public void handleEvent(Event event) {
              _function_2.apply(event);
            }
        }));
      };
      ObjectExtensions.<Button>operator_doubleArrow(_addButton, _function_1);
    };
    ObjectExtensions.<Composite>operator_doubleArrow(_addChildComposite, _function);
  }
  
  public void addOpenInEditorCheckbox(final Composite parent) {
    Button _addButton = SWTWidgetExtensions.addButton(parent, SWT.CHECK);
    final Procedure1<Button> _function = (Button it) -> {
      it.setText("Open artifact in editor");
      it.setSelection(true);
    };
    ObjectExtensions.<Button>operator_doubleArrow(_addButton, _function);
  }
  
  public void createLine(final Composite parent, final int ncol) {
    Label _addLabel = SWTWidgetExtensions.addLabel(parent, 
      ((SWT.SEPARATOR | SWT.HORIZONTAL) | SWT.BOLD));
    final Procedure1<Label> _function = (Label it) -> {
      GridData _newGridData = SWTLayoutExtensions.newGridData(GridData.FILL_HORIZONTAL);
      final Procedure1<GridData> _function_1 = (GridData it_1) -> {
        it_1.horizontalSpan = ncol;
      };
      GridData _doubleArrow = ObjectExtensions.<GridData>operator_doubleArrow(_newGridData, _function_1);
      it.setLayoutData(_doubleArrow);
    };
    ObjectExtensions.<Label>operator_doubleArrow(_addLabel, _function);
  }
  
  public void displayResult() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Model Name: ");
    String _text = this.modelName.getText();
    _builder.append(_text, "");
    String _string = _builder.toString();
    System.out.println(_string);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Model Namespace: ");
    String _text_1 = this.namespace.getText();
    _builder_1.append(_text_1, "");
    String _string_1 = _builder_1.toString();
    System.out.println(_string_1);
  }
  
  @Pure
  public Text getModelName() {
    return this.modelName;
  }
  
  @Pure
  public StyledText getWizardDescription() {
    return this.wizardDescription;
  }
  
  @Pure
  public Combo getNamespace() {
    return this.namespace;
  }
  
  @Pure
  public Text getParentModel() {
    return this.parentModel;
  }
}
